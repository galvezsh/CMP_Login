package com.galvezsh.cmplogin.presentation.shared

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class ScreenType {
    MOBILE,      // Small screen (mobile)
    TABLET,      // Medium screen (tablet)
    DESKTOP      // Big screen (desktop)
}

/**
 * Returns the current screen type based on the available width.
 * This composable must be called inside a composable with defined size constraints.
 * 
 * Breakpoints:
 * - MOBILE: < 600dp
 * - TABLET: 600dp - 840dp
 * - DESKTOP: > 840dp
 */
@Composable
fun getScreenType(currentWidth: Dp): ScreenType {
    return when {
        currentWidth < 600.dp -> ScreenType.MOBILE
        currentWidth < 840.dp -> ScreenType.TABLET
        else -> ScreenType.DESKTOP
    }
}

/**
 * Wrapper composable that provides adaptive layout capabilities.
 * Use this to wrap your content and get automatic screen type detection.
 */
@Composable
fun AdaptiveLayout(
    content: @Composable (ScreenType) -> Unit
) {
    BoxWithConstraints {
        val screenType = getScreenType(maxWidth)
        content(screenType)
    }
}