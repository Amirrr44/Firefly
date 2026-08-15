# FirefoxLite CyberPrivacy — Dependency / Repository / Submodule Audit

Audit target: FirefoxLite-CyberPrivacy-2.6.0-buildfix
Date: 2026-08-15

## Changes made

### Repository audit
- Removed every `jcenter()` declaration from the build.
- Replaced legacy JCenter usage with Maven Central in:
  - `buildSrc/build.gradle.kts`
  - `buildSrc/ktlint.gradle`
  - `third_party/glide/disklrucache/build.gradle`
- Root repositories remain Google + Maven Central + Mozilla Maven.
- Mozilla Maven is restricted to `org.mozilla.*`.
- Removed the unused `flatDir { dirs 'libs' }` repository from `app/build.gradle`.
- No `bintray.com`, `jcenter.bintray.com`, or `mavenLocal()` repository remains.

### Submodule audit
- Removed `.gitmodules`.
- Removed the CI-time `git clone` fallback for `android-permission-handler`.
- Vendored the archived Mozilla permission-handler module into:
  `components/utils/android-permission-handler/permissionhandler`
- Updated `settings.gradle` to use `rootDir` for the local module path.
- Updated README build instructions so no `git submodule init/update` step is required.

The upstream permission-handler repository is archived/inactive; vendoring it removes a runtime/build-time GitHub dependency while preserving the API used by FirefoxLite.

### CI audit
- GitHub Actions no longer clones external source repositories.
- JDK 17 is used for modern Android SDK command-line tools.
- JDK 8 is used for the legacy Gradle 5.6.4 / AGP 3.6.1 build.
- `set -o pipefail` is used so Gradle failures are not hidden by `tee`.
- Both Debug and Release APK variants are collected as artifacts.
- Release artifact is explicitly named `*-release-unsigned.apk`.
- No signing secret is required for this workflow.

## Remaining remote dependencies

The project necessarily downloads normal Maven/Google/Mozilla artifacts and the Gradle wrapper distribution during a clean build. These are not Git submodules or dead repository endpoints.

The Mozilla Maven repository is intentionally retained because this legacy FirefoxLite version depends on Mozilla Android Components (`org.mozilla.components:*`).

## Validation

Static audit results:
- `.gitmodules`: absent
- `jcenter()`: absent from Gradle build files
- `bintray.com`: absent from build configuration
- `jcenter.bintray.com`: absent
- `mavenLocal()`: absent
- CI `git clone` for dependencies: absent
- Permission handler source/build files: present

A full Gradle build could not be executed in this sandbox because the environment cannot resolve `services.gradle.org` to download the project's Gradle 5.6.4 distribution. This is an environment/network limitation, not a source-tree validation failure.
