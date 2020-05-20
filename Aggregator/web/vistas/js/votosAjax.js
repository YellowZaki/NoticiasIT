$(document).ready(function () {
    $('.likeVotos').hover(
        function() {
            $(this).css("cursor", "pointer");
        }
    );
    
    $('.dislikeVotos').hover(
        function() {
            $(this).css("cursor", "pointer");
        }
    );
    
    $('.likeVotos').click(function (event) {
        var noticia = $(this).find("#idNoticia");
        var padre = $(this).parent("div");
        
        if(($(this).css("color") == 'rgb(169, 169, 169)') && (padre.find(".dislikeVotos").css("color") == 'rgb(169, 169, 169)')){
            $(this).css("color", "green");

            var valor = parseInt(padre.find('#valorVotos').text());
            valor = valor + 1;

            padre.find('#valorVotos').text(valor);
        }else if(padre.find('.dislikeVotos').css("color") == 'rgb(255, 0, 0)'){
            $(this).css("color", "green");

            var valor = parseInt(padre.find('#valorVotos').text());
            valor = valor + 2;

            padre.find('#valorVotos').text(valor);
        }else{
            $(this).css("color", "#a9a9a9");

            var valor = parseInt(padre.find('#valorVotos').text());
            valor = valor - 1;

            padre.find('#valorVotos').text(valor);
        }

        padre.find('.dislikeVotos').css("color", "#a9a9a9");
        
        $.ajax({
            type: "POST",
            url: "votosLike",
            data: noticia,
            error : function(data) {
            
            },
            success : function(data) {
                
            }
        });
    });
    
    $('.dislikeVotos').click(function (event) {
        var noticia = $(this).find("#idNoticia");
        var padre = $(this).parent("div");
        
        if(($(this).css("color") == 'rgb(169, 169, 169)') && (padre.find(".likeVotos").css("color") == 'rgb(169, 169, 169)')){
            $(this).css("color", "red");

            var valor = parseInt(padre.find('#valorVotos').text());
            valor = valor - 1;

            padre.find('#valorVotos').text(valor);
        }else if(padre.find(".likeVotos").css("color") == 'rgb(0, 128, 0)'){
            $(this).css("color", "red");

            var valor = parseInt(padre.find('#valorVotos').text());
            valor = valor - 2;

            padre.find('#valorVotos').text(valor);
        }else{
            $(this).css("color", "#a9a9a9");

            var valor = parseInt(padre.find('#valorVotos').text());
            valor = valor + 1;

            padre.find('#valorVotos').text(valor);
        }

        padre.find(".likeVotos").css("color", "#a9a9a9");
        
        $.ajax({
            type: "POST",
            url: "votosDislike",
            data: noticia,
            error : function(data) {
            
            },
            success : function(data) {
                
            }
        });
    });
});
