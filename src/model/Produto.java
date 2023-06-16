package model;

public abstract class Produto {
        private String codigo;
        private String nome;
        private String descricao;
        private double preco;
        private int quantidadeEmEstoque;

        public Produto(String codigo, String nome, String descricao, double preco, int quantidadeEmEstoque) {
            this.codigo = codigo;
            this.nome = nome;
            this.descricao = descricao;
            this.preco = preco;
            this.quantidadeEmEstoque = quantidadeEmEstoque;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }

        public int getQuantidadeEmEstoque() {
            return quantidadeEmEstoque;
        }

        public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
            this.quantidadeEmEstoque = quantidadeEmEstoque;
        }

        public void exibirInformacoes() {
            System.out.println("Código: " + codigo);
            System.out.println("Nome: " + nome);
            System.out.println("Descrição: " + descricao);
            System.out.println("Preço: R$" + preco);
            System.out.println("Quantidade em estoque: " + quantidadeEmEstoque);
        }
    }
