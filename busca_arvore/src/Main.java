// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[][] estadoInical = {{0, 1, 3}, {4, 2, 6}, {7, 5, 8}};
        int[][] objetivo = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

        BuscaEmArvore buscaEmArvore = new BuscaEmArvore();

        No no  = new No(null, estadoInical, 0);

        buscaEmArvore.executar(estadoInical, objetivo, no);
    }
}

