/**
 * A class which represents the scroll state of a page,
 * and maintains the information which can be used across
 * numerous modules.
 */
class ScrollState {
    readonly header: any;
    readonly types: ScrollTypes = new ScrollTypes();
    open: Boolean = false;
    previousOffset: number | string | Window;

    constructor() {
        this.header = $("header").first();
        this.previousOffset = this.header.offset().top;
    }
}

/**
 * The different scroll states which a client can
 * enter within. Currently horizontal scrolling is disabled,
 * therefore there is only two scroll states, scroll-up and
 * scroll-down.
 */
class ScrollTypes {
    readonly scrollUp: String = "scroll-up";
    readonly scrollDown: String = "scroll-down";
}