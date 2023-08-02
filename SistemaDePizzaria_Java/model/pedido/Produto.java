package model.pedido;

import java.io.Serializable;

public class Produto implements Serializable {// por Cássia Santos em 11 de julho de 2023 - teste para
  // resolução de erro de exceção
  private Long idProduto;
  private String nomeProduto;
  private String categoriaProduto;
  private double valorProduto;

  // Construtor

  public Produto(String nomeProduto, String categoriaProduto, double valorProduto) {
    this.idProduto = null;
    this.nomeProduto = nomeProduto;
    this.categoriaProduto = categoriaProduto;
    this.valorProduto = valorProduto;
  }

  // Métodos de acesso
  public Long getIdProduto() {
    return this.idProduto;
  }

  public void setIdProduto(Long idProduto) {
    this.idProduto = idProduto;
  }

  public String getNomeProduto() {
    return this.nomeProduto;
  }

  public void setNomeProduto(String nomeProduto) {
    this.nomeProduto = nomeProduto;
  }

  public String getCategoriaProduto() {
    return this.categoriaProduto;
  }

  public void setCategoriaProduto(String categoriaProduto) {
    this.categoriaProduto = categoriaProduto;
  }

  public double getValorProduto() {
    return this.valorProduto;
  }

  public void setValorProduto(double valorProduto) {
    this.valorProduto = valorProduto;
  }

}