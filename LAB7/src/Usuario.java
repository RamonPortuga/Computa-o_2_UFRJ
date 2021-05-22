import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Usuario {

    private final String email;
    private String nome;
    private Image foto;

    public Usuario(String nome, String email) {
        /*if (registroDeUsuarios.containsKey(email) == false){
            this.email = email;
            this.nome = nome;
            registroDeUsuarios.put(this.email)
        }
        else{

        }*/
        // ToDo IMPLEMENT ME!!!
        //Criar um Map para poder realizar o armazenamento dos usuários através do email
        //E realizar um compareTo
        this.email = email;
        this.nome = nome;

    }

    /*public Usuario getUsuarioJaExistente(String email){

    }*/

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Image getFoto() {
        return this.foto;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNome() {
        return this.nome;
    }

    /*@Override
    public String compareTo(Usuario usuario){
        return
    }*/
}
