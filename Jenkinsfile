pipeline {
    agen any
    stages {
        stage ("checkout") {
            steps {
                git "https://github.com/mr3nz1-amalitech/jenkinsLab.git"
            }
        }

        stage ("test") {
            steps {
                sh "mvn test"
            }
        }

        stage ("build") {
            steps {
                sh "mvn clean install -DSkipTests"
            }
        }


        stage ("deploy") {

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