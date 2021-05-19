import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Album <T extends Colecionavel> {

    public static final int PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR = 90;

    public static final Image IMAGEM_PADRAO_PARA_POSICAO_VAZIA = null;

    private final Repositorio repositorio;
    private final int quantColecionaveisPorPacotinho;

    private List<T> colecionaveisColados;  // direct addressing
    private int quantColecionaveisColados;

    private Map<Integer, Integer> contRepetidasByPosicao;

    public Album(Repositorio repositorio, int quantItensPorPacotinho) {
        this.repositorio = repositorio;
        this.quantColecionaveisPorPacotinho = quantItensPorPacotinho;

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
        T[] colecionaveisDoPacotinho = (T[]) pacotinho.getFigurinhas();
        if (colecionaveisDoPacotinho.length != this.quantColecionaveisPorPacotinho) {
            return;
        }

        for (int i = 0; i < colecionaveisDoPacotinho.length; i++) {
            final int posicao = colecionaveisDoPacotinho[i].getPosicao();
            if (possuiItemColado(posicao)) {
                int contRepetidas = this.contRepetidasByPosicao.getOrDefault(posicao, 0);
                this.contRepetidasByPosicao.put(posicao, contRepetidas + 1);

            } else {
                this.colecionaveisColados.set(posicao, colecionaveisDoPacotinho[i]);
                this.quantColecionaveisColados++;
            }
        }
    }

    /*public void receberNovoPacotinho(Pacotinho pacotinho) {
        T colecionaveisDoPacotinho[] = (T[]) pacotinho.getFigurinhas();
        if (colecionaveisDoPacotinho.length != this.quantItensPorPacotinho) {
            return;  // melhor ainda: lançaria uma checked exception
        }

        for (int i =0; i<colecionaveisDoPacotinho.length; i++ ) {
            final int posicao = colecionaveisDoPacotinho[i].getPosicao();
            if (possuiItemColado(posicao)) {
                // adiciona como repetida

                // jeito pior
//                Integer contRepetidas = this.contRepetidasByPosicao.get(posicao);
//                this.contRepetidasByPosicao.put(
//                        posicao, contRepetidas == null ? 1 : contRepetidas + 1);

                // jeito mais elegante: getOrDefault
                int contRepetidas = this.contRepetidasByPosicao.getOrDefault(posicao, 0);
                this.contRepetidasByPosicao.put(posicao, contRepetidas + 1);

            } else {
                // item inédito
                this.colecionaveisColados.set(posicao, colecionaveisDoPacotinho[i]);
                this.quantColecionaveisColadas++;
            }
        }
    }*/

    /*public Figurinha getItemColado(int posicao) {
        //Obs: For Reach é melhor para percorrer, mas por algum motivo,
        //for não funciona. Na dúvida, melhor ir no certo
        for (T colecionavel: colecionaveisColados){
            if (colecionavel != null){
                if (colecionavel.getPosicao() == posicao){
                    return colecionavel;
                }
            }
        }
        return null;*/
        /*for (int i = 0; i < colecionaveisColados.size(); i++){
            if (colecionaveisColados.get(i) != null){
                if (colecionaveisColados.get(i).getPosicao() == posicao){
                    return (Colecionavel) colecionaveisColados.get(i);
                }
            }
        }
        return null;
    }*/

    //Pq raios esse agora funcionou e o outro não?
    public T getItemColado (int posicao) {
        for(T colecionavel : colecionaveisColados){
            if(colecionavel != null) {
                if (colecionavel.getPosicao() == posicao) {
                    return colecionavel;
                }
            }
        }
        return null;
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

    /*public void autoCompletar() {
        if(quantColecionaveisColados == 0)
            return;

        for (int i = 1; i < colecionaveisColados.size(); i++) {
            if(colecionaveisColados.get(i) == null) {
                colecionaveisColados.set(i, repositorio.getFigurinha(i));
                quantColecionaveisColados++;
            }
        }
    }*/

    /*public void autoCompletar() {
        if((getQuantItensColados()*100/getTamanho()>=PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR)){
            for(int i=1; i<getTamanho(); i++){
                if(colecionaveisColados.get(i)==null) {
                    if(colecionaveisColados instanceof  Figurinha)
                        colecionaveisColados.set(i,(T)new Figurinha(i, ""));
                   /* if(colecionaveisColados instanceof  Selo) {
                        Random r= new Random();
                        colecionaveisColados.set(i, (T)new Selo(i,"g", "Brasil", r.nextFloat()));
                    }*/

                    /*this.quantColecionaveisColados++;
                    System.out.println(i);
                }
            }

        }
    }*/

    private Image getImagem(int posicao) {
        return possuiItemColado(posicao)
                ? this.getItemColado(posicao).getImagem()
                : IMAGEM_PADRAO_PARA_POSICAO_VAZIA;
    }
}