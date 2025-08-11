#!/usr/bin/env bash
# step3_scaffold.sh — Scaffold minimal Android app (Java + AppCompat + Material)
# Target: minSdk 26, targetSdk 31, AGP 7.4.2, Gradle wrapper 7.6
# Repo user: Azrea-Shade  | App ID: com.azreashade.grimoireofgrowth

set -Eeuo pipefail

APP_NAME="Grimoire-of-Growth"
APP_ID="com.azreashade.grimoireofgrowth"
PKG_DIR="app/src/main/java/$(echo "$APP_ID" | tr '.' '/')"

say() { printf "\n\033[1;36m==>\033[0m %s\n" "$*"; }

# -- sanity checks -------------------------------------------------------------
say "Checking environment…"
command -v git >/dev/null || { echo "git not found"; exit 1; }
command -v gradle >/dev/null || { echo "gradle not found. Install: pkg install gradle"; exit 1; }

# verify we are in a git repo root
git rev-parse --show-toplevel >/dev/null 2>&1 || { echo "Not inside a git repo. cd into your cloned repo first."; exit 1; }

REPO_ROOT="$(git rev-parse --show-toplevel)"
cd "$REPO_ROOT"

say "Repo root: $REPO_ROOT"
CURRENT_BRANCH="$(git branch --show-current || echo '')"
if [ -z "$CURRENT_BRANCH" ]; then
  echo "No current branch. Create one with: git checkout -b mvp"
  exit 1
fi
say "On branch: $CURRENT_BRANCH"

# -- directories ---------------------------------------------------------------
say "Creating directories…"
mkdir -p "$PKG_DIR" \
  app/src/main/res/{layout,drawable,mipmap-anydpi-v26,values}

# -- settings.gradle -----------------------------------------------------------
say "Writing settings.gradle…"
cat > settings.gradle <<EOF
rootProject.name = "${APP_NAME}"
include(":app")
EOF

# -- root build.gradle ---------------------------------------------------------
say "Writing root build.gradle…"
cat > build.gradle <<'EOF'
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:7.4.2'
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
task clean(type: Delete) { delete rootProject.buildDir }
EOF

# -- app/build.gradle ----------------------------------------------------------
say "Writing app/build.gradle…"
cat > app/build.gradle <<EOF
plugins { id 'com.android.application' }

android {
    compileSdk 31

    defaultConfig {
        applicationId "${APP_ID}"
        minSdk 26
        targetSdk 31
        versionCode 1
        versionName "0.0.1"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
        debug { debuggable true }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    buildFeatures { viewBinding true }
}

dependencies {
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.10.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
}
EOF

# -- proguard rules ------------------------------------------------------------
say "Writing proguard rules…"
cat > app/proguard-rules.pro <<'EOF'
# keep rules go here
EOF

# -- AndroidManifest.xml -------------------------------------------------------
say "Writing AndroidManifest.xml…"
cat > app/src/main/AndroidManifest.xml <<'EOF'
<?xml version="1.0" encoding="utf-8"?>
<manifest package="com.azreashade.grimoireofgrowth"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.POST_NOTIFICATIONS" tools:targetApi="33" />
    <uses-permission android:name="android.permission.ACTIVITY_RECOGNITION" tools:targetApi="29" />
    <!-- Optional GPS (for later feature branch) -->
    <!-- <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" /> -->
    <!-- <uses-permission android:name="android.permission.ACCESS_BACKGROUND_LOCATION" tools:targetApi="29" /> -->

    <application
        android:label="Grimoire of Growth – A spellbook of your life’s habits"
        android:icon="@mipmap/ic_launcher"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:theme="@style/Theme.MaterialComponents.DayNight.NoActionBar">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
EOF

# -- MainActivity.java ---------------------------------------------------------
say "Writing MainActivity.java…"
cat > "${PKG_DIR}/MainActivity.java" <<'EOF'
package com.azreashade.grimoireofgrowth;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
EOF

# -- activity_main.xml ---------------------------------------------------------
say "Writing layout/activity_main.xml…"
cat > app/src/main/res/layout/activity_main.xml <<'EOF'
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/title"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:padding="24dp"
        android:text="🔮 Grimoire of Growth"
        android:textSize="24sp"
        android:gravity="center"
        android:contentDescription="App title"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"/>
</androidx.constraintlayout.widget.ConstraintLayout>
EOF

# -- colors.xml for icon background -------------------------------------------
say "Writing values/colors.xml…"
cat > app/src/main/res/values/colors.xml <<'EOF'
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="ic_launcher_background">#3E1F47</color>
</resources>
EOF

# -- simple vector foreground for adaptive icon --------------------------------
say "Writing drawable/ic_launcher_foreground.xml…"
cat > app/src/main/res/drawable/ic_launcher_foreground.xml <<'EOF'
<?xml version="1.0" encoding="utf-8"?>
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="108dp" android:height="108dp"
    android:viewportWidth="108" android:viewportHeight="108">
    <path android:fillColor="#FFFFFF" android:pathData="M0,0h108v108h-108z"/>
    <path android:fillColor="#7B44A5" android:pathData="M18,18h72v72h-72z"/>
</vector>
EOF

# -- adaptive icons ------------------------------------------------------------
say "Writing mipmap-anydpi-v26/ic_launcher*.xml…"
cat > app/src/main/res/mipmap-anydpi-v26/ic_launcher.xml <<'EOF'
<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@color/ic_launcher_background"/>
    <foreground android:drawable="@drawable/ic_launcher_foreground"/>
</adaptive-icon>
EOF

cat > app/src/main/res/mipmap-anydpi-v26/ic_launcher_round.xml <<'EOF'
<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@color/ic_launcher_background"/>
    <foreground android:drawable="@drawable/ic_launcher_foreground"/>
</adaptive-icon>
EOF

# -- Gradle wrapper ------------------------------------------------------------
say "Generating Gradle wrapper @ 7.6…"
gradle wrapper --gradle-version 7.6
chmod +x gradlew

# -- git commit & push ---------------------------------------------------------
say "Committing files…"
git add -A
if git diff --cached --quiet; then
  say "Nothing to commit."
else
  git commit -m "chore: scaffold Java+AppCompat skeleton (AGP 7.4.2, Gradle wrapper 7.6, minSdk 26 target 31)"
fi

say "Pushing…"
if git rev-parse --abbrev-ref --symbolic-full-name '@{u}' >/dev/null 2>&1; then
  git push
else
  git push -u origin "$(git branch --show-current)"
fi

say "Done! 🎉  Next: say 'next' and I’ll drop STEP B (full files + GitHub Actions CI)."
