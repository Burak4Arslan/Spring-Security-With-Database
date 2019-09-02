if(document.getElementById("signButton")!=null){
    document.getElementById("signButton").addEventListener("click",()=> {

        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;

        username = username.trim();
        password = password.trim();

        if(username == '' || password == '') {
            document.getElementById("emptyValues").style.display = "initial";
            document.getElementById("signinSuccessDiv").style.display = "none";
            document.getElementById("signinFailDiv").style.display = "none";
            return;
        }

        let user = {
            "username" : username,
            "password" : password
        }

        var saveUserRequest = new XMLHttpRequest();
        saveUserRequest.onreadystatechange = () => {
            if (saveUserRequest.readyState == 4 && saveUserRequest.status == 200){
                // console.log(saveUserRequest.response);
                if(saveUserRequest.response === '') {
                    document.getElementById("signinFailDiv").style.display = "initial";
                    document.getElementById("signinSuccessDiv").style.display = "none";
                    document.getElementById("emptyValues").style.display = "none";
                } else {
                    document.getElementById("signinSuccessDiv").style.display = "initial";
                    document.getElementById("signinFailDiv").style.display = "none";
                    document.getElementById("emptyValues").style.display = "none";
                }
                document.getElementById("password").value = '';
            }
        }
        saveUserRequest.open("POST","http://localhost:8080/users", true);
        saveUserRequest.setRequestHeader("Content-Type", "application/json");
        saveUserRequest.send(JSON.stringify(user));

    })
}