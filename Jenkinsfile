pipeline {
    agent any
    stages {
        stage ("checkout") {
            steps {
                git url: "https://github.com/mr3nz1-amalitech/jenkinsLab.git", credentialsId: "dc2ae824-a4cd-4290-8396-5bb25d412414", branch: "develop"
            }
        }

        stage ("test") {
            steps {
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
