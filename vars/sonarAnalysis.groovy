def call(boolean abortPipeline = false, boolean sonarExecution = true, String branchName = '') {
    def branch = branchName ?: env.BRANCH_NAME
    
    def shouldAbort = abortPipeline || (branch == 'master') || (branch.startsWith('hotfix'))

    withSonarQubeEnv('SonarQube') {
        timeout(time: 5, unit: 'MINUTES') {
            if (sonarExecution) {
                sh 'echo "Ejecución de las pruebas de calidad de código"'
            } else {
                echo 'Simulando ejecución de SonarQube'
            }
        }

        if (abortPipeline) {
            echo 'Evaluando QualityGate de SonarQube...'
        } else {
            echo 'Continuando el pipeline...'
        }
    }
}

