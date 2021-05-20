import java.awt.*;

public class Selo implements Colecionavel{

    private String pais;
    private float valorNominal;
    private final Image imagem;
    private final int posicao;

    public Selo(int posica, String urlDaImagem) {
        this.imagem = obterImagem(urlDaImagem);
        this.posicao = posica;
        this.pais = pais;
        this.valorNominal = valorNominal;

    }

    private Image obterImagem(String url) {
        // ToDo baixaria da Internet...
        return null;
    }

    @Override
    public Image getImagem() {
        return null;
    }

    @Override
    public int getPosicao() {
        return 0;
    }

    public float getValorNominal(){
        return this.valorNominal;
    }
    public String getPais(){
        return this.pais;
    }
}
