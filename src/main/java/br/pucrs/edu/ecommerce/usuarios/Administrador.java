package br.pucrs.edu.ecommerce.usuarios;

import br.pucrs.edu.ecommerce.pedidos.Pedido;

import java.util.List;

public class Administrador extends Usuario {


    public Administrador ( int id, String nome, String func ) {
        super(id, nome, func);
    }


    /*
    Somente o administrador pode aprovar ou reprovar pedidos.
    Implementar a funcionalidade de visualização e avaliação de pedidos.
     */
    public void aprovarPedidos(){}

    public List<Pedido> getPedidosPendentes(){return null;}

    public List<Pedido> listarPedidos (int dataInicial, int dataFinal){return null;}




    public List<String> relatorio(){
    /*
    Número total de pedidos (aprovados e reprovados com percentuais).
    Pedidos feitos nos últimos 30 dias e o valor médio.
    Valor total de cada departamento nos últimos 30 dias.
    Detalhes do pedido de maior valor ainda aberto.

     */

        return null;


    }


}
