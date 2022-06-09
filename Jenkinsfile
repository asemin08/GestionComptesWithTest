pipeline {
    agent any


    environment {
        GIT_PATH = "https://github.com/asemin08/GestionComptesWithTest.git"
        GIT_BRANCH = "main"
    }

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

    stage('Compile') {
        steps {
            sh 'mvn compile'
        }
    }

    stage('Test') {
        steps {
            sh 'mvn test'
        }
    }
    
}