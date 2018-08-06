//También podemos hacer una llamada jQuery AJAX utilizando su método ajax (), 
//como se muestra a continuación.Arriba está el enfoque abreviado para usar el método ajax ().

$(document).ready(function () {
    $('#userName').blur(function () {
        $.ajax({
            url: 'GetUserServlet',
            data: {userName: $('#userName').val()
            },
            success: function (responseText) {
                $('#ajaxGetUserServletResponse').text(responseText);
            }
        });
    });
});

//A continuación se muestra la sintaxis del método jQuery ajax (), 
//intenta relacionarlo con el código anterior y comprenderás lo que está sucediendo aquí.
//$ . ajax ({ 
//  url : url , 
//  data : data , 
//  success : success , 
//  dataType : dataType
// });