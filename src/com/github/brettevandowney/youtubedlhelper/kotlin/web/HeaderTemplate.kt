package com.github.brettevandowney.youtubedlhelper.kotlin.web

import io.ktor.html.*
import kotlinx.html.*

class HeaderTemplate : Template<FlowContent> {
    // extra items that will be added alongside the navigation such as "Home", "Downloads"
    val item = PlaceholderList<DIV, FlowContent>()

    override fun FlowContent.apply() {
        header {
            if (!item.isEmpty()) {
                div(classes = "inner-header flexbox") {
                    each(item) {
                        div(classes = "inner-head-wrapper") {
                            insert(it)
                        }
                    }

                    div("dropdown inner-head-wrapper") {
                        button(classes = "dropdown-button") {
                            i("fa fa-route fa-5x") {
                            }
                        }
                        div("dropdown-content") {
                            div("dropdown-header") {
                                h2 { +"""Navigation Menu""" }
                            }
                            div("flexbox") {
                                for (categoryColumn in 1..6) {
                                    div("dropdown-column") {
                                        h3 { +"""Category $categoryColumn""" }

                                        for (links in 1..4) {
                                            a {
                                                href = "#"
                                                +"""Link $links"""
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
    }
}