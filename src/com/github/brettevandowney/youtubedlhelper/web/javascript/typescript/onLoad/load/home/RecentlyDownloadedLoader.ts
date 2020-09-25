/**
 * A loadable module which initializes the scripts required
 * to handle the various functionality present on the recently downloaded page.
 */
class RecentlyDownloadedLoader extends Loadable {

    /**
     * Initializes required content on document load
     */
    load() {
        let videoInformationBox = $(".video-information-box");
        videoInformationBox.hide();

        new MultiPage("recently-downloaded");

        // setup button on clicks
        $(".multi-page-wrapper-recently-downloaded .multi-page .row.video-column.video-button").click(function () {
            let videoId = $(this).attr("additionalAttr"); // db query
            let videoInformationBox = $(".video-information-box");

            // temp, replace with db query
            $(videoInformationBox).find(".video-information-header").empty().append($(this).find(".video-column-header").clone(true));
            $(videoInformationBox).find(".video-information-video").attr("src", `/static/banner${Math.floor(Math.random() * (12 + 1))}.mp4`);
            videoInformationBox.show(); // show after the data has been changed
        });

        // bookmark button
        let n = 0;
        $(".row.video-column.video-button .video-column-bookmark i").each(function () {
            // give each button an identification
            $(this).addClass(`video-column-bookmark-icon-${n}`).attr("value", n++)

        }).click(function () {
            let videoId = $(this).attr("additionalAttr"); // db query

            let value = $(this).attr("value");
            let isToggled = $(this).hasClass("video-column-bookmark-clicked");

            // toggle class
            if (isToggled) {
                $(`.favourite-items .video-column-wrapper.flexbox .video-column-bookmark-${value}`).remove();
            } else {
                $(".video-column-wrapper.flexbox").append($(this).closest("div.video-column-flexbox-item").clone(true).addClass(`video-column-bookmark-${value}`));
            }

            $(`.video-column-bookmark-icon-${value}`).toggleClass("video-column-bookmark-clicked");
        });
    }
}