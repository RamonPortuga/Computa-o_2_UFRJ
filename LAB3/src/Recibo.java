import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Recibo {

    private float valorTotalDaCompra;
    private int quantidadeComprada;
    private Usuario usuario;
    private Produto produto;

    // captura do SO o separador decimal utilizado
    private static DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
    private static DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
    private static char sep = symbols.getDecimalSeparator();

    public Recibo (Produto produto, int quantidadeComprada, Usuario usuario){
        float valorTotalDaCompra = produto.getPrecoEmReais() * quantidadeComprada;
        this.valorTotalDaCompra = valorTotalDaCompra;
        this.produto = produto;
        this.quantidadeComprada = quantidadeComprada;
        this.usuario = usuario;
        produto.setQuantidadeEmEstoque(-quantidadeComprada);
    }

    public float getValorTotalDaCompra() {
        return this.valorTotalDaCompra;
    }

    public int getQuantidadeComprada(){
        return this.quantidadeComprada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Produto getProduto(){
        return produto;
    }

    @Override
    public String toString() {
        int valorInteiroDaCompra = (int)(this.valorTotalDaCompra);
        int valorDecimalDaCompra = (int)(this.valorTotalDaCompra - valorInteiroDaCompra);
        return "Recibo no valor de R$" + valorInteiroDaCompra + sep + valorDecimalDaCompra
                + "0 para "+ usuario.getNome() + " referente à compra de " + this.quantidadeComprada
                + " unidades de Livro: " + produto.getDescricao();
    }
}
