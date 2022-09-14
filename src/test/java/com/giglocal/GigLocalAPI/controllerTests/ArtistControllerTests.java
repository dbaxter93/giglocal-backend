package com.giglocal.GigLocalAPI.controllerTests;

import com.giglocal.GigLocalAPI.controllers.ArtistController;
import com.giglocal.GigLocalAPI.entities.Artist;
import com.giglocal.GigLocalAPI.services.ArtistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArtistController.class)
public class ArtistControllerTests {

    @MockBean
    private ArtistService artistService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getById_returnsArtist_ifExists() throws Exception {
        when(artistService.getArtistById(1)).thenReturn(new Artist().withFirstName("Christian"));

        mockMvc.perform(
                MockMvcRequestBuilders.get("/artists/1")
        ).andExpect(status().isOk());

        verify(artistService).getArtistById(1);
    }

}
