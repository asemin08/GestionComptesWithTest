pipeline {
    agent any

    parameters {
	    // choice(
        //     choices: ['prod' , 'test'],
        //     description: 'Choisir entre le code de prod ou de test',
        //     name: 'ENV'
        // )
    }

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


    }
}