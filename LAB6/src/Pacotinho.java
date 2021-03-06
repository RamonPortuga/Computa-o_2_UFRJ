/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pacotinho {

    private List<Figurinha> figurinhas;

    public Pacotinho(Repositorio repo, int[] posicoesDesejadas) {
        figurinhas = new ArrayList<Figurinha>();
        for( Integer posicao : posicoesDesejadas ){
            figurinhas.add(repo.getFigurinha(posicao));
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

        Integer tamanho = repo.getTotalFigurinhas();
        figurinhas = new ArrayList<Figurinha>();
        Random rand = new Random();
        int n;
        for(int i = 0; i < quantFigurinhas; i++ ){
            n = rand.nextInt(tamanho-1) + 1;
            figurinhas.add(repo.getFigurinha(n));
        }
    }

    public Figurinha[] getFigurinhas() {
        Figurinha[] figurinhasArray = new Figurinha[figurinhas.size()];
        figurinhas.toArray(figurinhasArray);
        return figurinhas.toArray(figurinhasArray);
    }
}