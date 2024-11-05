package br.com.floresdev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TestCadastrarPessoa {

    @Mock
    private ApiDosCorreios api;

    @InjectMocks
    private CadastrarPessoa cadastro = new CadastrarPessoa(api);

    @Test
    void validarDadosDeCadastro() {
        Mockito.when(api.buscaDadosComBaseNoCep("7058340")).thenReturn(new DadosLocalizacao("BA", "Salvador",
                "Rua 2", "Apto 3", "Correria"));

        Pessoa pessoa = cadastro.cadastrarPessoa("QualquerNome", "72138123",
                LocalDate.now(), "7058340");

        assertEquals("QualquerNome", pessoa.getNome());
        assertEquals("BA", pessoa.getEndereco().getUf());
    }

}
