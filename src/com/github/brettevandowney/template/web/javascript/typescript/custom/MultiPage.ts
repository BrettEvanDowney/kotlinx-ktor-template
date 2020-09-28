/**
 * A MultiPage script class, which initializes any scripts
 * required for a MultiPage which has been defined on the document
 * for the given string identification.
 */
class MultiPage {
    private readonly ANIMATION = "fade";
    private readonly ANIMATION_TIME = 750;
    private readonly ANIMATION_DELAY = 175;
    private readonly animationProperties = new AnimationProperties(this.ANIMATION, this.ANIMATION_TIME, this.ANIMATION_DELAY);

    /**
     * Initializes any scripts required for the MultiPage
     */
    constructor(private id: string) {
        // hide all pages but first
        $(".multi-page:first-child").show();
        $(".multi-page:not(:first-child)").hide();
        this.buttonHandler();
    }

    /**
     * Handles clicking a button on the MultiPage, and switching
     * the page to the correct clicked button.
     */
    private buttonHandler() {
        let _this = this;
        let buttonCount = $(`.multi-page-wrapper-${this.id} .multi-page`).length;


        for (let x = 0; x < buttonCount; x++) {
            $(`.multi-page-button-${this.id}-${x}`).click(function () {

                let currentDifferenceFromBottom = document.body.scrollHeight - (document.documentElement.scrollTop || window.pageYOffset);
                let multiPageActive = `multi-page-active-${_this.id}`; // the active multi page
                let currentActive = $(`.${multiPageActive}`).first();
                let page = $(`.multi-page-${_this.id}-${x}`).first();

                // remove other clicked elements and set this to clicked
                let clicked = `multi-page-clicked`;
                $(`.multi-page-button-${_this.id}.${clicked}`).removeClass(clicked);
                $(this).addClass(clicked);

                if (!page.is(currentActive)) {
                    currentActive.removeClass(multiPageActive).hide(); // remove any other active items
                    page.addClass(multiPageActive).show()
                }

                // handle screen size change by fixing scroll position
                window.scrollTo(0, document.body.scrollHeight - currentDifferenceFromBottom);
            });
        }
    }
}