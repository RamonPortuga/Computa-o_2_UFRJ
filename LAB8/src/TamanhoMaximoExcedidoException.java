/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */

public class TamanhoMaximoExcedidoException extends Exception {
    private int tamanhoTexto;

    public TamanhoMaximoExcedidoException(String message) {
        super(message);
    }

    public TamanhoMaximoExcedidoException(){
        super("Tamanho máximo do Tuite foi excedido.");
    }

    public TamanhoMaximoExcedidoException(int tamanhoTexto){
        super("Tamanho máximo do Tuite de " + tamanhoTexto + " caracteres foi excedido.");
        this.tamanhoTexto = tamanhoTexto;
    }

    public int getTamanhoTexto() {
        return tamanhoTexto;
    }
}
