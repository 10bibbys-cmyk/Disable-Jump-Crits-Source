# Building Disable Jump Crits 1.0.1.1

The project targets **Minecraft 1.20.1**, **Fabric**, **Java 17**, **Gradle 8.8** and **Zenith Attributes Renewed 1.0.3**.

1. Install Java Development Kit 17 and Gradle 8.8.
2. Clone or download this public source snapshot.
3. Run the following from the repository root:

```sh
gradle --no-daemon clean build
```

Gradle resolves Minecraft, Fabric Loader, Fabric API and the pinned Zenith Attributes Renewed dependency through its configured repositories. No local proprietary dependency files are required.

Expected artifacts:
- `build/libs/disable-jump-crits-1.0.1.1.jar`
- `build/libs/disable-jump-crits-1.0.1.1-sources.jar`

Confirm the generated `fabric.mod.json` reports:
- Mod ID: `pota_no_jump_crits`
- Version: `1.0.1.1`
- Required `zenith_attributes`: `1.0.3`

Building successfully checks compilation; it does not independently confirm compatibility in a running modpack. The preceding 1.0.1.1a build was tested in-game by the maintainer.

**Licence:** All Rights Reserved. Private local compilation for inspection is permitted under `LICENSE`. Public redistribution of source or binaries is not authorised without prior written permission.
