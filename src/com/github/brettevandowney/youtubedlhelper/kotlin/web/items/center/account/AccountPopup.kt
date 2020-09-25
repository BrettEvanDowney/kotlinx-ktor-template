package com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.account

import io.ktor.html.*
import kotlinx.html.*

/**
 * An AccountFormItem which inserts a list of
 * AccountFormItem's into numerous formatting
 * divs. This class is the base class for the account dialog.
 */
class AccountPopup : AccountFormItem() {
    val list = PlaceholderList<DIV, AccountFormItem>()

    override fun FlowContent.apply() {
        /* Popup panel with login panel inside of it */
        div(classes = "account-popup") {
            id = "account-dialog-popup"
            title = "Account Dialog"
            div(classes = "flexbox") {
                each(list) {
                    div(classes = "account-item flexbox") {
                        insert(it)
                    }
                }
            }
        }
    }
}