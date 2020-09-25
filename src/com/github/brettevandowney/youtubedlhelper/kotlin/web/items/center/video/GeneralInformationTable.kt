package com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.video

import io.ktor.html.*
import kotlinx.html.*

/**
 * A table which holds general information
 */
class GeneralInformationTable : Template<FlowContent> {

    /**
     * Applies the general table.
     */
    override fun FlowContent.apply() {
        section(classes = "video-information-table") {
            table("table table-striped table-hover table-borderless") {
                id = "tablePreview"
                thead(classes = "black white-text") {
                    tr {
                        th { +"""""" }
                        th { +"""Total Size""" }
                        th { +"""Video Name""" }
                        th { +"""Date Downloaded""" }
                    }
                }
                tbody {
                    tr {
                        th {
                            attributes["scope"] = "row"
                            +""""""
                        }
                        td { +"""Test""" }
                        td { +"""Example Video 1""" }
                        td { +"""9/22/2020 5:14 PM""" }
                    }
                }
            }
        }
    }
}

