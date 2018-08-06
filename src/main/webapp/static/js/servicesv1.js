$(document).ready(function () {

    $('#userName').blur(function (event) {
        var name = $('#userName').val();
        $.get('GetUserServlet', {
            userName: name
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        });
    });



});

function changeStatus(uid, lstatus) {
    //alert(userId+","+loginStatus);
    $.ajax({
        url: 'change_status',
        data: {userId: uid, loginStatus: lstatus},
        success: function (data) {
            alert(data);
        }
    });
}


    