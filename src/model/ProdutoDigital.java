package model;

public class ProdutoDigital extends Produto{
        private String formato;
        private double tamanhoArquivo;

        public ProdutoDigital(String codigo, String nome, String descricao, double preco, int quantidadeEmEstoque, String formato, double tamanhoArquivo) {
            super(codigo, nome, descricao, preco, quantidadeEmEstoque);
            this.formato = formato;
            this.tamanhoArquivo = tamanhoArquivo;
        }

        public String getFormato() {
            return formato;
        }

        public void setFormato(String formato) {
            this.formato = formato;
        }

        public double getTamanhoArquivo() {
            return tamanhoArquivo;
        }

        public void setTamanhoArquivo(double tamanhoArquivo) {
            this.tamanhoArquivo = tamanhoArquivo;
        }

        @Override
        public void exibirInformacoes() {
            super.exibirInformacoes();
            System.out.println("Formato: " + formato);
            System.out.println("Tamanho do arquivo: " + tamanhoArquivo + " MB");
        }
    }
