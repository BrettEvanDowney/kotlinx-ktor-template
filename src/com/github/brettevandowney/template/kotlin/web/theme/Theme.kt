package com.github.brettevandowney.template.kotlin.web.theme

import kotlin.random.Random

/**
 * A theme class, which holds some theme map,
 * and picks a random theme once created to be used
 * throughout the lifespan of the instance.
 */
class Theme(themes: Map<Int, ThemeType>) {
    val random = Random.nextInt(0, themes.size) // get a random value
    private val theme = themes[random] ?: error("Theme not found for $random") // select that random value from the given theme map
    val className = theme.className // the class name of the theme being used
}