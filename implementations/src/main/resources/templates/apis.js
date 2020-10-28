const API_URL = 'http://localhost:8080';

async function getAllUsers(){
    const result = await fetch(`${API_URL}/login`);
    console.log(result)
    return await result.json();
}

async function getAllSciencePlan() {
    const result = await fetch(`${API_URL}/all`);
    // console.log(result);
    return await result.json();
}

async function addSciencePlan(sc) {
    return await fetch(`${API_URL}/add2`, {
        method: 'POST',
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        },
        body: JSON.stringify(sc)
    });
}

async function submitSciencePlan(sc) {
    // console.log("here" + sc.id);
    return await fetch(`${API_URL}/updateSubmit/${sc.id}`, {
        method: 'PUT',
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        },
        body: JSON.stringify(sc)
    });
}

async function testSciencePlan() {
    const result = await fetch(`${API_URL}/displayimg`);
    console.log(result);
    return await result.json();
}

async function updateSciencePlan(sc) {
    // console.log("here" + sc.id);
    return await fetch(`${API_URL}/updateStatus/${sc.id}`, {
        method: 'PUT',
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        },
        body: JSON.stringify(sc)
    });
}

async function addImage(sc) {
    return await fetch(`${API_URL}/addImage`, {
        method: 'POST',
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        },
        body: JSON.stringify(sc)
    });
}

async function getAllImageOfEachSciencePlan() {
    const result = await fetch(`${API_URL}/displayTested`);
    // console.log(result);
    return await result.json();
}

async function updateSciencePlanOperate(sc) {
    // console.log("here" + sc.id);
    return await fetch(`${API_URL}/operate/${sc.id}`, {
        method: 'PUT',
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        },
        body: JSON.stringify(sc)
    });
}

async function updateOperate(sc) {
    return await fetch(`${API_URL}/operate/${sc.id}`, {
        method: 'PUT',
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        },
        body: JSON.stringify(sc)
    });
}
