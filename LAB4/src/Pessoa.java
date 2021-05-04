/*4) Crie uma classe Pessoa com atributos nome e ano de nascimento.*/

public class Pessoa {
    private String nome;
    private int anoDeNascimento;

    public Pessoa (String nome, int anoDeNascimento){
        this.nome = nome;
        this.anoDeNascimento = anoDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeNascimento() {
        return anoDeNascimento;
    }
}
