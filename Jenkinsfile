pomLocation = "pom.xml"
currentVersion
pipeline {

    agent any

	stages {
			stage("Set POM version") {
			    steps {
			        sh 'echo "*********** Set POM version stage *****************"'
					checkout scm
					currentVersion = readMavenPom file: "${pomLocation}"
                			newVersion = bumpBuildNumber(currentVersion.version)
					currentBuild.displayName = "${newVersion}"
                    			bat "C:\\engapps\\apache-maven-3.8.1\\bin\\mvn -f ${pomLocation} versions:set -DnewVersion=${newVersion}"
			}
		}

			stage("Build Java") {
			    steps {
			        bat "C:\\engapps\\apache-maven-3.8.1\\bin\\mvn -f ${pomLocation} clean package -DskipTests"
			}
		}

			stage("Test Java") {
                steps {
			        bat "mvn -f ${pomLocation} test -Dtest=!e2e/**"
                    unit allowEmptyResults: true, testResults: '**/TEST-*.xml'
			}		
		}
	}
}
