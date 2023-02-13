package entities;

public class ClientePessoaFisica extends Cliente{

    private String cpf;

    public ClientePessoaFisica() {
    }

    public ClientePessoaFisica(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    @Override
    public String getId() {
        return this.cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return getNome() + " (" +
                " cpf: "+ cpf + ")";
    }
}
