package com.github.brettevandowney.template.kotlin.web

import com.github.brettevandowney.template.kotlin.web.items.DefaultFooterTemplate
import com.github.brettevandowney.template.kotlin.web.items.DefaultHeaderTemplate
import com.github.brettevandowney.template.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.*

/**
 * The default layout template, which inserts the layout
 * of the head, stylesheets, scripts, center content, and
 * footer into the document.
 */
class DefaultLayout(private val theme: Theme, private val center: CenterTemplate) : Template<HTML> {
    private val centerContent = TemplatePlaceholder<CenterTemplate>()
    val header = TemplatePlaceholder<DefaultHeaderTemplate>()
    val footer = TemplatePlaceholder<DefaultFooterTemplate>()
    val defaultHead = Placeholder<HtmlHeadTag>()
    val stylesheets = Placeholder<HtmlHeadTag>()
    val scripts = Placeholder<HtmlHeadTag>()

    /**
     * Inserts the layout
     * of the head, stylesheets, scripts, center content, and
     * footer into the document.
     */
    override fun HTML.apply() {
        head {
            insert(defaultHead)
            insert(stylesheets)
            insert(scripts)
        }
        body(classes = "main-body") {
            insert(DefaultHeaderTemplate(theme), header)
            insert(center, centerContent)
            footer {
                insert(DefaultFooterTemplate(theme), footer)
            }
        }
    }
}