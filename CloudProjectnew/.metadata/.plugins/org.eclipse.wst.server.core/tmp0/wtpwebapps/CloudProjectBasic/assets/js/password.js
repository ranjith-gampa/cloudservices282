$(document).ready(function(){
    $('#pass2').focusout(function(){
        var pass = $('#form-password').val();
        var pass2 = $('#form-repeat-password').val();
        if(pass != pass2){
            alert('the passwords didn\'t match!');
        }

    });
});