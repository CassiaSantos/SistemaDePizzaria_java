package model.pessoa;
import java.io.Serializable;

public abstract class Pessoa implements Serializable{
    public static Object clientePed;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;

    //Método construtor:
    public Pessoa(String nome, String cpf, String telefone, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    //Métodos acessores:
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
}