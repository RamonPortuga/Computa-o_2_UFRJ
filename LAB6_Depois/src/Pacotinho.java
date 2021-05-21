/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pacotinho <T extends Colecionavel>{

    private List<T> colecionaveis;

    public Pacotinho(Repositorio repo, int[] posicoesDesejadas) {
        colecionaveis = new ArrayList<T>();
        for( Integer posicao : posicoesDesejadas ){
            colecionaveis.add((T) repo.getColecionavel(posicao));
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

        Integer tamanho = repo.getTotalColecionavel();
        colecionaveis = new ArrayList<T>();
        Random rand = new Random();
        int n;
        for(int i = 0; i < quantFigurinhas; i++ ){
            n = rand.nextInt(tamanho-1) + 1;
            colecionaveis.add((T) repo.getColecionavel(n));
        }
    }

    public Colecionavel[] getColecionaveis() {
        Colecionavel[] colecionavelArray = new Colecionavel[colecionaveis.size()];
        colecionaveis.toArray(colecionavelArray);
        return colecionaveis.toArray(colecionavelArray);
    }
}