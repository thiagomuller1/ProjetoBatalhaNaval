package entities;

class Tabuleiro {
    private char[][] tabuleiro;

    public Tabuleiro() {
        tabuleiro = new char[10][10];
    }

    public void configurarTabuleiro() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }
    public void exibirTabuleiroInimigo() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++) {
                char caractere = tabuleiro[i][j];
                if (caractere == 'N') {
                    caractere = '~'; 
                }
                System.out.print(caractere + " ");
            }
            System.out.println();
        }
    }


    public boolean posicaoOcupada(int linha, int coluna) {
        return tabuleiro[linha][coluna] == 'N';
    }

    public void marcarPosicao(int linha, int coluna, char symbol) {
        tabuleiro[linha][coluna] = 'N';
    }
    public void marcarPosicao(int linha, int coluna) {
        tabuleiro[linha][coluna] = 'N';
    }
}

