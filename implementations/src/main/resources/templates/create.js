(() => {
    let sciencePlanList = [];
    let selecteSciencePlan;
    let respond = [];

    function setupListeners() {
        const addBtn = document.getElementById('submitSciencePlan');
        addBtn.addEventListener('click', onAdd);
    }

    async function run() {
        setupListeners();
        sciencePlanList = await getAllSciencePlan();
        console.log("length = " + sciencePlanList.length)
    }

    function reformatDate(dateStr) {
        dArr = dateStr.split("-");  // ex input "2010-01-18"
        return dArr[2] + "/" + dArr[1] + "/" + dArr[0]; //ex out: "18/01/10"
    }


    async function onAdd() {
        var currentID;
        var no;
        console.log("length = " + sciencePlanList.length)
        if (sciencePlanList.length != 0) {
            currentID = sciencePlanList[sciencePlanList.length - 1].planNo
            console.log("currentID = " + currentID)
            no = currentID;
        } else {
            no = 0;
        }

        var Newid = no + 1;
        var Creator = document.querySelector("#creator").value;
        var Submitter = document.querySelector("#submitter").value;
        var FundingInUSD = document.querySelector("#fundinginusd").value;
        var Objectives = document.querySelector("#objectives").value;
        var StartDate1 = document.querySelector("#startDate").value;
        var StartDate = reformatDate(StartDate1);
        var EndDate1 = document.querySelector("#endDate").value;
        var EndDate = reformatDate(EndDate1);

        var e = document.getElementById("telescopeLocation");
        var TelescopeLocation = e.options[e.selectedIndex].value;

        var e1 = document.getElementById("starSystem");
        var StarSystem = e1.options[e1.selectedIndex].value;

        var DurutionOfObservation = parseInt(document.querySelector("#durutionOfObservation").value);
        var file = document.getElementById("filetype");
        var Filetype = file.options[file.selectedIndex].value;
        var FileQuality = document.querySelector("#fileQuality").value;
        var Bw = document.querySelector("#bw").value;
        var Colors = document.querySelector("#colors").value;
        var Contrast = document.querySelector("#contrast").value;
        var Brightness = document.querySelector("#brightness").value;
        var Saturation = document.querySelector("#saturation").value;


        var newSciencePlan = {
            id: Newid,
            creator: Creator,
            submitter: Submitter,
            fundingInUSD: parseFloat(FundingInUSD),
            objectives: Objectives,
            startDate: StartDate,
            endDate: EndDate,
            starSystem: StarSystem,
            telescopeLocation: TelescopeLocation,
            durutionOfObservation: DurutionOfObservation,
            fileType: Filetype,
            fileQuality: parseFloat(FileQuality),
            bw: parseFloat(Bw),
            colors: parseFloat(Colors),
            contrast: parseFloat(Contrast),
            brightness: parseFloat(Brightness),
            saturation: parseFloat(Saturation),
        };
        // console.log("add")
        // console.log(Newid+Creator+Submitter+FundingInUSD+Objectives+StartDate+EndDate+HourOfObservation)
        var respond = await addSciencePlan(newSciencePlan);
        console.log(respond);
        window.location.reload();
        // sciencePlanList = await getAllSciencePlan();
        window.open("Astronomer/home.html");
        self.close();
    }
    run();
})();