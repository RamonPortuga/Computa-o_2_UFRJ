public class TamanhoMaximoExcedidoException extends Exception {
    private int tamanhoTexto;

    public TamanhoMaximoExcedidoException(String message) {
        super(message);
    }

    public TamanhoMaximoExcedidoException(){
        super("Tamanho máximo do Tuite foi excedido.");
    }

    public TamanhoMaximoExcedidoException(int tamanhoTexto){
        super("Tamanho máximo do Tuite de " + tamanhoTexto + " caracteres foi excedida.");
        this.tamanhoTexto = tamanhoTexto;
    }

    public int getTamanhoTexto() {
        return tamanhoTexto;
    }
}
