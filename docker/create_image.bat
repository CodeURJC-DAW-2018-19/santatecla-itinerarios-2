cd ../itinerary
REM installs maven "docker run -it --rm --name webapp -v "%cd%":/src -w /src maven:3.3-jdk-8 mvn clean install"
call mvn package
copy target\itinerary-0.0.1-SNAPSHOT.jar ..\docker\app
cd ../docker
docker build -t dawgrupo8/fase3 .

