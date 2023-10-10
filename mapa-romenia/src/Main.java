public class Main {
    public static void main(String[] args) {

        No no = new No(Cidade.ARAD, 0, null);

//        BuscaEmProfundidade.executar(Cidade.BUCHAREST, no);
//BuscaPorCustoUniforme.executar(Cidade.BUCHAREST, no);
        //BuscaGulosa.executar(Cidade.BUCHAREST, no);
        BuscaAhEstrela.executar(Cidade.BUCHAREST, no);

    }
}