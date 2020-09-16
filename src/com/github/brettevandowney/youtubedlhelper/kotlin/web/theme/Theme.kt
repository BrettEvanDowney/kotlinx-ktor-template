package com.github.brettevandowney.youtubedlhelper.kotlin.web.theme

import kotlin.random.Random

class Theme(private val themes: Map<Int, ThemeType>) {
    val random = Random.nextInt(0, themes.size)
    private val theme = themes[random] ?: error("Theme not found for $random")
    val className = theme.className
}