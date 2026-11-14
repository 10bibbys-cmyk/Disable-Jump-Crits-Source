# Disable Jump Crits

**Public source code snapshot — 1.0.1.1**  
**Minecraft 1.20.1 · Fabric · Java 17+**

**Disable Jump Crits** removes vanilla jump/fall critical hits while preserving attribute-based critical hits in [Path of the Ascended](https://www.curseforge.com/minecraft/modpacks/path-of-the-ascended) and other compatible Fabric modpacks.

This repository contains a clean source snapshot corresponding to the stable **1.0.1.1** release, published so others can inspect and verify how the mod works. It contains **no private development history**.

> **Source available for inspection. All Rights Reserved.** This is **not** an open-source licence. Private, non-commercial inspection and local compilation are permitted under the terms in [LICENSE](LICENSE); redistribution, rehosting, published derivatives and reuse of the source in other distributed projects require prior written permission.

## What it does

- **Disables vanilla jump crits:** Airborne player attacks no longer receive the automatic vanilla critical-hit bonus.
- **Preserves attribute-based critical hits:** Critical chance and damage from **Zenith Attributes Renewed** remain functional.
- **Keeps critical-hit feedback:** Zenith successful-hit effects retain their sound and electric-spark particles.
- **Does not change** the player's fall distance, movement, jumping, normal attack speed, knockback or fall damage.
- **Lightweight:** No gameplay configuration, tick handlers or background processing.

This mod uses a targeted Mixin for the vanilla critical flag and three additional Mixins for the Zenith critical-hit feedback integration.

## Requirements

- **Minecraft:** Java Edition 1.20.1
- **Mod loader:** Fabric
- **Java:** 17 or newer
- **Required mod:** Zenith Attributes Renewed **1.0.3**, including its dependencies
- **Mod ID:** `pota_no_jump_crits`

The Zenith compatibility code is pinned to implementation details of version **1.0.3**. Other versions have not been verified and may be incompatible.

## Repository contents

- `src/main/java/` — vanilla critical-hit Mixin and Zenith critical-hit feedback classes
- `src/main/resources/` — Fabric metadata and Mixin configuration
- `build.gradle`, `settings.gradle`, `gradle.properties` — project build settings
- `CHANGELOG.md` — stable 1.0.1.1 release notes
- `BUILDING.md` — private build verification instructions
- `LICENSE` — All Rights Reserved source-inspection terms

## Building for private verification

Install **JDK 17** and **Gradle 8.8**, then run:

```sh
gradle --no-daemon clean build
```

The Gradle build resolves its dependencies from the configured repositories. Resulting JARs appear under `build/libs/`. The ability to build a local copy does not grant permission to distribute it; refer to [LICENSE](LICENSE).

## Release verification

**Source snapshot:** 1.0.1.1  
**Stable release source commit:** `c0ee14778776dadb63883900687afcc03ef67344` (private development repository)  
**Original gameplay logic:** Unchanged from 1.0.1

The preceding **1.0.1.1a** test was confirmed in-game by the modpack maintainer: vanilla jump crits were disabled, and attribute-based critical hits retained their VFX and SFX. The stable build was rebuilt and passed CI validation. Dedicated multiplayer and every possible third-party combat combination were not independently certified.

This public repository is a fresh source snapshot, not a mirror of private development commits. No bundled third-party JARs are included.

## Permission, support and disclosure

For bug reports, include the Minecraft version, mod version, mod list, `latest.log` and reproduction steps. Official mod releases are distributed separately under their applicable terms.

**Developed for Path of the Ascended.**

**AI-Assisted Development Disclosure:** AI-assisted tools were used during development and documentation. The mod was reviewed and tested by its developer.
