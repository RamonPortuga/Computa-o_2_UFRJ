import java.util.ArrayList;
import java.util.Objects;

public class Aluno extends Pessoa{

    // --------------------------------
    // atributos
    // --------------------------------

    private String nome;

    private final long dre;

//    public float cra;  // público para leitura e escrita de qualquer lugar do código
//    float cra;  // "public" APENAS DENTRO DO MESMO package!!!
//    protected float cra;  // "public" dentro do mesmo package + subclasses
    private float cra;

    private float numeradorCra;
    private float denominadorCra;

    private int creditosAcumulados;

    private Periodo periodoIngresso;

    private ArrayList<ItemHistorico> historico;

    private int anoDeNascimento;

    public final static int TAMANHO_MAXIMO_DO_NOME = 30;

    // --------------------------------
    // métodos
    // --------------------------------

    /*public Aluno() {
        this(0, "Sem Nome");  // chamando a sobrecarga de construtor deste objeto
    }*/

    public Aluno(long dre, String nome, int anoDeNascimento) {

        super (nome, anoDeNascimento);

        this.dre = dre;

        this.historico = new ArrayList<>();  // com <>, o compilador substitui por <ItemHistorico>

        this.periodoIngresso = Siguinha.obterPeriodoCorrente();

        this.cra = 0;  // desnecessário, pois 0 é o valor default de float
        this.numeradorCra = 0;
        this.denominadorCra = 0;

        this.creditosAcumulados = 0;  // idem para int
    }

    public void setNome(String nome) {
        if (nome.length() > TAMANHO_MAXIMO_DO_NOME) {
            // ToDo: lançar uma exceção!!!
            return;
        }

        this.nome = nome;
    }

    public float getCra() {
        return cra;
    }

    public int getCreditosAcumulados() {
        return creditosAcumulados;
    }

    public long getDre() {
        return dre;
    }

    public int getIdade() {
        return Siguinha.obterAnoCorrente() - this.getAnoDeNascimento();
    }

    public void inserirItemHistorico(Disciplina disciplina, float mediaFinal) {
        Periodo periodoCorrente = Siguinha.obterPeriodoCorrente();
        inserirItemHistorico(disciplina, mediaFinal, periodoCorrente);
    }

    public void inserirItemHistorico(
            Disciplina disciplina, float mediaFinal, Periodo periodo) {

        boolean disciplinaJaExistenteNoPeriodo = false;

        // verifica se já existe no histórico essa disciplina nesse período
        for (ItemHistorico itemHistorico : this.historico) {

            if (itemHistorico == null) {
                break;
            }

            if (itemHistorico.disciplinaCursada == disciplina &&
                    itemHistorico.periodo == periodo) {

                disciplinaJaExistenteNoPeriodo = true;

                int creditosDaDisciplina = itemHistorico.disciplinaCursada.getCreditos();
                this.numeradorCra -= itemHistorico.mediaFinal * creditosDaDisciplina;
                if (itemHistorico.mediaFinal >= Siguinha.MEDIA_MINIMA_PARA_APROVACAO) {
                    this.creditosAcumulados -= creditosDaDisciplina;
                }

                itemHistorico.mediaFinal = mediaFinal;
            }
        }

        if (!disciplinaJaExistenteNoPeriodo) {
            // inserir item no histórico

            ItemHistorico novoItem = new ItemHistorico(
                    disciplina, mediaFinal, periodo);
            this.historico.add(novoItem);
        }

        // atualizar creditos
        if (mediaFinal >= Siguinha.MEDIA_MINIMA_PARA_APROVACAO) {
            this.creditosAcumulados += disciplina.getCreditos();
        }

        // outro jeito de atualizar o CRA (melhor performance)
        this.numeradorCra += mediaFinal * disciplina.getCreditos();
        this.denominadorCra += disciplina.getCreditos();
        this.cra = this.numeradorCra / this.denominadorCra;
    }

    public String getHistoricoParaImpressao() {
        String resultado = "Aluno(a): " + this.nome +
                " (DRE: " + this.dre + ")\n";
        for (int i = 0; i < this.historico.size(); i++) {
            ItemHistorico itemHistorico = this.historico.get(i);
            resultado += itemHistorico.periodo.getAno();
            resultado += ".";
            resultado += itemHistorico.periodo.getSemestre();
            resultado += " - ";
            resultado += itemHistorico.disciplinaCursada.getNome();
            resultado += " - ";
            resultado += String.format("%.1f", itemHistorico.mediaFinal);
            if (i != this.historico.size() - 1) {  // se não é o último item...
                resultado += "\n";
            }
        }
        return resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return dre == aluno.dre &&
                Objects.equals(nome, aluno.getNome());
    }

    // inner class (classe auxiliar, visível apenas de dentro da classe Aluno)
    private class ItemHistorico {

        public Disciplina disciplinaCursada;

        float mediaFinal;

        Periodo periodo;

        ItemHistorico(Disciplina disciplinaCursada, float mediaFinal, Periodo periodo) {
            this.disciplinaCursada = disciplinaCursada;
            this.mediaFinal = mediaFinal;
            this.periodo = periodo;
        }
    }
}
