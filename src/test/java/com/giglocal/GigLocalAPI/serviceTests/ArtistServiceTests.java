package com.giglocal.GigLocalAPI.serviceTests;

import com.giglocal.GigLocalAPI.entities.Artist;
import com.giglocal.GigLocalAPI.repositories.ArtistRepository;
import com.giglocal.GigLocalAPI.services.ArtistService;
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
public class ArtistServiceTests {

    @Mock
    ArtistRepository artistRepository;

    @InjectMocks
    ArtistService artistService;

    List<Artist> artists = Arrays.asList(
            new Artist().withFirstName("David")
                    .withLastName("Taylor")
                    .withUserName("bighorn23")
                    .withEmailAddress("bassbonebro@email.com"),
            new Artist().withFirstName("Marshall")
                    .withLastName("Gilkes")
                    .withUserName("jazzcat99")
                    .withEmailAddress("fastlicks@hotmail.com"),
            new Artist().withFirstName("Denson")
                    .withLastName("Paul Pollard")
                    .withUserName("paulpol")
                    .withEmailAddress("iteachbass@uindiana.edu")
                    .withIsActive(false)
    );

    @Test
    public void saveArtist_callsRepoSave() {
        // Arrange
        Artist artist = new Artist().withFirstName("Christian")
                                    .withLastName("Lindberg")
                                    .withUserName("clindberg")
                                    .withEmailAddress("clindberg@email.com");
        // Act
        artistService.saveArtist(artist);
        // Assert
        verify(artistRepository, Mockito.times(1)).save(artist);
    }

    @Test
    public void getAllActiveArtists_returnsOnlyActive() {
        // Arrange
        when(artistRepository.findAll()).thenReturn(artists);
        // Act
        List<Artist> activeArtists = artistService.getAllActiveArtists();
        // Assert
        System.out.println("Number of artists: "+activeArtists.size());
        assertEquals(2, activeArtists.size());
        activeArtists.forEach(artist -> assertTrue(artist.isActive()));
    }

}
