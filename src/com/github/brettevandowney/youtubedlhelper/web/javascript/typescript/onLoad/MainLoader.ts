/**
 * The main loader class which loads in the various modules
 * required for the page.
 */
class MainLoader extends Loadable {
    private readonly loader: (Loadable)[] = [new HomepageLoader(), new OnscrollLoader(), new LoginDialogSetup()];
    load() {
        for (let loadable of this.loader) {
            loadable.load();
        }
    }
}