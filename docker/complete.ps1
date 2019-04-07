cd ../angular

# Build angular app
# docker run --rm --name angular-cli -v C:/Users/Adrián/Documents/GitHub/santatecla-itinerarios-2/angular -w /angular node /bin/bash -c "npm install; npm run ng build --prod --baseHref=https://localhost:8443/new/"
npm install; npm run ng build --prod --baseHref=/new/  --deploy-url=/new/ 

cd ../docker

.\create_image.bat

docker-compose up