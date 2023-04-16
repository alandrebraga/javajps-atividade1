/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  andre
 * Created: Apr 15, 2023
 */

CREATE TABLE financa ( 
    id SERIAL PRIMARY KEY,
    name varchar not null,
    tipo varchar not null,
    valor real not null
)

INSERT INTO financa (name, tipo, valor) VALUES ('comida', 'entrada', 64.75);
