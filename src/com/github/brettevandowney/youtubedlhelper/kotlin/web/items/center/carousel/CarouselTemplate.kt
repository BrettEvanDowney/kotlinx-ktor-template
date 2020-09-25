package com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.carousel

import com.github.brettevandowney.youtubedlhelper.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.*
import kotlin.random.Random


/**
 * A data class which holds the values used in the
 * carousel template
 */
data class CarouselTemplateItem(val header: String, val paragraph: String, val button: String)

/**
 * The default carousel template, which displays different CarouselTemplateItems
 * onto a carousel, allowing the items to be moved out of frame.
 */
class CarouselTemplate(private val theme: Theme) : Template<FlowContent> {

    /**
     * The template items being displayed onto the carousel
     */
    private val items = arrayOf(
        CarouselTemplateItem(
            header = "Built with Kotlin",
            paragraph = "Using TypeScript, SCSS, Bootstrap, jQuery, and jQueryUI.",
            button = "View Github"
        ),
        CarouselTemplateItem(
            header = "Reactive and Responsive Template",
            paragraph = "Featuring modular server side rendering with kotlinx.html.",
            button = "Github IO"
        ),
        CarouselTemplateItem(
            header = "Large support",
            paragraph = "Designed to easily allow expansion in all areas, without restricting technology",
            button = "View README"
        ),
        CarouselTemplateItem(
            header = "Navigation Panel",
            paragraph = "Featuring a large navigation panel, easily customizable to allow navigation throughout your site.",
            button = "Navigate"
        ),
        CarouselTemplateItem(
            header = "Additional Panel",
            paragraph = "Using Kotlin's template system, adding additional carousel items can be done in a single line using CarouselTemplateItems.",
            button = "View Github"
        )
    )

    /**
     * Applies the carousel items
     */
    override fun FlowContent.apply() {
        // carousel indicators
        ol("carousel-indicators") {
            if (items.isNotEmpty()) {
                li("active") {
                    attributes["data-target"] = "#topCarousel"
                    attributes["data-slide-to"] = "0"
                }
                for (n in 1 until items.size) {
                    li {
                        attributes["data-target"] = "#topCarousel"
                        attributes["data-slide-to"] = n.toString()
                    }
                }
            }
        }

        // items
        div("carousel-inner") {
            var outerClasses = "carousel-item active"
            val possibleClasses = arrayOf("text-left", "text-right", "")

            items.forEach {
                val additionalClass = possibleClasses[Random.nextInt(0, possibleClasses.size)]
                div(classes = outerClasses) {
                    outerClasses = "carousel-item"
                    div("container") {
                        div("carousel-caption $additionalClass ${theme.className}") {
                            h1 { +it.header }
                            p { +it.paragraph }
                            p {
                                a(classes = "btn btn-lg btn-primary") {
                                    href = "#"
                                    role = "button"
                                    +it.button
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
