imageId=$(docker images | grep -e 'local-repo/account' | awk '{print $3}')
docker rmi "$imageId"
mvn clean install
docker build -t local-repo/account:test1 .
docker images | grep -e 'local-repo/account'