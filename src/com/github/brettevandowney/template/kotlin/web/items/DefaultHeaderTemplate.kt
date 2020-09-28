package com.github.brettevandowney.template.kotlin.web.items

import com.github.brettevandowney.template.kotlin.web.items.center.account.AccountPopup
import com.github.brettevandowney.template.kotlin.web.items.center.account.login.AccountHelpPanel
import com.github.brettevandowney.template.kotlin.web.items.center.account.login.AccountRegisterPanel
import com.github.brettevandowney.template.kotlin.web.items.center.account.login.LoginPanel
import com.github.brettevandowney.template.kotlin.web.items.header.SidePanelItems
import com.github.brettevandowney.template.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.*

/**
 * The default header, which has different icons, a navigational menu,
 * a settings menu, and the account dialog.
 */
class DefaultHeaderTemplate(private val theme: Theme) : Template<FlowContent> {
    private val sideItems = TemplatePlaceholder<SidePanelItems>() // side settings items
    private val accountPopup = TemplatePlaceholder<AccountPopup>() // account dialog popup
    private val loginPanel = TemplatePlaceholder<LoginPanel>() // login panel within the account popup
    private val helpPanel = TemplatePlaceholder<AccountHelpPanel>() // the help panel within the account popup
    private val registerPanel = TemplatePlaceholder<AccountRegisterPanel>() // the register panel within the account popup
    val item = PlaceholderList<DIV, FlowContent>() // extra items that will be added alongside the navigation such as "Home", "Downloads"

    /**
     * Applies the default header template, and inserts
     * all of the given icons into the template.
     */
    override fun FlowContent.apply() {
        header {
            if (!item.isEmpty()) {
                div(classes = "inner-header") {
                    each(item) {
                        div(classes = "inner-head-wrapper") {
                            insert(it)
                        }
                    }

                    div("dropdown inner-head-wrapper") {
                        button(classes = "dropdown-button") {
                            i("fa fa-align-justify responsive-image-size header-image") {
                            }
                        }
                        div("dropdown-content ${theme.className}") {
                            div("dropdown-header") {
                                p(classes = theme.className) {
                                    +"""Navigation Menu"""
                                    i("fa fa-route") {
                                    }
                                }
                            }
                            div("flexbox") {
                                for (categoryColumn in 1..12) {

                                    div("dropdown-column") {
                                        h3 { +"""Category $categoryColumn""" }

                                        for (links in 1..4) {
                                            div(classes = "column-item") {
                                                a(classes = theme.className) {
                                                    +"""Link $links"""
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    div("dropdown-right-element inner-head-wrapper sidenav") {

                        // set items to add into SidePanel
                        sideItems {
                            for (n in 1..46) {
                                item {
                                    h1 {
                                        +"""Title $n"""
                                    }
                                    div(classes = "flexbox") {
                                        for (x in 1..16) {
                                            div(classes = "side-panel-icon") {
                                                i("fa fa-cogs") {
                                                }
                                            }
                                        }
                                    }

                                }
                            }

                        }


                        div("right-push-nav") {
                            insert(SidePanelItems(), sideItems)
                        }
                    }

                    div("dropdown-right-element inner-head-wrapper") {
                        id = "settings-icon"
                        i("fa fa-cogs responsive-image-size header-image") {
                        }
                    }


                    div("dropdown-right-element inner-head-wrapper") {
                        id = "account-icon"
                        i("fa fa-address-card responsive-image-size header-image") {
                        }
                    }
                }
            }


            accountPopup {
                // insert account popup items
                list {
                    insert(AccountRegisterPanel(), registerPanel)

                }
                list {
                    insert(LoginPanel(), loginPanel)

                }
                list {
                    insert(AccountHelpPanel(), helpPanel)
                }
            }

            insert(AccountPopup(), accountPopup)
        }
    }
}