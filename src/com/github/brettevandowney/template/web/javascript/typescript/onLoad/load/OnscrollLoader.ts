/**
 * The OnscrollLoader module which loads different
 * Loadable modules required for Onscroll functionality.
 * One scrollState object is created and pasted to each ScrollLoadable
 * Loadable class created within the OnscrollLoader.
 */
class OnscrollLoader extends Loadable {
    private readonly scrollState: ScrollState = new ScrollState();
    private readonly loader: (ScrollLoadable)[] = [new HeaderScroll(this.scrollState), new OnclickNavbar(this.scrollState)];
    load() {
        let loader = this.loader;
        for (let loadable of loader) {
            loadable.load();
        }

        window.onscroll = function () {
            for (let loadable of loader) {
                loadable.scrollFunction();
            }
        }
    }
}