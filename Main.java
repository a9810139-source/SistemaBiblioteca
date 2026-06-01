import java.util.ArrayList;
import java.util.Scanner;

// =======================
// CLASSE PESSOA
// =======================
class Pessoa {
    private String nome;
    private String matricula;

    public Pessoa(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
    }
}

// =======================
// CLASSE ALUNO (HERANÇA)
// =======================
class Aluno extends Pessoa {

    private String curso;

    public Aluno(String nome, String matricula, String curso) {
        super(nome, matricula);
        this.curso = curso;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Curso: " + curso);
    }
}

// =======================
// CLASSE LIVRO
// =======================
class Livro {

    private String titulo;
    private String autor;
    private int codigo;

    public Livro(String titulo, String autor, int codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void exibirLivro() {
        System.out.println("\nCódigo: " + codigo);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
    }
}

// =======================
// CLASSE BIBLIOTECA
// =======================
class Biblioteca {

    private ArrayList<Livro> livros = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        System.out.println("\n=== LISTA DE LIVROS ===");

        for (Livro livro : livros) {
            livro.exibirLivro();
        }
    }

    public void consultarLivro(int codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo() == codigo) {
                System.out.println("\nLivro encontrado:");
                livro.exibirLivro();
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }
}

// =======================
// CLASSE PRINCIPAL
// =======================
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        // ALUNO ATUALIZADO
        Aluno aluno = new Aluno(
            "Anthony Davidson",
            "1282612427",
            "Ciência da Computação"
        );

        int opcao;

        do {
            System.out.println("\n===== BIBLIOTECA =====");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Consultar Livro");
            System.out.println("4 - Mostrar Aluno");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Código: ");
                    int codigo = sc.nextInt();

                    Livro livro = new Livro(titulo, autor, codigo);
                    biblioteca.cadastrarLivro(livro);
                    break;

                case 2:
                    biblioteca.listarLivros();
                    break;

                case 3:
                    System.out.print("Digite o código: ");
                    int cod = sc.nextInt();
                    biblioteca.consultarLivro(cod);
                    break;

                case 4:
                    aluno.exibirDados();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}