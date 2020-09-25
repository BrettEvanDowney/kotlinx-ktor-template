package com.github.brettevandowney.youtubedlhelper.kotlin.web.pages

import com.github.brettevandowney.youtubedlhelper.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.FlowContent
import kotlinx.html.button
import kotlinx.html.div

/**
 * A page which displays numerous other pages, and displays buttons on the bottom
 * in order to navigate to the other pages.
 */
class MultiPage(theme: Theme, private val pages: ArrayList<Page>, private val id: String) : Page(theme) {

    /**
     * Applies the template for the multi pages, which inserts each page
     * with the required classes for client sided scripts. Client sided scripts
     * are required in order to hide and manipulate the pages.
     */
    override fun FlowContent.apply() {
        var extraClasses = "multi-page-active-$id"

        div(classes = "multi-page-wrapper multi-page-wrapper-$id flexbox") {
            pages.forEachIndexed { index, page ->
                div(classes = "multi-page multi-page-$id-$index $extraClasses") {
                    insert(page, TemplatePlaceholder())
                }
                extraClasses = ""
            }

            // insert buttons for each page
            extraClasses = "multi-page-clicked"
            div(classes = "multi-page-buttons flexbox") {
                pages.forEachIndexed { index, _ ->
                    button(classes = "multi-page-button multi-page-button-$id-$index multi-page-button-$id btn btn-primary $extraClasses") {
                        attributes["type"] = "button"
                        +"""${index + 1}"""
                    }
                    extraClasses = ""
                }
            }
        }
    }
}