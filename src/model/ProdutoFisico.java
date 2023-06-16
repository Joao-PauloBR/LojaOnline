package model;

public class ProdutoFisico extends Produto{
        private double peso;
        private String dimensoes;

        public ProdutoFisico(String codigo, String nome, String descricao, double preco, int quantidadeEmEstoque, double peso, String dimensoes) {
            super(codigo, nome, descricao, preco, quantidadeEmEstoque);
            this.peso = peso;
            this.dimensoes = dimensoes;
        }

        public double getPeso() {
            return peso;
        }

        public void setPeso(double peso) {
            this.peso = peso;
        }

        public String getDimensoes() {
            return dimensoes;
        }

        public void setDimensoes(String dimensoes) {
            this.dimensoes = dimensoes;
        }

        @Override
        public void exibirInformacoes() {
            super.exibirInformacoes();
            System.out.println("Peso: " + peso + " kg");
            System.out.println("Dimensões: " + dimensoes);
        }
    }
