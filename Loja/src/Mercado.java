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
        menu();
    }

    private static void menu() {
        System.out.println("----------------------------------------");
        System.out.println("---------------LOJA---------------------");
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
                case2: listarProdutos();
                break;
                case3: comprarProduto();
                break;
                case4: verCarrinho();
                break;
                case5: System.out.println("volte sempre");
                System.exit(option);
            default:
                System.out.println("invalido");
                menu();
                break;

        }
    }

    private static void cadastrarProdutos() {
        System.out.println("Nome do produto");
        String nome = input.next();

        System.out.println("PREÇO");
        double preco = input.nextDouble();

        Produto produto = new Produto(nome, preco);
        produtos.add(produto);

        System.out.println(produto.getNome() + "cadastrado com sucesso");
        menu();

    }

    private static void listarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("Lista de produtos\n");
            for (Produto p : produtos) {
                System.out.println("p");
            }
        } else {
            System.out.println("Nenhum produto cadastrado");
        }
        menu();
    }

}
