package fr.pompey.cda23016.apiprojet;

import fr.pompey.cda23016.apiprojet.controller.PersonController;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PersonController personController;

    @Test
    @Description("Test de récupération de la liste des personnes")
    @Severity(SeverityLevel.CRITICAL)
    public void getPersonsTest() throws Exception {
        performGetPersonsRequest();
    }

    @Step("Effectuer une requête GET pour récupérer la liste des personnes")
    private void performGetPersonsRequest() throws Exception {
        mockMvc.perform(get("/persons"))
                .andExpect(status().isOk());
    }
}
