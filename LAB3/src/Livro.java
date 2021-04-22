/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */
public class Livro extends Produto {

    private String trechoEmDestaque;
    private String autor;
    private String nome;
    private String editora;
    private int anoDePublicacao;
    private int numeroDePaginas;

    public Livro(String nome, String editora) {
        super(nome, "");
        this.nome = nome;
        this.editora = editora;
    }

    private int numeroDePaginas() {
        return this.numeroDePaginas;
    }

    public String getTrechoEmDestaque() {
        return this.trechoEmDestaque;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getAnoDePublicacao() {
        return this.anoDePublicacao;
    }
}
