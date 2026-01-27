# AIVA - Voice Assistant Android App
## Complete Setup Guide for Android Studio

### 📋 Prerequisites
- Android Studio Hedgehog (2023.1.1) or newer
- JDK 8 or higher
- Android SDK (API 24-34)
- Minimum 4GB RAM (8GB recommended)

---

## 🚀 Step-by-Step Setup

### 1. Create New Android Project

1. Open Android Studio
2. Click **"New Project"**
3. Select **"Empty Activity"** (Compose)
4. Configure:
   - **Name:** AIVA
   - **Package name:** com.example.aiva
   - **Save location:** Choose your directory
   - **Language:** Kotlin
   - **Minimum SDK:** API 24 (Android 7.0)
   - **Build configuration language:** Kotlin DSL
5. Click **"Finish"**

---

### 2. Project Structure

After creation, your project structure should look like this:

```
AIVA/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/aiva/
│   │       │   ├── MainActivity.kt
│   │       │   ├── ui/
│   │       │   │   ├── theme/
│   │       │   │   │   ├── Theme.kt
│   │       │   │   │   ├── Type.kt
│   │       │   │   │   └── Shape.kt
│   │       │   │   ├── screens/
│   │       │   │   │   ├── OnboardingScreen.kt
│   │       │   │   │   ├── HomeScreen.kt
│   │       │   │   │   ├── SmartDevicesScreen.kt
│   │       │   │   │   ├── HistoryScreen.kt
│   │       │   │   │   └── SettingsScreen.kt
│   │       │   │   └── components/
│   │       │   │       ├── VoiceOrb.kt
│   │       │   │       └── BottomNavigationBar.kt
│   │       ├── res/
│   │       │   ├── values/
│   │       │   │   ├── strings.xml
│   │       │   │   └── themes.xml
│   │       │   └── mipmap/
│   │       └── AndroidManifest.xml
│   └── build.gradle
└── build.gradle (Project level)
```

---

### 3. File Placement Guide

#### **Step 3.1: Update build.gradle (Module: app)**

Replace the content of `app/build.gradle` with the provided `build.gradle` file.

**Location:** `app/build.gradle`

#### **Step 3.2: Update AndroidManifest.xml**

Replace `app/src/main/AndroidManifest.xml` with the provided file.

**Location:** `app/src/main/AndroidManifest.xml`

#### **Step 3.3: Create Theme Files**

Create the `theme` package and add files:

1. Right-click on `java/com/example/aiva`
2. New → Package → Name it `ui.theme`
3. Add these files to `ui/theme/`:
   - `Theme.kt`
   - `Type.kt`
   - `Shape.kt`

**Location:** `app/src/main/java/com/example/aiva/ui/theme/`

#### **Step 3.4: Create Screen Files**

Create the `screens` package:

1. Right-click on `java/com/example/aiva/ui`
2. New → Package → Name it `screens`
3. Add these files to `ui/screens/`:
   - `OnboardingScreen.kt`
   - `HomeScreen.kt`
   - `SmartDevicesScreen.kt`
   - `HistoryScreen.kt`
   - `SettingsScreen.kt`

**Location:** `app/src/main/java/com/example/aiva/ui/screens/`

#### **Step 3.5: Create Component Files**

Create the `components` package:

1. Right-click on `java/com/example/aiva/ui`
2. New → Package → Name it `components`
3. Add these files to `ui/components/`:
   - `VoiceOrb.kt`
   - `BottomNavigationBar.kt`

**Location:** `app/src/main/java/com/example/aiva/ui/components/`

#### **Step 3.6: Update MainActivity.kt**

Replace the content of `MainActivity.kt` with the provided file.

**Location:** `app/src/main/java/com/example/aiva/MainActivity.kt`

#### **Step 3.7: Update Resources**

1. **strings.xml**: Replace `app/src/main/res/values/strings.xml`
2. **themes.xml**: Replace `app/src/main/res/values/themes.xml`

---

### 4. Sync and Build

1. Click **"Sync Project with Gradle Files"** (toolbar icon)
2. Wait for the sync to complete
3. Fix any errors if they appear
4. Click **"Build" → "Make Project"**

---

### 5. Run the App

1. Connect an Android device or create an emulator
2. Click the **"Run"** button (green play icon)
3. Select your device
4. Wait for the app to install and launch

---

## 📱 App Features

### Screens Included:

1. **Onboarding** - 3-step introduction
2. **Home** - Main screen with animated voice orb
3. **Smart Devices** - Control smart home devices
4. **History** - View conversation history
5. **Settings** - Privacy and preferences

### Voice Orb States:

- **Idle** - Blue/Violet gradient, ready to activate
- **Listening** - Cyan pulsing with expanding rings
- **Processing** - Purple spinning animation
- **Speaking** - Bright blue with intense glow

---

## 🎨 Customization

### Changing Colors

Edit `app/src/main/java/com/example/aiva/ui/theme/Theme.kt`:

```kotlin
// Light theme colors
private val LightPrimary = Color(0xFF3B82F6) // Change this

// Dark theme colors
private val DarkPrimary = Color(0xFF60A5FA) // Change this
```

### Changing App Name

Edit `app/src/main/res/values/strings.xml`:

```xml
<string name="app_name">Your App Name</string>
```

### Changing Package Name

1. Right-click on `com.example.aiva` in project structure
2. Refactor → Rename
3. Update in `build.gradle` and `AndroidManifest.xml`

---

## 🔧 Troubleshooting

### Issue: Compose version mismatch
**Solution:** Update compose version in `build.gradle`:
```gradle
kotlinCompilerExtensionVersion '1.5.1'
```

### Issue: Import errors
**Solution:** 
1. File → Invalidate Caches / Restart
2. Rebuild project

### Issue: Build fails
**Solution:**
1. Clean project: Build → Clean Project
2. Rebuild: Build → Rebuild Project

### Issue: App crashes on launch
**Solution:**
1. Check LogCat for errors
2. Verify all files are in correct packages
3. Ensure AndroidManifest.xml has correct activity name

---

## 📦 Adding More Features

### Add Voice Recognition (Future Enhancement)

Add to `build.gradle`:
```gradle
implementation 'com.google.android.gms:play-services-speech:20.0.0'
```

### Add Permissions Handler

Create `PermissionHandler.kt` in `utils` package:
```kotlin
// Permission handling code
```

---

## 📚 Resources

- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Material 3 Design](https://m3.material.io/)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation)

---

## ✅ Checklist

- [ ] Android Studio installed
- [ ] New project created
- [ ] All Kotlin files added to correct packages
- [ ] build.gradle updated
- [ ] AndroidManifest.xml updated
- [ ] Resources (strings.xml, themes.xml) updated
- [ ] Project synced successfully
- [ ] App builds without errors
- [ ] App runs on emulator/device
- [ ] All screens navigate correctly
- [ ] Voice orb animates properly

---

## 🎯 Next Steps

1. **Add Real Voice Recognition** - Integrate Android Speech API
2. **Add Backend** - Connect to AI service
3. **Add Database** - Store conversation history
4. **Add Smart Home Integration** - Connect to IoT devices
5. **Add Notifications** - Proactive suggestions
6. **Publish** - Prepare for Google Play Store

---

## 📄 License

This project is for educational purposes. Customize and use as needed.

## 🤝 Support

If you encounter issues:
1. Check all files are in correct locations
2. Verify package names match
3. Clean and rebuild project
4. Check Android Studio version compatibility

---

**Happy Coding! 🚀**
