pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
               input {
		            message "Press Ok to continue"
		            submitter "user1,user2"
		            parameters {
			            string(name:'username', defaultValue: 'user', description: 'Username of the user pressing Ok')
		            }
               }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
