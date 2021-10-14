#!/usr/bin/env groovy

def call() {
echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-key', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh 'docker build -t vladpartola/java-maven-app:jma-2.0 .'
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh 'docker push vladpartola/java-maven-app:jma-2.0'
    }
