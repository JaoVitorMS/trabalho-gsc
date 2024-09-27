package br.pucrs.edu.ecommerce.usuarios;

public class Usuario {
    private String nome;
    private Integer id;
    private Character prefix;

    public Usuario ( String nome, Integer id) {
        this.nome = nome;
        this.id = id;
        this.prefix = prefix;
    }

    public String getNome () {
        return nome;
    }

    public void setNome ( String nome ) {
        this.nome = nome;
    }

    public Integer getId () {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public Character getPrefix () {
        return prefix;
    }

    public void setPrefix ( Character prefix ) {
        this.prefix = prefix;
    }
}
