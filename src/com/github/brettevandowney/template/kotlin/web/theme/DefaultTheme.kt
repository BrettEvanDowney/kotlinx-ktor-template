package com.github.brettevandowney.template.kotlin.web.theme

/**
 * Maps the banner video (theme) to a basic
 * ThemeType
 */
class DefaultTheme {
    val themes: Map<Int, ThemeType> = mapOf(
        0 to ThemeType.LIGHT,
        1 to ThemeType.LIGHT,
        2 to ThemeType.DARK,
        3 to ThemeType.LIGHT,
        4 to ThemeType.LIGHT
    )
}