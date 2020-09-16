package com.github.brettevandowney.youtubedlhelper.kotlin.web

import io.ktor.html.*
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div

class VideoListTemplate : Template<FlowContent> {
    val videos = PlaceholderList<DIV, HtmlBlockTag>()

    override fun FlowContent.apply() {
        if (!videos.isEmpty()) {
            div {
                each(videos) {
                    insert(it)
                }
            }
        }
    }
}