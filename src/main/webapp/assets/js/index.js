/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

'use strict';

const table = document.querySelector(".table-body");
const registerButton = document.querySelector(".sbmt-button");
const form = document.querySelector('#register-form');
let editBtn = document.querySelectorAll(".edit-btn")
let hiddenForm = document.querySelector(".hidden-form");

async function getFinances() {
    const url = "http://localhost:8080/app1-crud/finance";
    try {
        let res = await fetch(url);
        return await res.json();
    } catch (error) {
        console.log(error);
    }
}

function addActionToEditButton() {
    editBtn = document.querySelectorAll(".edit-btn");

    editBtn.forEach((item) => {
        item.addEventListener("click", function () {
            hiddenForm.classList.remove("hidden");

            let row = item.closest('tr');
            let id = row.cells[0].textContent;
            let name = row.cells[1].textContent;
            let value = row.cells[3].textContent;
            let type = row.cells[2].textContent;
            
            document.querySelector('.id-form').value = id;
            document.querySelector('.name-form').value = name;
            document.querySelector('.value-form').value = value;
            document.querySelector(".tipo-form").value  = type;
        });
    });
}

function addCloseFormAction() { 
    let close = document.querySelector(".close");
    
    close.addEventListener("click", () => { 
         hiddenForm.classList.add("hidden");
    })
}
async function renderFinances() {
    let finances = await getFinances();
    let html = '';
    finances.forEach(finance => {
        let htmlTable = `
                <tr>
                    <td>${finance.id}</td>
                    <td>${finance.name}</td>
                    <td>${finance.type}</td>
                    <td>${finance.value}</td>
                    <td> <button class="edit-btn"> alterar </button> </td>
                </tr>
        `;
        html += htmlTable;
    });

    table.innerHTML = html;
    addCloseFormAction()
    addActionToEditButton();
}

renderFinances();



