pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
              	sh 'ls -al'
              	sh 'chmod 755 mvnw'
                sh './mvnw clean'
                sh './mvnw compile'
            }
        }
        stage('test') {
            steps {
               	sh './mvnw test'
           }
        }
         stage('install') {
                    steps {
                       	sh './mvnw install'
                      	sh 'ls -al'
                    }
                }
    }
//   post {
//          always {
//              junit 'build/test-results/**/*.xml'
//          }
//         success{
//         		   archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
//         }
//      }
}