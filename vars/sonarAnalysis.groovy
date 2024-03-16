def call(boolean abortPipeline = false, boolean sonarExecution = true) {
    timeout(time: 5, unit: 'MINUTES') {
        if (sonarExecution) {
            sh 'echo "Ejecución de las pruebas de calidad de código"'
            // Aquí ejecuta el análisis de SonarQube
            // Por ejemplo: sh 'sonar-scanner'
        } else {
            echo 'Simulando ejecución de SonarQube'
        }
    }

    if (abortPipeline) {
        // Evaluar el resultado del QualityGate de SonarQube
        // y abortar el pipeline si falla
        // Por ejemplo: sh 'sonar-scanner -Dsonar.qualitygate.wait=true'
        echo 'Evaluando QualityGate de SonarQube...'
        // Código para evaluar el QualityGate y abortar si es necesario
    } else {
        echo 'Continuando el pipeline...'
    }
}
