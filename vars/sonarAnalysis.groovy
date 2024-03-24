def call(boolean abortPipeline = false, boolean sonarExecution = true, String branchName = '') {
    def abort = abortPipeline ?: false
    def sonar = sonarExecution ?: false
    def branch = branchName?: env.BRANCH_NAME
    
    def shouldAbort = abort || (branch == 'master') || (branch.startsWith('hotfix'))

    withSonarQubeEnv('Sonar Local') {
        timeout(time: 5, unit: 'MINUTES') {
            if (sonar) {
                sh 'echo "Ejecución de las pruebas de calidad de código"'
            } else {
                echo 'Simulando ejecución de SonarQube'
            }
        }

        if (shouldAbort) {
            error 'Pipeline abortado debido a condiciones de rama.'
        } else {
            echo 'Continuando el pipeline...'
        }
    }
}
