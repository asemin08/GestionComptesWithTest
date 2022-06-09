pipeline {
    agent any

    environment {
        GIT_PATH = "https://github.com/asemin08/GestionComptesWithTest.git"
        GIT_BRANCH = "main"
    }

    stages {
        stage('récupération du code source et récupération de la bonne branch') {
            steps {
                checkout([$class: 'GitSCM',
                    branches: [[name: "*/${GIT_BRANCH}"]],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [],
                    submoduleCfg: [],
                    userRemoteConfigs: [[
                        url: "${GIT_PATH}"
                    ]]
                ])
            }
        }

        stage('Compile du projet') {
            steps {
                sh("mvn compile")
            }
        }

        stage('test unitaire du projet') {
            steps {
                sh("mvn test")
            }
            post {
                success {
                    junit '**/target/surefire-reports/*.xml'
                    emailext to: 'allan.semin@gmail.com',
                             body: 'ettsdfds', 
                             subject: 'test', 
                }
            }
        }

    }
}
