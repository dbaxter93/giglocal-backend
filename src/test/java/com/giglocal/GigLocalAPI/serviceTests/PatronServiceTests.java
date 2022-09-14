package com.giglocal.GigLocalAPI.serviceTests;

import com.giglocal.GigLocalAPI.entities.Patron;
import com.giglocal.GigLocalAPI.repositories.PatronRepository;
import com.giglocal.GigLocalAPI.services.PatronService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PatronServiceTests {

    @Mock
    PatronRepository patronRepository;

    @InjectMocks
    PatronService patronService;

    List<Patron> patrons = Arrays.asList(
            new Patron().withFirstName("Justin")
                        .withLastName("Corn")
                        .withUserName("jcoyne")
                        .withEmailAddress("jcoyne@yahoo.com"),
            new Patron().withFirstName("Claire")
                        .withLastName("Yoffe")
                        .withUserName("cloffnacht")
                        .withEmailAddress("claire@email.com")
                        .withIsActive(false)
    );

    @Test
    public void savePatron_callsRepoSave() {
        // Arrange
        Patron patron = new Patron().withFirstName("Debra");
        // Act
        patronService.savePatron(patron);
        // Assert
        verify(patronRepository, Mockito.times(1)).save(patron);
    }

    @Test
    public void getAllActivePatrons_returnsOnlyActive() {
        // Arrange
        when(patronRepository.findAll()).thenReturn(patrons);
        // Act
        List<Patron> activePatrons = patronService.getAllActivePatrons();
        // Assert
        assertEquals(1, activePatrons.size());
        activePatrons.forEach(patron -> assertTrue(patron.isActive()));
    }
}
