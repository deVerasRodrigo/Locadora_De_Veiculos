package utility;

import java.math.BigDecimal;

public class CalculadoraDeDiariasVeiculoMedio implements CalculaValor{

    public BigDecimal calcularValorTotal(long quantidadeDeDiarias) {
        BigDecimal valorDaDiaria = new BigDecimal(150.0);
                    BigDecimal valorTotal = valorDaDiaria.multiply(BigDecimal.valueOf(quantidadeDeDiarias));
            return valorTotal;
    }
}
