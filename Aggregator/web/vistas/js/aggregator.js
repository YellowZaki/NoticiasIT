//Color picker JQUERY plugin
$(document).ready(function () {
    var colorInicial = $("#color_primario").val();
    $(".colorPickSelector").colorPick({
        'initialColor': colorInicial,
        'allowRecent':false,
        'paletteLabel':"Elige color",
        'allowCustomColor': false,
        'palette': ["#1abc9c", "#16a085", "#2ecc71", "#27ae60", "#3498db", "#007bff", "#9b59b6", "#8e44ad", "#34495e", "#2c3e50", "#f1c40f", "#f39c12", "#e67e22", "#d35400", "#e74c3c", "#c0392b"],
        'onColorSelected': function () {
            $("#color_primario").val(this.color);
            this.element.css({'backgroundColor': this.color, 'color': this.color});
        }
    });
});


