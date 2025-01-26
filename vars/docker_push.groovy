def call(String project, String imageTag, String dockerHubUser) {
withCredentials([usernamePassword("credentialsId":"connectToDockerStudy", 
                    passwordVariable:"dockerHubPass", 
                    usernameVariable:"dockerHubUser")]) {
                    sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
                    sh "docker image tag notes-app:latest ${dockerHubUser}/{$project}:${imageTag}"
                    sh "docker push ${dockerHubUser}/{$project}:${imageTag}"
                }
}
