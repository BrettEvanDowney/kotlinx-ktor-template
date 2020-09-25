/**
 * Plays music upon page load
 */
class HomeMarketingHandler extends Loadable {
    private readonly buttons: string[] = ["home-open-news", "home-open-downloads", "home-open-favourites, home-open-extras"];
    private readonly ANIMATION: string = "fade";
    private readonly ANIMATION_TIME = 250;
    private readonly ANIMATION_DELAY = 150;

    load() {
        new SliderHandler(this.buttons, new AnimationProperties(this.ANIMATION, this.ANIMATION_TIME, this.ANIMATION_DELAY));
    }
}