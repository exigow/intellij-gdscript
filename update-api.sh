#!/bin/sh

# Usage:
# ./update-api.sh 3.5 4.1

rm -rf .versions/

for version in "$@"
do
  echo "Updating API version $version"
  git clone git@github.com:godotengine/godot.git \
    --branch "$version" \
    --depth 1 \
    --quiet \
    ".versions/$version"
  zip -qFSr \
    "src/main/resources/version/$version.zip" \
    ".versions/$version/doc/classes/" \
    ".versions/$version/modules/gdscript/doc_classes/@GDScript.xml"
done
