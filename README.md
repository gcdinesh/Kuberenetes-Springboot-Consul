# Kuberenets-Springboot-Consul
1) Start the docker desktop
2) Run kubectl proxy
2) Generate the token to login in the UI. Check the kubernetes steps in kubernetes folder.
3) Goto consul folder and run kubectl apply -f config.yml -n dev-server
4) Get the IP of consul by running kubectl get pods -o wide -n dev-server
5) Update this ip in both ./src/main/resources/config.yml under the CONSUL_IP
5) Goto product folder and run kubectl apply -f ./src/main/resources/config.yml -n dev-server
6) Get the IP of product by running kubectl get pods -o wide -n dev-server
6) Goto account folder and update the ip address of product in the AccountService.java class
6) Goto account folder and run kubectl apply -f ./src/main/resources/config.yml -n dev-server