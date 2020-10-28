(() => {
    let sciencePlanList = [];
    let imageList = [];
    const ran = Math.floor(Math.random() * 22);
    var image;
    document.getElementById("validate-container").setAttribute("style", "display:none;");

    // document.getElementById("submitSciencePlan").setAttribute("style", "display:none;");

    async function run() {
        setupListener();
        sciencePlanList = await getAllSciencePlan();
        // console.log("sciencePlanList");
        imageList = await getAllImageOfEachSciencePlan();
        // console.log("imageList");
        // setupListener();
        displaySciencePlan(sciencePlanList);
        // imageList = await getAllImageOfEachSciencePlan();
    }

    function clearSciencePlan() {
        const scElem = document.getElementById('dashTable');
        scElem.innerHTML = '';
    }

    function setupListener() {
        const testBtn = document.getElementById("operateSciencePlan");
        testBtn.addEventListener('click', updateOperate);

        const hmBtn = document.getElementById("back-home");
        hmBtn.addEventListener('click', onHome);
    }

    function onHome(){
        window.open("Astronomer/home.html");
        self.close();
    }

    async function updateOperate() {
        // console.log("here");
        const formElem = document.getElementById('form');
        var Id = document.querySelector("#id").value;

        var t = document.getElementById("telescopeName");
        var Telescope = t.options[t.selectedIndex].value;

        // var s = document.getElementById("starSystem");
        // var StarSystem = s.options[s.selectedIndex].value;

        var newData = {
            id: Id,
            telescope: Telescope,
        };
        console.log("newData = " + newData);
        await updateSciencePlanOperate(newData)
        // alert("done");
        // location.reload();
        // alert("done");
        sciencePlanList = await getAllSciencePlan();
        imageList = await getAllImageOfEachSciencePlan();
        await displayImageStar(imageList, sciencePlanList);

        // window.open("Astronomer/home.html");
        // self.close();
        // clearSciencePlan();
        // displaySciencePlan(sciencePlanList);
    }

    function displaySciencePlan(sciencePlanList) {

        const sciencePlanLists = document.getElementById('sciencePlanList');
        sciencePlanList.forEach((element, i) => {
            // console.log("test = "+element.status);
            if (element.status == "TESTED") {
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

    function displayImageStar(imageList, sciencePlanList) {
        // sciencePlanList = await getAllSciencePlan();
        // imageList = await getAllImageOfEachSciencePlan();
        // const ran = Math.floor(Math.random() * 22);
        var Id = document.querySelector("#id").value;
        sciencePlanList.forEach((element, i) => {
            console.log("test = " + element.planNo + " " + element.status);
            if (element.planNo == Id && element.status == "OPERATED") {
                // console.log("OPERATED test = "+element.planNo+" "+element.status);
                var ic = document.getElementById("image-catalog");
                // console.log(element.imageLink);
                var r = document.createElement("div");

                imageList.forEach((elementimg, i) => {
                    console.log("in loop 2 = " + elementimg.planNo + " " + elementimg.imagefile);
                    if (elementimg.planNo == Id) {

                        console.log(elementimg.imagefile);
                        r.innerHTML = `<div>
                <img src='${elementimg.imagefile}' style="margin:auto; width:480px;height:360px;display:block" />
                </div>`
                    }
                });
                const opBtn = document.getElementById("operateSciencePlan");
                opBtn.setAttribute("style", "display:none;");
                const hmBtn = document.getElementById("back-home");
                hmBtn.setAttribute("style", "display:block");
                ic.appendChild(r)
            }
            if (element.planNo == Id && element.status == "REJECTED") {
                alert("Our telescope cannot operate this science plan, So we rejected it");
                window.open("Astronomer/home.html");
                self.close();
            }
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