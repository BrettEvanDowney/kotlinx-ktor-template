package com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center

import com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.slider.ContentSlider
import com.github.brettevandowney.youtubedlhelper.kotlin.web.pages.Page
import io.ktor.html.*
import kotlinx.html.*

/**
 * A data class which holds the items that will be displayed
 * for any given marketing item.
 */
data class MarketingItem(val header: String, val button: String, val id: String, val goesTo: String, val extraClasses: String, val page: Page, val icon: String)

/**
 * The marketing template, which displays marketing buttons and information associated with those
 * marketing buttons in a row. This marketing template has been implemented along with client sided scripts
 * with a ContentSlider in order to display pages below the marketing buttons, and to display the pages below
 * the marketing buttons.
 */
class MarketingTemplate(private val contentSlider: TemplatePlaceholder<ContentSlider>, private val items: Array<MarketingItem>) : Template<FlowContent> {

    /**
     * Applies the marketing template along with the given
     * items.
     */
    override fun FlowContent.apply() {
        div("container marketing") {
            div("row") {
                var extraClasses = "clicked"

                for (n in 1..items.size) {
                    val item: MarketingItem = items[n - 1]
                    div("col-lg-4") {
                        i("${item.icon} fa-3x") {
                        }
                        h2 { +item.header }
                        p {
                            a(classes = "btn btn-primary $extraClasses") {
                                id = item.id // set the button id
                                attributes["goesTo"] = item.goesTo
                                role = "button"
                                +item.button // set the button content
                            }
                        }
                    }

                    extraClasses = "" // only first class is clicked (default)
                }
            }
        }

        // insert the bottom content slider which manages the bottom pages below the marketing template buttons
        insert(ContentSlider(), contentSlider)
    }
}

