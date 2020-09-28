package com.github.brettevandowney.template.kotlin.web.pages.pages.home.news

import com.github.brettevandowney.template.kotlin.web.items.center.CompanyFooter
import com.github.brettevandowney.template.kotlin.web.items.center.FeaturetteItem
import com.github.brettevandowney.template.kotlin.web.items.center.FeaturetteTemplate
import com.github.brettevandowney.template.kotlin.web.pages.Page
import com.github.brettevandowney.template.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.FlowContent
import kotlin.random.Random
import kotlin.streams.asSequence

/**
 * The default news page, which displays a list of featurette items.
 */
class NewsPage(theme: Theme, private val itemsToCreate: Int) : Page(theme) {
    private val featuretteItems: ArrayList<FeaturetteItem> = arrayListOf() // The featurette items which will be displayed

    /**
     * Fills the featurette items with template data.
     */
    init {
        for (n in 1..this.itemsToCreate) {
            featuretteItems.add(
                FeaturetteItem(
                    "New post $n",
                    "Secondary Heading.",
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase().generateRandomString(Random.nextInt(5, 125)),
                    "",
                    ""
                )
            )
        }
    }

    /**
     * Applies the featurette items, along with a company footer.
     */
    override fun FlowContent.apply() {
        insert(FeaturetteTemplate(featuretteItems), TemplatePlaceholder())
        insert(CompanyFooter(), TemplatePlaceholder())
    }

    /**
     * A private helper function which generates a random string, which is used
     * to generate mock data for the featurette items.
     */
    private fun String.generateRandomString(outputStrLength: Int): String {
        return java.util.Random().ints(outputStrLength.toLong(), 0, length)
            .asSequence()
            .map(this::get)
            .joinToString("")
            .capitalize()
            .plus(".")
    }
}