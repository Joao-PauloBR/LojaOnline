package model;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {
        private List<Produto> produtos;

        public Carrinho() {
            produtos = new ArrayList<>();
        }

        public List<Produto> getProdutos() {
            return produtos;
        }

        public void adicionarProduto(Produto produto) {
            produtos.add(produto);
            System.out.println("Produto adicionado ao carrinho.");
        }

        public void removerProduto(Produto produto) {
            produtos.remove(produto);
            System.out.println("Produto removido do carrinho.");
        }

        public double calcularValorTotal() {
            double valorTotal = 0;
            for (Produto produto : produtos) {
                valorTotal += produto.getPreco();
            }
            return valorTotal;
        }
    }
