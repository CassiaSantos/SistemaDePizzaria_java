package model.pedido;
import java.io.Serializable;

public class ItemPedido implements Serializable {
//atributos
    private Produto produto;
    private double valorItem;
    private int quantItem;


    //método construtor
    public ItemPedido(Produto produto, double valorItem, int quantItem)
    {
        this.produto = produto;
        this.valorItem = valorItem;
        this.quantItem = quantItem;
    }
    //métodos de entrada e saída
    public Produto getProduto()
    {
        return this.produto;
    }

    public void setProduto(Produto produto)
    {
        this.produto = produto;
    }

    public double getValorItem()
    {
        return this.valorItem;
    }

    public void setValorItem(double valorItem)
    {
        this.valorItem = valorItem;
    }

    public int getQuantItem()
    {
        return this.quantItem;
    }

    public void setQuantItem(int quantItem)
    {
        this.quantItem = quantItem;
    }
  
    }