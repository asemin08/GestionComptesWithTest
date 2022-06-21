pipeline {
    agent any

    environment {
        GIT_PATH = "https://github.com/asemin08/GestionComptesWithTest.git"
        GIT_BRANCH = "main"
    }

    stages {
        stage('récupération du code source et récupération de la bonne branch') {
            steps {
                cleanWS()
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
                sh("mvn clean compile")
            }
        }

        
        stage('test du projet') {
            steps {
                sh("mvn test")
            }
            post {
                success{
                    junit '**/target/surefire-reports/*.xml'
                    emailext body: '$PROJECT_NAME - test # $BUILD_NUMBER - $BUILD_STATUS: Lien $BUILD_URL pour voir les résultat des test.', subject: '$PROJECT_NAME - Test ok ! # $BUILD_NUMBER - $BUILD_STATUS!', to: 'allan.semin@gmail.com'
                }
                failure{
                    emailext body: '$PROJECT_NAME - test # $BUILD_NUMBER - $BUILD_STATUS: Lien $BUILD_URL pour voir les résultat des test.', subject: '$PROJECT_NAME - Test non ok ! # $BUILD_NUMBER - $BUILD_STATUS!', to: 'allan.semin@gmail.com'
                }
            }
        }

        stage('Génération de la documentation du projet') {
            steps {
                sh("mvn javadoc:javadoc")
            }
        }

                
        stage('packaging du projet') {
            steps {
                sh("mvn package")
            }
        }

        stage('Maven nexus archive') {
            steps {
                sh("mvn deploy -DskipTests -Dmaven.install.skip=true")
            }
        }

        stage('Lauch ') {
            steps {
                build job: 'BuildJavaImage', parameters: [string(value: 'openjdk', name: 'image'), string(value: '17-jdk-slim', name: 'tag'), string(value: 'verkeur08/gestioncomptes', name: 'newImage')]            
            }
        }        

    }
}
