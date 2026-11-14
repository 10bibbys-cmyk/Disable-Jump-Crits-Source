# Disable Jump Crits 1.0.1.1

**Stable maintenance release · Minecraft 1.20.1 / Fabric / Java 17**

Version 1.0.1.1 brings Disable Jump Crits into the Path of the Ascended release system without changing its working combat functionality.

## Changes

- Adopted the four-number release version.
- Updated the public description to accurately document the four existing Mixins and required **Zenith Attributes Renewed 1.0.3** dependency.
- Updated release documentation and installation guidance.

## Preserved behaviour

- Vanilla jump/fall critical hits remain disabled.
- Zenith attribute-based critical chance and damage still work.
- Zenith crit effects and sounds continue to appear correctly.
- No combat source, configuration, or Mixin changes. No additional features or background processing.

**Testing:** The 1.0.1.1a candidate passed the modpack maintainer's in-game checks for vanilla jump-crit suppression and Zenith critical feedback. The stable build changes only metadata and documentation.

**Install:** Remove the old JAR and install 1.0.1.1 on both client and server. No config or save migration required.
