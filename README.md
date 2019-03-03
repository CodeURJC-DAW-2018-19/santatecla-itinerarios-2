# Itinerary Manager (Santatecla Itinerarios 2)

## Members (Team 8)
|Full Name             | URJC mail                         | GitHub account                       |
|----------------|-------------------------------|-----------------------------|
| Adrián Cabezas Pedrosa | `a.cabezasp.2016@alumnos.urjc.es`| `cabezas97`          |
| Pablo Mira García | `p.mirag.2016@alumnos.urjc.es`|   `RamsayBoy`       |
| Raúl Fernández Medina| `r.fernandezme.2016@alumnos.urjc.es`|`Rauldilla` |
| Igor Teterycz | `i.teterycz.2016@alumnos.urjc.es`| `IgorT142`|

## Software Requirements Specification
**https://docs.google.com/document/d/1_3BBSBSCyIG1S9OcsxMRVN6xiv8tKaH-qONMfgEpAzM/edit?usp=sharing**

## Team Management Tools
We use Google Drive to share documents related to the project.
We also use [Trello.](https://trello.com/b/6ClCgEkx/itinerary-manager-daw)

## Navigation Diagram, up to date



![](https://github.com/CodeURJC-DAW-2018-19/santatecla-itinerarios-2/blob/master/Screenshots/navphase2.png "Navigation Diagram")



# Phase 1: Page Design with HTML and CSS Bootstrap

We used different tools to design our page, including some Bootstrap elements (our login modal, for example) and primarily Material Dashboard elements. Material Dashboard can be found [here](https://www.creative-tim.com/product/material-dashboard)

These are the pages we designed in this phase: 

This is our main page:

![Screenshot of main page.](https://github.com/CodeURJC-DAW-2018-19/santatecla-itinerarios-2/blob/master/Screenshots/Captura.PNG "Screenshot of main page")

Next, we have the unit page, showing its content or the itinerary section.

![Screenshot of an unit page with its content.](https://github.com/CodeURJC-DAW-2018-19/santatecla-itinerarios-2/blob/master/Screenshots/Captura2.PNG "Screenshot of an unit page with its content")

This is the itinerary section of the unit.

![Screenshot of an itinerary section, within an unit.](https://github.com/CodeURJC-DAW-2018-19/santatecla-itinerarios-2/blob/master/Screenshots/Captura3.PNG "Screenshot of an itinerary section, within an unit")

# Phase 2: Implementation of the web page using server generated HTML and AJAX
## Entities Diagram

This is our current entities diagram:

![Entities diagram.](https://github.com/CodeURJC-DAW-2018-19/santatecla-itinerarios-2/blob/master/Screenshots/entities.png "Entities diagram")
## Class and templates Diagram
## Setting up the IDE
Once you downloaded the app, you'll need a MySQL server to set up a database.
We use a database called db_prueba and an user called "springuser" with "user" pass, you can create the database and the user with the following MySQL shell commands:

  -create database db_prueba;
  
  -create user "springuser"@"%" identified by "user";
  
  -grant all on db_prueba.* to 'springuser'@'%';
  
Once you have this, and your MySQL server is running, you just have to start the app. 
The rest of the configuration is all on the application.properties.
