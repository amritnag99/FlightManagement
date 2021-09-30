pipeline {
  agent any
  stages {

  stage('Maven')
    {
    steps{
        echo "Building the checked out project...";
        bat "mvn clean install";
        }
    }
    stage('Compile')
    {
    steps{
        echo "Compiling Project";
         }
    }
    stage('Test')
    {
    steps{
        echo "Testing Project";
         }
    }
  stage('Deploy')
    {
    steps{
        echo "Deploying Project";
         }
    }
}
}
