# Grimoire of Growth — Vision

**Last updated:** 2025-08-12 (UTC)

A cozy Android habit-RPG you can build entirely from mobile. No monetization, no loot boxes — just progression, story, and tools that help real life feel like an adventure.

## Core Loop
1) Log habits/quests ➜ 2) Earn XP, gold, and items ➜ 3) Upgrade your character/town ➜ 4) Unlock new chapters, map areas, and narrative arcs.

## Pillars
- **Kotlin Android app** (AGP 7.4.2, Gradle 7.6, JDK 17, compileSdk 33, minSdk 26)
- **Mobile-first dev** (Termux + GitHub Actions for APKs)
- **Respect for players**: privacy, offline-friendly, exportable data, zero monetization.

## Systems (MVP ➜ 1.0 path)
- AI-assisted reward suggestions & stacking
- Journey-based chapters (~60-day arcs)
- Quantity goals & long-term mastery (e.g., “Brew 100 teas”)
- Journaling & mood logs that can branch narrative
- Sabbatical mode (pause without streak loss)
- Interactive map dashboard; Pomodoro mini-battles
- Themes & accessibility; exportable analytics
- Seasonal events; mentor NPC; meta-achievements

## Factions & Reputation
Towns are alive with **~12 factions** (e.g., City Guard, Monastic Order, Alchemists’ Guild, Merchants’ Consortium, Rangers, Artisans, Archivists, Healers, Explorers, Shipwrights, Astronomers, Couriers).  
Daily habits translate into **faction reputation** — complete guard-style tasks (discipline, fitness, patrol walks) to earn Guard rep; mindful routines build Monastic rep, etc.

**How it works**
- Each habit can (optionally) tag a primary faction.
- Completing a habit grants base XP + **rep** for that faction; streaks apply multipliers.
- Rep ranks unlock **perks** (discounts, fast-travel, crafting benches, NPC allies, town titles).
- Weekly co-op bounties let parties pool progress to unlock faction festivals or town upgrades.
- Narrative reacts to standing: doors open, prices change, rumors spread; rival factions may offer counter-quests.

**No monetization, ever.** Progress is earned purely through play and consistency.

---

## Appendix – Unique RPG Mechanics & Systems (added on 2025-08-12)
**No monetization. No loot boxes. Offline-friendly by design.**

### Combat, Crafting, Fusion
- **Active combat mini-games** tied to habits (quick tap/dodge battles that award XP/materials).
- **Deep crafting**: materials from habits → forge weapons/armor/spellbooks.
- **Habit fusion → hybrid spells** (e.g., meditation + exercise unlocks unique buffs).

### Quests, Exploration, PvP (optional/async)
- **Narrative chapters & treasure hunts** unlocked by milestones.
- **Optional co-op/world bosses** and later **async PvP** comparing streaks.

### Rhythm, Focus & Companions
- **Rhythm-based Pomodoro challenges**; perfect tempo yields resources.
- **Companion spirits (pets)** with care loops; long streaks enable breeding/traits.

### Economy & Trading (non-crypto, no real-money)
- **In-game marketplace** for crafted gear, herbs, lore pages.

### Classes, Bases, Dungeons
- **Classes mapped to habit categories** (Scholar/Warrior/Artisan/etc.).
- **Personal base/town upgrades** via resources from habits.
- **Procedural dungeons** unlocked after weekly goals.

### Settlement & Procedural Realms
- **Habit districts** (garden/library/forge) visually upgrade with streaks.
- **Procedurally generated zones** by time/season; expandable fortress with bonuses.

### Factions & Reputation
- **~12 town/guild factions** (Monks, Guards, Artisans, Scholars, etc.).
- Daily habits and themed quests **grant faction reputation**, unlocking perks, cosmetics, and storylines.
- Optional **territory control/guild wars** in future (offline-friendly, async updates).

### IRL-Aware (optional)
- **Location-aware reminders & AR encounters** (graceful offline fallback).
- **Geocache-style QR hunts** for lore/rare items (optional).

### Resource Management
- **Mining/herbalism/alchemy mini-games** powered by streak-generated workers/resources.

### Audio & Lore
- **Narrated missions** that progress as habits complete.
- **Collectible relic/lore sets** with trading of duplicates.

### Avatar, Accessibility, Themes
- **Deep, inclusive character creator**; one-hand & high-contrast modes; multiple themes.
- **Dynamic backdrops** based on time/weather/habit context.

### Systems & Rewards
- **Health/Corruption meter** (missed habits add tension; rituals/potions heal).
- **Random mystery chests** for clearing all dailies.
- **Attributes tied to habit types** (exercise→STR, reading→WIS, etc.).
- **Energy-aware, adaptive quests** (smaller tasks on low-energy days).
- **Archetype specializations** with repeatable/weekly quests.
- **Micro-quests for self-care** (hydration, stretching) grant quick buffs.

### UI/Flow
- **World map “habit hubs”** instead of a static list.
- **Focus Garden** that grows items during screen-free timers.
- **QoL**: quick-heal, pinned goals, gentle tips.

### Offline-First Notes
- Cache assets locally; procedural events when offline; **async sync** for co-op and backups.

