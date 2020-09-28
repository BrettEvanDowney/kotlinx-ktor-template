package com.github.brettevandowney.template.kotlin.web.items.center.account.login

import com.github.brettevandowney.template.kotlin.web.items.center.account.AccountFormItem
import kotlinx.html.*

/**
 * The panel which displays the account help information
 * within the account popup dialog.
 */
class AccountHelpPanel : AccountFormItem(false) {

    override fun FlowContent.apply() {
        form(classes = "form-help $additionalClasses") {
            i("fa fa-question-circle responsive-image-size") {
            }
            h1("h3 mb-3 font-weight-normal") { +"""Need help?""" }
            a(classes = "btn btn-lg btn-primary btn-block") {
                id = "open-help-button"
                +"""Get help"""
            }

            div(classes = "help-items") {
                br {
                }
                i("fa fa-comment-alt responsive-image-size") {
                }
                h1("h3 mb-3 font-weight-normal") { +"""Tell us your issue""" }

                // enter issue form
                label {
                    htmlFor = "enterIssueText"
                }
                textArea(classes = "form-control") {
                    id = "enterIssueText"
                    rows = "3"
                    attributes["autofocus"] = "true"
                }

                // email
                label("sr-only") {
                    htmlFor = "issueInputEmail"
                    +"""Email address"""
                }
                input(classes = "form-control") {
                    attributes["type"] = "email"
                    id = "issueInputEmail"
                    placeholder = "Email address"
                    attributes["required"] = "true"
                }

                // first name
                label("sr-only") {
                    htmlFor = "emailFirstName"
                    +"""First name"""
                }
                input(classes = "form-control") {
                    attributes["type"] = "text"
                    id = "emailFirstName"
                    placeholder = "First name"
                    attributes["required"] = "true"
                }

                // last name
                label("sr-only") {
                    htmlFor = "emailLastName"
                    +"""Last name"""
                }
                input(classes = "form-control") {
                    attributes["type"] = "text"
                    id = "emailLastName"
                    placeholder = "Last name"
                    attributes["required"] = "true"
                }

                // checkbox
                div("checkbox mb-3") {
                    label {
                        input {
                            attributes["type"] = "checkbox"
                            value = "email-to-me"
                        }
                        +"""Email to me"""
                    }
                }
                button(classes = "btn btn-lg btn-primary btn-block") {
                    attributes["type"] = "submit"
                    +"""Submit"""
                }
            }
        }
    }
}