
/**
 * A loadable module which initializes the scripts required
 * to animate the header scrolling, and handling the header's
 * visibility during scroll-down and scroll-up state changes.
 */
class HeaderScroll extends ScrollLoadable {
    private body = document.body;

    /**
     * Sets the scroll function on load
     *
     * @param scrollState The scroll state object that will be used
     */
    constructor(scrollState: ScrollState) {
        super(scrollState);

        this.scrollFunction = function () {
            if (!scrollState.open) {
                let currentOffset = window.pageYOffset;

                if (currentOffset == 0) {
                    this.body.classList.remove(scrollState.types.scrollUp);
                    return;
                }

                let containsScrollDown = this.body.classList.contains(scrollState.types.scrollDown);
                if (currentOffset > scrollState.previousOffset && !containsScrollDown) {
                    this.body.classList.remove(scrollState.types.scrollUp);
                    this.body.classList.add(scrollState.types.scrollDown);
                } else if (currentOffset < scrollState.previousOffset && containsScrollDown) {
                    this.body.classList.remove(scrollState.types.scrollDown);
                    this.body.classList.add(scrollState.types.scrollUp);
                }
                scrollState.previousOffset = currentOffset;
            }
        }
    }

}