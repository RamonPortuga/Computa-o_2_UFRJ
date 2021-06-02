/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */

public class TamanhoZeroException extends Exception {
    public TamanhoZeroException(String message) {
        super(message);
    }
    public TamanhoZeroException() {
        super("Tamanho do Tuite Igual a Zero");
    }
}
