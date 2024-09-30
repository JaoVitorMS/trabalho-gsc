package br.pucrs.edu.ecommerce.usuarios;

import br.pucrs.edu.ecommerce.pedidos.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Administrador extends Usuario {

    public Administrador ( int id, String nome, String func ) {
        super(id, nome, func);
    }


    /*
    Somente o administrador pode aprovar ou reprovar pedidos.
    Implementar a funcionalidade de visualização e avaliação de pedidos.
     */
    List<Pedido> listaTodosPedidos = new ArrayList<>();
    public void aprovarPedidos(){}
    public void reprovarPedidos(){}

    public List<Pedido> getPedidosPendentes(){return null;}

    public List<Pedido> listarPedidos (int dataPrimaria, int dataSecundaria){return null;}

    private void pedidos30dias(){
        List<Pedido> lista30dias = listaTodosPedidos.stream()
                                                    .filter(dia -> /*getDia()*/ <= 30)
                                                    .toList();

        System.out.println("Pedidos feitos nos ultimos 30 dias: "+lista30dias);
    }

    public void gerarRelatorio(){
    /*
    Número total de pedidos (aprovados e reprovados com percentuais).
    Pedidos feitos nos últimos 30 dias e o valor médio.
    Valor total de cada departamento nos últimos 30 dias.
    Detalhes do pedido de maior valor ainda aberto.

     */

        int num = listaTodosPedidos.size();
        System.out.println("O numero de pedidos no total é: "+num);

        pedidos30dias();

        //valor total departamento


        //logica para isso
        getPedidosPendentes();

    }


}
