pipeline {
    agent any
    stages {
      stage('clone repo') {
        steps {
          git(url: 'https: //github.com/Gogetter/java-blog-posts', branch: 'master', changelog: true, poll: true)
            }
        }

      stage('build') {
        parallel {
          stage('build') {
            steps {
              dir(path: 'java-for-docker-blog-post') {
                sh './gradlew clean build -x test'
                        }
                    }
                }

          stage('security checks') {
            steps {
              sh './gradlew dependencyCheckAnalyze'
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
      dependencyCheck 'dependency-check5.3.2'
    }
}