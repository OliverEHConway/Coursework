function loggedIn(Id) {
    console.log("Invoked loggedIn() ");
    var username = getCookie("username");
    if (username != ""){
        document.getElementById(Id).innerHTML = username;
    }
}