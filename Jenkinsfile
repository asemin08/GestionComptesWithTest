pipeline {
    agent any

    environment {
        GIT_PATH = "https://github.com/MaximeDzN/myResto-spring.git"
        GIT_BRANCH = "main"
    }

    stages {
	    stage('Suppression workspace') {
            steps {
                deleteDir()
            }
        }

        stage('récupération du code source') {
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
        

    }
}