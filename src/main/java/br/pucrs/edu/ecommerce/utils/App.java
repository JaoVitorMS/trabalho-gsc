package br.pucrs.edu.ecommerce.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.pucrs.edu.ecommerce.pedidos.Pedido;
import br.pucrs.edu.ecommerce.produtos.Produto;
import br.pucrs.edu.ecommerce.usuarios.Administrador;
import br.pucrs.edu.ecommerce.usuarios.Usuario;
import br.pucrs.edu.ecommerce.usuarios.Departamento;



public class App {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Pedido> pedidos;
    private Usuario usuarioAtual;
    private Scanner tec;
    private ArrayList<Departamento> departamentos;


    public App() {
        this.usuarios = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.departamentos = new ArrayList<>();
        this.tec = tec;

        this.tec = new Scanner(System.in);
        // Exemplo de usuários
        usuarios.add(new Administrador(1, "adm", "adm"));

        departamentos.add(new Departamento(1, "Vendas", 10000));
        departamentos.add(new Departamento(2, "TI", 15000));
        departamentos.add(new Departamento(3, "RH", 8000));
        departamentos.add(new Departamento(4, "Financeiro", 12000));
        departamentos.add(new Departamento(5, "Marketing", 9000));
        departamentos.add(new Departamento(6, "Logística", 11000));
        departamentos.add(new Departamento(7, "Suporte", 8500));
        departamentos.add(new Departamento(8, "Produção", 9500));
        departamentos.add(new Departamento(9, "Desenvolvimento", 16000));
        departamentos.add(new Departamento(10, "Pesquisa e Desenvolvimento", 17000));
        departamentos.add(new Departamento(11, "Qualidade", 10500));
        departamentos.add(new Departamento(12, "Jurídico", 14000));
        departamentos.add(new Departamento(13, "Gestão de Projetos", 11500));
        departamentos.add(new Departamento(14, "Desenvolvimento de Produto", 13000));
        departamentos.add(new Departamento(15, "Análise de Dados", 12500));

        usuarios.add(new Administrador(1, "adm", "adm"));
        usuarios.add(new Usuario(2, "João Silva", "Funcionário", departamentos.get(0)));
        usuarios.add(new Usuario(3, "Maria Oliveira", "Funcionária", departamentos.get(1)));
        usuarios.add(new Usuario(4, "Ana Costa", "Funcionária", departamentos.get(2)));
        usuarios.add(new Usuario(5, "Ricardo Santos", "Funcionário", departamentos.get(3)));
        usuarios.add(new Usuario(6, "Clara Mendes", "Funcionária", departamentos.get(4)));
        usuarios.add(new Usuario(7, "Lucas Martins", "Funcionário", departamentos.get(5)));
        usuarios.add(new Usuario(8, "Vinícius Sousa", "Funcionário", departamentos.get(6)));
        usuarios.add(new Usuario(9, "Larissa Gomes", "Funcionária", departamentos.get(7)));
        usuarios.add(new Usuario(10, "Roberto Almeida", "Funcionário", departamentos.get(8)));
        usuarios.add(new Usuario(11, "Mariana Lima", "Funcionária", departamentos.get(9)));
        usuarios.add(new Usuario(12, "Felipe Rocha", "Funcionário", departamentos.get(10)));
        usuarios.add(new Usuario(13, "Gabriela Alves", "Funcionária", departamentos.get(11)));
        usuarios.add(new Usuario(14, "André Ferreira", "Funcionário", departamentos.get(12)));
        usuarios.add(new Usuario(15, "Fernanda Nunes", "Funcionária", departamentos.get(13)));
        usuarios.add(new Usuario(16, "Juliana Costa", "Funcionária", departamentos.get(14)));
    }

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
                        aprovarRejeitarPedido();
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
        // Implementar lógica para gerar relatório
        System.out.println("Relatório gerado com sucesso!"); // Exemplo temporário
    }
}
