# Compose Multiplatform Login Demo

[![Kotlin](https://img.shields.io/badge/Kotlin-2.2.20-blue.svg?style=flat&logo=kotlin)](https://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-1.9.0-brightgreen.svg)](https://www.jetbrains.com/lp/compose-multiplatform/)
[![Koin](https://img.shields.io/badge/Koin-4.1.0-orange.svg)](https://insert-koin.io/)
[![Voyager](https://img.shields.io/badge/Voyager-1.1.0_Beta03-purple.svg)](https://voyager.adriel.cafe/)

**También disponible en ESPAÑOL** -->
**[Español](README.es.md)** | **English**

A **demonstration project** showcasing adaptive UI layouts in **Compose Multiplatform** with **Koin** dependency injection. This project demonstrates how to build responsive interfaces that automatically adapt to different screen sizes across Android and Desktop platforms.

## About

This project is a **practical example** of implementing:

- **Compose Multiplatform** for shared UI code
- **Adaptive layouts** for Mobile, Tablet, and Desktop
- **Koin 4.1** for dependency injection
- **Voyager** for navigation
- **Reusable UI components** for maximum code efficiency

The application features a login screen that dynamically adapts its layout based on screen size, demonstrating best practices for building multi-platform applications.

## Features

### Mobile Layout (< 600dp)
- Single-column vertical design
- Optimized for small screens
- Touch-friendly spacing

### Tablet Layout (600dp - 880dp)
- Centered content with constrained width
- Larger typography
- Improved readability

### Desktop Layout (> 880dp)
- Two-column design
- Left panel with branding
- Right panel with login form
- Professional desktop experience

## Project Structure

```
composeApp/src/
├── commonMain/          # Shared code across all platforms
│   ├── kotlin/
│   │   ├── di/          # Koin dependency injection modules
│   │   ├── presentation/
│   │   │   ├── login_screen/
│   │   │   │   ├── LoginScreen.kt      # Main screen with adaptive logic
│   │   │   │   ├── MobileLayout.kt     # Mobile-specific layout
│   │   │   │   ├── TabletLayout.kt     # Tablet-specific layout
│   │   │   │   ├── DesktopLayout.kt    # Desktop-specific layout
│   │   │   │   └── LoginViewModel.kt   # Business logic
│   │   │   └── shared/
│   │   │       ├── AdaptiveLayout.kt   # Adaptive layout detection
│   │   │       └── LoginComponents.kt  # Reusable UI components
│   │   └── App.kt       # Application entry point
├── androidMain/         # Android-specific code
└── jvmMain/            # Desktop-specific code
```

## Technology Stack

- **Kotlin Multiplatform** - Cross-platform development
- **Compose Multiplatform** - Declarative UI framework
- **Koin 4.1** - Dependency injection
- **Voyager** - Navigation library
- **Material 3** - Design system
- **Coroutines & Flow** - Asynchronous programming

## Getting Started

### Prerequisites

- JDK 11 or higher
- Android Studio or IntelliJ IDEA
- Android SDK (for Android builds)

### Build and Run

#### Android Application

**On macOS/Linux:**
```bash
./gradlew :composeApp:installDebug
```

**On Windows:**
```bash
.\gradlew.bat :composeApp:installDebug
```

#### Desktop Application

**On macOS/Linux:**
```bash
./gradlew :composeApp:run
```

**On Windows:**
```bash
.\gradlew.bat :composeApp:run
```

## Adaptive Layout System

The project uses a custom `AdaptiveLayout` component that detects screen width and renders the appropriate layout:

```kotlin
AdaptiveLayout { screenType ->
    when (screenType) {
        ScreenType.MOBILE -> MobileLayout( viewModel, ... )
        ScreenType.TABLET -> TabletLayout( viewModel, ... )
        ScreenType.DESKTOP -> DesktopLayout( viewModel, ... )
    }
}
```

**Breakpoints:**
- Mobile: `< 600dp`
- Tablet: `600dp - 880dp`
- Desktop: `> 880dp`

## Reusable Components

All layouts use shared, reusable components:

- `LoginHeaderTexts` - Configurable title and subtitle
- `LoginEmailField` - Email/username input
- `LoginPasswordField` - Password input with visibility toggle
- `LoginCheckBox` - Remember me checkbox
- `LoginButton` - Primary action button with loading state

This approach maximizes code reuse and ensures consistency across all screen sizes.

## Koin Configuration

Dependency injection is configured with separate modules:

- **`commonModule`** - Shared dependencies (ViewModels)
- **`platformModule`** - Platform-specific dependencies

```kotlin
KoinApplication( application = {
    modules( listOf(
        commonModule,
        platformModule
    ) ) } ) {
    // Your app content
}
```

## Learn More

- [Kotlin Multiplatform Documentation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- [Koin Documentation](https://insert-koin.io/)
- [Voyager Navigation](https://voyager.adriel.cafe/)

## License

This project is a demonstration and educational resource. Feel free to use it as a reference for your own projects.