package com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.video

import io.ktor.html.*
import kotlinx.html.*

/**
 * A class which holds information for a video, such as displaying the
 * header for the video and a section for displaying the actual video.
 */
class VideoInformationBox : Template<FlowContent> {

    override fun FlowContent.apply() {
        section(classes = "video-information-box") {
            h1(classes = "video-information-header") {
                +""""""
            }
            video(classes = "video-information-video") {
                controls = true
                source {
                    src = ""
                    type = "video/mp4"
                }
            }
        }
    }
}

