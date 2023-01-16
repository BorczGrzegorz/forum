function validateLoginForm(){
    var login = document.getElementById("login");
    var password = document.getElementById("password");

      var regex = /^[a-zA-Z0-9]{5,}&$/;

    if(!regex.test(login.value)){
    return false;
    }
 if(!regex.test(password.value)){
    return false;
    }
    return true;
}