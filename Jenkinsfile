CODE_CHANGES
pipeline {

    agent any

	stages {
			stage("Set POM version") {
			    steps {
			        sh 'echo "*********** Set POM version stage *****************"'
                    bat "C:\\engapps\\apache-maven-3.8.1\\bin\\mvn -f ${pomLocation} versions:set -DnewVersion=${newVersion}"
			}
		}

			stage("Build Java") {
                when {
                    expresssion {
                        BRANCH_NAME == 'dev' && CODE_CHANGES == true
                    }
			
			}
			    steps {
			        bat "C:\\engapps\\apache-maven-3.8.1\\bin\\mvn -f ${pomLocation} clean package -DskipTests"
			}
		}

			stage("Test Java") {
                when {
                    expresssion {
                        BRANCH_NAME == 'dev'
                    }
                }
			    
			    steps{
			        bat "mvn -f ${pomLocation} test"
                    unit allowEmptyResults: true, testResults: '**/TEST-*.xml'
			}		
		}
	}
}
