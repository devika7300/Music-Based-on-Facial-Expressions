# 🎵 Music Based on Facial Expressions

An Android app that detects a user's mood from their facial expressions and provides personalized music suggestions. Uses a custom CNN converted to TensorFlow Lite for on-device emotion detection at roughly 60 milliseconds per frame with around 88 percent accuracy. I developed the app in Java, integrated Firebase Crashlytics for stability, Remote Config for live model tweaks and persist user playlists locally in SQLite with the option to sync via Firestore. Fastlane CI drives nightly builds with Espresso UI tests and staged Google Play rollouts.
