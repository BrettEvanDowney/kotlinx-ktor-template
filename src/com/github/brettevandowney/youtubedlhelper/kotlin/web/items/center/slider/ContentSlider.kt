package com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.slider

import io.ktor.html.*
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div

/**
 * A content slider, which applies css classes around
 * flow content items which will be moved out by client sided
 * scripts.
 */
class ContentSlider : Template<FlowContent> {
    val list = PlaceholderList<DIV, FlowContent>()

    override fun FlowContent.apply() {
        var extraClasses = "content-item-active"
        div(classes = "content-slider") {
            each(list) {
                div(classes = "content-item $extraClasses") {
                    insert(it)
                    extraClasses = ""
                }
            }
        }
    }
}