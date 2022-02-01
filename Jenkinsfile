pomLocation = "pom.xml"
POM_VERSION
pipeline {

    agent any
	tools {
		maven "3.8.1"
		jdk "jdk-1.8.101"
	}

	stages {
			stage("Set POM version") {
			    steps {
			        sh 'echo *********** Set POM version stage *****************'
				
			}
		}

			stage("Build Java") {
			    steps {
			        sh "mvn clean package -DskipTests"
			}
		}

			stage("Test Java") {
                steps {
			        bat "mvn test -Dtest=!e2e/**"
                    unit allowEmptyResults: true, testResults: '**/TEST-*.xml'
			}		
		}
	}
}
