# 🎤 AIVA - AI Voice Assistant

A modern, voice-first Android mobile application built with Jetpack Compose and Material 3 design system.

![Android](https://img.shields.io/badge/Android-7.0+-green.svg)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9+-purple.svg)
![Compose](https://img.shields.io/badge/Compose-Latest-blue.svg)
![Material3](https://img.shields.io/badge/Material%203-Design-orange.svg)

---

## ✨ Features

### 🎯 Core Features
- **Animated Voice Orb** with 4 states (Idle, Listening, Processing, Speaking)
- **Voice-First Interface** optimized for hands-free interaction
- **Material 3 Design** with beautiful gradients and smooth animations
- **Dark/Light Theme** with seamless transitions
- **Navigation System** with bottom navigation bar
- **Onboarding Flow** for new users

### 📱 Screens
1. **Onboarding** - 3-step introduction to AIVA
2. **Home** - Main interface with voice orb and suggestions
3. **Smart Devices** - Control smart home devices
4. **History** - View past conversations
5. **Settings** - Privacy controls and preferences

### 🎨 Design Highlights
- Clean, futuristic, minimal aesthetic
- Soft gradients (Blue → Violet → Cyan)
- Smooth micro-interactions
- High-contrast typography
- Accessibility-friendly spacing
- Material You dynamic colors

---

## 🚀 Quick Start

### Prerequisites
- Android Studio Hedgehog (2023.1.1) or newer
- JDK 8 or higher
- Android SDK (API 24-34)
- Basic knowledge of Kotlin and Jetpack Compose

### Installation Steps

1. **Clone or Download** the project files

2. **Open Android Studio**
   ```
   File → New → New Project
   Select: Empty Activity (Compose)
   Name: AIVA
   Package: com.example.aiva
   Language: Kotlin
   Minimum SDK: API 24
   ```

3. **Copy Files** to your project:
   - See `FILE_STRUCTURE.txt` for exact locations
   - See `PROJECT_SETUP_GUIDE.md` for detailed instructions

4. **Sync Project**
   ```
   Click "Sync Project with Gradle Files"
   ```

5. **Build & Run**
   ```
   Build → Make Project
   Run → Run 'app'
   ```

---

## 📁 Project Structure

```
AIVA/
├── MainActivity.kt              # Entry point
├── ui/
│   ├── theme/                   # Theme, colors, typography
│   ├── screens/                 # All screen composables
│   └── components/              # Reusable components
├── res/
│   ├── values/                  # Strings, themes
│   └── mipmap/                  # App icons
└── build.gradle                 # Dependencies
```

---

## 🎨 Color Palette

### Light Theme
- Primary: `#3B82F6` (Blue)
- Secondary: `#8B5CF6` (Violet)
- Tertiary: `#06B6D4` (Cyan)
- Background: `#F9FAFB`
- Surface: `#FFFFFF`

### Dark Theme
- Primary: `#60A5FA` (Light Blue)
- Secondary: `#A78BFA` (Light Violet)
- Tertiary: `#22D3EE` (Light Cyan)
- Background: `#030712`
- Surface: `#111827`

---

## 🔧 Technologies Used

- **Kotlin** - Primary language
- **Jetpack Compose** - Modern UI toolkit
- **Material 3** - Design system
- **Navigation Compose** - Screen navigation
- **Coroutines** - Asynchronous programming
- **StateFlow** - Reactive state management

---

## 📚 Documentation

- **[PROJECT_SETUP_GUIDE.md](PROJECT_SETUP_GUIDE.md)** - Complete setup instructions
- **[FILE_STRUCTURE.txt](FILE_STRUCTURE.txt)** - Visual file organization
- **[ICON_GUIDE.md](ICON_GUIDE.md)** - How to create app icons

---

## 🎯 Voice Orb States

| State | Animation | Description |
|-------|-----------|-------------|
| **IDLE** | Static gradient | Ready to listen |
| **LISTENING** | Pulsing + rings | Capturing voice input |
| **PROCESSING** | Spinning | Analyzing request |
| **SPEAKING** | Glowing | Providing response |

---

## 🔐 Permissions

```xml
<uses-permission android:name="android.permission.RECORD_AUDIO" />
<uses-permission android:name="android.permission.INTERNET" />
```

---

## 🎓 Learning Resources

### Official Documentation
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Material 3](https://m3.material.io/)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)

### Tutorials
- [Compose Basics](https://developer.android.com/jetpack/compose/tutorial)
- [Navigation in Compose](https://developer.android.com/jetpack/compose/navigation)
- [Material 3 Components](https://developer.android.com/jetpack/compose/designsystems/material3)

---

## 🛠️ Customization

### Change App Name
Edit `res/values/strings.xml`:
```xml
<string name="app_name">Your App Name</string>
```

### Change Colors
Edit `ui/theme/Theme.kt`:
```kotlin
//private val LightPrimary = Color(0xFFYourColor)
```

### Modify Voice Orb
Edit `ui/components/VoiceOrb.kt`:
- Adjust animation duration
- Change gradient colors
- Modify ring count

---

## 🚧 Future Enhancements

- [ ] Real voice recognition (Android Speech API)
- [ ] AI backend integration
- [ ] Conversation history persistence (Room DB)
- [ ] Smart home device integration
- [ ] Wake word detection
- [ ] Multi-language support
- [ ] Proactive notifications
- [ ] Voice profiles

---

## 🐛 Troubleshooting

### Common Issues

**Build fails:**
```
Solution: Clean Project → Rebuild Project
```

**Import errors:**
```
Solution: File → Invalidate Caches / Restart
```

**App crashes:**
```
Check LogCat for error messages
Verify all files are in correct packages
```

**Compose version mismatch:**
```
Update compose version in build.gradle
```

---

## 📱 Compatibility

- **Minimum SDK:** API 24 (Android 7.0)
- **Target SDK:** API 34 (Android 14)
- **Tested on:**
  - Android 7.0 - 14
  - Various screen sizes (phones, tablets)
  - Multiple device manufacturers

---

## 📄 License

This project is for educational and demonstration purposes.
Feel free to use, modify, and distribute as needed.

---

## 🤝 Contributing

Contributions are welcome! Feel free to:
- Report bugs
- Suggest features
- Submit pull requests
- Improve documentation

---

## 👨‍💻 Author

Created as a demonstration of modern Android development with Jetpack Compose.

---

## 🙏 Acknowledgments

- Material Design team for design guidelines
- Jetpack Compose team for the amazing toolkit
- Android developer community

---

## 📞 Support

For issues and questions:
1. Check `PROJECT_SETUP_GUIDE.md`
2. Review `FILE_STRUCTURE.txt`
3. Verify package names match exactly
4. Ensure all dependencies are synced

---

## 🎉 Getting Started

Ready to build? Follow these steps:

1. ✅ Read `PROJECT_SETUP_GUIDE.md`
2. ✅ Create new Android project
3. ✅ Copy all files to correct locations
4. ✅ Sync and build
5. ✅ Run on device/emulator
6. ✅ Customize and enjoy!

---

**Happy Coding! 🚀**

---

## 📊 Stats

- **Lines of Code:** ~1,500+
- **Files:** 15+ Kotlin files
- **Screens:** 5 main screens
- **Components:** 2 reusable components
- **Animations:** Multiple state-based animations
- **Theme Support:** Light + Dark modes

---

Made with ❤️ using Jetpack Compose
