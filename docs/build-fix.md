# CyberPrivacy build hardening

This source tree is self-contained with respect to Git submodules.

## Repository policy
- Google Maven
- Maven Central
- Mozilla Maven, restricted to `org.mozilla.*`
- No JCenter/Bintray
- No Maven Local
- No external Git clone is required during CI.

## Permission handler
The archived Mozilla permission-handler module is vendored under:
`components/utils/android-permission-handler/permissionhandler`

It is part of the source tree and is not restored by GitHub Actions.

## CI
Android SDK tools use JDK 17; the legacy Gradle 5.6.4 build uses JDK 8.
