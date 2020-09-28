package com.github.brettevandowney.template.kotlin.web.items.center.carousel

import com.github.brettevandowney.template.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.*
import kotlin.random.Random


/**
 * A data class which holds the values used in the
 * carousel template
 */
data class CarouselTemplateItem(val header: String, val paragraph: String, val button: String, val href: String)

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
            paragraph = "Using TypeScript, SCSS, Bootstrap, jQuery, jQueryUI, and more. Deployed using Heroku.",
            button = "View Github",
            href = "https://github.com/BrettEvanDowney/kotlinx-ktor-template"
        ),
        CarouselTemplateItem(
            header = "Customizable Template",
            paragraph = "Implemented with server side rendering with kotlinx.html and Ktor.",
            button = "View kotlinx.html",
            href = "https://github.com/kotlin/kotlinx.html/wiki/Getting-started"
        ),
        CarouselTemplateItem(
            header = "Modular Design",
            paragraph = "Designed to easily allow expansion by using Gradle as the primary build tool.",
            button = "View README",
            href = "https://github.com/BrettEvanDowney/kotlinx-ktor-template"
        ),
        CarouselTemplateItem(
            header = "Template assets",
            paragraph = "Including many default assets which can be placed around different sections of the page. View all of the available assets on GitHub.",
            button = "View Defaults",
            href = "https://github.com/BrettEvanDowney/kotlinx-ktor-template/tree/master/src/com/github/brettevandowney/youtubedlhelper/kotlin/web/items"
        ),
        CarouselTemplateItem(
            header = "Server side rendering",
            paragraph = "Using Kotlin's template system, adding additional items to the page can be done in a single line.",
            button = "View Github",
            href = "https://github.com/BrettEvanDowney/kotlinx-ktor-template"
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
                                    href = it.href // link to the given button
                                    target = "_blank" // create a new page
                                    role = "button"
                                    +it.button // the button value
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
