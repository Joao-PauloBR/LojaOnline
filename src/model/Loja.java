package model;
import java.util.ArrayList;
import java.util.List;

public class Loja {
        private List<Produto> catalogo;

        public Loja() {
            catalogo = new ArrayList<>();
        }

        public List<Produto> getCatalogo(){
            return catalogo;
        }

        public void adicionarProduto(Produto produto) {
            catalogo.add(produto);
            System.out.println("Produto adicionado ao catálogo.");
        }

        public void exibirInformacoesProduto(String codigo) throws ProdutoNaoEncontradoException {
            for (Produto produto : catalogo) {
                if (produto.getCodigo().equals(codigo)) {
                    produto.exibirInformacoes();
                    return;
                }
            }
            throw new ProdutoNaoEncontradoException("Produto não encontrado na loja.");
        }

        public void processarPedido(String codigo) throws ProdutoNaoEncontradoException {
            for (Produto produto : catalogo) {
                if (produto.getCodigo().equals(codigo)) {
                    if (produto.getQuantidadeEmEstoque() > 0) {
                        produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - 1);
                        System.out.println("Pedido processado. Estoque atualizado.");
                        return;
                    } else {
                        throw new ProdutoNaoEncontradoException("Produto sem estoque.");
                    }
                }
            }
            throw new ProdutoNaoEncontradoException("Produto não encontrado na loja.");
        }

        public void gerarRelatorio() {
            System.out.println("Produtos disponíveis:");
            for (Produto produto : catalogo) {
                produto.exibirInformacoes();
                System.out.println("----------------------------");
            }
        }
    }
