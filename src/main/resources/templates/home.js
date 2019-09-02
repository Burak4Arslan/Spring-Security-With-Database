
document.getElementById("signButton").addEventListener("click",()=> {

    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let user = {
        "username" : username,
        "password" : password
    }

    var saveUserRequest = new XMLHttpRequest();
    saveUserRequest.onreadystatechange = () => {
        // console.log(saveUserRequest.response);
        if (saveUserRequest.readyState == 4 && saveUserRequest.status == 200){
            console.log(saveUserRequest.response);
        }
    }
    saveUserRequest.open("POST","http://localhost:8080/users", true);
    saveUserRequest.setRequestHeader("Content-Type", "application/json");
    saveUserRequest.send(JSON.stringify(user));

})