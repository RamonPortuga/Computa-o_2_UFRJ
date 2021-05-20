/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */

import java.awt.*;

public class Selo implements Colecionavel{
    private String pais;
    private float valorNominal;

    @Override
    public Image getImagem() {
        return null;
    }

    @Override
    public int getPosicao() {
        return 0;
    }

    public float getValorNominal(){
        return this.valorNominal;
    }
    public String getPais(){
        return this.pais;
    }
}
