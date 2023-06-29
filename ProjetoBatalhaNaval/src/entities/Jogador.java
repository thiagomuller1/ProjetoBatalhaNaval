package entities;



import java.util.Scanner;

class Jogador {
    private char identificacao;
    private Tabuleiro tabuleiro;
    private int pontuacao;

    public Jogador(char identificacao) {
        this.identificacao = identificacao;
        tabuleiro = new Tabuleiro();
        pontuacao = 0;
    }

    public char getIdentificacao() {
        return identificacao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void configurarTabuleiro() {
        tabuleiro.configurarTabuleiro();
    }

    public void posicionarNavios(Scanner scanner) {
        System.out.println("Jogador " + identificacao + ", posicione seus navios:");

        for (int i = 0; i < 5; i++) {
            System.out.println("Posicao " + (i + 1) + " de 5");
            int linha = obterEntradaValida(scanner, "Digite a linha: ", 0, 9);
            int coluna = obterEntradaValida(scanner, "Digite a coluna: ", 0, 9);

            if (tabuleiro.posicaoOcupada(linha, coluna)) {
                System.out.println("Posicao já ocupada por outro navio. Tente novamente.");
                i--;
            } else {
                tabuleiro.marcarPosicao(linha, coluna);
            }
        }
    }

    public void exibirTabuleiroInimigo() {
        System.out.println("\n--- Tabuleiro do Jogador " + identificacao + " ---");
        tabuleiro.exibirTabuleiroInimigo();
    }

    public void exibirPontuacao() {
        System.out.println("Pontuacao do Jogador " + identificacao + ": " + pontuacao);
    }

    public void realizarJogada(Scanner scanner, Jogador jogadorInimigo) {
        System.out.println("Jogador " + identificacao + ", execute sua jogada:");

        int linha = obterEntradaValida(scanner, "Digite a linha: ", 0, 9);
        int coluna = obterEntradaValida(scanner, "Digite a coluna: ", 0, 9);

        if (jogadorInimigo.tabuleiro.posicaoOcupada(linha, coluna)) {
            System.out.println("Jogador " + identificacao + " acertou um navio!");
            jogadorInimigo.pontuacao++;
            jogadorInimigo.tabuleiro.marcarPosicao(linha, coluna, '*');
        } else {
            System.out.println("Jogador " + identificacao + " errou o alvo.");
            jogadorInimigo.tabuleiro.marcarPosicao(linha, coluna, '#');
        }
    }

    public void reiniciar() {
        pontuacao = 0;
        tabuleiro.configurarTabuleiro();
    }

    private int obterEntradaValida(Scanner scanner, String mensagem, int limiteMin, int limiteMax) {
        int entrada;

        do {
            System.out.print(mensagem);
            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida. Tente novamente: ");
                scanner.next();
            }
            entrada = scanner.nextInt();

            if (entrada < limiteMin || entrada > limiteMax) {
                System.out.println("Valor fora dos limites. Tente novamente.");
            }

        } while (entrada < limiteMin || entrada > limiteMax);

        return entrada;
    }
}
