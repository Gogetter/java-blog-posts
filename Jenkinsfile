pipeline {
  agent any
  stages {
    stage('clone repo') {
      steps {
        git(url: 'https://github.com/Gogetter/java-blog-posts', branch: 'master', changelog: true, poll: true)
        dir(path: 'java-for-docker-blog-post') {
          parallel 'Build project' {
            sh "./gradlew clean build -x test"
          }
          echo 'in java directory'
        }

      }
    }

  }
  tools {
    gradle 'gradle6.5'
    jdk 'jdk11'
  }
}
