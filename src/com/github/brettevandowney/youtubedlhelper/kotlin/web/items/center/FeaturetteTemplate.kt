package com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center

import io.ktor.html.*
import kotlinx.html.*

/**
 * A data class which holds the items that will be displayed
 * for any given featurette item.
 */
data class FeaturetteItem(
    val header: String,
    val headerTwo: String,
    val paragraph: String,
    val additionalClasses: String = "",
    val additionalAttr: String = ""
)


/**
 * The featurette template, which displays featurette items and information associated with those
 * featurette items in a column.
 */
class FeaturetteTemplate(private val items: ArrayList<FeaturetteItem>) : Template<FlowContent> {

    /**
     * Applies the featurette template along with dividers for spacing
     * between featurette items.
     */
    override fun FlowContent.apply() {
        items.forEach {
            hr("featurette-divider") {
            }
            div("row featurette ${it.additionalClasses}") {
                attributes["additionalAttr"] = it.additionalAttr
                div("col-md-7") {
                    h2("featurette-heading") {
                        +it.header
                        span("text-muted") { +it.headerTwo }
                    }
                    p("lead") { +it.paragraph }
                }
                div("col-md-5") {
                    svgFeaturette()
                }
            }
        }

        hr("featurette-divider") {
        }
    }

    /**
     * A private helper function which inserts the svg
     * image beside the featurette.
     */
    private fun DIV.svgFeaturette() {
        svg("featurette-image") {
            attributes["width"] = "100%"
            attributes["height"] = "100%"
            attributes["preserveaspectratio"] = "xMidYMid slice"
            attributes["focusable"] = "false"
            role = "img"
        }
    }
}