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

Screenshots of the main pages of our app in Phase 2:

![Screenshot of main page.](https://github.com/CodeURJC-DAW-2018-19/santatecla-itinerarios-2/blob/master/Screenshots/fase2units.png "Screenshot of main page")

![Screenshot of login page.](https://github.com/CodeURJC-DAW-2018-19/santatecla-itinerarios-2/blob/master/Screenshots/fase2login.png "Screenshot of login form")


![Screenshot of contents page.](https://github.com/CodeURJC-DAW-2018-19/santatecla-itinerarios-2/blob/master/Screenshots/fase2fichas.png "Screenshot of contents page")

![Screenshot of itinerary page.](https://github.com/CodeURJC-DAW-2018-19/santatecla-itinerarios-2/blob/master/Screenshots/fase2itinerarios.png "Screenshot of itinerary page")

![Screenshot of error page.](https://github.com/CodeURJC-DAW-2018-19/santatecla-itinerarios-2/blob/master/Screenshots/fase2error.png "Screenshot of error page")


## Entities Diagram

This is our current entities diagram:

![Entities diagram.](https://github.com/CodeURJC-DAW-2018-19/santatecla-itinerarios-2/blob/master/Screenshots/entities.png "Entities diagram")
## Class and templates Diagram

We created a class diagram showcasing all the classes from our application, as requested. Different types of classes have a color of their own. The color code is:

Purple - Repositories,
Blue - Entities,
Pink - Services,
Gray - Standard class,
Dark green - Components,
Gradient pink - Configurations,
Red - Controllers,
Yellow - Templates.


![Class diagram.](https://github.com/CodeURJC-DAW-2018-19/santatecla-itinerarios-2/blob/master/Screenshots/classdiag.png "Class diagram")

## Setting up the IDE
Once you downloaded the app, you'll need a MySQL server to set up a database.
We use a database called db_prueba and an user called "springuser" with "user" pass, you can create the database and the user with the following MySQL shell commands:

  -create database db_prueba;
  
  -create user "springuser"@"%" identified by "user";
  
  -grant all on db_prueba.* to 'springuser'@'%';
  
Once you have this, and your MySQL server is running, you just have to start the app. 
The rest of the configuration is all on the application.properties.

# Phase 3: API REST incorporation to the web application and Docker display
To access to the public documentation of each API REST endpoint you can go to [API REST DOC](https://github.com/CodeURJC-DAW-2018-19/santatecla-itinerarios-2/blob/master/API_REST_DOC.md).


## Launching the app using Docker Compose
We have created a new folder called **docker** in our repository source folder. In this docker we have included some files with docker functionality. First, we need to install docker:

* [![Docker](https://img.shields.io/badge/Install-Docker-blue.svg)](https://www.docker.com/)

With docker installed in our machine, we must now go to the *docker* directory. Now we have a few options:

* **create_image.bat**: this batch file is a script that will automatically package our application using Maven (command *mvn package*), it will copy the jar into our docker folder, inside the *app* folder, and then it will use it to build the **docker image** of our application. For this purpose, the script will execute the command *docker build -t dawgrupo8/fase3*, which thanks to our Dockerfile, will properly build the image of our app. Note that this script does NOT push the image to our *DockerHub* repository. You must do this manually, if you will.
* **Dockerfile**: as stated before, this file will allow us to build our app *docker image*.

And the file we need to actually launch the app:
* **docker-compose.yml**: this YAML file will do several things. First, it'll pull the latest *mysql* image available from the Docker registry, and it'll also pull the latest *app* image from our own 
[DockerHub Repository.](https://cloud.docker.com/repository/docker/dawgrupo8/fase3)
Then it'll sync both images and we will be ready to launch our app. Few things to point out: Our app will always wait for the database to start up. If the app launches before the database, it'll restart itself. Also, to access our web, we must use now the port **8080** instead of the 8443 that we used before. If you are using Docker CE for Windows or Linux, you'll be able to access using localhost; but if you are in Docker Toolbox instead (Mac, Standard versions of Windows...) you must first start your Docker Toolbox quickstart terminal and find your virtual machine ip. For this purpose, you can use the *docker-machine ip default* command. You'll be using that ip to access the web, in our case it is https://192.168.99.100:8080/

## Class Diagram

Purple - Repositories,
Blue - Entities,
Pink - Services,
Gray - Standard class,
Dark green - Components,
Gradient pink - Configurations,
Red - Controllers,
Yellow - Templates,
Orange - Object.

![Class diagram.](https://github.com/CodeURJC-DAW-2018-19/santatecla-itinerarios-2/blob/master/Screenshots/classdiagPhase3.png "Class diagram")


# Phase 4: Web implementation with SPA Architecture.

## Setting up the Dev Workspace

First, we need to install Node.js, we can download it [from here](https://nodejs.org/es/download/) or using your favorite CLI.<br/>
Then, open up CLI and install Angular using the command *npm install -g angular.cli* .<br/>
After doing this, we must navigate to our Angular project folder (in our case, we should use *cd angular* inside our main repo) and then install all the modules required using *npm install*.<br/>
You can start working on your proyect and launch the angular app using *ng serve* or the script npm start, in our case.

## Angular application Showcase Video.
Leave us a like and suscribe to our channel. :sunglasses: <br/>

[![Our video vanished lol](http://img.youtube.com/vi/8JuyRMZLzpY/0.jpg)](http://www.youtube.com/watch?v=8JuyRMZLzpY "Phase 4 Video")