pipeline {
    agent any


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
//                 sh "mvn test"
//             }
//         }

        stage ("build") {
            steps {
                echo "Using maven #######################"
                sh "mvn clean install -DskipTests"
                echo "Using maven #######################"
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
