# Grimoire of Growth

A mobile-first, Kotlin-based Android skeleton for **Grimoire of Growth** — a habit RPG you can build entirely from your phone using **Termux + GitHub + GitHub Actions**.

## Tech Stack
- **Language:** Kotlin (JVM 17)  
- **Android Gradle Plugin:** 7.4.2  
- **Gradle (CI):** 7.6  
- **compileSdk:** 33 • **targetSdk:** 33 • **minSdk:** 26  
- **UI:** AppCompat + Material Components (XML) — no Compose

## Branch Strategy
- **testing/v1.0.0** – active dev; CI builds debug APK; artifacts include Logs + APKs.  
- **release/v1.0.0** – remains empty until we promote a tested build.  
- **docs/v1.0.0** – holds dev logs, changelogs, roadmaps (`dev-logs/`).

## CI
GitHub Actions installs JDK 17, Android SDK (platform 33, build-tools 33.0.2), runs Gradle 7.6 and uploads:
- `logs-testing-v*` → Gradle log(s)
- `apks-testing-v*` → debug APK(s)

## Build (via CI)
Push to **testing/v1.0.0** and open **Actions** to download artifacts.

## Status
Version: **1.0.0** (skeleton). Ready to extend with features (Habits, XP/Level, Streaks, Notifications, Settings).
