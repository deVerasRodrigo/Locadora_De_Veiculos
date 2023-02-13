package utility;

import java.math.BigDecimal;

public class CalculadoraDeDescontoPJ{

    public Double calcularDesconto(long quantidadeDeDiarias) {
        if (quantidadeDeDiarias <= 3L){
            return 0.0;
        }
        return 0.1;
    }

}
