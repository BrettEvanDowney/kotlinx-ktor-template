package com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.video

import io.ktor.html.*
import kotlinx.html.*
import kotlin.random.Random

/**
 * A data class which holds the items that will be displayed
 * for any given VideoColumnItem item.
 */
data class VideoColumnItem(
    val header: String, // the first video title
    val headerTwo: String, // the second header to display for the video title
    val desc: String, // the video desc
    val location: String, // the location where the video was downloaded from
    val name: String, // the name of the video
    val size: String, // the size of the video
    val dateDownloaded: String, // a formatted string representing the date the video was downloaded
    val additionalClasses: String = "",
    val additionalAttr: String = ""
)

/**
 * A class which displays the VideoColumn information for a given array list of VideoColumnItems.
 * The given VideoColumnItems is an array of video cards, which are wrapped in flexbox items.
 */
class VideoColumn(private val items: ArrayList<VideoColumnItem>) : Template<FlowContent> {

    override fun FlowContent.apply() {
        val dataImages =
            arrayOf("""data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQAgMAAABinRfyAAAADFBMVEX///8Kb6ft7e17rsqrf3iLAAAAPklEQVR4AWMAg9AGxjgGUTCRwBrHIJvAHscgFyEGImSAhAiIEIsAEQVAgjUBRByAEYwMcQzhDIyhDFoNDKsADyAONn3Pd1YAAAAASUVORK5CYII=""")

        div(classes = "video-column-wrapper flexbox") {
            items.forEachIndexed { index, it ->
                div(classes = "video-column-flexbox-item") {
                    hr("video-column-divider") {
                    }
                    div("row video-column ${it.additionalClasses}") {
                        attributes["additionalAttr"] = it.additionalAttr // for onclick db query

                        // header
                        section(classes = "video-column-header") {
                            img(classes = "video-column-header-img") {
                                src = dataImages[Random.nextInt(0, dataImages.size)]
                                alt = "Image"
                                attributes["aria-hidden"] = "true"
                                attributes["data-atf"] = "4"
                            }

                            span {
                                span { +it.header.replace("-", "") }
                                span { +"""› ${it.name} """ }
                                +"""› ${it.headerTwo}"""
                            }
                            span(classes = "video-column-bookmark") {
                                i("far fa-bookmark fa-3x") {
                                    attributes["additionalAttr"] = it.additionalAttr // for onclick db query
                                }
                            }
                            p(classes = "video-column-header-dl") {
                                +"""Video downloaded from ${it.location}"""
                            }


                        }

                        // left video column
                        div("col-md-7") {
                            // video desc
                            div(classes = "video-column-desc") {
                                // information table
                                div(classes = "video-column-table") {
                                    insert(
                                        VideoInformationTable(it.size, it.name, it.dateDownloaded),
                                        TemplatePlaceholder()
                                    )
                                }

                                div(classes = "video-column-desc-bottom") {
                                    p("video-column-desc-desc") { +it.desc }
                                    p("lead") { +"""Click here to view details""" }
                                }
                            }


                        }

                        // right video column
                        div("col-md-5") {
                            svgVideo()
                        }
                    }
                }
            }

            hr("video-column-divider") {
            }
        }
    }

    /**
     * A private class which displays the SVG video and the
     * search button.
     */
    private fun DIV.svgVideo() {
        div(classes = "video-column-video") {
            svg("video-column-image video-column-image-media") {
                attributes["width"] = "100%"
                attributes["preserveaspectratio"] = "xMidYMid slice"
                attributes["focusable"] = "false"
                role = "img"
            }

            // play button
            span(classes = "video-column-play-button") {
                i("fa fa-search fa-3x") {
                }
            }
        }
    }
}