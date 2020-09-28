package com.github.brettevandowney.template.kotlin.web


import com.github.brettevandowney.template.kotlin.web.pages.Page
import io.ktor.html.*
import kotlinx.html.FlowContent
import kotlinx.html.main

/**
 * The default template which inserts a given page
 * into a main element.
 */
class DefaultPagingTemplate(private val page: Page) : CenterTemplate() {
    private val pageSys = TemplatePlaceholder<Page>()
    override fun FlowContent.apply() {
        main {
            insert(page, pageSys)
        }
    }
}