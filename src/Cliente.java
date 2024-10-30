public class Cliente {
    private final String nome;
    private final String cpf;
    private final String telefone;

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getInfo(){
        return String.format("Nome: %s, CPF: %s, Telefone: %s", nome, cpf, telefone);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }
}