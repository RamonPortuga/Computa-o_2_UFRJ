public class TamanhoZeroException extends Exception {
    public TamanhoZeroException(String message) {
        super(message);
    }
    public TamanhoZeroException() {
        super("Tamanho do Tuite Igual a Zero");
    }
}
