package com.github.brettevandowney.youtubedlhelper.kotlin.web

import com.github.brettevandowney.youtubedlhelper.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.*

/**
 * The default/main template
 * used by each page
 */
class DefaultTemplate(private val theme: Theme) : Template<HTML> {
    val defaultHead = Placeholder<HtmlHeadTag>()
    val stylesheets = Placeholder<HtmlHeadTag>()
    val scripts = Placeholder<HtmlHeadTag>()
    val videoContent = Placeholder<HtmlBlockTag>()
    val defaultCenter = TemplatePlaceholder<DefaultCenterTemplate>()

    val header = TemplatePlaceholder<HeaderTemplate>()
    val footer = Placeholder<HtmlBlockTag>()

    val videoList = TemplatePlaceholder<VideoListTemplate>()


    override fun HTML.apply() {
        head {
            insert(defaultHead)
            insert(stylesheets)
            insert(scripts)
        }
        body(classes = "main-body") {
            insert(HeaderTemplate(), header)
            insert(DefaultCenterTemplate(theme), defaultCenter)
            footer {
                insert(footer)
                insert(videoContent)
            }
        }
    }
}