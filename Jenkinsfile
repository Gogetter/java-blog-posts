pipeline {
  agent any
  stages {
    stage('clone repo') {
      steps {
        git(url: 'https://github.com/Gogetter/java-blog-posts/tree/master/java-for-docker-blog-post', branch: 'master', changelog: true, poll: true)
      }
    }

  }
}