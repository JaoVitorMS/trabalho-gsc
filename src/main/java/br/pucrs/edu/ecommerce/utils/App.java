package br.pucrs.edu.ecommerce.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.pucrs.edu.ecommerce.pedidos.Pedido;
import br.pucrs.edu.ecommerce.pedidos.STATUS;
import br.pucrs.edu.ecommerce.produtos.Produto;
import br.pucrs.edu.ecommerce.usuarios.Administrador;
import br.pucrs.edu.ecommerce.usuarios.Usuario;

public class App {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Pedido> pedidos;
    private Usuario usuarioAtual;
    private Scanner tec;
    Administrador admin = new Administrador(1, "admin", "admin");

    public App() {
        this.usuarios = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.tec = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            System.out.println("-------- Sistema de Controle: --------");
            System.out.println("1. Escolher Usuário");
            System.out.println("2. Avaliar Pedidos");
            System.out.println("3. Listar Pedidos");
            System.out.println("4. Aprovar/Rejeitar Pedido (Admin)");
            System.out.println("5. Gerar Relatório (Admin)");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = tec.nextInt();
            tec.nextLine();

            switch (opcao) {
                case 1:
                    escolherUsuario();
                    break;

                case 2:
                    avaliarPedidos();
                    break;

                case 3:
                    listarPedidos();
                    break;

                case 4:
                    if (usuarioAtual instanceof Administrador) {
                        System.out.println("Digite a descricao do pedido:");
                        String descricao = tec.nextLine();
                        tec.nextLine();
                        System.out.println("Digite 1 se aprova ou 2 se rejeita");
                        int op = tec.nextInt();
                        admin.aprovarOuReprovarPedidos(descricao, op, pedidos);
                    } else {
                        System.out.println("Você não tem permissão para esta ação.");
                    }
                    break;

                case 5:
                    gerarRelatorio();
                    break;

                case 6:
                    System.out.println("Saindo do Sistema...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (opcao != 6);
    }

    private void avaliarPedidos() {
        int opcao;
        do {
            System.out.println("------ Avaliação de Pedidos ------");
            System.out.println("1. Listar pedidos entregues");
            System.out.println("2. Buscar pedido por funcionário");
            System.out.println("3. Buscar pedido por itens");
            System.out.println("4. Ver detalhes do pedido");
            System.out.println("5. Retornar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = tec.nextInt();
            tec.nextLine();

            switch (opcao) {
                case 1:
                    listarPedidosEntregues();
                    break;

                case 2:
                    buscarPedidoPorFuncionario();
                    break;

                case 3:
                    buscarPedidoPorItens();
                    break;

                case 4:
                    verDetalhesDoPedido();
                    break;

                case 5:
                    System.out.println("Retornando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (opcao != 5);
    }

    private void listarPedidosEntregues() {
        System.out.println("Pedidos entregues:");
        boolean temPedidosEntregues = false;
        for (Pedido pedido : pedidos) {
            if (pedido.getStatus() == STATUS.APROVADO) {
                System.out.println("Pedido ID: " + pedido.getId() + " | Usuário: " + pedido.getUsuarioSolicitante().getNome());
                temPedidosEntregues = true;
            }
        }
        if (!temPedidosEntregues) {
            System.out.println("Nenhum pedido foi entregue até o momento.");
        }
    }

    private void buscarPedidoPorFuncionario() {
        System.out.print("Digite o nome do funcionário: ");
        String nomeFuncionario = tec.nextLine();
        boolean encontrado = false;

        for (Pedido pedido : pedidos) {
            if (pedido.getUsuarioSolicitante().getNome().equalsIgnoreCase(nomeFuncionario)) {
                System.out.println("Pedido ID: " + pedido.getId());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum pedido encontrado para o funcionário: " + nomeFuncionario);
        }
    }

    private void buscarPedidoPorItens() {
        System.out.print("Digite a descrição do item: ");
        String descricaoItem = tec.nextLine();
        boolean encontrado = false;

        for (Pedido pedido : pedidos) {
            for (Produto produto : pedido.getProdutos()) {
                if (produto.getDescricao().equalsIgnoreCase(descricaoItem)) {
                    System.out.println("Pedido ID: " + pedido.getId() + " | Usuário: " + pedido.getUsuarioSolicitante().getNome());
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum pedido encontrado com o item: " + descricaoItem);
        }
    }

    private void verDetalhesDoPedido() {
        System.out.print("Digite o ID do pedido: ");
        int idPedido = tec.nextInt();
        tec.nextLine();
        boolean encontrado = false;

        for (Pedido pedido : pedidos) {
            if (pedido.getId() == idPedido) {
                System.out.println("Detalhes do Pedido ID: " + pedido.getId());
                System.out.println("Usuário: " + pedido.getUsuarioSolicitante().getNome());
                System.out.println("Data do Pedido: " + pedido.getDataPedido());
                System.out.println("Status: " + pedido.getStatus());
                System.out.println("Produtos:");

                for (Produto produto : pedido.getProdutos()) {
                    System.out.println(" - " + produto.getDescricao() + " | Quantidade: " + produto.getQuantidade() + " | Valor Unitário: " + produto.getValorUnitario());
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Pedido não encontrado com ID: " + idPedido);
        }
    }

    private void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }

        System.out.println("Lista de Pedidos:");
        for (Pedido pedido : pedidos) {
            System.out.println("Pedido ID: " + pedido.getId());
            System.out.println("Usuário: " + pedido.getUsuarioSolicitante().getNome());
            System.out.println("Data do Pedido: " + pedido.getDataPedido());
            System.out.println("Status: " + pedido.getStatus());
            System.out.println("Produtos:");

            for (Produto produto : pedido.getProdutos()) {
                System.out.println(" - " + produto.getDescricao() + " | Quantidade: " + produto.getQuantidade() + " | Valor Unitário: " + produto.getValorUnitario());
            }
        }
    }

    private void escolherUsuario() {
        System.out.println("Escolher Usuário:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getId() + ", " + usuario.getNome());
        }
        System.out.println("Digite o ID do usuário desejado:");
        int idEscolhido = tec.nextInt();

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == idEscolhido) {
                usuarioAtual = usuario;
                System.out.println("Usuário " + usuarioAtual.getNome() + " escolhido!");
                return;
            }
        }
        System.out.println("Usuário não encontrado!");
    }

    private void gerarRelatorio() {
        admin.relatorio(pedidos);
        System.out.println("Relatório gerado com sucesso!"); // Exemplo temporário
    }
}
