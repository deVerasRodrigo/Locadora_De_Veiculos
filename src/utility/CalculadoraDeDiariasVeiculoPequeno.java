package utility;

import java.math.BigDecimal;

public class CalculadoraDeDiariasVeiculoPequeno implements CalculaValor{

    public BigDecimal calcularValorTotal(long quantidadeDeDiarias) {
        BigDecimal valorDaDiaria = new BigDecimal(100.0);
        BigDecimal valorTotal = valorDaDiaria.multiply(BigDecimal.valueOf(quantidadeDeDiarias));
        return valorTotal;
    }
}
