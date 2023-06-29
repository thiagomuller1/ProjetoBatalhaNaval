package entities;

import java.util.Scanner;

    public class JogoBatalhaNaval {
    private Jogador jogadorA;
    private Jogador jogadorB;

    public JogoBatalhaNaval() {
        jogadorA = new Jogador('A');
        jogadorB = new Jogador('B');
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iniciando o jogo de Batalha Naval...");

        jogadorA.configurarTabuleiro();
        jogadorB.configurarTabuleiro();

        jogadorA.posicionarNavios(scanner);
        jogadorB.posicionarNavios(scanner);

        boolean jogoAtivo = true;
        Jogador jogadorAtual = jogadorA;

        while (jogoAtivo) {
            jogadorAtual.exibirTabuleiroInimigo();
            jogadorAtual.exibirPontuacao();

            jogadorAtual.realizarJogada(scanner, jogadorAtual == jogadorA ? jogadorB : jogadorA);

            if (jogadorAtual.getPontuacao() == 17) {
                jogoAtivo = false;
            } else {
                jogadorAtual = jogadorAtual == jogadorA ? jogadorB : jogadorA;
            }
        }

        System.out.println("\n--- Fim de jogo ---");
        jogadorA.exibirPontuacao();
        jogadorB.exibirPontuacao();
        Jogador vencedor = jogadorA.getPontuacao() > jogadorB.getPontuacao() ? jogadorA : jogadorB;
        System.out.println("O vencedor é o Jogador " + vencedor.getIdentificacao());

        reiniciarJogo(scanner);
    }

    private void reiniciarJogo(Scanner scanner) {
        System.out.print("\nDeseja jogar novamente? (S/N): ");
        String resposta = scanner.nextLine().toLowerCase();

        if (resposta.equals("s")) {
            jogadorA.reiniciar();
            jogadorB.reiniciar();
            iniciarJogo();
        } else {
            System.out.println("Obrigado por jogar!");
        }
    }
}



