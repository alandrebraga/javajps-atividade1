/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

'use strict';

console.log("ola");

const table = document.querySelector(".table-body");

async function getFinances() {
    const url = "http://localhost:8080/app1-crud/finance";
    try {
        let res = await fetch(url);
        return await res.json();
    } catch (error) {
        console.log(error);
    }
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
                    <td> <button> alterar </button> </td>
                </tr>
        `
        html += htmlTable;
    });
    
    table.innerHTML = html;
}

renderFinances();