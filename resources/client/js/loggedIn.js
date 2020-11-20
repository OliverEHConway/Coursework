function loggedIn(Id) {
    console.log("Invoked loggedIn() ");
    var username = getCookie("username");
    if (username != ""){
        document.getElementById(Id).innerHTML = username;
    }
}
function loggedInlogIn(name) {
    console.log("Invoked loggedInlogIn() ");
    var username = getCookie("username");
    if (username != ""){
        document.getElementsByName(name).innerHTML = username + " you are already logged in";
    }
}