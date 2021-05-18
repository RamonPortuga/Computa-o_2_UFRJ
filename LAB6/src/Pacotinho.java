import java.util.Random;

public class Pacotinho {

    private static final String PREFIXO_URL_IMAGENS = "http://www.nossoalbum.com.br/imagens/";

    private Figurinha [] figurinhas;

    public Pacotinho(Repositorio repo, int[] posicoesDesejadas) {
        figurinhas = new Figurinha[posicoesDesejadas.length];
        for (int i = 0; i < posicoesDesejadas.length; i++){
            figurinhas[i] = new Figurinha(posicoesDesejadas[i],
                    PREFIXO_URL_IMAGENS + posicoesDesejadas[i]);
        }
    }

    /**
     * Produz um pacotinho com quantFigurinhas sorteadas aleatoriamente
     * dentre aqueles presentes no repositório informado.
     *
     * @param repo o repositório desejado
     * @param quantFigurinhas a quantidade de figurinhas a constar no pacotinho
     */
    public Pacotinho(Repositorio repo, int quantFigurinhas) {
        //quantFigurinhas = repo.getTotalFigurinhas();
        Random gerador = new Random();

        figurinhas = new Figurinha[quantFigurinhas];

        for (int i = 0; i < quantFigurinhas; i++){
            int posicaoGerada = gerador.nextInt(quantFigurinhas);
            figurinhas[i] = new Figurinha(posicaoGerada, PREFIXO_URL_IMAGENS + i);
        }
    }

    public Figurinha[] getFigurinhas() {
        return figurinhas;
    }
}
