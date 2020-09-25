package com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.account.login

import com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.account.AccountFormItem
import kotlinx.html.*

/**
 * The panel which displays the account register information
 * within the account popup dialog.
 */
class AccountRegisterPanel : AccountFormItem(false) {

    override fun FlowContent.apply() {
        form(classes = "form-register $additionalClasses") {
            i("fa fa-signature fa-3x") {
            }
            h1("h3 mb-3 font-weight-normal") { +"""Need to register?""" }
            h1("h3 mb-3 font-weight-normal") { +"""Register Now!""" }
            button(classes = "btn btn-lg btn-primary btn-block") {
                id = "open-register-now-button"
                +"""Begin"""
            }

            div(classes = "register-items") {
                br {
                }
                // first name
                label("sr-only") {
                    htmlFor = "inputFirstName"
                    +"""First name"""
                }
                input(classes = "form-control") {
                    attributes["type"] = "text"
                    id = "inputFirstName"
                    placeholder = "First name"
                    attributes["required"] = "true"
                    attributes["autofocus"] = "true"
                }

                // last name
                label("sr-only") {
                    htmlFor = "inputLastName"
                    +"""Last name"""
                }
                input(classes = "form-control") {
                    attributes["type"] = "text"
                    id = "inputLastName"
                    placeholder = "Last name"
                    attributes["required"] = "true"
                    attributes["autofocus"] = "true"
                }

                // email
                label("sr-only") {
                    htmlFor = "registerInputEmail"
                    +"""Email address"""
                }
                input(classes = "form-control") {
                    attributes["type"] = "email"
                    id = "registerInputEmail"
                    placeholder = "Email address"
                    attributes["required"] = "true"
                }

                // password
                br {
                }
                label("sr-only") {
                    htmlFor = "registerInputPassword"
                    +"""Password"""
                }
                input(classes = "form-control") {
                    attributes["type"] = "password"
                    id = "registerInputPassword"
                    placeholder = "Password"
                    attributes["required"] = "true"
                }

                label("sr-only") {
                    htmlFor = "registerInputPasswordConfirm"
                    +"""Confirm Password"""
                }
                input(classes = "form-control") {
                    attributes["type"] = "password"
                    id = "registerInputPasswordConfirm"
                    placeholder = "Confirm password"
                    attributes["required"] = "true"
                }

                // checkbox
                div("checkbox mb-3") {
                    label {
                        input {
                            attributes["type"] = "checkbox"
                            value = "agree-terms"
                        }
                        +"""Agree to Terms"""
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