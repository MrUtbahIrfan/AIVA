# ⚡ AIVA - Quick Start Guide

## 🎯 Get Running in 5 Minutes

### Step 1: Create Project (2 min)

1. Open **Android Studio**
2. **New Project** → **Empty Activity**
3. Configure:
   - Name: `AIVA`
   - Package: `com.example.aiva`
   - Language: `Kotlin`
   - Minimum SDK: `API 24`
4. Click **Finish**

---

### Step 2: Create Packages (1 min)

Right-click on `com.example.aiva` → New → Package

Create these 3 packages:
- `ui.theme`
- `ui.screens`
- `ui.components`

---

### Step 3: Copy Files (1 min)

Copy files to these locations:

#### Main Files
```
MainActivity.kt → app/src/main/java/com/example/aiva/
```

#### Theme Files (in ui/theme/)
```
Theme.kt
Type.kt
Shape.kt
```

#### Screen Files (in ui/screens/)
```
OnboardingScreen.kt
HomeScreen.kt
SmartDevicesScreen.kt
HistoryScreen.kt
SettingsScreen.kt
```

#### Component Files (in ui/components/)
```
VoiceOrb.kt
BottomNavigationBar.kt
```

#### Config Files
```
build.gradle → app/build.gradle (REPLACE)
AndroidManifest.xml → app/src/main/AndroidManifest.xml (REPLACE)
strings.xml → app/src/main/res/values/strings.xml (REPLACE)
themes.xml → app/src/main/res/values/themes.xml (REPLACE)
```

---

### Step 4: Sync & Build (1 min)

1. Click **Sync Project with Gradle Files** 🔄
2. Wait for sync to complete
3. Click **Build → Make Project** 🔨

---

### Step 5: Run! (30 sec)

1. Click **Run** ▶️
2. Select device/emulator
3. Done! 🎉

---

## 🎨 File Locations Cheat Sheet

```
AIVA/
└── app/
    ├── build.gradle ← build.gradle
    └── src/main/
        ├── AndroidManifest.xml ← AndroidManifest.xml
        ├── java/com/example/aiva/
        │   ├── MainActivity.kt
        │   └── ui/
        │       ├── theme/
        │       │   ├── Theme.kt
        │       │   ├── Type.kt
        │       │   └── Shape.kt
        │       ├── screens/
        │       │   ├── OnboardingScreen.kt
        │       │   ├── HomeScreen.kt
        │       │   ├── SmartDevicesScreen.kt
        │       │   ├── HistoryScreen.kt
        │       │   └── SettingsScreen.kt
        │       └── components/
        │           ├── VoiceOrb.kt
        │           └── BottomNavigationBar.kt
        └── res/values/
            ├── strings.xml
            └── themes.xml
```

---

## ✅ Quick Checklist

- [ ] Project created in Android Studio
- [ ] 3 packages created (theme, screens, components)
- [ ] All .kt files copied to correct packages
- [ ] build.gradle replaced
- [ ] AndroidManifest.xml replaced
- [ ] strings.xml and themes.xml replaced
- [ ] Project synced successfully
- [ ] Project builds without errors
- [ ] App runs on device

---

## 🐛 Quick Fixes

**Can't find package?**
```
Make sure package name is exactly: com.example.aiva
```

**Import errors?**
```
File → Invalidate Caches / Restart
```

**Build fails?**
```
Build → Clean Project
Build → Rebuild Project
```

**Sync issues?**
```
Update Android Studio to latest version
```

---

## 🎯 Next Steps

1. **Test all screens** - Navigate through the app
2. **Try voice orb** - Tap to see animations
3. **Toggle theme** - Test light/dark mode
4. **Read full docs** - Check PROJECT_SETUP_GUIDE.md

---

## 🚀 Pro Tips

1. Use Android Studio's auto-import (Alt+Enter)
2. Enable auto-sync in settings
3. Keep only one version of each file
4. Check package statements match folders

---

## 📱 Expected Result

After successful setup:
- ✅ Onboarding screen shows first
- ✅ Voice orb animates on tap
- ✅ Bottom navigation works
- ✅ All screens accessible
- ✅ Theme toggle works
- ✅ Smooth animations

---

## 🎉 Success!

You should now have a fully functional AIVA app!

**Still stuck?** Check the detailed `PROJECT_SETUP_GUIDE.md`

---

Made with ❤️ for quick setup
