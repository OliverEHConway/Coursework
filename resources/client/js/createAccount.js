function createAccount(){
    console.log("Invoked createAccount() ");
    var url = "/user/createAccount";
    var formData = new FormData(document.getElementById('accountCreationForm'));
    var name = formData.form.username;
    var email = formData.form.email;
    var password1 = formData.form.password1;
    var password2 = formData.form.password2;
    if (password1 == password2) {
        var subject = "Email confirmation";
        var number = console.log(Math.floor(100000 + Math.random() * 900000));
        var letter = "This is your confirm code";
        var message = letter + number;
        sendEmail(email, name, subject, message);
        window.open("emailConfirm.html", "_self");
    } else{
        alert("Passwords are not the same");
    }
}


