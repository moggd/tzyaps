"""Prepare the instructor's unmodified module from a local course archive."""

import argparse
import hashlib
from pathlib import Path
from zipfile import ZipFile

ROOT = Path(__file__).resolve().parents[1]
DIGEST = {
    "v1": "3318f380c8a9c00a28fba1bd7ad0bcd2b0464be66965937ff87b1d0210a31c1b",
    "v2": "0f9c0c6b5da960186af53dddf637b976718b1c50f4ddce0917006646b325933c",
}
PACKAGE = Path("src/main/java/ua/kpi/tzyapz/personal")
parser = argparse.ArgumentParser(description=__doc__)
parser.add_argument("version", choices=DIGEST)
parser.add_argument("archive", type=Path)
args = parser.parse_args()
if hashlib.sha256(args.archive.read_bytes()).hexdigest() != DIGEST[args.version]:
    parser.error("Archive differs from the verified course distribution.")
dest = ROOT if args.version == "v1" else ROOT / ".qa-local" / "v2"
prefix = f"code/modules/personal/{args.version}/"
with ZipFile(args.archive) as archive:
    files = {
        dest / name: archive.read(prefix + str(name))
        for name in [Path("pom.xml"), *(PACKAGE / (c + ".java") for c in
                  ["LeaveCalculator", "PayrollCalculator", "EmployeeValidator"])]
    }
if args.version == "v2":
    test_dir = ROOT / "src/test"
    files.update({dest / path.relative_to(ROOT): path.read_bytes()
                  for path in test_dir.rglob("*.java")})
    stale = set((dest / "src/test").rglob("*.java")) - set(files)
    if stale:
        parser.error("Unexpected previous test files in .qa-local/v2. Use a clean checkout.")
for path, data in files.items():
    if path.exists() and path.read_bytes() != data:
        parser.error(f"Refusing to overwrite a different file: {path}")
for path, data in files.items():
    if not path.exists():
        path.parent.mkdir(parents=True, exist_ok=True)
        path.write_bytes(data)
print(dest)
