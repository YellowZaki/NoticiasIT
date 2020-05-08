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
                if($('#like').css("color") == 'rgb(169, 169, 169)'){
                    $('#like').css("color", "green");
                }else{
                    $('#like').css("color", "#a9a9a9");
                }
                
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
                if($('#dislike').css("color") == 'rgb(169, 169, 169)'){
                    $('#dislike').css("color", "red");
                }else{
                    $('#dislike').css("color", "#a9a9a9");
                }
                
                $('#like').css("color", "#a9a9a9");
            }
        });
    });
});
