'use strict';

var app = app || {};

(function() {
    class Notifier{
        showNotification(text, type) {
            toastr.options = {
                "closeButton": false,
                "debug": false,
                "newestOnTop": true,
                "progressBar": false,
                "positionClass": "toast-bottom-right",
                "preventDuplicates": true,
                "onClick": null,
                "showDuration": "5",
                "hideDuration": "100",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            };

            if (type == 'success') {
                toastr.success(text);
            } else if (type == 'error') {
                toastr.error(text);
            }
        }
    }

    app.notifier = new Notifier();
})();