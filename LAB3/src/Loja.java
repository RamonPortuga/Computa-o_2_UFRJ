/**
 * Implementa uma loja virtual para produtos de qualquer tipo,
 * desde que tenham descrição, preço e dimensões.
 *
 * Essa classe será um singleton, isto é, permitiremos apenas
 * uma instância desde objeto no sistema.
 */

import java.util.ArrayList;
import java.util.List;

public class Loja {

    private int quantidadeEmEstoque;
    private Produto produto;
    private Usuario usuario;

    List lista_produtos = new ArrayList();
    List lista_usuarios = new ArrayList();

    private static final Loja instanciaUnica = new Loja();

    static {
        System.out.println("Estou subindo a classe Loja...");
    }

    protected Loja() {
        // escrevo código normalmente para o construtor
    }

    public static Loja getInstanciaUnica() {
        return instanciaUnica;
    }

    public void limparEstado() {
        // recria os atributos, ou os limpa...
    }

    /**
     * Inclui no estoque da loja a quantidade informado do produto.
     *
     * @param produto o produto a ser incluído
     * @param quantidadeAIncluir a quantidade que será acrescentada à quantidade existente.
     */
    public void incluirProduto(Produto produto, int quantidadeAIncluir) {
        int quantidadeFinal = quantidadeAIncluir + quantidadeEmEstoque;
        produto.setQuantidadeEmEstoque(quantidadeFinal);
        lista_produtos.add(produto);
        /*int quantidadeFinal = quantidadeAIncluir + quantidadeEmEstoque;
        produto.setQuantidadeEmEstoque(quantidadeFinal);*/
    }

    public void cadastrarUsuario(Usuario usuario) {
        lista_usuarios.add(usuario);
    }

    /**
     * Efetua a venda do produto desejado na quantidade especificada.
     *
     * @param produto o produto
     * @param quantidadeDesejada a quantidade
     *
     * @return um Recibo indicando a venda feita, se o produto existia (em quantidade suficiente)
     *         no estoque da loja; null, caso o usuário ou o produto sejam desconhecidos,
     *         ou não haja quantidade suficiente do produto desejado
     */
    public Recibo efetuarVenda(
            Produto produto, int quantidadeDesejada, Usuario usuario) {

        return null;  // ToDo IMPLEMENT ME!!!
    }

    @Override
    public boolean equals (Object o){
        /*
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
         */

        return false;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Fracao fracaoAuxiliar = (Fracao) o;
        fracaoAuxiliar = fracaoAuxiliar.getFracaoGeratriz();
        Fracao fracao = this;

        fracaoAuxiliar = fracaoAuxiliar.getFracaoGeratriz();
        fracao = fracao.getFracaoGeratriz();

        return fracao.getNumerador() == fracaoAuxiliar.getNumerador()
                && fracao.getDenominador() == fracaoAuxiliar.getDenominador()
                && fracao.getSinal() == fracaoAuxiliar.getSinal();
    }*/

    /**
     * @param produto o produto a ser consultado
     *
     * @return a quantidade em estoque;
     *         0 se não houver nenhuma unidade;
     *         -1 se o produto não é sequer vendido pela loja
     */
    public int informarQuantidadeEmEstoque(Produto produto) {
        this.quantidadeEmEstoque = produto.getQuantidadeEmEstoque();
        return quantidadeEmEstoque;
        // ToDo IMPLEMENT ME!!!
    }
}
