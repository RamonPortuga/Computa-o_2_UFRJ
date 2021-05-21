/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */

import java.util.ArrayList;
import java.util.List;

public class Repositorio <T extends Colecionavel> {

    private static final String PREFIXO_URL_IMAGENS = "http://www.nossoalbum.com.br/imagens/";

    private List<T> todosOsColecionaveis;

    public Repositorio(String sufixoUrlImagens, int quantColecionaveis, Figurinha fig) {
        todosOsColecionaveis = new ArrayList<>(quantColecionaveis);
        for (int i = 1; i <= quantColecionaveis; i++) {
            fig = new Figurinha(i, PREFIXO_URL_IMAGENS + sufixoUrlImagens);
            todosOsColecionaveis.add((T) fig);
        }
    }

    public Repositorio(String sufixoUrlImagens, int quantColecionaveis, Selo selo) {
        todosOsColecionaveis = new ArrayList<>(quantColecionaveis);
        for (int i = 1; i <= quantColecionaveis; i++) {
            selo = new Selo(i, PREFIXO_URL_IMAGENS + sufixoUrlImagens);
            todosOsColecionaveis.add((T) selo);
        }
    }

    public int getTotalColecionavel() {
        return this.todosOsColecionaveis.size();
    }

    public Colecionavel getColecionavel(int pos){
        if(todosOsColecionaveis.size() + 1 <= pos || pos <= 0)
            throw new ArrayIndexOutOfBoundsException("Informe uma posição valida.");
        return todosOsColecionaveis.get(pos - 1);
    }
}
