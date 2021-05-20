import java.util.ArrayList;
import java.util.List;

public class Repositorio <T extends Colecionavel> {

    private static final String PREFIXO_URL_IMAGENS = "http://www.nossoalbum.com.br/imagens/";

    private List<T> todosOsColecionaveis;

    public Repositorio(String sufixoUrlImagens, int quantColecinaveis) {
        todosOsColecionaveis = new ArrayList<>(quantColecinaveis);
        for (int i = 1; i <= quantColecinaveis; i++) {
            Colecionavel fig = new Figurinha(i, PREFIXO_URL_IMAGENS + sufixoUrlImagens);
            todosOsColecionaveis.add((T) fig);
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
