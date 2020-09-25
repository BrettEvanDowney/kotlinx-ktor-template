package com.github.brettevandowney.youtubedlhelper.kotlin.web.pages.pages

import com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.MarketingItem
import com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.MarketingTemplate
import com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.carousel.VideoCarouselTemplate
import com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.slider.ContentSlider
import com.github.brettevandowney.youtubedlhelper.kotlin.web.pages.MultiPage
import com.github.brettevandowney.youtubedlhelper.kotlin.web.pages.Page
import com.github.brettevandowney.youtubedlhelper.kotlin.web.pages.pages.home.FavouritesPage
import com.github.brettevandowney.youtubedlhelper.kotlin.web.pages.pages.home.RecentlyDownloadedPage
import com.github.brettevandowney.youtubedlhelper.kotlin.web.pages.pages.home.news.NewsPage
import com.github.brettevandowney.youtubedlhelper.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlin.random.Random

/**
 * The default home page, which is the current home page
 * being displayed on the template.
 */
class DefaultHomePage(theme: Theme) : Page(theme) {
    private val carousel = TemplatePlaceholder<VideoCarouselTemplate>() // the default carousel
    private val marketing = TemplatePlaceholder<MarketingTemplate>() // the marketing buttons below the carousel
    private val slider = TemplatePlaceholder<ContentSlider>() // a content slider to display different sub-pages
    private val marketingItems: Array<MarketingItem> // the items within the marketing template

    /**
     * Sets the marketing items that will be displayed.
     *
     * Creates the template data that will be submitted when a user
     * requests this page.
     */
    init {
        val array: ArrayList<Page> = arrayListOf(NewsPage(theme, 24), NewsPage(theme, 24))

        for (n in 1..Random.nextInt(4, 9)) {
            array.add(NewsPage(theme, Random.nextInt(1, 34)))
        }

        marketingItems = arrayOf(
            // ids relate to SliderHandler.ts button names
            MarketingItem("News", "View News", "home-open-news", "news-page", "", MultiPage(theme, array, "homepage-news"), "far fa-newspaper"),
            MarketingItem("Recently Downloaded", "View Downloads", "home-open-downloads", "recently-downloaded-page", "", RecentlyDownloadedPage(
                theme, "recently-downloaded"
            ), "fas fa-download"),
            MarketingItem("Favourites", "View Favourites", "home-open-favourites", "favourites-page", "", FavouritesPage(theme), "far fa-bookmark")
        )
    }

    /**
     * Adds the items into the content slider which were added into the marketing items.
     * Then, applies the carousel and then the marketing template along with the sub-pages inside
     * the marketing template.
     */
    override fun FlowContent.apply() {
        // divs are wrapped in the goesTo class for typescript/js
        slider {
            marketingItems.forEach { marketingItem ->
                list {
                    div(classes = "${marketingItem.goesTo} ${marketingItem.extraClasses}") {
                        insert(marketingItem.page, TemplatePlaceholder()) // insert page in goesTo wrapper
                    }
                }
            }
        }

        insert(VideoCarouselTemplate(theme), carousel)
        insert(MarketingTemplate(slider, marketingItems), marketing)
    }
}