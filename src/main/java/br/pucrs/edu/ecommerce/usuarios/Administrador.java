package br.pucrs.edu.ecommerce.usuarios;

import br.pucrs.edu.ecommerce.pedidos.Pedido;
import br.pucrs.edu.ecommerce.pedidos.STATUS;
import br.pucrs.edu.ecommerce.produtos.Produto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario {

    public Administrador ( int id, String nome, String func ) {
        super(id, nome, func);
    }

    STATUS pendente = STATUS.PENDENTE;
    STATUS aprovado = STATUS.APROVADO;
    STATUS reprovado = STATUS.REPROVADO;

    /*
    Somente o administrador pode aprovar ou reprovar pedidos.
    Implementar a funcionalidade de visualização e avaliação de pedidos.
     */
    private List<Pedido> getPedidosPendentes(List<Pedido> pedidos){
        List<Pedido> pedidosPendentes = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            if (pedido.getStatus() == pendente) {
                pedidosPendentes.add(pedido);
            }
        }
        return pedidosPendentes;
    }



    public boolean aprovarPedidos(String desc, List<Pedido> pedidos){
        List<Pedido> pedidosPendentes = getPedidosPendentes(pedidos);
        for (Pedido pedido : pedidosPendentes) {
            for(Produto p : pedido.getProdutos()){
                if(p.getDescricao().equals(desc)){
                    pedido.setStatus(aprovado);
                    return true;
                }
            }
        }
        return true;
    }


    public List<Pedido> listarPedidosEntreDatas (Date dataInicial, Date dataFinal){return null;}




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
