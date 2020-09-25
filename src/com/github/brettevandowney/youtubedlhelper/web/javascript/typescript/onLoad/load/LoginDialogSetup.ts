/**
 * A basic tuple type that contains two strings
 */
type twoStrings = [string, string];

/**
 * Sets up the login dialog upon loading
 */
class LoginDialogSetup extends Loadable {
    private readonly ANIMATION: string = "fade";
    private readonly ANIMATION_TIME = 500;
    private readonly BUTTONS: twoStrings[] = [];

    /**
     * Calls all private methods upon load
     */
    load() {
        this.setInitialValues();
        this.createDialog();
        this.registerAndHelpSetup();
    }

    /**
     * Sets the buttons which will be used within the
     * dialog.
     */
    private setInitialValues() {
        // set buttons
        this.BUTTONS.push(["open-register-now-button", "Begin"]);
        this.BUTTONS.push(["open-help-button", "Get help"]);
    }

    /**
     * Creates the jQuery UI account dialog.
     */
    private createDialog() {
        let isDialogOpen = false;
        let scrollSave = 0;

        let dialog = $("#account-dialog-popup").dialog({
            autoOpen: false,
            resizable: false,
            draggable: false,
            height: "50vh",
            position: {my: 'top', at: "top+65"},
            modal: true,
            close: function () {
                $('body').removeClass('disable-scrolling'); // enable scrolling again
                isDialogOpen = false;
                window.scrollTo(0, scrollSave); // scroll to last position
            }
        });

        // resize dialog on window resize event
        $(window).resize(function(){
            $("#account-dialog-popup").dialog( "option", "position", { my: "center", at: "center", of: window });
        });

        // setup dialog open click listener on login picture icon
        $("#account-icon").click(function () {
            if (isDialogOpen) {
                dialog.dialog("close"); // close the dialog
                isDialogOpen = false;
                window.scrollTo(0, scrollSave); // scroll to last position

            } else {
                scrollSave = (document.documentElement.scrollTop || window.pageYOffset);
                $('body').addClass('disable-scrolling'); // disable scrolling
                dialog.dialog("open"); // open the dialog
                isDialogOpen = true;
            }
        });
    }

    /**
     * Creates the setup required for the register and help
     * sections within the account dialog menu.
     */
    private registerAndHelpSetup() {
        let clicked = new Map();
        let _this = this;

        // initial map values
        clicked.set("register-items", false);
        clicked.set("help-items", false);

        let onClick = (button: any, buttonText: any, form: any, items: any) => {
            if (!clicked.get(items)) {
                // set clicked
                clicked.set(items, true);

                // hide all other forums (except login forum)
                _this.BUTTONS.forEach(value => {
                    $(`#${value[0]}`).html(value[1]);
                });

                $('.form-item-active:not(.form-signin)').removeClass('form-item-active').addClass('form-item');
                clicked.forEach((value: any, key: any) => {
                    if (key !== items) {
                        clicked.set(key, false);
                        $(`.${key}`).hide(_this.ANIMATION,  { }, _this.ANIMATION_TIME, function() {});
                    }
                });

                // make this active
                $(`.${form}`).removeClass("form-item").addClass("form-item-active");
                $(button).html("Close");
                $(`.${items}`).show(_this.ANIMATION,  { }, _this.ANIMATION_TIME, function() {});

            } else {
                // set not clicked
                clicked.set(items, false);

                $(`.${form}`).removeClass("form-item-active").addClass("form-item");
                $(button).html(buttonText); // change button text
                $(`.${items}`).hide(_this.ANIMATION,  { }, _this.ANIMATION_TIME, function() {});
            }
        };

        // setup register now open information
        $("#open-register-now-button").click(function () {
            onClick(this, "Begin", "form-register", "register-items");
        });

        // setup need help open information
        $("#open-help-button").click(function () {
            onClick(this, "Get help", "form-help", "help-items");
        });
    }
}