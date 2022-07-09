package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveriaSerDeTresPorCentoQuantoDesempenhoForADesejar() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("nome", LocalDate.now(), new BigDecimal("1000.00"));
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorCentoQuantoDesempenhoForBom() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("nome", LocalDate.now(), new BigDecimal("1000.00"));
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuantoDesempenhoForOtimo() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("nome", LocalDate.now(), new BigDecimal("1000.00"));
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
