package com.github.brettevandowney.template.kotlin.web.theme

/**
 * The different supported theme types, which
 * are CSS classes.
 */
enum class ThemeType(val className: String) {
    LIGHT("light-theme"),
    DARK("dark-theme")
}