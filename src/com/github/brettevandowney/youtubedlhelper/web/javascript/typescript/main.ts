$(document).ready(function() {
    const body = document.body;
    const scrollUp = "scroll-up";
    const scrollDown = "scroll-down";
    const header =  $("header").first();
    let previousOffset = header.offset().top;
    window.onscroll = function() {
        let currentOffset = window.pageYOffset;

        if (currentOffset == 0) {
            body.classList.remove(scrollUp);
            return;
        }

        let containsScrollDown = body.classList.contains(scrollDown);
        if (currentOffset > previousOffset && !containsScrollDown) {
            body.classList.remove(scrollUp);
            body.classList.add(scrollDown);
        } else if (currentOffset < previousOffset && containsScrollDown) {
            body.classList.remove(scrollDown);
            body.classList.add(scrollUp);
        }
        previousOffset = currentOffset;
    }
});