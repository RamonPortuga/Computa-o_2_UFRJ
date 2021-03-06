/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */
public class Produto {

    private int quantidadeEmEstoque;
    private String descricao;
    private String urlDaImagem;
    private float preco;
    private int pesoEmGramas;


    public Produto(String descricao, String urlDaImagem) {
       this.descricao = descricao;
       this.urlDaImagem = urlDaImagem;
    }

    /**
     * @return uma descrição textual do produto
     */
    public String getDescricao() {
        return this.descricao;
    }

    public int getPesoEmGramas() {
        return this.pesoEmGramas;
    }

    public Dimensoes getDimensoes() {
        return null;
    }

    public float getPrecoEmReais() {
        return this.preco;
    }

    public void setPrecoEmReais(float preco) {
        this.preco = preco;
    }

    public String getUrlDaImagem() {
        return this.urlDaImagem;
    }

    public int getQuantidadeEmEstoque(){
        return this.quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque){
        this.quantidadeEmEstoque += quantidadeEmEstoque;
    }
}
