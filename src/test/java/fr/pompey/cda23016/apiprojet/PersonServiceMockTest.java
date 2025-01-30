package fr.pompey.cda23016.apiprojet;

import fr.pompey.cda23016.apiprojet.model.Person;
import fr.pompey.cda23016.apiprojet.repository.PersonRepository;
import fr.pompey.cda23016.apiprojet.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class PersonServiceMockTest {

    /**
     * Dans ce test Mockito, nous utilisons @Mock pour créer un mock de PersonRepository
     * et @InjectMocks pour injecter ce mock dans PersonService.
     * Ensuite, nous configurons le comportement du mock pour la méthode getPerson afin qu'elle renvoie
     * une Optional contenant une personne fictive lorsque l'ID spécifié est 1.
     * Ensuite, nous appelons la méthode getPerson de PersonController avec l'ID 1
     * et vérifions que la réponse est correcte.
     */
    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private PersonService personService;

    @Test
    public void GetPersonByIdTest() {
        // Création d'une personne fictive pour le test
        Person person = new Person();
        person.setId(1);
        person.setFirstName("John");
        person.setLastName("Doe");

        // Configuration du comportement du mock pour la méthode findById
        when(personRepository.findById(1)).thenReturn(Optional.of(person));

        // Appel de la méthode à tester
        Optional<Person> result = personService.getPerson(1);

        // Vérification du résultat
        verify(personRepository, times(1)).findById(1);
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getId()).isEqualTo(1);
        assertThat(result.get().getFirstName()).isEqualTo("John");
        assertThat(result.get().getLastName()).isEqualTo("Doe");
    }

    @Test
    public void getPersonsTest() {

        Person person1 = new Person();
        person1.setId(1);
        person1.setFirstName("John");
        person1.setLastName("Doe");

        Person person2 = new Person();
        person2.setId(2);
        person2.setFirstName("Mary");
        person2.setLastName("Doe");

        when(personRepository.findAll()).thenReturn(Arrays.asList(person1, person2));
        // verifie que ma méthode est appelé 1 fois

        // appel de la méthode
        Iterable<Person> result = personService.getPersons();

        verify(personRepository, times(1)).findAll();
        // contrôle du résultat
        assertThat(result.iterator().next().getFirstName().contains("John"));
        assertThat(result.iterator().next().getLastName().contains("Mary"));

    }

}
