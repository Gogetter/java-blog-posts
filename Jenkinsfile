pipeline {
    agent any
    stages {
      stage('clone repo') {
        steps {
          git(url: 'https: //github.com/Gogetter/java-blog-posts', branch: 'master', changelog: true, poll: true)
            }
        }
  
      stage('build') {
        steps {
          dir(path: 'java-for-docker-blog-post') {
                      sh "gradle clean build -x test"
                }
            }
        }
    }
    tools {
      gradle 'gradle6.5'
      jdk 'jdk11'
    }
}
