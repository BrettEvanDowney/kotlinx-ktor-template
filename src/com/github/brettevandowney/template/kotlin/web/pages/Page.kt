package com.github.brettevandowney.template.kotlin.web.pages

import com.github.brettevandowney.template.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.FlowContent

/**
 * A page, which is a large piece of content which
 * is it's own section on the document.
 */
abstract class Page(protected val theme: Theme) : Template<FlowContent>