package utility;

import java.math.BigDecimal;

public class CalculadoraDeDescontoPF{

    public Double calcularDesconto(long quantidadeDeDiarias) {
        if (quantidadeDeDiarias <= 5L){
            return 0.0;
        }
        return 0.05;
    }

}
