function createAccount(){
    console.log("Invoked createAccount() ");

    var url = "/user/createAccount";
    var formData = new FormData(document.getElementById('accountCreationForm'));
    var name = document.getElementById('username').value;
    var email = document.getElementById('email').value;
    var password1 = document.getElementById('password1').value;
    var password2 = document.getElementById('password2').value;
    var passwordCheck = password1.localeCompare(password2);
    if (passwordCheck == 0){
        console.log("Invoked createAccount()/passwords the same");
        fetch(url, {
            method: "POST",
            body: formData,
        }).then(response => {
            return response.json();                 //now return that promise to JSON
        }).then(response => {
            if (response.hasOwnProperty("Error")) {
                alert(JSON.stringify(response));        // if it does, convert JSON object to string and alert
            } else {
                Cookies.set("token", response.token);
                Cookies.set("username", response.username);
                window.open("Home.html", "_self");       //open Home.html in same tab
            }
        });
        var number = console.log(Math.floor(100000 + Math.random() * 900000));
        var letter = "This is your confirm code";
        var message = letter + number;
        //sendEmail(email, name, subject, message);
        window.open("Home.html", "_self");
    }else{
        console.log("Invoked createAccount()/passwords not the same");
        alert("Passwords are not the same");
    }
}


