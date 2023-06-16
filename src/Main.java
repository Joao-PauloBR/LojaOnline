import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ProdutoNaoEncontradoException {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();
        Carrinho carrinho = new Carrinho();

        int opcao;
        do {
            System.out.println("=== MENU ===");
            System.out.println("1. Adicionar produto ao catálogo");
            System.out.println("2. Exibir informações de um produto");
            System.out.println("3. Adicionar produto ao carrinho");
            System.out.println("4. Remover produto do carrinho");
            System.out.println("5. Calcular valor total do carrinho");
            System.out.println("6. Processar pedido");
            System.out.println("7. Gerar relatório de produtos disponíveis");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    // Adicionar produto ao catálogo
                    System.out.print("Digite o código do produto: ");
                    String codigo = scanner.nextLine();

                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite a descrição do produto: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Digite o preço do produto: ");
                    double preco = Double.parseDouble(scanner.nextLine());

                    System.out.print("Digite a quantidade em estoque do produto: ");
                    int quantidadeEmEstoque = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer de entrada

                    System.out.println("O produto é digital (D) ou físico (F)?");
                    String tipoProduto = scanner.nextLine();

                    Produto produto;
                    if (tipoProduto.equalsIgnoreCase("D")) {
                        System.out.print("Digite o formato do produto digital: ");
                        String formato = scanner.nextLine();
                        System.out.print("Digite o tamanho do arquivo do produto digital: ");
                        double tamanhoArquivo = scanner.nextDouble();

                        produto = new ProdutoDigital(codigo, nome, descricao, preco, quantidadeEmEstoque, formato, tamanhoArquivo);
                    } else if (tipoProduto.equalsIgnoreCase("F")) {
                        System.out.print("Digite o peso do produto físico: ");
                        double peso = scanner.nextDouble();
                        scanner.nextLine(); // Limpar o buffer de entrada

                        System.out.print("Digite as dimensões do produto físico: ");
                        String dimensoes = scanner.nextLine();

                        produto = new ProdutoFisico(codigo, nome, descricao, preco, quantidadeEmEstoque, peso, dimensoes);
                    } else {
                        System.out.println("Tipo de produto inválido.");
                        continue;
                    }

                    loja.adicionarProduto(produto);
                    break;
                case 2:
                    // Exibir informações de um produto
                    System.out.print("Digite o código do produto: ");
                    codigo = scanner.nextLine();
                    try {
                        loja.exibirInformacoesProduto(codigo);
                    } catch (ProdutoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    // Adicionar produto ao carrinho
                    System.out.print("Digite o código do produto: ");
                    codigo = scanner.nextLine();
                    try {
                        produto = buscarProduto(loja, codigo);
                        carrinho.adicionarProduto(produto);
                    } catch (ProdutoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    // Remover produto do carrinho
                    System.out.print("Digite o código do produto: ");
                    codigo = scanner.nextLine();
                    try {
                        produto = buscarProduto(carrinho, codigo);
                        carrinho.removerProduto(produto);
                    } catch (ProdutoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    // Calcular valor total do carrinho
                    double valorTotal = carrinho.calcularValorTotal();
                    System.out.println("Valor total do carrinho: R$" + valorTotal);
                    break;
                case 6:
                    // Processar pedido
                    System.out.print("Digite o código do produto: ");
                    codigo = scanner.nextLine();
                    try {
                        loja.processarPedido(codigo);
                    } catch (ProdutoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    // Gerar relatório de produtos disponíveis
                    loja.gerarRelatorio();
                    break;
                case 0:
                    // Sair
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            System.out.println();
        } while (opcao != 0);
    }

    private static Produto buscarProduto(Loja loja, String codigo) throws ProdutoNaoEncontradoException {
        for (Produto produto : loja.getCatalogo()) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        throw new ProdutoNaoEncontradoException("Produto não encontrado na loja.");
    }

    private static Produto buscarProduto(Carrinho carrinho, String codigo) throws ProdutoNaoEncontradoException {
        for (Produto produto : carrinho.getProdutos()) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        throw new ProdutoNaoEncontradoException("Produto não encontrado no carrinho.");
    }
}
