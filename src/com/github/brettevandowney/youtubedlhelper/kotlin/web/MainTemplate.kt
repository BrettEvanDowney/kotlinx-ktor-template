package com.github.brettevandowney.youtubedlhelper.kotlin.web

import com.github.brettevandowney.youtubedlhelper.kotlin.web.theme.DefaultTheme
import com.github.brettevandowney.youtubedlhelper.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.*


/**
 * The main HTML template used for the application.
 */
class MainTemplate(
    private val defaultTheme: Theme = Theme(DefaultTheme().themes),
    private val main: DefaultTemplate = DefaultTemplate(defaultTheme)
) : Template<HTML> {
    val columns = PlaceholderList<DIV, FlowContent>()

    override fun HTML.apply() {
        insert(main) {

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
                script {
                    src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"
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
            }

            header {
                // additional items besides the navigation menu which is included by default
                item {
                    i("fas fa-home fa-5x") {
                    }
                }

                item {
                    i("fas fa-download fa-5x") {
                    }
                }
            }

            footer {
                div {
                    h3 { +"""This is the page footer""" }
                }
            }

            defaultCenter {
                for (n in 1..25) {
                    item { +"$n" }
                }
            }

            if (!columns.isEmpty()) {
                videoContent {
                    div(classes = "flexbox") {
                        each(columns) { columnItem ->
                            div(classes = "flexbox-item") {
                                insert(columnItem)
                            }
                        }
                    }
                }
            }
        }
    }
}