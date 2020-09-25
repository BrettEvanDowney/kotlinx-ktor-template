/**
 * A loadable module which initializes the scripts required
 * to handle the various functionality present on the news page, which is on
 * the default home page.
 */
class NewsHandler extends Loadable {
    private readonly ANIMATION: string = "fade";
    private readonly ANIMATION_TIME = 500;
    private readonly ANIMATION_DELAY = 150;

    load() {
        new AnimationProperties(this.ANIMATION, this.ANIMATION_TIME, this.ANIMATION_DELAY);
        new MultiPage("homepage-news");
    }
}