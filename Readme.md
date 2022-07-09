# TDD - Test Driven Development

## Fluxo
```
Testes -> Implementação -> Refatoração

Escrever os testes, implementar a funcionalidade para passar no teste, aproveitar a segurança de que o teste garante e já refatorar o código.
```


### Pattern Strategy
Melhora legibilidade e facilita extensão das funcionalidades do projeto sem alterar os comportamentos.
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