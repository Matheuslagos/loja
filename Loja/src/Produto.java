public class Produto {
    private static int count = 1;

    private int id;
    private String nome;
    private Double preco;
    private String descricao;

    public Produto(String nome, Double preco, String descricao) {
        this.id = count;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        Produto.count += 1;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String toString() {
        return "Id: " + this.getId() +
                "\nNome: " + this.getNome() +
                "\nDescriçao: " + this.getDescricao() +
                "\nPreço: " + Utils.doubleToString(this.getPreco());

    }

}
