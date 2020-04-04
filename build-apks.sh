#!/bin/bash
BASE=`pwd`
REPO_BASE_DIR=$BASE/SourceCode
APK_DIR=$BASE/APKs
mkdir -p APKs
for DIR in `ls $REPO_BASE_DIR`; do
	./build-single-apk.sh $REPO_BASE_DIR/$DIR $APK_DIR
done
