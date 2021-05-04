/*6) Crie uma classe Professor, herdando de Pessoa e acrescentando anoContratacao.*/

public class Professor extends Pessoa{

    private String nome;
    private int anoDeNascimento;
    private int anoContratacao;

    public Professor (String nome, int anoDeNascimento, int anoContratacao){
        super (nome, anoDeNascimento);
        this.anoContratacao = anoContratacao;
    }

    public int getAnoContratacao(){
        return anoContratacao;
    }
}
