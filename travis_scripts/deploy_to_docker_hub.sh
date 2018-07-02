echo "Pushing service docker images to docker hub ...."
docker login -u "$DOCKER_USERNAME" -p "$DOCKER_PASSWORD"
docker push motoguard/authservice:$BUILD_NAME
docker push motoguard/rawdataservice:$BUILD_NAME
docker push motoguard/devicesservice:$BUILD_NAME
docker push motoguard/configservice:$BUILD_NAME
docker push motoguard/discoveryservice:$BUILD_NAME
docker push motoguard/routingservice:$BUILD_NAME
