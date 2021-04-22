/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */
public class Brinquedo extends Produto {

    private String marca;
    private String descricao;
    private int idadeMinimaRecomendada;

    public Brinquedo(String descricao) {
        super(descricao, "");
    }

    public String getMarca() {
        return this.marca;
    }

    public int getIdadeMinimaRecomendada() {
        return this.idadeMinimaRecomendada;
    }
}
