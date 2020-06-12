pipeline {
  agent any
  tools {
    gradle 'gradle6.5'
    jdk 'jdk11'
  }
  stages {
    stage('clone repo') {
      steps {
        git(url: 'https://github.com/Gogetter/java-blog-posts', branch: 'master', changelog: true, poll: true)
        dir('java-for-docker-blog-post')
      }
    }

  }
}
