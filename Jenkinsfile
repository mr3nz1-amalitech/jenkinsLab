pipeline {
    agent any

    tools {
            maven 'maven'
    }


    stages {
//         stage("Checkout") {
//                 steps {
//                     git branch: "${env.BRANCH_NAME}",
//                         credentialsId: 'c68e1e84-57b3-4aaa-98e1-da4ea910fc10',
//                         url: 'git@github.com:mr3nz1-amalitech/jenkinsLab.git'
//                 }
//         }


//         stage ("test") {
//             steps {
//                 echo "Branch name ###################"
//                 echo BRANCH_NAME
//                 echo "Branch name ###################"
//                 bat "mvn test"
//             }
//         }

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
                bat "docker build -t jenkinslab ."
                bat "docker tag jenkinslab mr3nz1amalitech/jenkinslab:latest"
            }
        }

        stage ("push to docker hub") {
            steps {
                echo "Pushing to docker hub ###############"
                bat "echo 'R2,S3i3E@J@4xDf' | docker login -u mr3nz1amalitech --password-stdin"
                bat "docker push mr3nz1amalitech/jenkinsLab:latest"
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
