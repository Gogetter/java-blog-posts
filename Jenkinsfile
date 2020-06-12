pipeline {
    agent any
    git {
        url 'https: //github.com/Gogetter/java-blog-posts'
        branch 'master'
        changelog true
        poll true
    }
    stages {
      stage('build') {
        steps {
          dir(path: 'java-for-docker-blog-post') {
            sh 'gradle clean build -x test'
                  }
              }
          }
    tools {
      gradle 'gradle6.5'
          }
      }
  }
