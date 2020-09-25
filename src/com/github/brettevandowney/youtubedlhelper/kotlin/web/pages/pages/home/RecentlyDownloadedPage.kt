package com.github.brettevandowney.youtubedlhelper.kotlin.web.pages.pages.home

import com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.CompanyFooter
import com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.video.GeneralInformationTable
import com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.video.VideoInformationBox
import com.github.brettevandowney.youtubedlhelper.kotlin.web.pages.MultiPage
import com.github.brettevandowney.youtubedlhelper.kotlin.web.pages.Page
import com.github.brettevandowney.youtubedlhelper.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.p
import kotlin.random.Random

/**
 * The default recently downloaded page, which displays a CSS grid with three
 * sections.
 */
class RecentlyDownloadedPage(theme: Theme, private val multiPageId: String) : Page(theme) {
    private val array: ArrayList<Page> = arrayListOf() // the other download pages which will be shown
    private val footer = TemplatePlaceholder<CompanyFooter>() // company footer which presents company name and a "back to top" button
    private val headers = arrayOf("Recently Downloaded Information", "Most Downloaded Sites") // default headers to display
    private val paragraphs =
        arrayOf("New downloads are automatically updated!", "View the top 5 most downloaded sites") // default paragraphs to display

    /**
     * Creates some template mock data for the
     * different download pages
     */
    init {
        for (n in 1..Random.nextInt(4, 6)) {
            array.add(DownloadsPage(theme, 24))
        }
    }

    /**
     * Applies the download page formatting.
     */
    override fun FlowContent.apply() {
        div("recently-downloaded-page rd-grid-container") {
            // information section
            div("rd-grid-information") {
                // display all headers and paragraphs
                for (n in 1..2) {
                    h1 {
                        +headers[n - 1]
                    }
                    insert(GeneralInformationTable(), TemplatePlaceholder())
                    p {
                        +paragraphs[n - 1]
                    }
                }
            }

            // video section
            div("rd-grid-video") {
                insert(VideoInformationBox(), TemplatePlaceholder())
            }

            // list section
            div("rd-grid-list") {
                insert(MultiPage(theme, array, multiPageId), TemplatePlaceholder())
                insert(CompanyFooter(), footer)
            }
        }
    }
}