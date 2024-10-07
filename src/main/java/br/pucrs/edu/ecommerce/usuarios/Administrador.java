package br.pucrs.edu.ecommerce.usuarios;

import br.pucrs.edu.ecommerce.pedidos.Pedido;
import br.pucrs.edu.ecommerce.pedidos.STATUS;
import br.pucrs.edu.ecommerce.produtos.Produto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Administrador extends Usuario {
    
    List<Pedido> pedidosTotais = new ArrayList<>();
    List<Pedido> pedidosAprovados = new ArrayList<>();
    List<Pedido> pedidosReprovados = new ArrayList<>();



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



    public boolean aprovarOuReprovarPedidos(String desc, int opcao, List<Pedido> pedidos){
        List<Pedido> pedidosPendentes = getPedidosPendentes(pedidos);
        if (opcao == 1) {
            for (Pedido pedido : pedidosPendentes) {
                for(Produto p : pedido.getProdutos()){
                    if(p.getDescricao().equals(desc)){
                        pedido.setStatus(aprovado);
                        return true;
                    }
                }
            }
        } else if (opcao == 2) {
            for (Pedido pedido : pedidosPendentes) {
                for(Produto p : pedido.getProdutos()){
                    if(p.getDescricao().equals(desc)){
                        pedido.setStatus(reprovado);
                        return true;
                    }
                }
            }
        }
        else{
            return false;
        }
        
        for (Pedido pedido : pedidos) {
            if (pedido.getStatus() == aprovado) {
                pedidosTotais.add(pedido);
                pedidosAprovados.add(pedido);
            }
        }
        for (Pedido pedido : pedidos) {
            if (pedido.getStatus() == reprovado) {
                pedidosTotais.add(pedido);
                pedidosReprovados.add(pedido);
            }
        }
    }


    public List<Pedido> listarPedidosEntreDatas (Date dataInicial, Date dataFinal, List<Pedido> pedidos){
        List<Pedido> pedidosEntreDatas = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getDataPedido().after(dataInicial) && pedido.getDataPedido().before(dataFinal)) {
                pedidosEntreDatas.add(pedido);
            }
        }
        return pedidosEntreDatas;

    }

    public List<Pedido> listaListaPedidosUltimos30Dias(List<Pedido> pedidos){
        List<Pedido> pedidosUltimos30Dias = new ArrayList<>();
        Date dataAtual = new Date(System.currentTimeMillis());
        Date dataInicial = new Date(dataAtual.getTime() - 30 * 24 * 60 * 60 * 1000);
        for (Pedido pedido : pedidos) {
            if (pedido.getDataPedido().after(dataInicial) && pedido.getDataPedido().before(dataAtual)) {
                pedidosUltimos30Dias.add(pedido);
            }
        }
        return pedidosUltimos30Dias;
    }



    public void relatorio(List<Pedido> pedidosTotais){
    /*
    Número total de pedidos (aprovados e reprovados com percentuais).
    Pedidos feitos nos últimos 30 dias e o valor médio.
    Valor total de cada departamento nos últimos 30 dias.
    Detalhes do pedido de maior valor ainda aberto.

     */
        int totalPedidos = pedidosTotais.size();
        int totalAprovados = pedidosAprovados.size();
        int totalReprovados = pedidosReprovados.size();

        int porcentagemAprovados = (totalAprovados * 100) / totalPedidos;
        int porcentagemReprovados = (totalReprovados * 100) / totalPedidos;
       
        List<Pedido> pedidosUltimos30Dias = listaListaPedidosUltimos30Dias(pedidosTotais);

        double valorTotalPedidosUltimos30Dias = 0;
        Pedido pedidoMaiorValor = null;
        for (Pedido pedido : pedidosUltimos30Dias) {
            valorTotalPedidosUltimos30Dias += pedido.getValorTotal();
            if (pedidoMaiorValor == null || pedido.getValorTotal() > pedidoMaiorValor.getValorTotal()) {
            pedidoMaiorValor = pedido;
            }
        }
        
        System.out.println("Número total de pedidos: " + totalPedidos);
        System.out.println("Percentual de pedidos aprovados: " + porcentagemAprovados + "%");
        System.out.println("Percentual de pedidos reprovados: " + porcentagemReprovados + "%");
        System.out.println("Pedidos feitos nos últimos 30 dias: " + pedidosUltimos30Dias.size());
        
        String pedidosString = pedidosUltimos30Dias.stream()
        .map(Pedido::toString)
        .collect(Collectors.joining(", "));
        System.out.println(pedidosString);

    }


}
