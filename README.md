# Grimoire of Growth

**Grimoire of Growth** is a mobile-first **habit-RPG** for Android. Level up your life like a game: complete habits, earn XP, maintain streaks, and unlock progression. Built to be developed and shipped entirely from a phone (Termux + GitHub Actions), then grown into a full game.

## Vision
Turn daily routines into meaningful quests. The app stays fast, simple, and rewarding—every action should feel like progress toward a character you care about.

## Design Pillars
- **Tiny wins, big momentum** – frequent feedback (XP, streaks, milestones).
- **Frictionless input** – adding/checking habits should be one-tap simple.
- **Readable & cozy** – calm UI, clear typography, minimal clutter.
- **Honest progression** – no predatory loops; progression is earned.

## Core Loop
1. Plan or pick a habit.
2. Complete the habit.
3. Earn **XP**, track **streak**, see **level** grow.
4. Review trends → adjust habits → repeat.

## Current Scope (MVP Skeleton)
- Kotlin Android app w/ **AppCompat + Material Components** (XML views, ViewBinding).
- **MainActivity** + **SettingsActivity** (preferences scaffold).
- Resource groundwork (strings, arrays, theme, simple layout).
- **CI** builds on `testing/v1.0.0` and uploads **APKs** + **build logs** as Artifacts.
- **Release branch** stays clean until promotion.

## Planned Gameplay/Features
- **Habits System**: create/edit habits, categories/tags, sort & swipe actions.
- **Progression**: XP curve, levels, streaks, achievements (later).
- **Reminders**: daily reset time, local notifications, quiet hours.
- **Stats & Insights**: streak heatmap, completion rate, best days.
- **Cosmetics (later)**: themes, simple vanity rewards, name/title customization.
- **Backups (later)**: export/import, cloud option.

## Settings (Initial Targets)
- Theme (Light/Dark/System)  
- Daily reset time  
- Default sort (Created/Last/Name)  
- Swipe action (None/Complete/Delete/Rename)  
- Notifications toggles (later)

## Tech Stack
- **Language**: Kotlin (JVM 17)  
- **Android Gradle Plugin**: 7.4.2 • **Gradle**: 7.6  
- **SDK**: compile/target 33 • min 26  
- **UI**: AppCompat + Material Components (XML)  
- **Testing**: (to add) JUnit, Espresso

## Branch & CI Policy
- **testing/v1.0.0** – development branch, **auto-builds** on push, uploads **APKs + logs**.
- **release/v1.0.0** – manual promotion only, kept clean/stable.
- **docs** – dev logs, changelogs, roadmaps.

## Status
Version **1.0.0 (skeleton)**. The base is green on CI and ready to grow into the full game.
