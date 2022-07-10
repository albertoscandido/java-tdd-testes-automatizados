# TDD - Test Driven Development

## Fluxo
```
Testes -> Implementação -> Refatoração

Escrever os testes, implementar a funcionalidade para passar no teste, aproveitar a segurança de que o teste garante e já refatorar o código.
```


### Pattern Strategy / Policy

Melhora legibilidade e facilita extensão das funcionalidades do projeto sem alterar os comportamentos.
Quando usar: quando você precisa encapsular algoritimos similares para tomar uma decisão.
A classe que usa os algorítimos não é alterada.
Fechado para modificação, mas aberto para extensão. (Solid -> Open–closed principle)

``` 
Before
    if (desempenho == Desempenho.A_DESEJAR) {
        BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
        funcionario.reajustarSalario(reajuste);
    } else if (desempenho == Desempenho.BOM) {
        BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
        funcionario.reajustarSalario(reajuste);
    } else if (desempenho == Desempenho.OTIMO){
        BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.20"));
        funcionario.reajustarSalario(reajuste);
    }

After
    BigDecimal percentual = desempenho.percentualReajuste();
    BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
    funcionario.reajustarSalario(reajuste);

```

## Benefícios
- Código já sai testado;
- Evita testes viciados na implementação;
- Refatoração faz parte do processo;
- Ajuda a manter o foco;
- Temos a tendência em escrever um código mais limpo/simples.


## Lidando com Exceptions
```
assertThrows - classe de erro esperada + lambda com chamada do método que deve lançar a exceção.

assertThrows(IllegalArgumentException.class,
                () -> bonusService.calcularBonus(new Funcionario("Sir", LocalDate.now(), new BigDecimal("10001"))));
```
```
fail() para indicar que não parou onde deveria e bloco catch para pegar a exception e sua mensagem.

try {
    bonusService.calcularBonus(new Funcionario("Sir", LocalDate.now(), new BigDecimal("10001")));
    fail("Não caiu na exception");
} catch (Exception e) {
    assertEquals("Funcionário com salário maior do que 1000 não pode receber bônus.", e.getMessage());
}
```

É preciso se preocupar também com o código dos testes e refatorá-los e deixa-los simples e fáceis de serem entendidos e alterados.
```
@BeforeEach
@AfterEach
@BeforeAll
@AfterAll
```

Um método private não precisa de testes pois ele é testado internamente na classe e já vai ser testado quando escrevermos os testes dos outros métodos.
Em um projeto, não precisamos testar 100%. Classes sem regras de negócios/validações e que não tendem a ser alteradas ao longo do tempo não precisam ser testadas.
