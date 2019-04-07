cd ../angular

:: Copy angular resources on static

del /Q ..\itinerary\src\main\resources\static\new\*
copy /Y dist\my-app\* ..\itinerary\src\main\resources\static\new

:: Make jar file

cd ../itinerary
call mvn package

:: Copy jar file to docker folder

copy target\itinerary-0.0.1-SNAPSHOT.jar ..\docker\app
cd ../docker

:: Create and push image
docker build -t dawgrupo8/fase3 .
docker push dawgrupo8/fase3
