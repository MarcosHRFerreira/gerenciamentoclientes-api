package br.com.fiap.tc.gerenciamentoclientes_api.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ControllerConfigTest {

    @Autowired
    private CharacterEncodingFilter characterEncodingFilter;

    @Test
    void deveRegistrarCharacterEncodingFilterNoContexto() {
        assertNotNull(characterEncodingFilter, "O filtro CharacterEncodingFilter não foi registrado no contexto.");
        assertEquals("UTF-8", characterEncodingFilter.getEncoding(), "A codificação esperada é UTF-8.");
        assertTrue(characterEncodingFilter.isForceRequestEncoding(), "ForceEncoding deve estar ativado.");
    }
}
