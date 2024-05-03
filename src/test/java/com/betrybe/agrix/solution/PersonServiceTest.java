package com.betrybe.agrix.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;


/**
 * PerService test.
 */
@SpringBootTest
@ActiveProfiles("test")
public class PersonServiceTest {
    
  @Autowired
  PersonService personService;
    
  @MockBean
  PersonRepository personRepository;

  @Test
  public void getPersonByIdExistsTest() {
    Person personMock = new Person();
    Role roleMock = Role.ADMIN;
    personMock.setUsername("Marcos Valdecy");
    personMock.setId(23L);
    personMock.setPassword("senha");
    personMock.setRole(roleMock);

    Mockito.when(personRepository.findById(eq(23L)))
        .thenReturn(Optional.of(personMock));
    
    Person returnedPerson = personService.getPersonById(23L);
    assertEquals(returnedPerson.getUsername(), personMock.getUsername());
    assertEquals(returnedPerson.getId(), personMock.getId());
    assertEquals(returnedPerson.getPassword(), personMock.getPassword());
    assertEquals(returnedPerson.getRole(), personMock.getRole());
  }

  @Test
  public void getPersonByIdNotFound() {
    Mockito.when(personRepository.findById(any()))
        .thenReturn(Optional.empty());
    
    assertThrows(PersonNotFoundException.class, () -> personService.getPersonById(5L));

    Mockito.verify(personRepository).findById(5L);
  }

  @Test
  public void getPersonByUsernameExists() {
    Person personMock = new Person();
    Role roleMock = Role.ADMIN;
    personMock.setUsername("Marcos Valdecy");
    personMock.setId(23L);
    personMock.setPassword("senha");
    personMock.setRole(roleMock);

    Mockito.when(personRepository.findByUsername("Marcos Valdecy"))
        .thenReturn(Optional.of(personMock));
    
    Person returnedPerson = personService.getPersonByUsername("Marcos Valdecy");
    assertEquals(returnedPerson.getUsername(), personMock.getUsername());
    assertEquals(returnedPerson.getId(), personMock.getId());
    assertEquals(returnedPerson.getPassword(), personMock.getPassword());
    assertEquals(returnedPerson.getRole(), personMock.getRole());
  }

  @Test
  public void getPersonByUsernameNotFound() {
    Mockito.when(personRepository.findByUsername(any()))
        .thenReturn(Optional.empty());

    assertThrows(PersonNotFoundException.class,
        () -> personService.getPersonByUsername("Usuario inexistente"));
    
    Mockito.verify(personRepository).findByUsername("Usuario inexistente");
  }

  @Test
  public void createPerson() {
    Person person = new Person();
    person.setPassword("senha");
    person.setRole(Role.ADMIN);
    person.setUsername("Marcos");

    Person personToReturn = new Person();
    personToReturn.setId(1L);
    personToReturn.setPassword(person.getPassword());
    personToReturn.setRole(person.getRole());
    personToReturn.setUsername(person.getUsername());

    Mockito.when(personRepository.save(any(Person.class))).thenReturn(personToReturn);

    Person createdPerson = personService.create(person);

    Mockito.verify(personRepository).save(any(Person.class));

    assertEquals(1L, createdPerson.getId());
    assertEquals("senha", createdPerson.getPassword());
    assertEquals(Role.ADMIN, createdPerson.getRole());
    assertEquals("Marcos", createdPerson.getUsername());

  }
  
}
