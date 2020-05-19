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
                if(($('#like').css("color") == 'rgb(169, 169, 169)') && ($('#dislike').css("color") == 'rgb(169, 169, 169)')){
                    $('#like').css("color", "green");
                    
                    var valor = parseInt($('#valorVotos').text());
                    valor = valor + 1;
                    
                    $('#valorVotos').text(valor);
                }else if($('#dislike').css("color") == 'rgb(255, 0, 0)'){
                    $('#like').css("color", "green");
                    
                    var valor = parseInt($('#valorVotos').text());
                    valor = valor + 2;
                    
                    $('#valorVotos').text(valor);
                }else{
                    $('#like').css("color", "#a9a9a9");
                    
                    var valor = parseInt($('#valorVotos').text());
                    valor = valor - 1;
                    
                    $('#valorVotos').text(valor);
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
                if(($('#dislike').css("color") == 'rgb(169, 169, 169)') && ($('#like').css("color") == 'rgb(169, 169, 169)')){
                    $('#dislike').css("color", "red");
                    
                    var valor = parseInt($('#valorVotos').text());
                    valor = valor - 1;
                    
                    $('#valorVotos').text(valor);
                }else if($('#like').css("color") == 'rgb(0, 128, 0)'){
                    $('#dislike').css("color", "red");
                    
                    var valor = parseInt($('#valorVotos').text());
                    valor = valor - 2;
                    
                    $('#valorVotos').text(valor);
                }else{
                    $('#dislike').css("color", "#a9a9a9");
                    
                    var valor = parseInt($('#valorVotos').text());
                    valor = valor + 1;
                    
                    $('#valorVotos').text(valor);
                }
                
                $('#like').css("color", "#a9a9a9");
            }
        });
    });
});
