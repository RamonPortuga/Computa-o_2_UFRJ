/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */

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
        T[] colecionaveisDoPacotinho = (T[]) pacotinho.getColecionaveis();
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
        return this.repositorio.getTotalColecionavel();
    }

    public int getQuantItensColados() {
        return this.quantColecionaveisColados;
    }

    public int getQuantItensFaltantes() {
        return getTamanho() - getQuantItensColados();
    }

    public void autoCompletar() {
        if(quantColecionaveisColados == 0)
            return;

        for (int i = 1; i < colecionaveisColados.size(); i++) {
            if(colecionaveisColados.get(i) == null) {
                colecionaveisColados.set(i, (T) repositorio.getColecionavel(i));
                quantColecionaveisColados++;
            }
        }
    }

    private Image getImagem(int posicao) {
        return possuiItemColado(posicao)
                ? this.getItemColado(posicao).getImagem()
                : IMAGEM_PADRAO_PARA_POSICAO_VAZIA;
    }
}