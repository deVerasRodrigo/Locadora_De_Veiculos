package entities;

public abstract class Veiculo implements Entidade {

    private String fabricante;
    private String modelo;
    private String placa;

    public Veiculo(){

    }

    public Veiculo(String fabricante, String modelo, String placa) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.placa = placa;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String getId() {
        return this.placa;
    }

    @Override
    public String toString() {
        return  fabricante + " " + modelo + " (placa: " + placa + ")";
    }
}
