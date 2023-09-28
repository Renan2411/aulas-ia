import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class BuscaEmArvore {
    static List<No> borda = new ArrayList<>();

    public void executar(int[][] estadoInicial, int[][] objetivo, No no) {

        boolean executar = true;


        No noAtual = new No(no.pai, no.estado, no.profundidade);

        while (executar) {
            if (verificarObjetivoAlcancado(noAtual.estado, objetivo)) {
                executar = false;
                break;
            }

            expandirNo(noAtual);

            borda.remove(noAtual);
            No novoNo = borda.get(0);


            noAtual = novoNo;
        }


        System.out.printf("-----Profundidade = %d---\n", noAtual.profundidade);
        for (int i = 0; i < noAtual.estado.length; i++) {
            for (int j = 0; j < noAtual.estado[i].length; j++) {
                System.out.printf("%d\t", noAtual.estado[i][j]);
            }
            System.out.println("\n---------");
        }

//        while (!Objects.isNull(noAtual)) {
//            System.out.printf("-----Profundidade = %d---\n", noAtual.profundidade);
//            for (int i = 0; i < noAtual.estado.length; i++) {
//                for (int j = 0; j < noAtual.estado[i].length; j++) {
//                    System.out.printf("%d\t", noAtual.estado[i][j]);
//                }
//                System.out.println("\n---------");
//            }
//
//            noAtual = noAtual.pai;
//        }

    }

    public static No criarNo(No pai, int[][] estado, int profundidade) {
        return new No(pai, estado, profundidade);
    }

    public static Boolean verificarObjetivoAlcancado(int[][] estado, int[][] objetivo) {
        boolean resultado = true;

        for (int i = 0; i < estado.length; i++) {
            resultado = Arrays.equals(estado[i], objetivo[i]);

            if (!resultado) {
                break;
            }
        }

        return resultado;
    }

    public static void expandirNo(No no) {
        String[] acoes = {"DIREITA", "PARA_CIMA", "PARA_BAIXO", "ESQUERDA"};

        for (String acao : acoes) {

            if (ehPossivelRealizarAcao(Acao.valueOf(acao), posicaoElementoVazio(no.estado), no.estado)) {
                borda.add(criarNo(no, moverPeca(cloneArrayBidimensional(no.estado), Acao.valueOf(acao)), no.profundidade + 1));
            }
        }
    }

    public static List<String> removerAcao(List<String> acoes, String acaoAtual) {
        return acoes.stream().filter(acao -> acao != acaoAtual).collect(Collectors.toList());
    }

    public static String getAcao(List<String> acoes) {

        if (acoes.size() == 0) {
            return acoes.get(0);
        }

        Random random = new Random();

        int numeroAleatorio = random.nextInt(acoes.size());

        return acoes.get(numeroAleatorio);
    }

    public static void setarAcoes(List<String> acoes) {
        acoes.add(Acao.DIREITA.name());
        acoes.add(Acao.ESQUERDA.name());
        acoes.add(Acao.PARA_CIMA.name());
        acoes.add(Acao.PARA_BAIXO.name());
    }

    public static int[][] cloneArrayBidimensional(int[][] original) {
        int rows = original.length;
        int cols = original[0].length;
        int[][] clone = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            clone[i] = Arrays.copyOf(original[i], cols);
        }

        return clone;
    }


    public static int[][] moverPeca(int[][] estado, Acao acao) {
        int[] posicaoElementoVazio = posicaoElementoVazio(estado);
        int espacoMovido = 0;

        switch (acao) {
            case DIREITA:
                espacoMovido = estado[posicaoElementoVazio[0]][posicaoElementoVazio[1] + 1];
                estado[posicaoElementoVazio[0]][posicaoElementoVazio[1] + 1] = 0;
                estado[posicaoElementoVazio[0]][posicaoElementoVazio[1]] = espacoMovido;
                break;
            case ESQUERDA:
                espacoMovido = estado[posicaoElementoVazio[0]][posicaoElementoVazio[1] - 1];
                estado[posicaoElementoVazio[0]][posicaoElementoVazio[1] - 1] = 0;
                estado[posicaoElementoVazio[0]][posicaoElementoVazio[1]] = espacoMovido;
                break;
            case PARA_BAIXO:
                espacoMovido = estado[posicaoElementoVazio[0] + 1][posicaoElementoVazio[1]];
                estado[posicaoElementoVazio[0] + 1][posicaoElementoVazio[1]] = 0;
                estado[posicaoElementoVazio[0]][posicaoElementoVazio[1]] = espacoMovido;
                break;
            case PARA_CIMA:
                espacoMovido = estado[posicaoElementoVazio[0] - 1][posicaoElementoVazio[1]];
                estado[posicaoElementoVazio[0] - 1][posicaoElementoVazio[1]] = 0;
                estado[posicaoElementoVazio[0]][posicaoElementoVazio[1]] = espacoMovido;
                break;
        }


//        if (ehDireitaPossivel(posicaoElementoVazio[1], estado.length)) {
//            int espacoMovido = estado[posicaoElementoVazio[0]][posicaoElementoVazio[1] + 1];
//            estado[posicaoElementoVazio[0]][posicaoElementoVazio[1] + 1] = 0;
//            estado[posicaoElementoVazio[0]][posicaoElementoVazio[1]] = espacoMovido;
//        } else if (ehParaCimaPossivel(posicaoElementoVazio[0])) {
//            int espacoMovido = estado[posicaoElementoVazio[0] - 1][posicaoElementoVazio[1]];
//            estado[posicaoElementoVazio[0] - 1][posicaoElementoVazio[1]] = 0;
//            estado[posicaoElementoVazio[0]][posicaoElementoVazio[1]] = espacoMovido;
//        } else if (ehEsquerdaPossivel(posicaoElementoVazio[1])) {
//            int espacoMovido = estado[posicaoElementoVazio[0]][posicaoElementoVazio[1] - 1];
//            estado[posicaoElementoVazio[0]][posicaoElementoVazio[1] - 1] = 0;
//            estado[posicaoElementoVazio[0]][posicaoElementoVazio[1]] = espacoMovido;
//        } else if (ehParaBaixoPossivel(posicaoElementoVazio[0], estado[0].length)) {
//            int espacoMovido = estado[posicaoElementoVazio[0] + 1][posicaoElementoVazio[1]];
//            estado[posicaoElementoVazio[0] + 1][posicaoElementoVazio[1]] = 0;
//            estado[posicaoElementoVazio[0]][posicaoElementoVazio[1]] = espacoMovido;
//        }

        return estado;
    }

    public static int[] posicaoElementoVazio(int[][] estado) {
        int[] posicao = new int[2];

        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado[0].length; j++) {
                if (estado[i][j] == 0) {
                    posicao[0] = i;
                    posicao[1] = j;
                }
            }
        }

        return posicao;
    }

    public static boolean ehPossivelRealizarAcao(Acao acao, int[] posicao, int[][] estado) {
        switch (acao) {
            case DIREITA:
                return ehDireitaPossivel(posicao[1], estado[0].length);
            case ESQUERDA:
                return ehEsquerdaPossivel(posicao[1]);
            case PARA_BAIXO:
                return ehParaBaixoPossivel(posicao[0], estado.length);
            case PARA_CIMA:
                return ehParaCimaPossivel(posicao[0]);
        }

        return false;
    }

    public static boolean ehDireitaPossivel(int coluna, int tamanhoColuna) {
        return coluna < tamanhoColuna - 1;
    }

    public static boolean ehEsquerdaPossivel(int coluna) {
        return coluna > 0;
    }

    public static boolean ehParaCimaPossivel(int linha) {
        return linha > 0;
    }

    public static boolean ehParaBaixoPossivel(int linha, int tamanhoLinha) {
        return linha < tamanhoLinha - 1;
    }

//    public static No getNoAtual(No no) {
//        return no.filhos.get(0);
//    }
}
