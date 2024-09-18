pipeline {
    agent any

    tools {
            maven 'Maven 3.23'  // Define the Maven tool by the name given in Jenkins
    }


    stages {
        stage ("test") {
            steps {
                echo "Branch name ###################"
                echo BRANCH_NAME
                echo "Branch name ###################"
                sh "mvn test"
            }
        }

        stage ("build") {
            steps {
                sh "mvn clean install -DskipTests"
            }
        }

        stage ("deploy") {
            steps {
                echo "Deploying ..."
            }
        }
    }

    post {
        success {
            echo 'Build and Deploy succeeded!'
        }
        failure {
            echo 'Build or Deploy failed!'
        }
    }
}
