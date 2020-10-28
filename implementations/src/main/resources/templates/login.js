(() => {
    let userList =[];

    async function run() {
        setupListener();
        userList = await getAllUsers();
    }

    function setupListener() {
        const loginBtn = document.getElementById("login-btn")
        loginBtn.addEventListener('click', onLogIn);
    }

    async function onLogIn() {
        const inpUsername = document.getElementById("username").value;
        const inpPassword = document.getElementById("password").value;
        // console.log("asdasd");
        // console.log(inpUsername);
        // console.log(inpPassword);
        // var ssUsername = inpUsername;
        // sessionStorage.setItem("Username", ssUsername);
        userList.forEach((element, i) => {
            if(inpUsername===element.username && inpPassword===element.password){
                console.log("MATCH!!!");
                if(element.role==="Astronomer"){
                    const ssID = element.id;
                    const ssName = element.name;
                    sessionStorage.setItem("userID", ssID);
                    sessionStorage.setItem("name", ssName);
                    console.log(ssID);
                    console.log(ssName);
                    self.close();
                    self.open('Astronomer/home.html');
                }
                else {
                    self.close();
                    self.open('SciObserve/home.html');
                }
            }
            else{
                // break;
                const Wcred = document.getElementById("invalidCredential");
                Wcred.setAttribute("style", "display:block");
                // alert("Username or Password Wrong!");
                // window.location.reload();
            }
        });
    }

    run();
})();