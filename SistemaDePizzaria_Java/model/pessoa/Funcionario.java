package model.pessoa;

public class Funcionario extends Pessoa {
  
    private String cargoFuncionario;
    private Double salarioFuncionario;

    //Método construtor:
    public Funcionario(String nome, String cpf, String telefone, String endereco, String cargoFuncionario, Double salarioFuncionario) {
        super(nome, cpf, telefone, endereco);
      
        this.cargoFuncionario = cargoFuncionario;
        this.salarioFuncionario = salarioFuncionario;
    }

    //Métodos acessores:
    

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario){
        this.cargoFuncionario = cargoFuncionario;
    }

    public Double getSalarioFuncionario() {
        return salarioFuncionario;
    }

    public void setSalarioFuncionario(double salarioFuncionario){
        this.salarioFuncionario = salarioFuncionario;
    }
}