/**
 * A loadable module which initializes the scripts required
 * to handle the various functionality present on the recently downloaded page.
 */
class RecentlyDownloadedLoader extends Loadable {
    private readonly ANIMATION: string = "drop";
    private readonly ANIMATION_TIME = 300;

    /**
     * Initializes required content on document load
     */
    load() {
        this.setVideoInformation();
        this.setBookmarkButton();
    }

    /**
     * Initializes all click listeners required
     * for the video information
     */
    private setVideoInformation() {
        let videoInformationBox = $(".video-information-box");
        videoInformationBox.hide();

        new MultiPage("recently-downloaded");

        // setup button on clicks
        $(".multi-page-wrapper-recently-downloaded .multi-page .row.video-column.video-button").click(function () {
            console.log("doing one");
            let videoId = $(this).attr("additionalAttr"); // db query
            let videoInformationBox = $(".video-information-box");

            // temp, replace with db query
            $(videoInformationBox).find(".video-information-header").empty().append($(this).find(".video-column-header").clone(true));
            $(videoInformationBox).find(".video-information-video").attr("src", `/static/banner${Math.floor(Math.random() * (4 + 1))}.mp4`);
            videoInformationBox.show(); // show after the data has been changed
        });
    }

    /**
     * Initializes the click listeners and functions
     * for the bookmark buttons.
     */
    private setBookmarkButton() {
        let _this = this;
        // bookmark button
        let n = 0;
        $(".row.video-column.video-button .video-column-bookmark i").each(function () {
            // give each button an identification
            $(this).addClass(`video-column-bookmark-icon-${n}`).attr("value", n++)

        }).click(function (e) {
            let videoId = $(this).attr("additionalAttr"); // db query

            let value = $(this).attr("value");
            let isToggled = $(this).hasClass("video-column-bookmark-clicked");

            // toggle class
            if (isToggled) {
                $(`.favourite-items .video-column-wrapper.flexbox .video-column-bookmark-${value}`).effect(_this.ANIMATION, {}, _this.ANIMATION_TIME, function() {
                    $(this).remove()
                });
            } else {
                // .favourite-items targets the favourites page
                $(".favourite-items .video-column-wrapper.flexbox").append($(this).closest("div.video-column-flexbox-item").clone(true).addClass(`video-column-bookmark-${value}`));
            }

            $(`.video-column-bookmark-icon-${value}`).toggleClass("video-column-bookmark-clicked");
            e.stopPropagation(); // stop parent click handler from going off
        });
    }
}