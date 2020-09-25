package com.github.brettevandowney.youtubedlhelper.kotlin.web.pages.pages.home

import com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.video.VideoColumn
import com.github.brettevandowney.youtubedlhelper.kotlin.web.items.center.video.VideoColumnItem
import com.github.brettevandowney.youtubedlhelper.kotlin.web.pages.Page
import com.github.brettevandowney.youtubedlhelper.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.FlowContent
import kotlin.random.Random

/**
 * The default downloads page, which displays a list of download cards.
 * A download card displays template information about the download.
 */
class DownloadsPage(theme: Theme, private val videosToCreate: Int) : Page(theme) {
    private val sizeTypes = arrayOf("Bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB") // template size types
    private val videoItems: ArrayList<VideoColumnItem> = arrayListOf() // template video items

    /**
     * Creates random template data to be displayed within the downloads page.
     */
    init {
        val resolutionsRandom = arrayOf("360p", "480p", "520p", "720p", "1080p", "2k", "4k", "8k")

        for (n in 1..this.videosToCreate) {
            val resolution = resolutionsRandom[Random.nextInt(0, resolutionsRandom.size)]

            videoItems.add(
                VideoColumnItem(
                    header = "Local Video $n - ",
                    headerTwo = resolution,
                    desc = "Video Desc $n. To view this video, please click on this sample video card. The video will then display on the left side of the screen for your best viewing pleasure. This is an example of a video description.",
                    location = "www.example.com",
                    name = "Example Video $n",
                    size = """${Random.nextInt(1, Random.nextInt(2, 3293))}${sizeTypes[Random.nextInt(0, sizeTypes.size)]}""",
                    dateDownloaded = """${Random.nextInt(1, 13)}/${Random.nextInt(1, 32)}/${Random.nextInt(2012, 2021)} ${Random.nextInt(1, 10)}:${Random.nextInt(1, 6)}${Random.nextInt(1, 10)} PM""",
                    additionalClasses = "video-button",
                    additionalAttr = "video-id-$n"
                )
            )
        }
    }

    /**
     * Inserts the column along with the video items onto the page
     */
    override fun FlowContent.apply() {
        insert(VideoColumn(videoItems), TemplatePlaceholder())
    }
}