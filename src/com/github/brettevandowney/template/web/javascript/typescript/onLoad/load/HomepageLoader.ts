/**
 * The HomepageLoader module which loads different
 * Loadable modules required for the homepage.
 */
class HomepageLoader extends Loadable {
    private readonly loader: (Loadable)[] = [new MusicLoader(), new HomeMarketingHandler(), new NewsHandler(), new RecentlyDownloadedLoader(), new FavouritesLoader()];
    load() {
        let loader = this.loader;
        for (let loadable of loader) {
            loadable.load();
        }
    }
}