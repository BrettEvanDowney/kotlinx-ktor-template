package com.github.brettevandowney.template.kotlin.web.items

import com.github.brettevandowney.template.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div

/**
 * The default footer, which inserts each item given to it inside of
 * div footer wrapper.
 */
class DefaultFooterTemplate(private val theme: Theme) : Template<FlowContent> {

    val item = PlaceholderList<DIV, FlowContent>()

    override fun FlowContent.apply() {
        div(classes = "inner-footer") {
            each(item) {
                insert(it)
            }
        }
    }
}