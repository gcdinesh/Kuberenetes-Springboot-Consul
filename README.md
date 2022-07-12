# Kuberenets-Springboot-Consul
Phase 2:
1) Start the docker desktop
2) Run kubectl proxy
3) Generate the token to login in the UI. Check the kubernetes steps in kubernetes folder.
4) Goto consul folder and run kubectl apply -f config.yml -n dev-server
5) Goto product folder and run kubectl apply -f config.yml -n dev-server
6) Goto account folder and run kubectl apply -f config.yml -n dev-server

The order of deploying resources should not change.
Because in this phase we have tied up the pods to SVC resource.
And now if we do kubectl get svc -n dev-server then we would get the clusterIP of each service.
This clusterIP and port will be exposed as ENVIRONMENT variables in all the services which in our case is used
in the account service to fetch the details of product service.
Now if We deploy first the account service then the ENV variable present inside the account pod will not have the product service IP and port which would provide us null values.

Hence first we need to deploy consul, product and then account.
Similarly as part of this change we have moved from consul service discovery to kubernetes service discovery using the SVC resource IPs.


Phase 1:
1) Start the docker desktop
2) Run kubectl proxy
3) Generate the token to login in the UI. Check the kubernetes steps in kubernetes folder.
4) Goto consul folder and run kubectl apply -f config.yml -n dev-server
5) Get the IP of consul by running kubectl get pods -o wide -n dev-server
6) Update this ip in both ./src/main/resources/config.yml under the CONSUL_IP
7) Goto product folder and run kubectl apply -f ./src/main/resources/config.yml -n dev-server
8) Get the IP of product by running kubectl get pods -o wide -n dev-server
9) Goto account folder and update the ip address of product in the AccountService.java class
10) Run the generateImage.sh present in the account folder.
10) Goto account folder and run kubectl apply -f ./src/main/resources/config.yml -n dev-server
