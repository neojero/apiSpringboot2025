package fr.pompey.cda23016.apiprojet;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiprojetApplicationTests {

    @Test
    @Description("Test de chargement du contexte Spring Boot")
    @Severity(SeverityLevel.BLOCKER)
    void contextLoads() {
        performContextLoad();
    }

    @Step("Charger le contexte Spring Boot")
    private void performContextLoad() {
        // Le contexte Spring Boot est chargé automatiquement par l'annotation @SpringBootTest
        // Aucune action supplémentaire n'est nécessaire ici
    }

}
