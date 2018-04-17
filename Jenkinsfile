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
        sh "/usr/bin/mvn package -Pprod -DskipTests"
        archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
    }
  
    /***/ 
    stage ('docker build'){
      withCredentials([[$class: "UsernamePasswordMultiBinding", usernameVariable: 'DOCKERHUB_USER', passwordVariable: 'DOCKERHUB_PASS', credentialsId: 'dockerhub_id']]) {
      sh 'docker login --username $DOCKERHUB_USER --password $DOCKERHUB_PASS'
    }
    def serverImage = docker.build('snyamars007/coe-spring-web')
    serverImage.push('latest')
    sh 'docker logout'
   }
   
      stage 'notifyKubernetes'
     try{
      sh "kubectl delete deployment coe-spring-web"
     }catch(e){
      println("no prior deployment exists")
     }
     try{
          sh "kubectl delete svc coe-spring-web"   
     }catch(e){
      println("no prior service exists")
     }
   
      sh "sleep 3s"
      sh "kubectl run --image=snyamars007/coe-spring-web:latest coe-spring-web  --port=8090"
      //sh "kubectl expose deployment customer-data-service1 --type=NodePort "
      sh "kubectl expose deployment coe-spring-web"
      // sh "kubectl create -f customer-data-service1.yaml"
    
      /***/   
}//end of node
