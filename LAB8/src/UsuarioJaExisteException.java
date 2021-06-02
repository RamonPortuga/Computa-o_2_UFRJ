/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */

public class UsuarioJaExisteException extends Exception {
    public UsuarioJaExisteException(String usuario){
        super("O usuário " + usuario + " já está cadastrado no TuiterLite.");
    }

    public UsuarioJaExisteException(){
        super("Este usuário já está cadastrado no TuiterLite.");
    }
}
