getAllUsers();

function getAllUsers() {

    var getUsersRequest = new XMLHttpRequest();
    getUsersRequest.onreadystatechange = () => {
        if (getUsersRequest.readyState == 4 && getUsersRequest.status == 200){
            let ul = document.getElementById("myUL");
            let list = "";
            let users = JSON.parse(getUsersRequest.response);
            let deleteUser = "deleteUser";
            users.forEach(function (user) { console.log(user.roleSet);
                let deletingUsername = user.username;
                list += "<li>"+user.username;

                if (user.roleSet[0] == null) {
                    list += "<button onclick=deleteUser('" + deletingUsername + "')>x</button>"+"</li>";
                } else {
                    let temp = 0;
                    for (let i = 0; i < user.roleSet.length; i++) {
                        if (user.roleSet[i].role === "ADMIN") {
                            list += "(ADMIN)"+"</li>";
                            temp = 1;
                        }
                    }
                    if (temp === 0) {
                        list += "<button class='badge badge-pill badge-warning ml-5' onclick=deleteUser('" + deletingUsername + "')>x</button>"+"</li>";
                    }
                }
            })
            ul.innerHTML = list;
        }
    }
    getUsersRequest.open("GET","http://localhost:8080/users", true);
    getUsersRequest.setRequestHeader("Content-Type", "application/json");
    getUsersRequest.send();
}

function deleteUser(username) {
    let deleteUserRequest = new XMLHttpRequest();
    deleteUserRequest.onreadystatechange = () => {
        if (deleteUserRequest.readyState === 4 && deleteUserRequest.status === 200){
            // console.log(deleteUserRequest);
            if(deleteUserRequest.response==="OK") {
                // console.log("User Deleted");
                getAllUsers();
            } else {
                // console.log("Not Deleted");
            }

        }
    }
    deleteUserRequest.open("DELETE","http://localhost:8080/users", true);
    deleteUserRequest.setRequestHeader("Content-Type", "application/json");
    deleteUserRequest.send(username);
    // console.log(deleteUserRequest.request);
}