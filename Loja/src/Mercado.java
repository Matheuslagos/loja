import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mercado {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho;

    public static void main(String[] args) {
        produtos = new ArrayList<>();
        carrinho = new HashMap<>();
        String username, password;

        System.out.println("Cadastro");
        System.out.print("Insira o nome de usuário: ");
        username = input.nextLine();
        System.out.print("Insira a senha: ");
        password = input.nextLine();

        while (true) {
            System.out.println("\nLogin");
            System.out.print("Insira o nome de usuário: ");
            String loginUsername = input.nextLine();
            System.out.print("Insira a senha: ");
            String loginPassword = input.nextLine();
            if (username.equals(loginUsername) && password.equals(loginPassword)) {
                System.out.println("\nBem-vindo ao menu do programa");
                menu();
                break;
            } else {
                System.out.println("\nNome de usuário ou senha inválidos. Tente novamente.");
            }
        }
        menu();

    }

    private static void menu() {
        System.out.println("----------------------------------------");
        System.out.println("------------------LOJA------------------");
        System.out.println("---------SELECIONE UMA OPCAO------------");
        System.out.println("---------------1-CADASTRAR--------------");
        System.out.println("---------------2-LISTAR-----------------");
        System.out.println("---------------3-COMPRAR----------------");
        System.out.println("---------------4-CARRINHO---------------");
        System.out.println("---------------5-SAIR-------------------");
        int option = input.nextInt();
        switch (option) {
            case 1:
                cadastrarProdutos();
                break;
            case 2:
                listarProdutos();
                break;
            case 3:
                comprarProduto();
                break;
            case 4:
                verCarrinho();
                break;
            case 5:
                System.out.println("volte sempre");
                System.exit(0);
            default:
                System.out.println("invalido");
                menu();
                break;

        }
    }

    private static void cadastrarProdutos() {
        System.out.println("Nome do produto ");
        String nome = input.next();

        System.out.println("Preço");
        Double preco = input.nextDouble();

        System.out.printf("Descricao do produto \n");
        String descricao = input.nextLine();
        descricao = input.nextLine();

        Produto produto = new Produto(nome, preco, descricao);
        produtos.add(produto);

        System.out.println(produto.getNome() + " cadastrado(a) com sucesso");
        menu();

    }

    private static void listarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("Lista de produtos\n");
            for (Produto p : produtos) {
                System.out.println(p);
            }
        } else {
            System.out.println("Nenhum produto cadastrado");
        }
        menu();
    }

    private static void comprarProduto() {
        if (produtos.size() > 0) {
            System.out.println("Codigo do produto: \n");

            System.out.println("--------produtos disponiveis------DIGITE O ID PARA COMPRAR--\n");
            for (Produto p : produtos) {
                System.out.println(p + "\n");
            }
            int id = Integer.parseInt(input.next());
            boolean isPresent = false;

            for (Produto p : produtos) {
                if (p.getId() == id) {
                    int qtd = 0;
                    try {
                        qtd = carrinho.get(p);
                        carrinho.put(p, qtd + 1);
                    } catch (NullPointerException e) {
                        carrinho.put(p, 1);
                    }
                    System.out.println(p.getNome() + " adicionado ao carrinho.");
                    isPresent = true;

                    if (isPresent) {
                        System.out.println("deseja adicionar outro produto ao carrinho?");
                        System.out.println("digite 1 para sim, 0 para finalizar a compra.\n");
                        int option = Integer.parseInt(input.next());

                        if (option == 1) {
                            comprarProduto();

                        } else {
                            finalizarCompra();
                        }
                    }
                } else {
                    System.out.println("Produto nao encontrado");
                    menu();
                }
            }
        } else {
            System.out.println("Produto nao encontrado");
            menu();
        }
    }

    private static void verCarrinho() {
        System.out.println("---Produto no seu carrinho!---");
        if (carrinho.size() > 0) {
            for (Produto p : carrinho.keySet()) {
                System.out.println("Produto: " + p + "\nQuantidade: " + carrinho.get(p));
            }
        } else {
            System.out.println("carrinho vazio!");
        }
        menu();
    }

    private static void finalizarCompra() {
        Double valorDaCompra = 0.0;
        System.out.println("Seus produtos!");
        for (Produto p : carrinho.keySet()) {
            int qtd = carrinho.get(p);
            valorDaCompra += p.getPreco() * qtd;
            System.out.println("Quantidade " + qtd);
            System.out.println("\n");
        }
        System.out.println("O valor da sua compra é: " + Utils.doubleToString(valorDaCompra));
        carrinho.clear();
        System.out.println("volte sempre!");
        menu();
    }

}
