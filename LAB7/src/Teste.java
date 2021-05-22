import java.util.*;

public class Teste {
    public static void main (String [] args){
        String[] palavras = new String[] { "João", "Augusto", "Joaquim", "Maria" };
        //Set<String> set = new HashSet<String>(Arrays.asList(palavras));
        Set<String> set = new HashSet<String>();
        // OU (prefiro a opção acima...economiza linha de código)
        //set.addAll (Arrays.asList(palavras));
        List arrayList = new ArrayList<>();
        arrayList.add("João");
        arrayList.add("Augusto");
        set.addAll(arrayList);
        System.out.println(set);
    }
}
