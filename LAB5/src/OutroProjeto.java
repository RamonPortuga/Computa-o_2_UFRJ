import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutroProjeto {
    public static void encontrarPar(List<Integer> lista, int k){
        Collections.sort(lista);
        for (int i = 0; i < lista.size(); i++){
            int numeroProcurado = k - lista.get(i);
            if(lista.indexOf(numeroProcurado) >= 0){
                System.out.println(lista.get(i) + "\t" + numeroProcurado);
                break;
            }
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
        System.out.println("Teste de encontrarCaracterMaisFrequente:");
        String string = "arara";
        encontrarCaracterMaisFrequente (string);
        System.out.println("\nTeste de encontrarPar:");
        List <Integer> lista = new ArrayList <Integer>();
        lista.add(1);
        lista.add(5);
        lista.add(-10);
        lista.add(56);
        lista.add(44);
        lista.add(12);
        lista.add(18);
        encontrarPar(lista,34);
    }
}
