

console.log("ÇALIŞIYOR");

getAllUsers();

function getAllUsers() {

    var getUsersRequest = new XMLHttpRequest();
    getUsersRequest.onreadystatechange = () => {
        if (getUsersRequest.readyState == 4 && getUsersRequest.status == 200){
            let users = JSON.parse(getUsersRequest.response);

            users.forEach(function (user) {

            })

        }
    }
    getUsersRequest.open("GET","http://localhost:8080/users", true);
    getUsersRequest.setRequestHeader("Content-Type", "application/json");
    getUsersRequest.send();
}