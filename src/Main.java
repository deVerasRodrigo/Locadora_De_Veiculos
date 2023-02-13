import entities.*;
import repository.RepositorioDeClientes;
import repository.RepositorioDeVeiculosDisponiveis;
import repository.RepositoriodeVeiculosAlugados;
import system.GerenciadorDeAluguel;
import system.GerenciadorDeCliente;
import system.GerenciadorDeVeiculo;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {

//
//
//        repositorioDeClientes.salvar(cliente1);
//        repositorioDeClientes.salvar(cliente2);
//        repositorioDeClientes.salvar(cliente3);
//        repositorioDeClientes.salvar(clientePJ1);
//
//        System.out.println(repositorioDeClientes.listarTodos());
//
//        ClientePessoaFisica cliente1atualizado = new ClientePessoaFisica("Cliente1Att", "11111111111");
//
//        repositorioDeClientes.atualizar(cliente1atualizado);
//        System.out.println(repositorioDeClientes.listarTodos());
//
//        repositorioDeClientes.deletar("22222222222");
//        System.out.println(repositorioDeClientes.listarTodos());

//        repositorioDeVeiculosDisponiveis.salvar(veiculoM1);
//        repositorioDeVeiculosDisponiveis.salvar(veiculoM2);
//        repositorioDeVeiculosDisponiveis.salvar(veiculoM3);
//
//        System.out.println(repositorioDeVeiculosDisponiveis.buscarPorFabricante("ss"));

        RepositorioDeClientes repositorioDeClientes = new RepositorioDeClientes();
        RepositorioDeVeiculosDisponiveis repositorioDeVeiculosDisponiveis = new RepositorioDeVeiculosDisponiveis();
        RepositoriodeVeiculosAlugados repositoriodeVeiculosAlugados = new RepositoriodeVeiculosAlugados();

        GerenciadorDeVeiculo gerenciadorDeVeiculo = new GerenciadorDeVeiculo(repositorioDeVeiculosDisponiveis, repositoriodeVeiculosAlugados);
        GerenciadorDeCliente gerenciadorDeCliente = new GerenciadorDeCliente(repositorioDeClientes);
        GerenciadorDeAluguel gerenciadorDeAluguel = new GerenciadorDeAluguel(gerenciadorDeCliente, gerenciadorDeVeiculo);

//        //Criando clientes
        ClientePessoaFisica cliente1 = new ClientePessoaFisica("cliente1", "11111111111");
        ClientePessoaFisica cliente2 = new ClientePessoaFisica("cliente2", "22222222222");
        ClientePessoaFisica cliente3 = new ClientePessoaFisica("cliente3", "33333333333");
        ClientePessoaJuridica clientePJ1 = new ClientePessoaJuridica("clientePJ1", "44444444444444444");
        ClientePessoaJuridica clientePJ2 = new ClientePessoaJuridica("clientePJ2", "55555555555555555");

        //Criando veículos
        VeiculoPequeno veiculoPequeno1 = new VeiculoPequeno("Hyundai", "HB20", "PPP1P11");
        VeiculoPequeno veiculoPequeno2 = new VeiculoPequeno("Hyundai", "HB20", "PPP2P22");
        VeiculoPequeno veiculoPequeno3 = new VeiculoPequeno("Fiat", "Uno", "PPP3P33");
        VeiculoMedio veiculoMedio1 = new VeiculoMedio("Nissan", "Versa", "MMM1M11");
        VeiculoMedio veiculoMedio2 = new VeiculoMedio("Fiat", "Cronos", "MMM2M22");
        VeiculoMedio veiculoMedio3 = new VeiculoMedio("Honda", "Wr-v", "MMM3M33");
        VeiculoSUV veiculoSUV1 = new VeiculoSUV("Hyundai", "Creta", "SUV1S11");
        VeiculoSUV veiculoSUV2 = new VeiculoSUV("Fiat", "Pulse", "SUV2S22");
        VeiculoSUV veiculoSUV3 = new VeiculoSUV("Nissan", "Kicks", "SUV3S33");

        //Cadastro de clientes
        gerenciadorDeCliente.cadastrarCliente(cliente1);
        gerenciadorDeCliente.cadastrarCliente(cliente2);
        gerenciadorDeCliente.cadastrarCliente(cliente3);
        gerenciadorDeCliente.cadastrarCliente(clientePJ1);
        gerenciadorDeCliente.cadastrarCliente(clientePJ2);

        System.out.println("CLientes cadastrados: ");
        System.out.println(gerenciadorDeCliente.listarClientes());
        System.out.println();

        //Alterando clientes
        ClientePessoaFisica cliente2Alterado = new ClientePessoaFisica("Cliente2Alterado", "22222222222");
        gerenciadorDeCliente.editarCliente(cliente2Alterado);
        System.out.println("CLientes cadastrados após edição: ");
        System.out.println(gerenciadorDeCliente.listarClientes());
        System.out.println();

        //Cadastrando Veiculos
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoPequeno1);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoPequeno2);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoPequeno3);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoMedio1);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoMedio2);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoMedio3);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoSUV1);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoSUV2);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoSUV3);

        System.out.println("Veículos Disponíveis: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosDisponiveis());
        System.out.println("Veículos Alugados: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosAlugados());
        System.out.println();

        //Alterando veículos
        VeiculoSUV veiculoSUV3Alterado = new VeiculoSUV("Nissan", "Kicks 2023", "SUV3S33");

        gerenciadorDeVeiculo.editarVeiculo(veiculoSUV3Alterado);

        System.out.println("Veículos Disponíveis após edição: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosDisponiveis());
        System.out.println("Veículos Alugados: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosAlugados());
        System.out.println();

        //Buscando veículos por parte do nome do modelo ou fabricante
        System.out.println("Buscando por modelo que contenha s");
        System.out.println(gerenciadorDeVeiculo.buscarVeiculoPorModelo("s"));
        System.out.println("Buscando por fabricante que contenha yund");
        System.out.println(gerenciadorDeVeiculo.buscarVeiculoPorFabricante("yund"));
        System.out.println();

        //Alugando veículos
        Aluguel aluguel1 = gerenciadorDeAluguel.alugarVeiculoPF(cliente1, LocalDateTime.of(2023, Month.FEBRUARY, 13, 11, 49), veiculoMedio1);
        Aluguel aluguel2 =gerenciadorDeAluguel.alugarVeiculoPF(clientePJ1, LocalDateTime.of(2023, Month.FEBRUARY, 13, 11, 49), veiculoSUV1);
        Aluguel aluguel3 =gerenciadorDeAluguel.alugarVeiculoPF(cliente3, LocalDateTime.of(2023, Month.FEBRUARY, 13, 11, 49), veiculoPequeno2);
        Aluguel aluguel4 =gerenciadorDeAluguel.alugarVeiculoPF(clientePJ2, LocalDateTime.of(2023, Month.FEBRUARY, 13, 11, 49), veiculoPequeno3);

        System.out.println("Veículos Disponíveis: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosDisponiveis());
        System.out.println("Veículos Alugados: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosAlugados());
        System.out.println();

        //Devolvendo veículos
        gerenciadorDeAluguel.devolverVeiculo(aluguel1, LocalDateTime.of(2023, Month.APRIL, 13, 11, 54));
        gerenciadorDeAluguel.devolverVeiculo(aluguel2, LocalDateTime.of(2023, Month.FEBRUARY, 16, 11, 54));
        gerenciadorDeAluguel.devolverVeiculo(aluguel3, LocalDateTime.of(2023, Month.FEBRUARY, 14, 11, 54));

        System.out.println();
        System.out.println("Veículos Disponíveis: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosDisponiveis());
        System.out.println("Veículos Alugados: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosAlugados());
        System.out.println();
        
    }
}