package utility;

import java.math.BigDecimal;

public class CalculadoraDeDiariasVeiculoSUV implements CalculaValor{

    public BigDecimal calcularValorTotal(long quantidadeDeDiarias) {
        BigDecimal valorDaDiaria = new BigDecimal(200.0);
        BigDecimal valorTotal = valorDaDiaria.multiply(BigDecimal.valueOf(quantidadeDeDiarias));
        return valorTotal;
    }
}
