pomLocation = "pom.xml"
pipeline {

    agent any
	tools {
		maven "jenkins-maven"
		jdk "jdk_9.0.4"
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
