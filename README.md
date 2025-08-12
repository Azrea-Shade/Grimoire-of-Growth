# Grimoire of Growth – A spellbook of your life’s habits

**Android habit tracker with light RPG flair.**  
Built in **Kotlin** with **AppCompat + Material (XML only, no Compose)**. Targets Android **8.0+ (API 26–15)**.

---

## Tech Stack

- **Language:** Kotlin **1.7.20**
- **Android Gradle Plugin:** **7.4.2**
- **Gradle Wrapper:** **7.6**
- **JDK:** Temurin **17**
- **compileSdk / targetSdk:** **33**
- **minSdk:** **26**
- **AndroidX / Material (pinned for AGP 7.4.2)**
  - appcompat 1.6.1, material 1.9.0, core-ktx 1.9.0
  - recyclerview 1.3.1, preference 1.2.1, constraintlayout 2.1.4
  - activity-ktx 1.6.1 (kept < 1.8 to avoid compileSdk 34 requirement)

> CI installs Android SDK **platforms;android-33** and **build-tools;33.0.2**.

---

## Branch & CI Strategy

- **testing/v1.0** — active dev. Every push builds a **debug APK** and uploads **logs/APKs** as GitHub Actions artifacts.
- **release/v1.0** — **manual-only** workflow. Stays clean until we explicitly trigger a release build.

Artifacts (Actions → latest run):
- Logs: `logs-testing-*` / `logs-release-*`
- APKs: `apks-testing-*` / `apks-release-*`

🔒 **Policy:** scripts never modify `release/*` unless explicitly requested.

---

## MVP (current)

- **Habits list:** create / rename / delete; toggle “completed today”.
- **Settings** (PreferenceFragmentCompat): Theme (System/Light/Dark), Sort (Created/Last/Name), Quick toggle, Confirm delete, Swipe L/R action.
- **Storage:** single JSON blob in `SharedPreferences`.
- **A11y:** ~56dp touch rows, content descriptions, respects system font size.

---

## Near-term Roadmap

**Slice 2 — XP / Level / Streaks + Daily Reset**
- XP curve: `level = floor(sqrt(XP / 10))`
- Per-habit streaks; break on missed day
- Local-midnight reset via `AlarmManager` + `BroadcastReceiver`
- Settings: Night-owl offset, optional 1-day streak grace

Next: Notifications, Export/Import JSON (SAF), UI foundation, RPG features, sensors, cloud, Room.

---

## Project Structure

app/src/main/java/com/azreashade/grimoireofgrowth/  
- ui/ (MainActivity, HabitsActivity, SettingsActivity)  
- ui/adapters/ (RecyclerView adapters)  
- data/ (PrefsStore)  
- domain/ (Habit model)  
- util/ (DateUtils, ThemeUtils, SwipeToAction)  
res/layout/ (activity_*.xml, item_*.xml)  
res/xml/ (prefs_settings.xml)  
res/values/ (strings.xml, arrays.xml, themes.xml)  
dev-logs/ (daily development logs)  
scripts/ (dev helper scripts)

---

## Build & Test

**CI builds** are the source of truth. For a local build (optional):

./gradlew :app:assembleDebug  
# APK: app/build/outputs/apk/debug/app-debug.apk

---

## License

MIT
