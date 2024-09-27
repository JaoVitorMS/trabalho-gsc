package br.pucrs.edu.ecommerce.usuarios;

import br.pucrs.edu.ecommerce.pedidos.Pedido;
import br.pucrs.edu.ecommerce.pedidos.Status;

import java.util.ArrayList;
import java.util.List;

public class Adminstrador extends Usuario {
    // espaço para atributos



    //

    public Adminstrador(String nome, Integer id, Character prefix) {
        super(nome, id);
        this.setPrefix(prefix);
    }

    /*
    1.Aprovar ou Reprovar Pedidos de Aquisição:
        * Visualizar todos os pedidos pendentes e tomar uma decisão (aprovar ou rejeitar).
        * Motivo opcional para aprovação/rejeição.
        * Atualizar o status do pedido (aberto -> aprovado/reprovado).
        * Visualizar e Gerar Relatórios:
    */
    public List<Pedido> getPedidosPendentes() {
        List<Pedido> pedidosPendentes = new ArrayList<>();

        return pedidosPendentes;
    }

    public void statusPedido(Pedido pedido) {
        Status aprovado = Status.APROVADO;
        Status reprovado = Status.REPROVADO;

        System.out.println(getPedidosPendentes());
        System.out.println("Escolha um pedido");

        System.out.println("Finalizado");
    }



    /*
    2.Relatórios e estatísticas de pedidos.
        * Filtros de pedidos (por data, por funcionário, por departamento, por valor).
        * Resumo dos pedidos (aprovados, reprovados, pendentes).
        * Relatórios dos últimos 30 dias:
        * Número total de pedidos.
        * Valor médio dos pedidos.
        * Valor total por departamento.
        * Pedido de maior valor ainda aberto.
        * Filtrar e Buscar Pedidos:
    */


    /*
    3.Buscar pedidos por:
        * Período (entre duas datas específicas).
        * Funcionário solicitante.
        * Descrição de um item.
        * Listagem detalhada de pedidos.
        * Manutenção de Departamentos e Limites:
    */









    /*
    4.Criar, editar e remover departamentos.
        * Definir limites máximos de pedidos para cada departamento.
        * Atualizar limites conforme a necessidade.
     */
}
