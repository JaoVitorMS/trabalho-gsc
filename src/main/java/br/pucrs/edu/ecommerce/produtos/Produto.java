package br.pucrs.edu.ecommerce.produtos;

public class Produto {
    //atributos
    private String descricao;
    private double valorUnitario;
    private int quantidade;
    private double valorTotal;
    
    //construtor
    public Produto(String descricao, double valorUnitario, int quantidade) {
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.valorTotal = calculaValorTotal();
    }

    //método para calcular o valor total do produto
    private double calculaValorTotal() {
        return valorUnitario * quantidade;
    }

    //getters e setters
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return String.format(
            "Produto {\n" +
            "  Descrição: '%s',\n" +
            "  Valor Unitário: %.2f,\n" +
            "  Quantidade: %d,\n" +
            "  Valor Total: %.2f\n" +
            "}", descricao, valorUnitario, quantidade, valorTotal);
    }
}
