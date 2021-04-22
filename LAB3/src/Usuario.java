/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */
public class Usuario {

    private String nome;
    private long cpf;
    private String endereco;

    public Usuario(String nome, long cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public String getNome(){
        return this.nome;
    }

}