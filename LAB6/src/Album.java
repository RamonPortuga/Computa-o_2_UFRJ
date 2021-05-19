import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Album {

    public static final int PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR = 90;

    public static final Image IMAGEM_PADRAO_PARA_POSICAO_VAZIA = null;

    private final Repositorio repositorio;
    private final int quantItensPorPacotinho;

    private List<Figurinha> figurinhasColadas;  // direct addressing
    private int quantFigurinhasColadas;

    // poderíamos fazer novamente direct addressing para as repetidas,
    // mas vamos usar um HashMap aqui só para treinarmos
    private Map<Integer, Integer> contRepetidasByPosicao;

    public Album(Repositorio repositorio, int quantItensPorPacotinho) {
        this.repositorio = repositorio;
        this.quantItensPorPacotinho = quantItensPorPacotinho;

        int tamanhoFisicoDaLista = getTamanho() + 1;
        this.figurinhasColadas = new ArrayList<>(tamanhoFisicoDaLista);
        // inicializa as posições com nulls, para poder acessá-las diretamente
        for (int i = 0; i < tamanhoFisicoDaLista; i++) {
            this.figurinhasColadas.add(null);
        }
        this.quantFigurinhasColadas = 0;

        this.contRepetidasByPosicao = new HashMap<>();
    }

    public void receberNovoPacotinho(Pacotinho pacotinho) {
        Figurinha[] figurinhasDoPacotinho = pacotinho.getFigurinhas();
        if (figurinhasDoPacotinho.length != this.quantItensPorPacotinho) {
            return; // melhor ainda: lançaria uma checked exception
        }

        for (Figurinha fig : figurinhasDoPacotinho) {
            final int posicao = fig.getPosicao();
            if (possuiItemColado(posicao)) {
                int contRepetidas = this.contRepetidasByPosicao.getOrDefault(posicao, 0);
                this.contRepetidasByPosicao.put(posicao, contRepetidas + 1);

            } else {
                this.figurinhasColadas.set(posicao, fig);
                this.quantFigurinhasColadas++;
            }
        }
    }

    public Figurinha getItemColado(int posicao) {
        Figurinha figurinha = (Figurinha) this.figurinhasColadas.get(posicao);
        return figurinha;
    }

    public boolean possuiItemColado(int posicao) {
        if (posicao > getTamanho() || posicao < 0){
            return false;
        }
        if (this.figurinhasColadas.get(posicao) != null){
            return true;
        }
        return false;
    }

    public boolean possuiItemRepetido(int posicao) {
        int contRepetidas = 0;
        if (this.contRepetidasByPosicao.containsKey(posicao)){
            contRepetidas = contRepetidasByPosicao.get(posicao);
        }
        if (contRepetidas > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public int getTamanho() {
        return this.repositorio.getTotalFigurinhas();
    }

    public int getQuantItensColados() {
        return this.quantFigurinhasColadas;
    }

    public int getQuantItensFaltantes() {
        return getTamanho() - getQuantItensColados();
    }

    public void autoCompletar() {
        if(quantFigurinhasColadas == 0)
            return;

        for (int i = 1; i < figurinhasColadas.size(); i++) {
            if(figurinhasColadas.get(i) == null)
            {
                figurinhasColadas.set(i, repositorio.getFigurinha(i));
                quantFigurinhasColadas++;
            }
        }
    }

    private Image getImagem(int posicao) {
        return possuiItemColado(posicao)
                ? this.getItemColado(posicao).getImagem()
                : IMAGEM_PADRAO_PARA_POSICAO_VAZIA;
    }
}