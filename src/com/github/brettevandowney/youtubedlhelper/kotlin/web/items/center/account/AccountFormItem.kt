package com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.account

import io.ktor.html.*
import kotlinx.html.FlowContent

/**
 * An account form item, which is an item that
 * cam displayed on the account form dialog.
 */
abstract class AccountFormItem(private val active: Boolean = false) : Template<FlowContent> {
    protected val additionalClasses: String by lazy {
       if (active) {
           "form-item-active"
       } else {
           "form-item"
       }
    }
}