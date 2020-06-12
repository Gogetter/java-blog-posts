pipeline {
  agent any
  stages {
    stage('clone repo') {
      steps {
        git(url: 'https://github.com/Gogetter/java-blog-posts', branch: 'master', changelog: true, poll: true)
      }
    }

    stage('build application') {
      parallel {
        stage('gradle build') {
          steps {
            dir(path: 'java-for-docker-blog-post') {
              sh 'gradle clean build -x test'
            }

          }
        }

        stage('security checks') {
          steps {
            sh 'gradle dependencyCheckAnalyze'
          }
        }

        stage('Run Tests') {
          steps {
            echo 'On run tests'
          }
        }

      }
    }

  }
  tools {
    gradle 'gradle6.5'
  }
}