/**
 * A loadable module which initializes the scripts required
 * to animate the navigation bar click handler.
 */
class OnclickNavbar extends ScrollLoadable {
    private readonly ANIMATION: string = "slide"; // the animation that will be used for the settings show/hide
    private readonly ANIMATION_TIME = 350; // the animation time used during animation

    constructor(scrollState: ScrollState) {
        super(scrollState)
    }

    /**
     * Setup click listeners (non-scroll listeners)
     * on load
     */
    load() {
        let _this = this; // for nested function
        $(".right-push-nav").hide();

        // on click function for the top right settings icon, hide/show nav bar with animation
        $("#settings-icon").on("click", function () {
            if (_this.scrollState.open) {
                _this.scrollState.open = false;
                $(".right-push-nav").hide(_this.ANIMATION,  { direction: 'right' }, _this.ANIMATION_TIME, function() {});
            } else {
                _this.scrollState.open = true;
                $(".right-push-nav").show(_this.ANIMATION, { direction: 'right' }, _this.ANIMATION_TIME, function(){} );
            }
        });
    }
}