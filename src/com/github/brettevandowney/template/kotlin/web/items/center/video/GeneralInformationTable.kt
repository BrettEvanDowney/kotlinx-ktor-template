package com.github.brettevandowney.template.kotlin.web.items.center.video

import io.ktor.html.*
import kotlinx.html.*

/**
 * A table which holds general information
 */
class GeneralInformationTable(private val headers: Array<String>, private val content: Array<Array<String>>) :
    Template<FlowContent> {

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

                        headers.forEach {
                            th {
                                +it
                            }
                        }
                    }
                }
                tbody {
                    content.forEach { itemArray ->
                        if (itemArray.isNotEmpty()) {
                            tr {
                                th {
                                    attributes["scope"] = "row"
                                    +""""""
                                }

                                itemArray.forEach {
                                    td {
                                        +it
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

