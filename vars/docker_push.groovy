def call(String ProjectName, String ImageTag, String dockerhubUser){
withCredentials([usernamePassword(credentialsId: 'dockerhubcred', 
                                 usernameVariable: 'dockerhubUser', 
                                 passwordVariable: 'dockerhubPass')]){
                sh "docker login -u ${dockerhubUser} -p ${dockerhubPass}"
                sh "docker image tag notes-app:latest ${dockerhubUser}/notes-app:latest"
                sh "docker push ${dockerhubUser}/${ProjectName}:${ImageTag}"
}
}
