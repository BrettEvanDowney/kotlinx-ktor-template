package com.github.brettevandowney.youtubedlhelper.kotlin.web

import com.github.brettevandowney.youtubedlhelper.kotlin.web.pages.Page
import com.github.brettevandowney.youtubedlhelper.kotlin.web.pages.pages.DefaultHomePage
import com.github.brettevandowney.youtubedlhelper.kotlin.web.theme.DefaultTheme
import com.github.brettevandowney.youtubedlhelper.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.*

/**
 * The main HTML template used for the application, which uses
 * the DefaultPagingTemplate.
 */
class MainPage(
    private val theme: Theme = Theme(DefaultTheme().themes),
    private val page: Page = DefaultHomePage(theme), // the content
    private val template: DefaultLayout = DefaultLayout(
        theme,
        DefaultPagingTemplate(page)
    ) // header/footer, page formatting and other defaults
) : Template<HTML> {
    private val leftFooterIcons = arrayOf("github", "linkedin", "twitter", "facebook", "youtube")
    private val rightFooterIcons = arrayOf("html5", "css3")

    /**
     * Applies the default head,
     * which includes stylesheets, scripts,
     * and other related information. Additionally, the header
     * and the footer is supplied. The center content is included
     * within the DefaultPagingTemplate.
     */
    override fun HTML.apply() {
        insert(template) {
            defaultHead {
                meta {
                    charset = "utf-8"
                }
                title { +"""Youtube DL Helper""" }
                meta {
                    name = "description"
                    content = ""
                }
                meta {
                    name = "viewport"
                    content = "width=device-width, initial-scale=1, shrink-to-fit=no"
                }
            }

            scripts {
                // jquery
                script {
                    src = "https://code.jquery.com/jquery-1.12.4.js"
                }

                // static scripts
                script {
                    src = "/static/javascript/tscompiled/tsc.js"
                }
                script {
                    src = "/static/javascript/main.js"
                }

                // bootstrap
                script {
                    src = "https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
                    integrity = "sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
                    attributes["crossorigin"] = "anonymous"
                }
                script {
                    src = "https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
                    integrity = "sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
                    attributes["crossorigin"] = "anonymous"
                }

                // jQuery UI must go after bootstrap
                script {
                    src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"
                }
            }

            stylesheets {
                link(rel = "stylesheet", href = "/static/styles/normalize.css")
                link(rel = "stylesheet", href = "/static/styles/norm.css")
                link(rel = "stylesheet", href = "/static/styles/csscompiled/main.css")
                link(rel = "stylesheet", href = "//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css")

                // font awesome
                link(href = "/static/styles/fontawesome/css/all.css", rel = "stylesheet")

                // bootstrap
                link {
                    rel = "stylesheet"
                    href = "https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
                    attributes["integrity"] = "sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
                    attributes["crossorigin"] = "anonymous"
                }

                // web icons
                link {
                    rel = "stylesheet"
                    href = "/static/styles/webicons/css/web-icons.css"
                }

                // brand icons
                link {
                    rel = "stylesheet"
                    href = "/static/styles/brandicons/css/brand-icons.css"
                }
            }

            header {
                // additional items besides the navigation menu which is included by default
                item {
                    i("fas fa-home fa-3x header-image") {
                        attributes["onclick"] = "location.href = '/';"
                    }
                }

                item {
                    i("fas fa-download fa-3x header-image") {
                        attributes["onclick"] = "location.href = '/downloads';"
                    }
                }
            }


            footer {

                // left icons
                for (x in leftFooterIcons.indices) {
                    val extraClasses = if (x == leftFooterIcons.size - 1) {
                        "last-of-type"
                    } else ""

                    item {
                        div(classes = "inner-footer-wrapper inner-footer-left $extraClasses") {
                            i("bd-${leftFooterIcons[x]} font-3x") {
                            }
                        }
                    }
                }


                // middle content
                item {
                    div(classes = "inner-footer-wrapper inner-footer-middle flexbox") {
                        p {
                            +"""Created by Brett Downey"""
                        }
                    }
                }

                // right icons
                rightFooterIcons.forEach { item ->
                    item {
                        div(classes = "inner-footer-wrapper inner-footer-right") {
                            i("bd-$item font-3x") {
                            }
                        }
                    }
                }
            }
        }
    }
}