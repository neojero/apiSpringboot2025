package fr.pompey.cda23016.apiprojet.repository;

import fr.pompey.cda23016.apiprojet.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    // ici aucun codes...
    // En effet, le fait d'appeler @Repository nous donne accés à un CRUD

}
