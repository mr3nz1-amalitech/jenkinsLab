pipeline {
    agent any

    tools {
            maven 'maven'
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
