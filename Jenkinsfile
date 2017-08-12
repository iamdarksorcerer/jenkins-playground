#!/usr/bin/env groovy

node {
    stage('Checkout source') {
        checkout scm
    }

    stage('Project build') {
        dir('playground') {
            sh 'chmod +x gradlew'
            sh './gradlew clean build'
        }
    }

    stage("Archive test reports") {
        dir('playground') {
            junit 'build/**/TEST-*.xml'
        }
    }
}
