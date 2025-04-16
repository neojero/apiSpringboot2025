package fr.pompey.cda23016.apiprojet;


import fr.pompey.cda23016.apiprojet.model.Person;
import fr.pompey.cda23016.apiprojet.repository.PersonRepository;
import fr.pompey.cda23016.apiprojet.service.PersonService;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceMockAllureTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    @Description("Test de récupération d'une personne par ID")
    @Severity(SeverityLevel.CRITICAL)
    public void GetPersonByIdTest() {
        // Création d'une personne fictive pour le test
        Person person = createTestPerson(1, "John", "Doe");

        // Configuration du comportement du mock pour la méthode findById
        configureMockToReturnPerson(person);

        // Appel de la méthode à tester
        Optional<Person> result = personService.getPerson(1);

        // Vérification du résultat
        verifyFindByIdCalledOnce();
        assertPersonResult(result, 1, "John", "Doe");
    }

    @Test
    @Description("Test de récupération de toutes les personnes")
    @Severity(SeverityLevel.NORMAL)
    public void getPersonsTest() {
        // Création de personnes fictives pour le test
        Person person1 = createTestPerson(1, "John", "Doe");
        Person person2 = createTestPerson(2, "Mary", "Doe");

        // Configuration du comportement du mock pour la méthode findAll
        configureMockToReturnPersons(person1, person2);

        // Appel de la méthode à tester
        Iterable<Person> result = personService.getPersons();

        // Vérification du résultat
        verifyFindAllCalledOnce();
        assertPersonsResult(result, "John", "Mary");
    }

    @Step("Créer une personne fictive pour le test")
    private Person createTestPerson(int id, String firstName, String lastName) {
        Person person = new Person();
        person.setId(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return person;
    }

    @Step("Configurer le mock pour renvoyer une personne")
    private void configureMockToReturnPerson(Person person) {
        when(personRepository.findById(1)).thenReturn(Optional.of(person));
    }

    @Step("Configurer le mock pour renvoyer des personnes")
    private void configureMockToReturnPersons(Person... persons) {
        when(personRepository.findAll()).thenReturn(Arrays.asList(persons));
    }

    @Step("Vérifier que findById a été appelé une fois")
    private void verifyFindByIdCalledOnce() {
        verify(personRepository, times(1)).findById(1);
    }

    @Step("Vérifier que findAll a été appelé une fois")
    private void verifyFindAllCalledOnce() {
        verify(personRepository, times(1)).findAll();
    }

    @Step("Vérifier le résultat de la personne")
    private void assertPersonResult(Optional<Person> result, int id, String firstName, String lastName) {
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getId()).isEqualTo(id);
        assertThat(result.get().getFirstName()).isEqualTo(firstName);
        assertThat(result.get().getLastName()).isEqualTo(lastName);
    }

    @Step("Vérifier le résultat des personnes")
    private void assertPersonsResult(Iterable<Person> result, String... expectedNames) {
        for (String name : expectedNames) {
            assertThat(result.iterator().next().getFirstName()).contains(name);
        }
    }
}