imageId=$(docker images | grep -e 'local-repo/product' | awk '{print $3}')
docker rmi "$imageId"
mvn clean install
docker build -t local-repo/product:test1 .
docker images | grep -e 'local-repo/product'