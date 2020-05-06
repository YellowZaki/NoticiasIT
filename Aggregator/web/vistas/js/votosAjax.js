$(document).ready(function () {
    $('#like').hover(
        function() {
            $( this ).css("cursor", "pointer");
        }
    );
    
    $('#dislike').hover(
        function() {
            $( this ).css("cursor", "pointer");
        }
    );
    
    $('#like').click(function (event) {
        var noticia = $(this).find("#idNoticia");
        $.ajax({
            type: "POST",
            url: "votosLike",
            data: noticia,
            error : function(data) {
            
            },
            success : function(data) {
                $('#like').css("color", "green");
                $('#dislike').css("color", "#a9a9a9");
            }
        });
    });
    
    $('#dislike').click(function (event) {
        var noticia = $(this).find("#idNoticia");
        $.ajax({
            type: "POST",
            url: "votosDislike",
            data: noticia,
            error : function(data) {
            
            },
            success : function(data) {
                $('#dislike').css("color", "red");
                $('#like').css("color", "#a9a9a9");
            }
        });
    });
});
