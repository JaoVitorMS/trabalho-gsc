package br.pucrs.edu.ecommerce.usuarios;

import br.pucrs.edu.ecommerce.pedidos.Pedido;
import br.pucrs.edu.ecommerce.pedidos.Status;
import br.pucrs.edu.ecommerce.produtos.Produto;

import java.util.Date;
import java.util.List;

public interface RegistrarPedido {
    List<Pedido> registrar( String nome, Departamento departamento, List<Produto> produtos, Status status, Date dataPedido, Date dataConclusao );
}
