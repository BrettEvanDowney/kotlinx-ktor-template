package com.github.brettevandowney.template.kotlin.web.pages.pages

import com.github.brettevandowney.template.kotlin.web.items.center.MarketingItem
import com.github.brettevandowney.template.kotlin.web.items.center.MarketingTemplate
import com.github.brettevandowney.template.kotlin.web.items.center.banners.DownloadBanner
import com.github.brettevandowney.template.kotlin.web.items.center.slider.ContentSlider
import com.github.brettevandowney.template.kotlin.web.pages.Page
import com.github.brettevandowney.template.kotlin.web.pages.pages.home.FavouritesPage
import com.github.brettevandowney.template.kotlin.web.pages.pages.home.RecentlyDownloadedPage
import com.github.brettevandowney.template.kotlin.web.pages.pages.home.news.NewsPage
import com.github.brettevandowney.template.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.FlowContent

/**
 * The default download page, which is the current download page
 * being displayed on the template. As this page is a large page, it is
 * sectioned into a different HTML page request.
 */
class DownloadTemplatePage(theme: Theme) : Page(theme) {
    private val banner = TemplatePlaceholder<DownloadBanner>() // the top download banner
    private val marketing = TemplatePlaceholder<MarketingTemplate>() // a template re-used marketing section
    private val slider = TemplatePlaceholder<ContentSlider>() // a content slider to display different sub-pages

    private val marketingItems: Array<MarketingItem> = arrayOf(
        // ids relate to SliderHandler.ts button names
        MarketingItem("News", "View News", "home-open-news", "news-page", "", NewsPage(theme, 3), "far fa-newspaper"),
        MarketingItem("Recently Downloaded", "View Downloads", "home-open-downloads", "recently-downloaded-page", "", RecentlyDownloadedPage(
            theme, "recently-downloaded"
        ), "fas fa-download"),
        MarketingItem("Favourites", "View Favourites", "home-open-favourites", "favourites-page", "", FavouritesPage(theme), "far fa-bookmark")
    )

    override fun FlowContent.apply() {
        insert(DownloadBanner(), banner)
        insert(MarketingTemplate(slider, marketingItems), marketing)
    }
}