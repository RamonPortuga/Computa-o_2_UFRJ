/*7) Crie uma classe Turma. Um objeto da classe Turma representará uma
   disciplina em um determinado período lecionada por um determinado professor.
   A classe Turma deve ter os seguintes métodos públicos:

   void inscreverAluno(Aluno aluno)

   void atribuirMediaFinal(long dre, float nota)

   float obterMediaFinal(long dre)

   String listarAlunos()*/

import java.util.HashMap;
import java.util.Map;

public class Turma {

    private Disciplina disciplina;
    private Periodo periodo;
    private Professor professor;

    private Map<Long, Aluno> alunosIncritos = new HashMap<>();
    private Map<Aluno, Float> notasAlunosInscritos = new HashMap<>();

    public void inscreverAluno (Aluno aluno){
        float nota = 0f;
        final long dre = aluno.getDre();
        Aluno alunoJaInscrito = this.alunosIncritos.get(dre);
        if (alunoJaInscrito != null) {
            return;
        }
        this.alunosIncritos.put(dre, aluno);
        this.notasAlunosInscritos.put(aluno, nota);
    }

    public void atribuirMediaFinal (long dre, float nota){
        Aluno aluno = this.alunosIncritos.get(dre);
        aluno.inserirItemHistorico(disciplina, nota, periodo);
        this.notasAlunosInscritos.put(aluno, nota);
    }

    public float obterMediaFinal (long dre){
        Aluno aluno = this.alunosIncritos.get(dre);
        float mediaFinal = this.notasAlunosInscritos.get(aluno);
        return mediaFinal;
    }

    public String listarAlunos(){
        String lista_nomes = "";
        for (Long dre : alunosIncritos.keySet()){
            Aluno aluno = this.alunosIncritos.get(dre);
            lista_nomes += aluno.getNome();
        }
        return lista_nomes;
    }

}
