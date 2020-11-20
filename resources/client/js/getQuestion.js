function getQuestion(Id) {
    var url = "/question/getQ";
    fetch(url, {
        method: "GET",
    }).then(response => {
        return response.json();                 //now return that promise to JSON
    }).then(response => {
        if (response.hasOwnProperty("Error")) {
        alert(JSON.stringify(response));        // if it does, convert JSON object to string and alert
    } else {
        document.getElementById(Id).innerHTML = question;
        return answer;
    }
});
}
}