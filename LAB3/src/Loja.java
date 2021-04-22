/**
 * Nome: Ramon Oliveira de Azevedo
 * DRE: 120023419
 * 2° Período - Ciências da Computação
 */

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
        this.lista_usuarios = new ArrayList<>();
        this.lista_produtos = new ArrayList<>();
    }

    public static Loja getInstanciaUnica() {
        return instanciaUnica;
    }

    public void limparEstado() {
        this.lista_usuarios = new ArrayList<>();
        this.lista_produtos = new ArrayList<>();
    }

    /**
     * Inclui no estoque da loja a quantidade informado do produto.
     *
     * @param produto o produto a ser incluído
     * @param quantidadeAIncluir a quantidade que será acrescentada à quantidade existente.
     */
    public void incluirProduto(Produto produto, int quantidadeAIncluir) {
        produto.setQuantidadeEmEstoque(quantidadeAIncluir);
        lista_produtos.add(produto);
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
        lista_usuarios.contains(usuario);
        boolean existencia_usuario = lista_usuarios.contains(usuario);
        boolean existencia_produto = lista_produtos.contains(produto);
        if(existencia_produto == true && existencia_usuario == true){
            if(quantidadeDesejada > produto.getQuantidadeEmEstoque()){
                return null;
            }
        }
        else{
            return null;
        }
        return new Recibo(produto, quantidadeDesejada, usuario);
    }

    /**
     * @param produto o produto a ser consultado
     *
     * @return a quantidade em estoque;
     *         0 se não houver nenhuma unidade;
     *         -1 se o produto não é sequer vendido pela loja
     */
    public int informarQuantidadeEmEstoque(Produto produto) {
        if (lista_produtos.contains(produto) == false){
            return -1;
        }
        this.quantidadeEmEstoque = produto.getQuantidadeEmEstoque();
        return quantidadeEmEstoque;
    }
}