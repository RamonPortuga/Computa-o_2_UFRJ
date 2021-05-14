/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */
import java.util.ArrayList;
import java.util.List;

public class CalculadorIntersecaoIngenuo implements CalculadorIntersecao {

    @Override
    public List<Usuario> obterIntersecao(List<Usuario> lista1, List<Usuario> lista2) {

        List<Usuario> intersecao = new ArrayList<>();

        // para cada elemento da primeira lista, percorra a segunda lista até encontrá-lo (ou não)
        for (int i = 0; i < lista1.size(); i++){
            for (int j = 0; j < lista2.size(); j++) {
                if(lista1.get(i).compareTo(lista2.get(j)) == 0){
                    intersecao.add(lista1.get(i));
                }
            }
        }
        return intersecao;
    }
}
