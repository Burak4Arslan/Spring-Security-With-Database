let loggedUsername = document.getElementById("usernameSpan").innerText;
console.log(loggedUsername);
getUserInfos();
function getUserInfos() {
    let getUserInfosRequest = new XMLHttpRequest();

    getUserInfosRequest.onreadystatechange = () => {
        if (getUserInfosRequest.readyState == 4 && getUserInfosRequest.status == 200){
            let response = JSON.parse(getUserInfosRequest.response)
            document.getElementById("rolesSpan").innerText = response.roleSet[0].role;
            // console.log( getUserInfosRequest.response)
        }
    }

    getUserInfosRequest.open("GET","http://localhost:8080/user?username="+loggedUsername, true);
    getUserInfosRequest.setRequestHeader("Content-Type", "application/json");
    getUserInfosRequest.send();

}