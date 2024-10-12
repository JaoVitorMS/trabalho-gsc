package br.pucrs.edu.ecommerce.usuarios;

public class Departamento {
    private int id;
    private String nome;
    private double valorMax;

    //construtor
    public Departamento(int id, String nome, double valorMax) {
        this.id = id;
        this.nome = nome;
        this.valorMax = valorMax;
    }

    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorMax() {
        return valorMax;
    }

    public void setValorMax(double valorMax) {
        this.valorMax = valorMax;
    }
}
