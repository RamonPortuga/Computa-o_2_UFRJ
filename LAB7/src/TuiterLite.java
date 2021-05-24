import java.util.*;

/**
 *  Esta classe implementa um sistema de mensagens curtas estilo Twitter.
 *  É preciso cadastrar um usuário, identificado pelo seu e-mail, para que tuítes possam ser feitos.
 *  Usuários começam como iniciantes, depois são promovidos a senior e a ninja, em função do número de tuítes.
 *  Existe um tamanho máximo permitido por mensagem (constante TAMANHO_MAXIMO_TUITES).
 *  As mensagens podem conter hashtags (palavras iniciadas por #), que são detectadas automaticamente.
 *  Os tuítes podem conter, além da mensagem de texto, um anexo qualquer.
 *  Há um método para retornar, a qualquer momento, qual a hashtag mais usada em toda a história do sistema.
 */
public class TuiterLite {

    public static int TAMANHO_MAXIMO_TUITES = 120;

    private List arrayListTodasAsHashtags = new ArrayList<>();

    private Map<String, Usuario> registroDeUsuarios = new HashMap<>();
    private Map<String, Integer> frequenciaHashtags = new HashMap<>();

    private Set <String> todasAsHashtags = new HashSet<String>();

    /**
     * Cadastra um usuário, retornando o novo objeto Usuario criado.
     * @param nome O nome do usuário.
     * @param email O e-mail do usuário (precisa ser único no sistema).
     * @return O Usuario criado.
     */
    public Usuario cadastrarUsuario(String nome, String email) {  // throws UsuarioJaExisteException {
        Usuario usuario = new Usuario(nome, email);
        return usuario;
    }

    /**
     *
     * @param usuario O autor do tuíte
     * @param texto O texto desejado
     * @return Um "tuíte", que será devidamente publicado no sistema
     *
     * PS.: Se o texto exceder o limite pré-definido, ou o usuário não estiver cadastrado, return null
     */
    public Tuite tuitarAlgo(Usuario usuario, String texto) {
        if (texto.length() <= TAMANHO_MAXIMO_TUITES){
            List arrayListHashtagsDoTuite = new ArrayList<>();
            Set <String> hashtags = new HashSet<String>();
            String[] palavras = new String[120];
            palavras = texto.split(" ");
            for (int i = 0; i < palavras.length; i++){
                if (palavras[i].contains("#") == true){
                    palavras[i] = palavras[i].replaceAll("#+", "#");
                    arrayListTodasAsHashtags.add(palavras[i]);
                    arrayListHashtagsDoTuite.add(palavras[i]);
                }
            }
            hashtags.addAll(arrayListHashtagsDoTuite);
            Tuite tuite = new Tuite(usuario, texto, hashtags);
            return tuite;
        }
        return null;
    }

    /**
     * Retorna a hashtag mais comum dentre todas as que já apareceram.
     * A cada tuíte criado, hashtags devem ser detectadas automaticamente para que este método possa funcionar.
     * @return A hashtag mais comum, ou null se nunca uma hashtag houver sido tuitada.
     */
    public String getHashtagMaisComum() {
        todasAsHashtags.addAll(arrayListTodasAsHashtags);
        if (arrayListTodasAsHashtags.isEmpty()){
            return null;
        }
        int maiorFrequencia = 0;
        String hashtagMaisFrequente = "banana";
        Collections.sort(arrayListTodasAsHashtags);
        int i = 0;
        while (arrayListTodasAsHashtags.size() != 0 && i < arrayListTodasAsHashtags.size()){
            int primeiroAparicaoHashtag = arrayListTodasAsHashtags.indexOf(arrayListTodasAsHashtags.get(i));
            int ultimaAparicaoHashtag = arrayListTodasAsHashtags.lastIndexOf(arrayListTodasAsHashtags.get(i));
            int frequencia = ultimaAparicaoHashtag - primeiroAparicaoHashtag;
            if (frequencia > maiorFrequencia){
                hashtagMaisFrequente = (String) arrayListTodasAsHashtags.get(i);
                maiorFrequencia = frequencia;
            }
            i++;
        }
        return hashtagMaisFrequente;
    }
}
