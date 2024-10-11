package br.pucrs.edu.ecommerce.pedidos;

import br.pucrs.edu.ecommerce.produtos.Produto;
import br.pucrs.edu.ecommerce.usuarios.Departamento;
import br.pucrs.edu.ecommerce.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private Status status; //definicao do bagúi
    private Usuario usuarioSolicitante;
    private Departamento departamento;
    private Date dataPedido;
    private Date dataConclusao;
    private ArrayList<Produto> produtos;
    private double valorTotal;
    private int id;

    //construtor
    public Pedido (Usuario usuario, Departamento departamento) {
        this.status = status.PENDENTE; //define como pendente todos os novos pedidos
        this.usuarioSolicitante = usuario;
        this.departamento = departamento;
        this.dataPedido = new Date(); //data atual
        this.produtos = new ArrayList<>();
        this.id = id;
    }

    //getters e setters
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Usuario getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public void setUsuarioSolicitante(Usuario usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pedido {" +
            "\n  Status: " + getStatus() +
            "\n  Usuario Solicitante: " + getUsuarioSolicitante() +
            "\n  Departamento: " + getDepartamento() +
            "\n  Data do Pedido: " + getDataPedido() +
            "\n  Data de Conclusao: " + getDataConclusao() +
            "\n  Produtos: " + getProdutos() +
            "\n  Valor Total: " + getValorTotal() +
            "\n}";
    }
}
