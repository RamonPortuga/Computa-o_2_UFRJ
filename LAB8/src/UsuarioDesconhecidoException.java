/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */

public class UsuarioDesconhecidoException extends Exception {
    public UsuarioDesconhecidoException(String message) {
        super(message);
    }
    public UsuarioDesconhecidoException() {
        super("O Usuário não está cadastrado na plataforma");
    }
}
