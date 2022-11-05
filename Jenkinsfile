pipeline {
       agent any
        stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'badisBack',
                    credentialsId: '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',
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
                sh  'mvn compile'
                }
            }
            stage('MVN PACKAGE'){
                          steps{
                              sh  'mvn package'
                          }
                    }
                           stage('MVN Test'){
                                              steps{
                                                  sh  'mvn test'
                                              
                                        }
                           }
                             stage('MVN SONARQUBE ')
                                            {
                                                steps{
                                                sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
                                                }
                                            }
                                            stage("nexus deploy"){
                                                           steps{
                                                                   sh 'mvn  deploy'
                                                           }
                                                      }
                    stage('Build docker image'){
                                                 steps{
                                                     script{
                                                        sh 'docker build -t badiskhalsi/springproject .'
                                                     }
                                                 }
                                             }

                                              stage('Docker login') {

                                                                                      steps {
                                                                                       sh 'echo "login Docker ...."'
                                                                	sh 'docker login -u badiskhalsi -p badis160698'
                                                                            }  }


          stage('Docker push') {

                           steps {
                                sh 'echo "Docker is pushing ...."'
                               	sh 'docker push badiskhalsi/springproject'
                                  }  }







	}

}