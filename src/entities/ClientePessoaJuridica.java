package entities;

public class ClientePessoaJuridica extends Cliente {

    private String cnpj;

    public ClientePessoaJuridica(String cnpj) {
        this.cnpj = cnpj;
    }

    public ClientePessoaJuridica(String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }

    @Override
    public String getId() {
        return this.cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        return  getNome() + " (" +
                " cnpj: "+ cnpj + ")";
    }

}
