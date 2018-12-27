define("web:page/musician/header/index",
    function(require, exports, module) {
        $(function() {
            var modalCtrl = function() {
                function show() {
                    console.log("show"),
                    $modal || ($(document.body).append(ModalTmplRender({})), $modal = $("#headerModal"), $modalCont = $("#headerModalCont")),
                        $modal.addClass("header-modal-show"),
                        setTimeout(function() {
                                $modalCont.addClass("header-modal-container-show")
                            },
                            100)
                }
                var ModalTmplRender = function(obj) {
                        {
                            var __p = "";
                            Array.prototype.join
                        }
                        with(obj || {}) __p += '';
                        return __p
                    },
                    $modal = null,
                    $modalCont = null;
                return {
                    show: show
                }
            } ();
            $("#loginBtn").click(modalCtrl.show)
        })
    });