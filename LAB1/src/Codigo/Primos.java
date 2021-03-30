/*
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * Ciências da Computação - 2° Período
 */

/*
 * Obs: Prezado Professor, coloquei apenas a chamada das funções
 * e comentei as linhas que possibilitam printar os resultados.
 * Acabei deixando só mesmo as comparações com relação ao tempo
 * de execução seguindo um modelo similar ao código que está no
 * github.
 */
package Codigo;

import java.util.Scanner;
import java.lang.Math;

public class Primos {
    public static int [] obterPrimos (int n){
        int [] primos = new int [n];
        int cont = 0;
        int k = 0;
        for (int i = 2; i <= n; i++) {
        	for(int j = 2; j <= (int) Math.sqrt(n) + 1; j++) {
        		if((i % j == 0) && (i != j)) {
        			cont++;
        			break;
        		}
        	}
        	if (cont == 0) {
        		primos[k] = i;
        		k++;
        	}
        	cont = 0;
        }
        int [] lista_primos = new int [k];
        k = 0;
        for (int i = 0; i < n; i++) {
        	if(primos[i] != 0) {
        		lista_primos[k] = primos[i];
        		k++;
        	}
        }
        return lista_primos;
    }
    
    public static int [] obterPrimosViaCrivo (int n) {
    	boolean[] primos = new boolean [n + 1];
    	for (int i = 0; i <= n; i++) {
    		primos[i] = true;
    	}
    	primos[0] = primos[1] = false;
    	for (int i = 2; i <= (int) Math.sqrt(n) + 1; i++) {
    		if (primos[i]) {
    			for (int j = i; i * j <= n; j++) {
    				primos[i * j] = false;
    			}
    		}
    	}
    	int k = 0;
    	for (int i = 0; i < primos.length; i++) {
    		if(primos[i]){
    			k++;
    		}
    	}
    	int [] lista_primos = new int [k];
    	k = 0;
    	for (int i = 0; i < primos.length; i++) {
    		if(primos[i]){
    			lista_primos[k] = i;
    			k++;
    		}
    	}
    	return lista_primos;
    }
    
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        long inicio = System.currentTimeMillis();
        for (int n = 10; n <= 10_000; n *= 10) {
            int[] primos = obterPrimos(n);
            /*System.out.printf("Há %d primos no intervalo [1, %d].\n",
                    primos.length, n);*/
        }
        long fim = System.currentTimeMillis();
        System.out.printf("O tempo gasto SEM Crivo foi de: %dms\n", fim - inicio);
        System.out.println();
        inicio = System.currentTimeMillis();
        for (int n = 10; n <= 10_000; n *= 10) {
            int[] primos = obterPrimosViaCrivo(n);
            /*System.out.printf("Há %d primos no intervalo [1, %d].\n",
                    primos.length, n);*/
        }
        fim = System.currentTimeMillis();
        System.out.printf("O tempo gasto COM Crivo foi de: %dms\n", fim - inicio);
        input.close();
    }
}
