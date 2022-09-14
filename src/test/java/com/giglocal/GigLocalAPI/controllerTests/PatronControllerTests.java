package com.giglocal.GigLocalAPI.controllerTests;

import com.giglocal.GigLocalAPI.controllers.PatronController;
import com.giglocal.GigLocalAPI.entities.Patron;
import com.giglocal.GigLocalAPI.services.PatronService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PatronController.class)
public class PatronControllerTests {

    @MockBean
    private PatronService patronService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getById_returnsPatron_ifExists() throws Exception {
        when(patronService.getPatronById(1)).thenReturn(new Patron().withFirstName("Justin"));

        mockMvc.perform(
                MockMvcRequestBuilders.get("/patrons/1")
        ).andExpect(status().isOk());

        verify(patronService).getPatronById(1);
    }
}
