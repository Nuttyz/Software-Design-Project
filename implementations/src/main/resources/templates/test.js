(() => {
    let sciencePlanList = [];
    let imageList = [];
    var checkO = false;
    var checkC = false;
    const ran = Math.floor(Math.random() * 22);
    var image;
    document.getElementById("validate-container").setAttribute("style", "display:none;");
    document.getElementById("submitSciencePlan").setAttribute("style", "display:none;");

    async function run() {
        setupListener();
        sciencePlanList = await getAllSciencePlan();
        displaySciencePlan(sciencePlanList);
        // displayListSciPlan(sciencePlanList);
        imageList = await testSciencePlan();
    }

    function clearSciencePlan() {
        const scElem = document.getElementById('dashTable');
        scElem.innerHTML = '';
    }

    function setupListener() {
        const testBtn = document.getElementById("testSciencePlan");
        testBtn.addEventListener('click', onTest);

        const addBtn = document.getElementById('submitSciencePlan');
        addBtn.addEventListener('click', onUpdate);
    }

    async function onTest() {
        displayImageStar(imageList);
    }

    async function onUpdate() {
        const formElem = document.getElementById('form');
        var Id = document.querySelector("#id").value;

        var e = document.getElementById("statusValidate");
        var Validation = e.options[e.selectedIndex].value;

        var newstatus = {
            id: Id,
            statusValidate: Validation,
        };

        console.log(Id + Validation);
        var Id = document.querySelector("#id").value;
        var Angle = document.querySelector("#angle").value;
        var Comment = document.querySelector("#comment").value;
        var v = document.getElementById("validity");
        var Validation = v.options[v.selectedIndex].value;

        var t = document.getElementById("telescopeName");
        var Telescope = t.options[t.selectedIndex].value;

        var s = document.getElementById("starSystem");
        var StarSystem = s.options[s.selectedIndex].value;

        var newData = {
            id: Id,
            angle: Angle,
            image: image,
            comment: Comment,
            telescope: Telescope,
            valid: Validation,
            starSystem: StarSystem,
        };
        addImage(newData);
        updateSciencePlan(newstatus);
        window.open("Astronomer/home.html");
        self.close();
        // clearSciencePlan();
        // displaySciencePlan(sciencePlanList);
    }

    function closeModal(){

    }

    function displaySciencePlan(sciencePlanList) {
        const sciencePlanLists = document.getElementById('sciencePlanList');
        sciencePlanList.forEach((element, i) => {
            console.log("test = " + element.status);
            if (element.status == "RUNNING") {
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

    function displayImageStar(imageList) {
        // const ran = Math.floor(Math.random() * 22);
        imageList.forEach((element, i) => {
            var ic = document.getElementById("image-catalog");
            // console.log(element.imageLink);
            var r = document.createElement("div");
            if (element.id === ran) {
                image = element.imageLink;
                console.log(element.imageLink);
                r.innerHTML = `<div>
            <img src='${element.imageLink}' style="margin:auto; width:480px;height:360px;display:block" />
            </div>`

                const btns = document.getElementById("testSciencePlan");
                btns.setAttribute("style", "display:none;");
                planChecking()
            }
            ic.appendChild(r)
        });
    }

    function planChecking() {
        const validCon = document.getElementById("validate-container");
        const submitBtn = document.getElementById("submitSciencePlan");
        validCon.setAttribute("style", "display:block;");
        submitBtn.setAttribute("style", "display:block;");
    }

    run();
})();
