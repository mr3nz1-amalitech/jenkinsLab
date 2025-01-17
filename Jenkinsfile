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
                bat "mvn test"
            }
        }

        stage ("build") {
            steps {
                echo "Using maven #######################"
                bat "java -version"
                bat "mvn clean install -DskipTests"
                echo "Using maven #######################"
            }
        }

        stage ("create image") {
            steps {
                echo "Creating docker #############"
                bat "docker build -t jenkinslab2 ."
                bat "docker tag jenkinslab2 mr3nz1amalitech/jenkinslab2:latest"
            }
        }

        stage("push image to docker hub") {
            steps {
                echo "Pushing to Docker Hub ###############"
                withCredentials([usernamePassword(credentialsId: '211a7a70-baf2-4b42-aeb6-05cbd54b8ba5', usernameVariable: 'USER_NAME', passwordVariable: 'PASSWORD')]) {
                    bat "docker logout"
                    bat "docker login -u %USER_NAME% -p %PASSWORD%"
                    bat "docker push mr3nz1amalitech/jenkinslab2:latest"
                }
            }
        }

        stage("deploy") {
            steps {
                withCredentials([usernamePassword(credentialsId: '211a7a70-baf2-4b42-aeb6-05cbd54b8ba5', usernameVariable: 'USER_NAME', passwordVariable: 'PASSWORD')]) {
                    echo "Deploying to container"
                    bat "docker logout"
                    bat "docker login -u %USER_NAME% -p %PASSWORD%"
                    bat "docker pull mr3nz1amalitech/jenkinslab2:latest"
                    bat "docker run -p 8082:8080 mr3nz1amalitech/jenkinslab2"
                }
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }

        success {
            echo 'Build and Deploy succeeded!'
        }

        failure {
            echo 'Build or Deploy failed!'
        }
    }
}
