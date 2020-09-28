package com.github.brettevandowney.template.kotlin.web.pages.pages.home

import com.github.brettevandowney.template.kotlin.web.pages.Page
import com.github.brettevandowney.template.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.*

/**
 * The default favourites page, which displays all items which have been
 * favourited. A downloads page is inserted with the client's favourited videos.
 * When the client favorites a new video, the video is then added to the favourited box
 * through client-sided script.
 */
class FavouritesPage(theme: Theme) : Page(theme) {

    /**
     * Applies the formatting for the favourites page.
     */
    override fun FlowContent.apply() {
        div("favourites-page") {
            h1 {
                span {
                    i("far fa-bookmark") {
                    }
                }
                +"""Favourite Videos"""
            }
            div(classes = "favourite-items") {
                insert(DownloadsPage(theme, 0), TemplatePlaceholder())
            }
            p {
                +"""Easily favourite more videos by selecting the bookmark located at the top right corner of any video information card!"""
            }
        }
    }
}