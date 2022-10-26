pipeline {
       agent any
        stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'nourheneBack',
                    url : 'https://github.com/khalsibadis/devOps-Backend.git';
                             }
                             }

            stage('MVN CLEAN')
            {
                steps{
                sh  'mvn clean'
                }
            }
            stage('MVN COMPILE')
            {
                steps{
                sh  'mvn compile -e'
                }
            }
      
        stage("build & SonarQube analysis") {
            steps {

               sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=esprit'
               
            }
          }
         stage('package artifact'){
              steps{
                  sh 'mvn package'
              }
          }
          stage("nexus deploy"){
                steps{
                    nexusArtifactUploader artifacts: [
                     [
                        artifactId: 'spring-boot-starter-parent', 
                        classifier: '', 
                        file: 'target/tpAchatProject-2.5.3.jar', 
                        type: 'jar'
                        ]
                        ], 
                        credentialsId: 'nexus3', 
                        groupId: 'org.springframework.boot', 
                        nexusUrl: '192.168.1.17:8081', 
                        nexusVersion: 'nexus3', 
                        protocol: 'http', 
                        repository: 'http://192.168.1.17:8081/repository/Devops-Back-Release/', 
                        version: '2.5.3'
             }
         }                   

	}
}