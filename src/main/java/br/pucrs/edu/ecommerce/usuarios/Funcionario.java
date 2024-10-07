package br.pucrs.edu.ecommerce.usuarios;

import br.pucrs.edu.ecommerce.pedidos.Pedido;
import br.pucrs.edu.ecommerce.pedidos.STATUS;
import br.pucrs.edu.ecommerce.produtos.Produto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario extends Usuario implements RegistrarPedido {

    public Funcionario ( int id, String nome, String func ) {
        super(id, nome, func);
    }

    @Override
    public int getId () {
        return super.getId();
    }

    @Override
    public void setId ( int id ) {
        super.setId(id);
    }

    @Override
    public String getNome () {
        return super.getNome();
    }

    @Override
    public void setNome ( String nome ) {
        super.setNome(nome);
    }

    @Override
    public String getFunc () {
        return super.getFunc();
    }

    @Override
    public void setFunc ( String func ) {
        super.setFunc(func);
    }


    @Override
    public List<Pedido> registrar ( String nome, Departamento departamento, List<Produto> produtos, STATUS status, Date dataPedido, Date dataConclusao ) {
        //metodo para fazer pedido
    }
}