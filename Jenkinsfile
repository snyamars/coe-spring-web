#!/usr/bin/env groovy

node {
  
   
   stage('checkout') {
        checkout scm
    }

    stage('check java') {
        sh "java -version"
    }

    stage('clean') {
      sh "/usr/bin/mvn clean"
    }
  
   stage('packaging') {
        //sh "./mvnw package -Pprod -DskipTests"
        sh "/usr/bin/mvn package -DskipTests"
        archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
    }
  
    /*** 
    stage ('docker build'){
      withCredentials([[$class: "UsernamePasswordMultiBinding", usernameVariable: 'DOCKERHUB_USER', passwordVariable: 'DOCKERHUB_PASS', credentialsId: 'dockerhub_id']]) {
      sh 'docker login --username $DOCKERHUB_USER --password $DOCKERHUB_PASS'
    }
    def serverImage = docker.build('snyamars007/coe-spring-webpromote')
    serverImage.push('latest')
    sh 'docker logout'
   }
   
  ***/
      stage 'notifyKubernetes'
     try{
      //sh "kubectl --kubeconfig=/var/jenkins_home/kubeconfig delete deployment coe-spring-webpromote"
       //sh "helm --kubeconfig=/var/jenkins_home/kubeconfig install coe-spring-webpromote"
       sh "helm install --kubeconfig /var/jenkins_home/kubeconfig –repo https://example.com/charts/ nginx"
       
     }catch(e){
      println("no prior deployment exists")
     }
    
      /***/   
}//end of node
