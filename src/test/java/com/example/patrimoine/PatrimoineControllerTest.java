package com.example.patrimoine;

import com.example.patrimoine.controller.PatrimoineController;
import com.example.patrimoine.model.Patrimoine;
import com.example.patrimoine.service.PatrimoineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PatrimoineControllerTest {
    @InjectMocks
    private PatrimoineController patrimoineController;

    @Mock
    private PatrimoineService patrimoineService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateOrUpdatePatrimoine() {
        Patrimoine patrimoine = new Patrimoine();
        patrimoine.setPossesseur("John Doe");

        patrimoineController.createOrUpdatePatrimoine("1", patrimoine);

        verify(patrimoineService, times(1)).saveOrUpdatePatrimoine(eq("1"), any(Patrimoine.class));
    }

    @Test
    void testGetPatrimoine() {
        Patrimoine patrimoine = new Patrimoine();
        patrimoine.setPossesseur("John Doe");

        when(patrimoineService.getPatrimoine("1")).thenReturn(patrimoine);

        ResponseEntity<Patrimoine> response = patrimoineController.getPatrimoine("1");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("John Doe", response.getBody().getPossesseur());
    }
}