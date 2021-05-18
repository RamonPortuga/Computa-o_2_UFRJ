import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Album <T extends Colecionavel>{

    public static final int PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR = 90;

    public static final Image IMAGEM_PADRAO_PARA_POSICAO_VAZIA = null;

    private final Repositorio repositorio;
    private final int quantItensPorPacotinho;

    private List<Figurinha> colecionaveisColados;  // direct addressing
    private int quantColecionaveisColados;

    private Map<Integer, Integer> contRepetidasByPosicao;

    public Album(Repositorio repositorio, int quantItensPorPacotinho) {
        this.repositorio = repositorio;
        this.quantItensPorPacotinho = quantItensPorPacotinho;

        int tamanhoFisicoDaLista = getTamanho() + 1;
        this.colecionaveisColados = new ArrayList<>(tamanhoFisicoDaLista);
        // inicializa as posições com nulls, para poder acessá-las diretamente
        for (int i = 0; i < tamanhoFisicoDaLista; i++) {
            this.colecionaveisColados.add(null);
        }
        this.quantColecionaveisColados = 0;

        this.contRepetidasByPosicao = new HashMap<>();
    }

    public void receberNovoPacotinho(Pacotinho pacotinho) {
        Figurinha[] figurinhasDoPacotinho = pacotinho.getFigurinhas();
        if (figurinhasDoPacotinho.length != this.quantItensPorPacotinho) {
            return;  // melhor ainda: lançaria uma checked exception
        }

        for (Figurinha fig : pacotinho.getFigurinhas()) {
            final int posicao = fig.getPosicao();
            if (possuiItemColado(posicao)) {
                int contRepetidas = this.contRepetidasByPosicao.getOrDefault(posicao, 0);
                this.contRepetidasByPosicao.put(posicao, contRepetidas + 1);

            } else {
                this.colecionaveisColados.set(posicao, fig);
                this.quantColecionaveisColados++;
            }
        }
    }

    public Figurinha getItemColado(int posicao) {
        Figurinha figurinha = (Figurinha) this.colecionaveisColados.get(posicao);
        return figurinha;
    }

    public boolean possuiItemColado(int posicao) {
        if (posicao > getTamanho() || posicao < 0){
            return false;
        }
        if (this.colecionaveisColados.get(posicao) != null){
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
        return this.quantColecionaveisColados;
    }

    public int getQuantItensFaltantes() {
        return getTamanho() - getQuantItensColados();
    }

    public void autoCompletar() {
        // ToDo IMPLEMENT ME!!!
        /*List<Figurinha> todasAsFigurinhas = new ArrayList<>();
        todasAsFigurinhas = this.repositorio.getTodasAsFigurinhas();
        if(this.colecionaveisColados.isEmpty() == true){

        }
        else{
        //if(this.colecionaveisColados.isEmpty() == true) {
            for (int i = 1; i < getTamanho(); i++){
                boolean aux = possuiItemColado(i);
                //System.out.println(aux);
                System.out.println(colecionaveisColados.get(i));
                if(this.colecionaveisColados.get(i) == null){
                    Figurinha fig = (Figurinha) todasAsFigurinhas.get(i);
                    this.colecionaveisColados.set(i, fig);
                    this.quantcolecionaveisColados++;
                    System.out.println("Ei");
                }
            }
        }*/
        /*List<Figurinha> todasAsFigurinhas = new ArrayList<>();
        todasAsFigurinhas = this.repositorio.getTodasAsFigurinhas();
        if (getQuantItensColados() == 0){
            System.out.println("Ei");
        }
        else{
            for (int i = 1; i < getTamanho(); i++){
                if(possuiItemColado(i) == false){
                    Figurinha fig = (Figurinha) todasAsFigurinhas.get(i);
                    this.colecionaveisColados.set(i, fig);
                    this.quantcolecionaveisColados++;
                }
                System.out.println("i: " + i);
            }
        }*/
    }

    private Image getImagem(int posicao) {
        return possuiItemColado(posicao)
                ? this.getItemColado(posicao).getImagem()
                : IMAGEM_PADRAO_PARA_POSICAO_VAZIA;
    }

}
