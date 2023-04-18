"use strict";

(function() {
    const output = document.getElementById("output");

    const address = "http://localhost:8080";

    async function getPerson() {
        try {
            output.innerHTML = "";
            const res = await axios.get(`${address}/getAll`);
            res.data.forEach(person => renderPerson(person));
        } catch (e) {
            console.error(e);
        }
    }

    function renderPerson({fullName, oldNess, occupation, notNiNumber, id}) {
        const person = document.createElement("div");
        person.classList.add("col");
        const personCard = document.createElement("div");
        personCard.classList.add("card");

        const personBody = document.createElement("div");
        personBody.classList.add("card-body");
        const personName = document.createElement("p");
        personName.innerText = `Name: ${fullName}`;
        personName.classList.add("card-text");
        personBody.appendChild(personName);

        const personAge = document.createElement("p");
        personAge.innerText = `Oldness: ${oldNess}`;
        personAge.classList.add("card-text");
        personBody.appendChild(personAge);

        const personColour = document.createElement("p");
        personColour.innerText = `Occupation: ${occupation}`;
        personColour.classList.add("card-text");
        personBody.appendChild(personColour);

        const personHabitat = document.createElement("p");
        personHabitat.innerText = `Not Ni Number: ${notNiNumber}`;
        personHabitat.classList.add("card-text");
        personBody.appendChild(personHabitat);

        const deleteBtn = document.createElement("button");
        deleteBtn.innerText = 'DELETE';
        deleteBtn.classList.add("btn", "btn-danger");
        deleteBtn.addEventListener('click', () => deletePerson(id));
        
        const updateBtn = document.createElement("button");
        updateBtn.id = "select-btn"
        updateBtn.innerText = 'SELECT';
        updateBtn.classList.add("btn", "btn-light");
        updateBtn.addEventListener('click', () => updatePerson(id));

        personBody.appendChild(deleteBtn);
        personBody.appendChild(updateBtn);
        personCard.appendChild(personBody);
        person.appendChild(personCard);

        output.appendChild(person);
    }

    async function deletePerson(id) {
        const res = await axios.delete(`${address}/remove/${id}`);
        getPerson();
    }

    async function updatePerson(id) {
        //get their details and put it into the form. 
        //delete the card
        //add a new card

        //get
        const res1 = await axios.get(`${address}/getAll`);
        const person = res1.data.find(person => person.id === id);

        
        if (person) {
            //renderPerson(person)
            fillForm(person);
            //deletePerson(id);
            //create(person);

            

        } else {
            console.log(person);
        }
        
    }

    function fillForm(person){
        const nameLabel = document.getElementById("name-label");
        nameLabel.innerText = `Current name: ${person.fullName}`;

        const ageLabel = document.getElementById("age-label");
        ageLabel.innerText = `Current age: ${person.oldNess}`;
        
        const occLabel = document.getElementById("occ-label");
        occLabel.innerText = `Current oldness: ${person.occupation}`;
       
        const niLabel = document.getElementById("ni-label");
        niLabel.innerText = `Current not ni number: ${person.notNiNumber}`;

        const deleteBtn = document.getElementById("select-btn");
        deleteBtn.innerText = 'UPDATE';

        console.log(person)
    }

    // async function create(person){
    //         document.getElementById("peopleForm").addEventListener("submit", async function(e) {
    //         e.preventDefault();
    //         const {pName, oldness, occupation, notninumber} = this;
            
    //         const newPerson = {
    //             fullName: pName.value,
    //             oldNess: oldness.value,
    //             occupation: occupation.value,
    //             notNiNumber: notninumber.value
    //         }

    //         console.log("Person:", newPerson);
    //         this.reset();
    //         pName.focus();
    //         try {
    //             const res = await axios.post(`${address}/create`, newPerson);
    //             getPerson();
    //         } catch(error) {
    //             console.log("33e43")
    //             console.error(error);
    //         }
    //     });
    // }

    document.getElementById("peopleForm").addEventListener("submit", async function(e) {
        e.preventDefault();
        const {pName, oldness, occupation, notninumber} = this;
        
        const newPerson = {
            fullName: pName.value,
            oldNess: oldness.value,
            occupation: occupation.value,
            notNiNumber: notninumber.value
        }

        console.log("Person:", newPerson);
        this.reset();
        pName.focus();
        try {
            const res = await axios.post(`${address}/create`, newPerson);
            getPerson();
        } catch(error) {
            console.log("33e43")
            console.error(error);
        }
    });

    getPerson();
    
})();