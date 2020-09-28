package com.github.brettevandowney.template.kotlin.web.items.header

import io.ktor.html.*
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div

/**
 * The side panel settings items used within the template
 */
class SidePanelItems : Template<FlowContent> {
    val item = PlaceholderList<DIV, FlowContent>()

    /**
     * Displays all items given along with some initial padding into a
     * side-panel-items div wrapper
     */
    override fun FlowContent.apply() {
        div(classes = ("padding")) {
        }
        div(classes = "side-panel-items") {
            each(item) {
                div(classes = "side-panel-item") {
                    insert(it)
                }
            }
        }
    }
}

