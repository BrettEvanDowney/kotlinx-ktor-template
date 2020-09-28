/**
 * Creates a new slider handler which creates sets up
 * the click listener functions on the given button ids
 * to switch to the goesTo content-item once clicked on.
 */
class SliderHandler {

    /**
     *
     * @param buttons An array of buttons which will be the click
     * handlers for the pages. The goesTo should be a class whose parent
     * is the content-item that will be shown.
     * @param animation The animation properties which will be used to animate the
     * sliding of the content items.
     */
    constructor(private readonly buttons: string[], private readonly animation: AnimationProperties) {
        // hide all pages but first
        $(".content-item:first-child").show();
        $(".content-item:not(:first-child)").hide();

        this.buttonHandler();
    }


    /**
     * Sets the click lister function on each given button
     */
    buttonHandler() {
        let _this = this;
        let animating = false;

        for (let button of this.buttons) {
            $(`#${button}`).click(function () {
                let goesTo = $(this).attr('goesTo');
                let parent = $(`.${goesTo}`).parent();
                let currentActive = $(".content-item-active");

                // remove other clicked elements
                $(".row .col-lg-4 p .clicked").removeClass("clicked");
                // set this to clicked
                $(this).addClass("clicked");

                // only change the panel if the selected panel if a different panel that the currently active panel
                if (!parent.is(currentActive)) {
                    currentActive.removeClass("content-item-active").hide();
                    parent.addClass("content-item-active").show();
                }
            });
        }
    }
}