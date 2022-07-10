package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroQuandoSalarioForMaiorDoQueDezMil () {
        BonusService bonusService = new BonusService();
//        assertThrows(IllegalArgumentException.class,
//                () -> bonusService.calcularBonus(new Funcionario("Sir", LocalDate.now(), new BigDecimal("10001"))));
        try {
            bonusService.calcularBonus(new Funcionario("Sir", LocalDate.now(), new BigDecimal("10001")));
            fail("Não caiu na exception");
        } catch (Exception e) {
            assertEquals("Funcionário com salário maior do que 1000 não pode receber bônus.", e.getMessage());
        }
    }

    @Test
    public void bonusDeveriaSerDezPorcentoDoSalarioSeSalarioForIgualADezMil () {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Sir", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

    @Test
    public void bonusDeveriaSerDezPorcentoDoSalarioSeSalarioForMenorDoQueDezMil () {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Sir", LocalDate.now(), new BigDecimal("9000")));

        assertEquals(new BigDecimal("900.00"), bonus);
    }
}