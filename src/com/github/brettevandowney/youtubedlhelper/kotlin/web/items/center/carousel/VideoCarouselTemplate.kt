package com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.carousel

import com.github.brettevandowney.youtubedlhelper.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.*

/**
 * An animated video and carousel template, which displays different CarouselTemplateItems
 * onto a carousel, allowing the items to be moved out of frame. The animated video is displayed behind the
 * carousel. The video that is displayed depends on the theme that is provided to this class.
 */
class VideoCarouselTemplate(private val theme: Theme) : Template<FlowContent> {
    private val randomVideo = "/static/banner${theme.random}.mp4" // The random video that will be displayed behind the carousel
    private val templateItems = TemplatePlaceholder<CarouselTemplate>() // The items that will be displayed within the carousel

    /**
     * Applies background video and then the carousel
     */
    override fun FlowContent.apply() {
        div("carousel slide") {
            id = "topCarousel"
            attributes["data-ride"] = "carousel"

            // video background
            video(classes = "${theme.className} background-video") {
                attributes["autoplay"] = ""
                attributes["loop"] = ""
                attributes["muted"] = ""
                attributes["playsinline"] = ""
                src = randomVideo
            }

            // carousel items
            insert(CarouselTemplate(theme), templateItems)

            // left and right buttons
            a(classes = "carousel-control-prev") {
                href = "#topCarousel"
                role = "button"
                attributes["data-slide"] = "prev"
                span("carousel-control-prev-icon") {
                    attributes["aria-hidden"] = "true"
                }
                span("sr-only") { +"""Previous""" }
            }
            a(classes = "carousel-control-next") {
                href = "#topCarousel"
                role = "button"
                attributes["data-slide"] = "next"
                span("carousel-control-next-icon") {
                    attributes["aria-hidden"] = "true"
                }
                span("sr-only") { +"""Next""" }
            }
        }
    }
}