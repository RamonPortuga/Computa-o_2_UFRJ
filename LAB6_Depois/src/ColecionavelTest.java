import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColecionavelTest {

    private Album albumFigurinhas;
    private Album albumDeSelos;

    private Repositorio repositorioFigurinhas;
    private Repositorio repositorioSelos;

    private static final int TAMANHO_DO_ALBUM = 200;
    private static final int ITENS_POR_PACOTE = 3;

    @Before  // roda antes de cada teste
    public void setUp() {
        this.repositorioFigurinhas = new Repositorio("album_copa2014", TAMANHO_DO_ALBUM);
        this.albumFigurinhas = new Album(repositorioFigurinhas, ITENS_POR_PACOTE);

        this.repositorioSelos = new Repositorio("selos_Correios", TAMANHO_DO_ALBUM);
        this.albumDeSelos = new Album(repositorioSelos, ITENS_POR_PACOTE);

    }

    private void popularAlbum(int[] posicoesDesejadas) {
        Pacotinho pacoteFigurinhas = new Pacotinho(this.repositorioFigurinhas, posicoesDesejadas);
        this.albumFigurinhas.receberNovoPacotinho(pacoteFigurinhas);

        Pacotinho pacoteSelos = new Pacotinho(this.repositorioSelos, posicoesDesejadas);
        this.albumDeSelos.receberNovoPacotinho(pacoteSelos);
    }

    @Test
    public void testarInstanciasDeItensColecionaveis(){
        /*Adicione um unit test (um único método) onde você terá duas instâncias de Album:
   uma para Selos e outra para Figurinhas, fazendo algum teste muito básico
   com cada instância dessas.*/
        popularAlbum(new int[] {1, 2, 3});
        Colecionavel figurinha = albumFigurinhas.getItemColado(2);

        assertNotNull(figurinha);

        assertEquals(2, figurinha.getPosicao());

        assertNull(albumFigurinhas.getItemColado(4));

        Colecionavel selo = albumDeSelos.getItemColado(2);

        assertNotNull(selo);

        assertEquals(2, selo.getPosicao());

        assertNull(albumDeSelos.getItemColado(4));
    }
}
