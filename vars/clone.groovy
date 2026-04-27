def call(String url, String branch){
                echo "This is a coding stage"
                git url: "${url}", branch: "${branch}"
                echo "Code cloning success"
}
