# Cyber-Privacy Update

This branch applies a privacy-first browser baseline without changing the app's existing product architecture.

## UI / UX
- Dark minimalist visual system with cyan/indigo cyber accents.
- Glass-style surfaces use translucent fills, thin borders and rounded geometry.
- Browser chrome and bottom navigation use larger touch targets and reduced visual noise.
- Home/search surfaces use the same visual language as the browser chrome.

## Transport / WebView protocol baseline
- Cleartext HTTP is denied by Android Network Security Config.
- WebView mixed content is denied on Android 5.0+.
- Android Safe Browsing is explicitly enabled on Android 8.0+.
- Third-party cookies are disabled on Android 5.0+ to reduce cross-site tracking.
- WebView form-data persistence is disabled.
- Local file/content access remains restricted.

## Compatibility note
This is intentionally a conservative hardening pass. Some legacy HTTP-only resources or sites that depend on third-party cookies may behave differently. The existing content-blocking and browser navigation layers remain responsible for site-level behavior.

## CI / APK
GitHub Actions builds the `focus + webkit + release` variant using the repository's Gradle wrapper, Java 8 and Android API 28/build-tools 28.0.3, then publishes the unsigned release APK as an Actions artifact named `FirefoxLite-CyberPrivacy-release`.
