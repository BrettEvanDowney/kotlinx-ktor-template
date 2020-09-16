$(document).ready(function () {
    var body = document.body;
    var scrollUp = "scroll-up";
    var scrollDown = "scroll-down";
    var header = $("header").first();
    var previousOffset = header.offset().top;
    window.onscroll = function () {
        var currentOffset = window.pageYOffset;
        if (currentOffset == 0) {
            body.classList.remove(scrollUp);
            return;
        }
        var containsScrollDown = body.classList.contains(scrollDown);
        if (currentOffset > previousOffset && !containsScrollDown) {
            body.classList.remove(scrollUp);
            body.classList.add(scrollDown);
        }
        else if (currentOffset < previousOffset && containsScrollDown) {
            body.classList.remove(scrollDown);
            body.classList.add(scrollUp);
        }
        previousOffset = currentOffset;
    };
});
//# sourceMappingURL=tsc.js.map