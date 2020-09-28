package com.github.brettevandowney.template.kotlin.web.items.center.video

import io.ktor.html.*
import kotlinx.html.*

/**
 * A basic table which holds video information for some downloaded video.
 * The information that will be displayed for that video is taken as a parameter.
 */
class VideoInformationTable(val size: String, val name: String, private val date: String) : Template<FlowContent> {

    /**
     * Applies the table
     */
    override fun FlowContent.apply() {
        section(classes = "video-information-table") {
            table("table table-striped table-hover table-borderless") {
                id = "tablePreview"
                thead(classes = "black white-text") {
                    tr {
                        th { +"""Total Size""" }
                        th { +"""Video Name""" }
                        th { +"""Date Downloaded""" }
                    }
                }
                tbody {
                    tr {
                        td { +size }
                        td { +name }
                        td { +date }
                    }
                }
            }
        }
    }
}

