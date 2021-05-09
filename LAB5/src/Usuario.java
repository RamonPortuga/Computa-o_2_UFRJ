import java.util.List;

public class Usuario implements Comparable<Usuario> {

    private int id;

    private List<Usuario> amigos;

    private CalculadorIntersecao calculadorIntersecao;

    public Usuario(int id, CalculadorIntersecao calculador) {
        this.id = id;
        // instancia um calculador de interseção
        if(calculador instanceof CalculadorIntersecaoEsperto){
            calculadorIntersecao = new CalculadorIntersecaoEsperto();
        }
        else if (calculador instanceof CalculadorIntersecaoViaBuscaBinaria){
            calculadorIntersecao = new CalculadorIntersecaoViaBuscaBinaria();
        }
        else if (calculador instanceof CalculadorIntersecaoIngenuo){
            calculadorIntersecao = new CalculadorIntersecaoIngenuo();
        }
        /*if(calculador instanceof CalculadorIntersecaoEsperto){
            CalculadorIntersecaoEsperto esperto = new CalculadorIntersecaoEsperto();
        }
        else if (calculador instanceof CalculadorIntersecaoViaBuscaBinaria){
            CalculadorIntersecaoViaBuscaBinaria buscaBinaria = new CalculadorIntersecaoViaBuscaBinaria();
        }
        else if (calculador instanceof  CalculadorIntersecaoIngenuo){
            CalculadorIntersecaoIngenuo ingenuo = new CalculadorIntersecaoIngenuo();
        }*/
    }

    public int getId() {
        return id;
    }

    public List<Usuario> getAmigos() {
        return this.amigos;
    }

    public void setAmigos(List<Usuario> amigos){
        this.amigos = amigos;
    }

    /**
     * Retorna a quantidade de amigos em comum entre este Usuario e o
     * outro Usuario informado.
     *
     * @param outro outro Usuario da rede social
     * @return o tamanho da interseção dos conjuntos de amigos
     */
    public int obterQuantidadeDeAmigosEmComum(Usuario outro) {
        return calculadorIntersecao.obterIntersecao(amigos, outro.getAmigos()).size();
    }

    @Override
    public int compareTo(Usuario o) {
        return this.id - o.id;
    }
}
