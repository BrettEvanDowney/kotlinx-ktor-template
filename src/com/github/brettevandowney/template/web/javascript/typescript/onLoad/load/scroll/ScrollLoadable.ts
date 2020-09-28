
/**
 * A loadable module which represents any module
 * which should have access to a scroll state
 * instance object, relating to the current page.
 */
abstract class ScrollLoadable extends Loadable {
    protected scrollState: ScrollState;
    scrollFunction: () => void = function() {};
    protected constructor(scrollState: ScrollState) {
        super();
        this.scrollState = scrollState;
    }
}