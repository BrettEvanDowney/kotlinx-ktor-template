package com.github.brettevandowney.template.kotlin.web.items.center.account.login

import com.github.brettevandowney.template.kotlin.web.items.center.account.AccountFormItem
import kotlinx.html.*

/**
 * The panel which displays the login information
 * within the account popup dialog.
 */
class LoginPanel : AccountFormItem(true) {

    override fun FlowContent.apply() {
        form(classes = "form-signin $additionalClasses") {
            i("fa fa-clipboard-list responsive-image-size") {
            }
            h1("h3 mb-3 font-weight-normal") { +"""Sign in""" }
            label("sr-only") {
                htmlFor = "inputEmail"
                +"""Email address"""
            }
            input(classes = "form-control") {
                attributes["type"] = "email"
                id = "inputEmail"
                placeholder = "Email address"
                attributes["required"] = "true"
                attributes["autofocus"] = "true"
            }
            label("sr-only") {
                htmlFor = "inputPassword"
                +"""Password"""
            }
            input(classes = "form-control") {
                attributes["type"] = "password"
                id = "inputPassword"
                placeholder = "Password"
                attributes["required"] = "true"
            }
            div("checkbox mb-3") {
                label {
                    input {
                        attributes["type"] = "checkbox"
                        value = "remember-me"
                    }
                    +"""Remember me"""
                }
            }
            button(classes = "btn btn-lg btn-primary btn-block") {
                attributes["type"] = "submit"
                +"""Sign in"""
            }
            p("mt-5 mb-3 text-muted") { +"""2020""" }
        }
    }
}