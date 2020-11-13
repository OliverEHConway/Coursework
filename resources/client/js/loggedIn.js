function loggedIn() {
    console.log("Invoked loggedIn() ");
    var username = getCookie("username");
    if (username != ""){
        document.getElementById('login').innerHTML = username;
    } else{
        document.getElementById('login').innerHTML = "Login";
    }

}