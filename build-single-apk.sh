#!/bin/bash
REPO_DIR=$1
BASE=$(pwd)
APK_DIR=${2:-$BASE/APKs}
mkdir -p $APK_DIR
APK_PATH=$APK_DIR/$(basename $REPO_DIR).apk
rm -f $APK_PATH
cd $REPO_DIR
./gradlew clean assembleDebug
cd $BASE
cp $REPO_DIR/app/build/outputs/apk/debug/app-debug.apk $APK_PATH
