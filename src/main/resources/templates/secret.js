getAllUsers();

function getAllUsers() {

    var getUsersRequest = new XMLHttpRequest();
    getUsersRequest.onreadystatechange = () => {
        if (getUsersRequest.readyState == 4 && getUsersRequest.status == 200){
            let temp = 0;
            let ul = document.getElementById("myUL");
            let list = "";
            let users = JSON.parse(getUsersRequest.response);
            let deleteUser = "deleteUser";
            users.forEach(function (user) { console.log(user.roleSet);
                let deletingUsername = user.username;
                list += "<li>"+user.username+"</li>";

                if(user.roleSet[0]==null){
                    list += "<button onclick=deleteUser('"+deletingUsername+"')>x</button>";
                } else {
                    for(let i = 0; i < user.roleSet.length;i++) {
                        if(user.roleSet[i].role=="ADMIN") {
                            list += "(ADMIN)";
                            temp = 1;
                        }
                    }
                    if(temp===0) {
                        list += "<button onclick=deleteUser('"+deletingUsername+"')>x</button>";
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
    // console.log(username);

    let deleteUserRequest = new XMLHttpRequest();
    deleteUserRequest.onreadystatechange = () => {
        if (deleteUserRequest.readyState === 4 && deleteUserRequest.status === 200){

            if(deleteUserRequest.response==="OK") {
                console.log("User Deleted");
                getAllUsers();
            } else {
                console.log("Silinemedi");
            }

        }
    }
    deleteUserRequest.open("POST","http://localhost:8080/deleteUser", true);
    deleteUserRequest.setRequestHeader("Content-Type", "application/json");
    deleteUserRequest.send(username);

}