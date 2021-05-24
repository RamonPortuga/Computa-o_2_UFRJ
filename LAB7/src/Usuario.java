/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */

import java.awt.*;

public class Usuario {

    private final String email;
    private String nome;
    private Image foto;

    public Usuario(String nome, String email) {
        this.email = email;
        this.nome = nome;

    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this.getEmail() == ((Usuario)o).getEmail()) {
            result = true;
        }
        return result;
    }

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
}
