(() => {
    let sciencePlanList = [];
    let selecteSciencePlan;

    async function run() {
        setupListeners();
        sciencePlanList = await getAllSciencePlan();
        displaySciencePlan(sciencePlanList);
    }

    function clearSciencePlan() {
        const scElem = document.getElementById('dashTable');
        scElem.innerHTML = '';
    }

    function setupListeners() {

        const addBtn = document.getElementById('submitSciencePlan');
        addBtn.addEventListener('click', onUpdate);
    }

    async function onUpdate() {
        const ssID = sessionStorage.getItem("userID");
        const ssName = sessionStorage.getItem("name");
        // alert(ssID);
        console.log(ssID);
        // console.log(userList[ssID-1].name);
        console.log("login-name" + ssName);

        const formElem = document.getElementById('form');
        var Id = document.querySelector("#id").value;
        ;

        var e = document.getElementById("statusValidate");
        var Validation = e.options[e.selectedIndex].value;
        var newstatus = {
            id: Id,
            statusValidate: Validation,
            submitter: ssName,
        };
        // console.log(id+statusValidate)


        submitSciencePlan(newstatus);
        window.open("Astronomer/home.html");
        self.close();
        // clearSciencePlan();
        // displaySciencePlan(sciencePlanList);
        // window.location.reload();
        // sciencePlanList = await getAllSciencePlan();

    }


    function displaySciencePlan(sciencePlanList) {
        const sciencePlanLists = document.getElementById('sciencePlanList');
        sciencePlanList.forEach((element, i) => {
            console.log("test = " + element.status);
            if (element.status == "OPERATED") {
                var t = document.getElementById("dashTable");
                var r = document.createElement("TR");
                r.innerHTML = `
                                                  <tr>
                                                     <th scope="row" style="background-color: #4b4e5e">${element.planNo}</th>
                                                     <td>${element.creator}</td>
                                                     <td style="background-color: #4b4e5e">${element.submitter}</td>
                                                     <td>${element.fundingInUSD}</td>
                                                      <td style="background-color: #4b4e5e">${element.objectives}</td>
                                                       <td>${element.starSystem}</td>
                                                        <td style="background-color: #4b4e5e">${element.startDate}</td>
                                                         <td>${element.endDate}</td>
                                                         <td style="background-color: #4b4e5e">${element.telescopeLocation}</td>
                                                           <td>${element.durutionOfObservation}</td>
                                                           <td style="background-color: #4b4e5e">${element.status}</td>
                                                            <td>${element.fileType}</td>
                                                            <td style="background-color: #4b4e5e">${element.fileQuality}</td>
                                                            <td>${element.bw}</td>
                                                            <td style="background-color: #4b4e5e">${element.colors}</td>
                                                            <td>${element.contrast}</td>
                                                            <td style="background-color: #4b4e5e">${element.brightness}</td>
                                                            <td>${element.saturation}</td>
                                                 </tr>
                                         `;
                t.tBodies[0].appendChild(r)
            }

        })
    }

    run();
})();
