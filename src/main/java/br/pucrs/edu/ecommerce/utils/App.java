package br.pucrs.edu.ecommerce.utils;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import br.pucrs.edu.ecommerce.pedidos.Pedido;
import br.pucrs.edu.ecommerce.usuarios.Administrador;
import br.pucrs.edu.ecommerce.usuarios.Usuario;

public class App {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Pedido> pedidos;
    private Usuario usuarioAtual;
    private Scanner tec;

    public App() {
        this.usuarios = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.tec = new Scanner(System.in);
    }

    //usuarios exemplo    
    usuarios.add(new Administrador(1,"adm","adm"));

    public void iniciar() {
        int opcao;
        do {
            System.out.println("-------- Sistema de Controle: --------");
            System.out.println("1. Escolher Usuário");
            System.out.println("2. Registrar Pedido");
            System.out.println("3. Listar Pedidos");
            System.out.println("4. Aprovar/Rejeitar Pedido (Admin)");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = tec.nextInt();
            tec.nextLine();
        
            switch (opcao) {
                case 1:
                    escolherUsuario();
                    break;

                case 2:
                    registrarPedido();
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
                    System.out.println("Saindo do Sistema...");
                    break;
                
                default:
                    break;
            }
        } while (opcao != 5);
    }

    private void registrarPedido() {
        if (usuarioAtual == null) {
            System.out.println("Nenhum usuário selecionado! Por favor, escolha um usuário primeiro.");
            return;
        }

        System.out.println("Registrar novo pedido para " + usuarioAtual.getNome() + ":");

        List<Produto> produtosPedido = new ArrayList<>();
        int opcaoProduto;

        do {
            System.out.print("Digite a descrição do produto: ");
            String descricao = tec.nextLine();

            System.out.print("Digite o valor unitário do produto: ");
            double valorUnitario = tec.nextDouble();

            System.out.print("Digite a quantidade do produto: ");
            int quantidade = tec.nextInt();
            tec.nextLine();

            Produto produto = new Produto(descricao, valorUnitario, quantidade);
            produtosPedido.add(produto);

            System.out.print("Deseja adicionar mais produtos? (1-Sim, 0-Não): ");
            opcaoProduto = tec.nextInt();
            tec.nextLine();

        } while (opcaoProduto == 1);


        Pedido novoPedido = new Pedido(pedidos.size() + 1, produtosPedido, usuarioAtual, STATUS.PENDENTE);


        pedidos.add(novoPedido);

        System.out.println("Pedido registrado com sucesso!");
    }



    private void escolherUsuario(){
        System.out.println("Escolher Usuário:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getId() + "," + usuario.getNome());
        }
        System.out.println("Digite o ID do usuário desejado:");
        int idEscolhido = tec.nextInt();

        for (Usuario usuario : usuarios) {
            if(usuario.getId() == idEscolhido) {
                usuarioAtual = usuario;
                System.out.println("Usuário" + usuarioAtual.getNome() + "Escolhido!");
                return;
            }else {
                System.out.println("Usuário não Encontrado!");
            }
        }
    }
}
