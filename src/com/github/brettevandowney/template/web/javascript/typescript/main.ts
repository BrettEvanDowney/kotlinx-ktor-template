/**
 * Loads the main loader, which contains all
 * scripts required to be ran once the document is
 * ready, and sets up and click handlers or other
 * page functionality.
 */
$(document).ready(function() {
    let loader = new MainLoader();
    loader.load();
});