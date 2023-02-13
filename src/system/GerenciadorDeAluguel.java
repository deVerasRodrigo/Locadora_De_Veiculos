package system;

import entities.*;
import utility.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GerenciadorDeAluguel {

    private GerenciadorDeCliente gerenciadorDeClientesPF;
    private GerenciadorDeVeiculo gerenciadorDeVeiculo;
    private final CalculadoraDeDescontoPF calculadoraDeDescontoPF = new CalculadoraDeDescontoPF();
    private final CalculadoraDeDescontoPJ calculadoraDeDescontoPJ = new CalculadoraDeDescontoPJ();
    private final CalculadoraDeDiariasVeiculoPequeno calculadoraDeDiariasVeiculoPequeno = new CalculadoraDeDiariasVeiculoPequeno();
    private final CalculadoraDeDiariasVeiculoMedio calculadoraDeDiariasVeiculoMedio = new CalculadoraDeDiariasVeiculoMedio();
    private final CalculadoraDeDiariasVeiculoSUV calculadoraDeDiariasVeiculoSUV = new CalculadoraDeDiariasVeiculoSUV();
    private final CalculadoraDeQuantidadeDeDiarias calcularQuantidadeDeDiarias = new CalculadoraDeQuantidadeDeDiarias();

    public GerenciadorDeAluguel(GerenciadorDeCliente gerenciadorDeClientesPF, GerenciadorDeVeiculo gerenciadorDeVeiculo) {
        this.gerenciadorDeClientesPF = gerenciadorDeClientesPF;
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
    }

    public Aluguel alugarVeiculoPF (Cliente cliente, LocalDateTime dataEHoraDeAluguel, Veiculo veiculo){
        Aluguel aluguel = new Aluguel(cliente, dataEHoraDeAluguel, veiculo);
        gerenciadorDeVeiculo.moverVeiculoParaAlugados(veiculo);
        return aluguel;
    }

    public void devolverVeiculo (Aluguel aluguel, LocalDateTime dataDaDevolucao){
        gerenciadorDeVeiculo.moverVeiculoParaDisponiveis(aluguel.getVeiculo());
        BigDecimal valorDoAluguel = calcularValorDoAluguel(aluguel, dataDaDevolucao);
        Long quantidadeDeDiarias = calcularQuantidadeDeDiarias(aluguel, dataDaDevolucao);
        System.out.println("Quantidade de Diárias: " + quantidadeDeDiarias);
        System.out.println("Valor do aluguel: $" + valorDoAluguel);
    }

    private BigDecimal calcularValorTotal(Aluguel aluguel, LocalDateTime dataDaDevolucao){
        long quantidadeDeDiarias = calcularQuantidadeDeDiarias(aluguel, dataDaDevolucao);
        if (aluguel.getVeiculo() instanceof VeiculoPequeno){
           return calculadoraDeDiariasVeiculoPequeno.calcularValorTotal(quantidadeDeDiarias);
       } else if (aluguel.getVeiculo() instanceof VeiculoMedio) {
           return calculadoraDeDiariasVeiculoMedio.calcularValorTotal(quantidadeDeDiarias);
       } else if (aluguel.getVeiculo() instanceof VeiculoSUV){
           return calculadoraDeDiariasVeiculoSUV.calcularValorTotal(quantidadeDeDiarias);
        } else {
            throw new IllegalArgumentException("Tipo de Veiculo Inválido");
       }
    }
    private Double calcularDesconto (Aluguel aluguel, LocalDateTime dataDaDevolucao) {
        long quantidadeDeDiarias = calcularQuantidadeDeDiarias(aluguel, dataDaDevolucao);
        if (aluguel.getCliente() instanceof ClientePessoaFisica){
            return calculadoraDeDescontoPF.calcularDesconto(quantidadeDeDiarias);
        } else if (aluguel.getCliente() instanceof ClientePessoaJuridica){
            return calculadoraDeDescontoPJ.calcularDesconto(quantidadeDeDiarias);
        } else {
            throw new IllegalArgumentException("Tipo de cliente inválido");
        }
    }
    public BigDecimal calcularValorDoAluguel (Aluguel aluguel, LocalDateTime dataDaDevolucao){
        BigDecimal valorTotal =  calcularValorTotal(aluguel, dataDaDevolucao);
        Double desconto = calcularDesconto(aluguel, dataDaDevolucao);
        return valorTotal.multiply(BigDecimal.valueOf(1L-desconto));
    }
    public long calcularQuantidadeDeDiarias (Aluguel aluguel, LocalDateTime dataDaDevolucao){
        return calcularQuantidadeDeDiarias.calcularQuantidadeDeDiarias(aluguel.getDataEhoraDeInicio(), dataDaDevolucao);
    }

}
