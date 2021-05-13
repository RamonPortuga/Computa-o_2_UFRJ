import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutroProjeto {
    public static void encontrarPar(List<Integer> lista, int k){
        boolean achou = false;
        Collections.sort(lista);
        for (int i = 0; i < lista.size(); i++){
            int numeroProcurado = k - lista.get(i);
            if(lista.indexOf(numeroProcurado) >= 0){
                System.out.println(lista.get(i) + "\t" + numeroProcurado);
                achou = true;
                break;
            }
        }
        if(!achou){
            System.out.println("Não existe Par referente ao número dado");
        }
    }
    public static void encontrarCaracterMaisFrequente(String string){
        int tam = string.length() - 1;
        int maiorOcorrencia = 0;
        char caracterComMaiorOcorrencia = 0;
        int i = 0;
        while (tam != 0 && string != ""){
            char caracter = string.charAt(i);
            tam = string.length() - string.replaceAll(String.valueOf(caracter), "").length();
            if (tam > maiorOcorrencia){
                maiorOcorrencia = tam;
                caracterComMaiorOcorrencia = caracter;
            }
            string = string.replaceAll(String.valueOf(caracter), "");
        }
        System.out.printf("%c\t%d\n", caracterComMaiorOcorrencia, maiorOcorrencia);
    }

    public static void main (String [] args){
        String string = "arara";
        System.out.println("Teste de encontrarCaracterMaisFrequente na palavra: " + string);
        encontrarCaracterMaisFrequente (string);

        int k = 34;
        System.out.println("\nTeste de encontrarPar com k igual a: " + k);
        List <Integer> lista = new ArrayList <Integer>();
        lista.add(1);
        lista.add(5);
        lista.add(-10);
        lista.add(56);
        lista.add(44);
        lista.add(12);
        lista.add(18);
        encontrarPar(lista, k);
    }
}
