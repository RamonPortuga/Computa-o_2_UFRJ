import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UsuarioTest {
    private List<Usuario> usuarioIngenuo;
    private List<Usuario> usuarioBuscaBinaria;
    private List<Usuario> usuarioEsperto;

    int qtdEsperadaDeAmigosEmComum = 10_000;

    @Before
    public void setUp() {
        List<Usuario> lista1 = new ArrayList<>();
        List<Usuario> lista2 = new ArrayList<>();

        usuarioIngenuo = new ArrayList<>();
        usuarioBuscaBinaria = new ArrayList<>();
        usuarioEsperto = new ArrayList<>();

        CalculadorIntersecaoEsperto esperto = new CalculadorIntersecaoEsperto();
        CalculadorIntersecaoIngenuo ingenuo = new CalculadorIntersecaoIngenuo();
        CalculadorIntersecaoViaBuscaBinaria buscaBinaria = new CalculadorIntersecaoViaBuscaBinaria();

        for (int i = 0; i < qtdEsperadaDeAmigosEmComum; i++){
            lista1.add(new Usuario(i, esperto));
        }
        for (int i = 0; i < 1_000_000; i++){
            lista2.add(new Usuario(i, esperto));
        }

        for (int i = 0; i < 2; i++){
            usuarioIngenuo.add(new Usuario(i, ingenuo));
            usuarioBuscaBinaria.add(new Usuario(i, buscaBinaria));
            usuarioEsperto.add(new Usuario(i, esperto));
            if(i == 0){
                usuarioIngenuo.get(i).setAmigos(lista1);
                usuarioBuscaBinaria.get(i).setAmigos(lista1);
                usuarioEsperto.get(i).setAmigos(lista1);
            }
            else if (i == 1){
                usuarioIngenuo.get(i).setAmigos(lista1);
                usuarioBuscaBinaria.get(i).setAmigos(lista1);
                usuarioEsperto.get(i).setAmigos(lista1);
            }
        }

    }

    @Test
    public void testarQtdEsperadaDeAmigosEmComum(){
        long inicio = System.currentTimeMillis();
        assertEquals("A quantidade de Amigos em Comum está errada", qtdEsperadaDeAmigosEmComum,
                usuarioIngenuo.get(0).obterQuantidadeDeAmigosEmComum(usuarioIngenuo.get(1)));
        long fim = System.currentTimeMillis();
        long tempoDecorrido = fim - inicio;
        int segundos = (int) (tempoDecorrido / 1000);
        int milissegundos = (int) tempoDecorrido - (segundos * 1000);
        System.out.printf("Tempo decorrido de maneira Ingênua: %ds e %dms\n", segundos, milissegundos);

        inicio = System.currentTimeMillis();
        assertEquals("A quantidade de Amigos em Comum está errada", qtdEsperadaDeAmigosEmComum,
                usuarioBuscaBinaria.get(0).obterQuantidadeDeAmigosEmComum(usuarioBuscaBinaria.get(1)));
        fim = System.currentTimeMillis();
        tempoDecorrido = fim - inicio;
        segundos = (int) (tempoDecorrido / 1000);
        milissegundos = (int) tempoDecorrido - (segundos * 1000);
        System.out.printf("Tempo decorrido com Busca Binaria: %ds e %dms\n", segundos, milissegundos);

        inicio = System.currentTimeMillis();
        assertEquals("A quantidade de Amigos em Comum está errada", qtdEsperadaDeAmigosEmComum,
                usuarioEsperto.get(0).obterQuantidadeDeAmigosEmComum(usuarioEsperto.get(1)));
        fim = System.currentTimeMillis();
        tempoDecorrido = fim - inicio;
        segundos = (int) (tempoDecorrido / 1000);
        milissegundos = (int) tempoDecorrido - (segundos * 1000);
        System.out.printf("Tempo decorrido de maneira Esperta: %ds e %dms\n", segundos, milissegundos);
    }
}
