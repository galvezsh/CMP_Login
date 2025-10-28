# 🚀 Demo de Login con Compose Multiplatform

[![Kotlin](https://img.shields.io/badge/Kotlin-2.2.20-blue.svg?style=flat&logo=kotlin)](https://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-1.9.0-brightgreen.svg)](https://www.jetbrains.com/lp/compose-multiplatform/)
[![Koin](https://img.shields.io/badge/Koin-4.1.0-orange.svg)](https://insert-koin.io/)
[![Voyager](https://img.shields.io/badge/Voyager-1.1.0_Beta03-purple.svg)](https://voyager.adriel.cafe/)

Un **proyecto de demostración** que muestra layouts adaptativos en **Compose Multiplatform** con inyección de dependencias **Koin**. Este proyecto demuestra cómo construir interfaces responsivas que se adaptan automáticamente a diferentes tamaños de pantalla en plataformas Android y Desktop.

## 📖 Acerca de

Este proyecto es un **ejemplo práctico** de implementación de:

- ✅ **Compose Multiplatform** para código UI compartido
- ✅ **Layouts adaptativos** para Móvil, Tablet y Desktop
- ✅ **Koin 4.1** para inyección de dependencias
- ✅ **Voyager** para navegación
- ✅ **Componentes UI reutilizables** para máxima eficiencia de código

La aplicación presenta una pantalla de login que adapta dinámicamente su diseño según el tamaño de pantalla, demostrando las mejores prácticas para construir aplicaciones multi-plataforma.

## 🎯 Características

### 📱 **Layout Móvil** (< 600dp)
- Diseño vertical de una sola columna
- Optimizado para pantallas pequeñas
- Espaciado amigable al tacto

### 📲 **Layout Tablet** (600dp - 880dp)
- Contenido centrado con ancho limitado
- Tipografía más grande
- Mejor legibilidad

### 🖥️ **Layout Desktop** (> 880dp)
- Diseño de dos columnas
- Panel izquierdo con branding
- Panel derecho con formulario de login
- Experiencia profesional de escritorio

## 🏗️ Estructura del Proyecto

```
composeApp/src/
├── commonMain/          # Código compartido entre todas las plataformas
│   ├── kotlin/
│   │   ├── di/          # Módulos de inyección de dependencias Koin
│   │   ├── presentation/
│   │   │   ├── login_screen/
│   │   │   │   ├── LoginScreen.kt      # Pantalla principal con lógica adaptativa
│   │   │   │   ├── MobileLayout.kt     # Layout específico para móvil
│   │   │   │   ├── TabletLayout.kt     # Layout específico para tablet
│   │   │   │   ├── DesktopLayout.kt    # Layout específico para desktop
│   │   │   │   └── LoginViewModel.kt   # Lógica de negocio
│   │   │   └── shared/
│   │   │       ├── AdaptiveLayout.kt   # Detección de layout adaptativo
│   │   │       └── LoginComponents.kt  # Componentes UI reutilizables
│   │   └── App.kt       # Punto de entrada de la aplicación
├── androidMain/         # Código específico de Android
└── jvmMain/            # Código específico de Desktop
```

## 🛠️ Stack Tecnológico

- **Kotlin Multiplatform** - Desarrollo cross-platform
- **Compose Multiplatform** - Framework UI declarativo
- **Koin 4.1** - Inyección de dependencias
- **Voyager** - Librería de navegación
- **Material 3** - Sistema de diseño
- **Coroutines & Flow** - Programación asíncrona

## 🚀 Primeros Pasos

### Prerrequisitos

- JDK 11 o superior
- Android Studio o IntelliJ IDEA
- Android SDK (para builds de Android)

### Compilar y Ejecutar

#### Aplicación Android

**En macOS/Linux:**
```bash
./gradlew :composeApp:installDebug
```

**En Windows:**
```bash
.\gradlew.bat :composeApp:installDebug
```

#### Aplicación Desktop

**En macOS/Linux:**
```bash
./gradlew :composeApp:run
```

**En Windows:**
```bash
.\gradlew.bat :composeApp:run
```

## 🎨 Sistema de Layout Adaptativo

El proyecto utiliza un componente personalizado `AdaptiveLayout` que detecta el ancho de pantalla y renderiza el layout apropiado:

```kotlin
AdaptiveLayout { screenType ->
    when (screenType) {
        ScreenType.MOBILE -> MobileLayout( viewModel, ... )
        ScreenType.TABLET -> TabletLayout( viewModel, ... )
        ScreenType.DESKTOP -> DesktopLayout( viewModel, ... )
    }
}
```

**Puntos de quiebre (Breakpoints):**
- Móvil: `< 600dp`
- Tablet: `600dp - 880dp`
- Desktop: `> 880dp`

## 🧩 Componentes Reutilizables

Todos los layouts utilizan componentes compartidos y reutilizables:

- `LoginHeaderTexts` - Título y subtítulo configurables
- `LoginEmailField` - Campo de email/usuario
- `LoginPasswordField` - Campo de contraseña con toggle de visibilidad
- `LoginCheckBox` - Checkbox de "Recordarme"
- `LoginButton` - Botón de acción principal con estado de carga

Este enfoque maximiza la reutilización de código y asegura consistencia en todos los tamaños de pantalla.

## 🔧 Configuración de Koin

La inyección de dependencias está configurada con módulos separados:

- **`commonModule`** - Dependencias compartidas (ViewModels)
- **`platformModule`** - Dependencias específicas de plataforma

```kotlin
KoinApplication( application = {
    modules( listOf(
        commonModule,
        platformModule
    ) ) } ) {
    // Contenido de tu app
}
```

## 📚 Aprende Más

- [Documentación de Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- [Documentación de Koin](https://insert-koin.io/)
- [Navegación con Voyager](https://voyager.adriel.cafe/)

## 📄 Licencia

Este proyecto es un recurso de demostración y educativo. Siéntete libre de usarlo como referencia para tus propios proyectos.
