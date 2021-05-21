/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */

/*Adicione um unit test (um único método) onde você terá duas instâncias de Album:
   uma para Selos e outra para Figurinhas, fazendo algum teste muito básico
   com cada instância dessas.*/

/*OBS: Professor, coloquei alguns testes só mesmo para demonstrar que funciona,
espero q não se importe. Inclusive, criei um teste específico bastante básico. */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColecionavelTest {

    private Album albumFigurinhas;
    private Album albumDeSelos;

    private Repositorio repositorioFigurinhas;
    private Repositorio repositorioSelos;

    private Figurinha fig;
    private Selo selo;

    private static final int TAMANHO_DO_ALBUM = 200;
    private static final int ITENS_POR_PACOTE = 3;

    @Before  // roda antes de cada teste
    public void setUp() {
        this.repositorioFigurinhas = new Repositorio("album_copa2014", TAMANHO_DO_ALBUM, fig);
        this.albumFigurinhas = new Album(repositorioFigurinhas, ITENS_POR_PACOTE);

        this.repositorioSelos = new Repositorio("selos_Correios", TAMANHO_DO_ALBUM, selo);
        this.albumDeSelos = new Album(repositorioSelos, ITENS_POR_PACOTE);

    }

    private void popularAlbum(int[] posicoesDesejadas) {
        Pacotinho pacoteFigurinhas = new Pacotinho(this.repositorioFigurinhas, posicoesDesejadas);
        this.albumFigurinhas.receberNovoPacotinho(pacoteFigurinhas);

        Pacotinho pacoteSelos = new Pacotinho(this.repositorioSelos, posicoesDesejadas);
        this.albumDeSelos.receberNovoPacotinho(pacoteSelos);
    }

    @Test
    public void testarGetTamanhoAlbum() {
        assertEquals(TAMANHO_DO_ALBUM, this.albumFigurinhas.getTamanho());
        assertEquals(TAMANHO_DO_ALBUM, this.albumDeSelos.getTamanho());
    }

    @Test
    public void testarPossuiFigurinhaParaFigurinhasAusentes() {
        popularAlbum(new int[] {1, 2, 3});

        assertFalse("Não devemos encontrar no álbum figurinhas nunca inseridas",
                this.albumFigurinhas.possuiItemColado(4));
        assertFalse("Não devemos encontrar figurinhas de posições não-positivas",
                this.albumFigurinhas.possuiItemColado(-390));
        assertFalse("Não devemos encontrar figurinhas maiores do que o tamanho",
                this.albumFigurinhas.possuiItemColado(TAMANHO_DO_ALBUM + 1));

        assertFalse("Não devemos encontrar no álbum figurinhas nunca inseridas",
                this.albumDeSelos.possuiItemColado(4));
        assertFalse("Não devemos encontrar figurinhas de posições não-positivas",
                this.albumDeSelos.possuiItemColado(-390));
        assertFalse("Não devemos encontrar figurinhas maiores do que o tamanho",
                this.albumDeSelos.possuiItemColado(TAMANHO_DO_ALBUM + 1));
    }

    @Test
    public void testarRejeicaoPacotinhosDeTamanhoErrado() {
        popularAlbum(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8});

        assertEquals("Pacotes de tamanho distinto do informado na construção " +
                        "do álbum devem ser rejeitados",
                0, albumFigurinhas.getQuantItensColados());

        assertEquals("Pacotes de tamanho distinto do informado na construção " +
                        "do álbum devem ser rejeitados",
                0, albumDeSelos.getQuantItensColados());
    }

    @Test
    public void testarInstanciasDeItensColecionaveis(){
        popularAlbum(new int[] {1, 2, 3});

        assertNull(albumFigurinhas.getItemColado(4));

        assertNull(albumDeSelos.getItemColado(4));
    }
}
