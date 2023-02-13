package system;

import entities.Veiculo;
import repository.RepositorioDeVeiculosDisponiveis;
import repository.RepositoriodeVeiculosAlugados;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeVeiculo {

    private final RepositorioDeVeiculosDisponiveis repositorioDeVeiculosDisponiveis;
    private final RepositoriodeVeiculosAlugados repositoriodeVeiculosAlugados;

    public GerenciadorDeVeiculo(RepositorioDeVeiculosDisponiveis repositorioDeVeiculosDisponiveis, RepositoriodeVeiculosAlugados repositoriodeVeiculosAlugados) {
        this.repositorioDeVeiculosDisponiveis = repositorioDeVeiculosDisponiveis;
        this.repositoriodeVeiculosAlugados = repositoriodeVeiculosAlugados;
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        if (isVeiculoDisponivel(veiculo)){
            throw new IllegalArgumentException("Placa já cadastrada");
        }
        if (isVeiculoAlugado(veiculo)){
            throw new IllegalArgumentException("Veículo já cadastrado e encontra-se alugado!");
        }
        repositorioDeVeiculosDisponiveis.salvar(veiculo);
    }

    public void moverVeiculoParaAlugados(Veiculo veiculo) {
        if (!isVeiculoDisponivel(veiculo)){
            throw new IllegalArgumentException("Placa não cadastrada, ou veículo indisponível para aluguel");
        }
        if (isVeiculoAlugado(veiculo)){
            throw new IllegalArgumentException("Veículo já está alugado");
        }

        repositorioDeVeiculosDisponiveis.deletar(veiculo.getId());
        repositoriodeVeiculosAlugados.salvar(veiculo);
    }
    public void moverVeiculoParaDisponiveis(Veiculo veiculo) {
        if (!isVeiculoAlugado(veiculo)){
            throw new IllegalArgumentException("Veículo não existe ou não pode ser devolvido por estar alugado");
        }
        if (isVeiculoDisponivel(veiculo)){
            throw new IllegalArgumentException("Veículo não está alugado para devolução");
        }

        repositoriodeVeiculosAlugados.deletar(veiculo.getId());
        repositorioDeVeiculosDisponiveis.salvar(veiculo);
    }
    public void removerVeiculo (Veiculo veiculo){
        if (!isVeiculoDisponivel(veiculo)){
            throw new IllegalArgumentException("Veículo não cadastrado ou Veículo alugado");
        }
        if ((isVeiculoAlugado(veiculo))){
            throw new IllegalArgumentException("Impossível remover um veículo que encontra-se alugado");
        }
        repositorioDeVeiculosDisponiveis.deletar(veiculo.getId());
    }
    public void editarVeiculo (Veiculo veiculo){
        if (!isVeiculoDisponivel(veiculo) && !isVeiculoAlugado(veiculo)){
            throw new IllegalArgumentException("Veículo não cadastrado");
        }
        if (isVeiculoDisponivel(veiculo)){
            repositorioDeVeiculosDisponiveis.deletar(veiculo.getId());
            repositorioDeVeiculosDisponiveis.salvar(veiculo);
        }
        if (isVeiculoAlugado(veiculo)){
            repositoriodeVeiculosAlugados.deletar(veiculo.getId());
            repositoriodeVeiculosAlugados.salvar(veiculo);
        }
    }
    public List<Veiculo> buscarVeiculoPorModelo(String modelo){
        List<Veiculo> veiculosDisponiveis = repositorioDeVeiculosDisponiveis.buscarPorModelo(modelo);
        List<Veiculo> veiculosAlugados = repositoriodeVeiculosAlugados.buscarPorModelo(modelo);
        List<Veiculo> todosEncontrados = new ArrayList<>();
        todosEncontrados.addAll(veiculosDisponiveis);
        todosEncontrados.addAll(veiculosAlugados);
        return todosEncontrados;
    }
    public List<Veiculo> buscarVeiculoPorFabricante(String fabricante){
        List<Veiculo> veiculosDisponiveis = repositorioDeVeiculosDisponiveis.buscarPorFabricante(fabricante);
        List<Veiculo> veiculosAlugados = repositoriodeVeiculosAlugados.buscarPorFabricante(fabricante);
        List<Veiculo> todosEncontrados = new ArrayList<>();
        todosEncontrados.addAll(veiculosDisponiveis);
        todosEncontrados.addAll(veiculosAlugados);
        return todosEncontrados;
    }

    public List<Veiculo> listarVeiculosDisponiveis(){
        return repositorioDeVeiculosDisponiveis.listarTodos();
    }
    public List<Veiculo> listarVeiculosAlugados(){
        return repositoriodeVeiculosAlugados.listarTodos();
    }

   public boolean isVeiculoDisponivel(Veiculo veiculo) {
        return repositorioDeVeiculosDisponiveis.consultar(veiculo.getId()) != null;
    }

    public boolean isVeiculoAlugado(Veiculo veiculo) {
        return repositoriodeVeiculosAlugados.consultar(veiculo.getId()) != null;
    }

}
