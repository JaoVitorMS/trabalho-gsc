package br.pucrs.edu.ecommerce.usuarios;

public class Usuario {
    private int id;
    private String nome;
    private String func;

    public Usuario ( int id, String nome, String func ) {
        this.id = id;
        this.nome = nome;
        this.func = func;
    }

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getNome () {
        return nome;
    }

    public void setNome ( String nome ) {
        this.nome = nome;
    }

    public String getFunc () {
        return func;
    }

    public void setFunc ( String func ) {
        this.func = func;
    }
}
