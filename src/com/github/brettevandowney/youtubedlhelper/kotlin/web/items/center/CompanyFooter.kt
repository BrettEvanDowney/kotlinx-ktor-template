package com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center

import io.ktor.html.*
import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.footer
import kotlinx.html.p

/**
 * A company footer template, which has an area to enter
 * the company name, terms, and other information to the
 * footer.
 */
class CompanyFooter : Template<FlowContent> {
    override fun FlowContent.apply() {
        footer("container") {
            p("float-right") {
                a(classes = "btn btn-primary") {
                    href = "#"
                    +"""Back to top"""
                }
            }
            p {
                +"""2017-2020 Company, Inc."""
                a {
                    href = "#"
                    +"""Terms"""
                }
            }
        }
    }
}