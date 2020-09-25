var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
$(document).ready(function () {
    var loader = new MainLoader();
    loader.load();
});
var AnimationProperties = (function () {
    function AnimationProperties(animation, animationTime, animationDelay) {
        this.animation = animation;
        this.animationTime = animationTime;
        this.animationDelay = animationDelay;
    }
    return AnimationProperties;
}());
var MultiPage = (function () {
    function MultiPage(id) {
        this.id = id;
        this.ANIMATION = "fade";
        this.ANIMATION_TIME = 750;
        this.ANIMATION_DELAY = 175;
        this.animationProperties = new AnimationProperties(this.ANIMATION, this.ANIMATION_TIME, this.ANIMATION_DELAY);
        $(".multi-page:first-child").show();
        $(".multi-page:not(:first-child)").hide();
        this.buttonHandler();
    }
    MultiPage.prototype.buttonHandler = function () {
        var _this = this;
        var buttonCount = $(".multi-page-wrapper-" + this.id + " .multi-page").length;
        var _loop_1 = function (x) {
            $(".multi-page-button-" + this_1.id + "-" + x).click(function () {
                var currentDifferenceFromBottom = document.body.scrollHeight - (document.documentElement.scrollTop || window.pageYOffset);
                var multiPageActive = "multi-page-active-" + _this.id;
                var currentActive = $("." + multiPageActive).first();
                var page = $(".multi-page-" + _this.id + "-" + x).first();
                var clicked = "multi-page-clicked";
                $(".multi-page-button-" + _this.id + "." + clicked).removeClass(clicked);
                $(this).addClass(clicked);
                if (!page.is(currentActive)) {
                    currentActive.removeClass(multiPageActive).hide();
                    page.addClass(multiPageActive).show();
                }
                window.scrollTo(0, document.body.scrollHeight - currentDifferenceFromBottom);
            });
        };
        var this_1 = this;
        for (var x = 0; x < buttonCount; x++) {
            _loop_1(x);
        }
    };
    return MultiPage;
}());
var SliderHandler = (function () {
    function SliderHandler(buttons, animation) {
        this.buttons = buttons;
        this.animation = animation;
        $(".content-item:first-child").show();
        $(".content-item:not(:first-child)").hide();
        this.buttonHandler();
    }
    SliderHandler.prototype.buttonHandler = function () {
        var _this = this;
        var animating = false;
        for (var _i = 0, _a = this.buttons; _i < _a.length; _i++) {
            var button = _a[_i];
            $("#" + button).click(function () {
                var goesTo = $(this).attr('goesTo');
                var parent = $("." + goesTo).parent();
                var currentActive = $(".content-item-active");
                $(".row .col-lg-4 p .clicked").removeClass("clicked");
                $(this).addClass("clicked");
                if (!parent.is(currentActive)) {
                    currentActive.removeClass("content-item-active").hide();
                    parent.addClass("content-item-active").show();
                }
            });
        }
    };
    return SliderHandler;
}());
var Loadable = (function () {
    function Loadable() {
    }
    Loadable.prototype.load = function () { };
    return Loadable;
}());
var MainLoader = (function (_super) {
    __extends(MainLoader, _super);
    function MainLoader() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.loader = [new HomepageLoader(), new OnscrollLoader(), new LoginDialogSetup()];
        return _this;
    }
    MainLoader.prototype.load = function () {
        for (var _i = 0, _a = this.loader; _i < _a.length; _i++) {
            var loadable = _a[_i];
            loadable.load();
        }
    };
    return MainLoader;
}(Loadable));
var HomepageLoader = (function (_super) {
    __extends(HomepageLoader, _super);
    function HomepageLoader() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.loader = [new MusicLoader(), new HomeMarketingHandler(), new NewsHandler(), new RecentlyDownloadedLoader(), new FavouritesLoader()];
        return _this;
    }
    HomepageLoader.prototype.load = function () {
        var loader = this.loader;
        for (var _i = 0, loader_1 = loader; _i < loader_1.length; _i++) {
            var loadable = loader_1[_i];
            loadable.load();
        }
    };
    return HomepageLoader;
}(Loadable));
var LoginDialogSetup = (function (_super) {
    __extends(LoginDialogSetup, _super);
    function LoginDialogSetup() {
        var _this_1 = _super !== null && _super.apply(this, arguments) || this;
        _this_1.ANIMATION = "fade";
        _this_1.ANIMATION_TIME = 500;
        _this_1.BUTTONS = [];
        return _this_1;
    }
    LoginDialogSetup.prototype.load = function () {
        this.setInitialValues();
        this.createDialog();
        this.registerAndHelpSetup();
    };
    LoginDialogSetup.prototype.setInitialValues = function () {
        this.BUTTONS.push(["open-register-now-button", "Begin"]);
        this.BUTTONS.push(["open-help-button", "Get help"]);
    };
    LoginDialogSetup.prototype.createDialog = function () {
        var isDialogOpen = false;
        var scrollSave = 0;
        var dialog = $("#account-dialog-popup").dialog({
            autoOpen: false,
            resizable: false,
            draggable: false,
            height: "50vh",
            position: { my: 'top', at: "top+65" },
            modal: true,
            close: function () {
                $('body').removeClass('disable-scrolling');
                isDialogOpen = false;
                window.scrollTo(0, scrollSave);
            }
        });
        $(window).resize(function () {
            $("#account-dialog-popup").dialog("option", "position", { my: "center", at: "center", of: window });
        });
        $("#account-icon").click(function () {
            if (isDialogOpen) {
                dialog.dialog("close");
                isDialogOpen = false;
                window.scrollTo(0, scrollSave);
            }
            else {
                scrollSave = (document.documentElement.scrollTop || window.pageYOffset);
                $('body').addClass('disable-scrolling');
                dialog.dialog("open");
                isDialogOpen = true;
            }
        });
    };
    LoginDialogSetup.prototype.registerAndHelpSetup = function () {
        var clicked = new Map();
        var _this = this;
        clicked.set("register-items", false);
        clicked.set("help-items", false);
        var onClick = function (button, buttonText, form, items) {
            if (!clicked.get(items)) {
                clicked.set(items, true);
                _this.BUTTONS.forEach(function (value) {
                    $("#" + value[0]).html(value[1]);
                });
                $('.form-item-active:not(.form-signin)').removeClass('form-item-active').addClass('form-item');
                clicked.forEach(function (value, key) {
                    if (key !== items) {
                        clicked.set(key, false);
                        $("." + key).hide(_this.ANIMATION, {}, _this.ANIMATION_TIME, function () { });
                    }
                });
                $("." + form).removeClass("form-item").addClass("form-item-active");
                $(button).html("Close");
                $("." + items).show(_this.ANIMATION, {}, _this.ANIMATION_TIME, function () { });
            }
            else {
                clicked.set(items, false);
                $("." + form).removeClass("form-item-active").addClass("form-item");
                $(button).html(buttonText);
                $("." + items).hide(_this.ANIMATION, {}, _this.ANIMATION_TIME, function () { });
            }
        };
        $("#open-register-now-button").click(function () {
            onClick(this, "Begin", "form-register", "register-items");
        });
        $("#open-help-button").click(function () {
            onClick(this, "Get help", "form-help", "help-items");
        });
    };
    return LoginDialogSetup;
}(Loadable));
var OnscrollLoader = (function (_super) {
    __extends(OnscrollLoader, _super);
    function OnscrollLoader() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.scrollState = new ScrollState();
        _this.loader = [new HeaderScroll(_this.scrollState), new OnclickNavbar(_this.scrollState)];
        return _this;
    }
    OnscrollLoader.prototype.load = function () {
        var loader = this.loader;
        for (var _i = 0, loader_2 = loader; _i < loader_2.length; _i++) {
            var loadable = loader_2[_i];
            loadable.load();
        }
        window.onscroll = function () {
            for (var _i = 0, loader_3 = loader; _i < loader_3.length; _i++) {
                var loadable = loader_3[_i];
                loadable.scrollFunction();
            }
        };
    };
    return OnscrollLoader;
}(Loadable));
var FavouritesLoader = (function (_super) {
    __extends(FavouritesLoader, _super);
    function FavouritesLoader() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    FavouritesLoader.prototype.load = function () {
    };
    return FavouritesLoader;
}(Loadable));
var HomeMarketingHandler = (function (_super) {
    __extends(HomeMarketingHandler, _super);
    function HomeMarketingHandler() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.buttons = ["home-open-news", "home-open-downloads", "home-open-favourites, home-open-extras"];
        _this.ANIMATION = "fade";
        _this.ANIMATION_TIME = 250;
        _this.ANIMATION_DELAY = 150;
        return _this;
    }
    HomeMarketingHandler.prototype.load = function () {
        new SliderHandler(this.buttons, new AnimationProperties(this.ANIMATION, this.ANIMATION_TIME, this.ANIMATION_DELAY));
    };
    return HomeMarketingHandler;
}(Loadable));
var MusicLoader = (function (_super) {
    __extends(MusicLoader, _super);
    function MusicLoader() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    MusicLoader.prototype.load = function () {
        var audioCtx = new (window.AudioContext || window.webkitAudioContext)();
        var xhr = new XMLHttpRequest();
        xhr.open('GET', '/static/ivantorrent.mp3');
        xhr.responseType = 'arraybuffer';
        xhr.addEventListener('load', function () {
            var playsound = function (audioBuffer) {
                var source = audioCtx.createBufferSource();
                source.buffer = audioBuffer;
                source.connect(audioCtx.destination);
                source.loop = false;
                source.start();
            };
            audioCtx.decodeAudioData(xhr.response).then(playsound);
        });
        xhr.send();
    };
    return MusicLoader;
}(Loadable));
var NewsHandler = (function (_super) {
    __extends(NewsHandler, _super);
    function NewsHandler() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.ANIMATION = "fade";
        _this.ANIMATION_TIME = 500;
        _this.ANIMATION_DELAY = 150;
        return _this;
    }
    NewsHandler.prototype.load = function () {
        new AnimationProperties(this.ANIMATION, this.ANIMATION_TIME, this.ANIMATION_DELAY);
        new MultiPage("homepage-news");
    };
    return NewsHandler;
}(Loadable));
var RecentlyDownloadedLoader = (function (_super) {
    __extends(RecentlyDownloadedLoader, _super);
    function RecentlyDownloadedLoader() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    RecentlyDownloadedLoader.prototype.load = function () {
        var videoInformationBox = $(".video-information-box");
        videoInformationBox.hide();
        new MultiPage("recently-downloaded");
        $(".multi-page-wrapper-recently-downloaded .multi-page .row.video-column.video-button").click(function () {
            var videoId = $(this).attr("additionalAttr");
            var videoInformationBox = $(".video-information-box");
            $(videoInformationBox).find(".video-information-header").empty().append($(this).find(".video-column-header").clone(true));
            $(videoInformationBox).find(".video-information-video").attr("src", "/static/banner" + Math.floor(Math.random() * (12 + 1)) + ".mp4");
            videoInformationBox.show();
        });
        var n = 0;
        $(".row.video-column.video-button .video-column-bookmark i").each(function () {
            $(this).addClass("video-column-bookmark-icon-" + n).attr("value", n++);
        }).click(function () {
            var videoId = $(this).attr("additionalAttr");
            var value = $(this).attr("value");
            var isToggled = $(this).hasClass("video-column-bookmark-clicked");
            if (isToggled) {
                $(".favourite-items .video-column-wrapper.flexbox .video-column-bookmark-" + value).remove();
            }
            else {
                $(".video-column-wrapper.flexbox").append($(this).closest("div.video-column-flexbox-item").clone(true).addClass("video-column-bookmark-" + value));
            }
            $(".video-column-bookmark-icon-" + value).toggleClass("video-column-bookmark-clicked");
        });
    };
    return RecentlyDownloadedLoader;
}(Loadable));
var ScrollLoadable = (function (_super) {
    __extends(ScrollLoadable, _super);
    function ScrollLoadable(scrollState) {
        var _this = _super.call(this) || this;
        _this.scrollFunction = function () { };
        _this.scrollState = scrollState;
        return _this;
    }
    return ScrollLoadable;
}(Loadable));
var ScrollState = (function () {
    function ScrollState() {
        this.types = new ScrollTypes();
        this.open = false;
        this.header = $("header").first();
        this.previousOffset = this.header.offset().top;
    }
    return ScrollState;
}());
var ScrollTypes = (function () {
    function ScrollTypes() {
        this.scrollUp = "scroll-up";
        this.scrollDown = "scroll-down";
    }
    return ScrollTypes;
}());
var HeaderScroll = (function (_super) {
    __extends(HeaderScroll, _super);
    function HeaderScroll(scrollState) {
        var _this = _super.call(this, scrollState) || this;
        _this.body = document.body;
        _this.scrollFunction = function () {
            if (!scrollState.open) {
                var currentOffset = window.pageYOffset;
                if (currentOffset == 0) {
                    this.body.classList.remove(scrollState.types.scrollUp);
                    return;
                }
                var containsScrollDown = this.body.classList.contains(scrollState.types.scrollDown);
                if (currentOffset > scrollState.previousOffset && !containsScrollDown) {
                    this.body.classList.remove(scrollState.types.scrollUp);
                    this.body.classList.add(scrollState.types.scrollDown);
                }
                else if (currentOffset < scrollState.previousOffset && containsScrollDown) {
                    this.body.classList.remove(scrollState.types.scrollDown);
                    this.body.classList.add(scrollState.types.scrollUp);
                }
                scrollState.previousOffset = currentOffset;
            }
        };
        return _this;
    }
    return HeaderScroll;
}(ScrollLoadable));
var OnclickNavbar = (function (_super) {
    __extends(OnclickNavbar, _super);
    function OnclickNavbar(scrollState) {
        var _this_1 = _super.call(this, scrollState) || this;
        _this_1.ANIMATION = "slide";
        _this_1.ANIMATION_TIME = 350;
        return _this_1;
    }
    OnclickNavbar.prototype.load = function () {
        var _this = this;
        $(".right-push-nav").hide();
        $("#settings-icon").on("click", function () {
            if (_this.scrollState.open) {
                _this.scrollState.open = false;
                $(".right-push-nav").hide(_this.ANIMATION, { direction: 'right' }, _this.ANIMATION_TIME, function () { });
            }
            else {
                _this.scrollState.open = true;
                $(".right-push-nav").show(_this.ANIMATION, { direction: 'right' }, _this.ANIMATION_TIME, function () { });
            }
        });
    };
    return OnclickNavbar;
}(ScrollLoadable));
//# sourceMappingURL=tsc.js.map