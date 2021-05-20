public class Teste {
    public static void main (String [] args){
        final int TAMANHO_DO_ALBUM = 200;
        Figurinha fig = new Figurinha(1, "banana");
        Repositorio rep = new Repositorio("album_copa2014", TAMANHO_DO_ALBUM, fig);
        Album album = new Album(rep, 3);
        System.out.println(rep.getTotalColecionavel());
        System.out.println(album.getTamanho());
    }
}
