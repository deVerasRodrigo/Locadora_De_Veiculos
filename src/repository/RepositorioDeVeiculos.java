package repository;

import entities.Veiculo;

import java.util.ArrayList;
import java.util.List;

public interface RepositorioDeVeiculos extends Repositorio<Veiculo> {

    default List<Veiculo> buscarPorFabricante(String fabricante){
        List<Veiculo> busca = new ArrayList<>();
        for (int i = 0; i < listarTodos().size(); i++) {
            if (listarTodos().get(i).getFabricante().contains(fabricante)){
                busca.add(listarTodos().get(i));
            }
        }
        return busca;
    }

    default List<Veiculo> buscarPorModelo(String modelo){
        List<Veiculo> busca = new ArrayList<>();
        for (int i = 0; i < listarTodos().size(); i++) {
            if (listarTodos().get(i).getModelo().contains(modelo)){
                busca.add(listarTodos().get(i));
            }
        }
        return busca;
    }
}
