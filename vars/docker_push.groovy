def call(String Project, String ImageTag, String dockerhubuser){
withCredentials([usernamePassword(credentialsId: 'dockerhubcred', 
                                 usernameVariable: 'dockerhubUser', 
                                 passwordVariable: 'dockerhubPass')]){
                sh "docker login -u ${dockerhubUser} -p ${dockerhubPass}"
                sh "docker image tag notes-app:latest ${env.dockerhubUser}/notes-app:latest"
                sh "docker push ${dockerhubUser}/${ProjectName}:${ImageTag}"
}
