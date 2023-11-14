//import java.util.ArrayList;
//import java.util.List;
//
//public class Perceptron {
//
//    public static int[][] entrada = {{1, 1, 0, 0}, {1, 0, 1, 0}};
//    public static int[] saida = {1, 1, 1, 0};
//    public static double n = 0.5;
//    public static List<Double> pesos = new ArrayList<>();
//
//    public static void execute() {
//        pesos.add(0.5);
//
//        double erro = 1;
//
//        while (erro != 0){
//            int i = 0;
//            int indexPesoAtual = 0;
//            while(i != 4){
//                double ativacao = entrada[i][i] * pesos.get(pesos.size() - 1);
//
//                erro = saida[i] - ativacao;
//
//                if (erro != 0){
//                    pesos.add(pesos.get(indexPesoAtual) + n * erro * entrada[i][i]);
//                    indexPesoAtual++;
//                }
//
//                i++;
//            }
//        }
//
//        System.out.println("Peso: " + pesos.get(pesos.size() - 1));
//        System.out.println("N: " + n);
//
//
//    }
//
//}

import java.util.Random;

public class Perceptron {
    private double[] pesos;
    private double taxaAprendizado;
    private int epocas;

    public PerceptronOR(int tamanhoEntrada, double taxaAprendizado, int epocas) {
        this.pesos = new double[tamanhoEntrada];
        this.taxaAprendizado = taxaAprendizado;
        this.epocas = epocas;

        // Inicializa os pesos aleatoriamente
        Random rand = new Random();
        for (int i = 0; i < tamanhoEntrada; i++) {
            pesos[i] = rand.nextDouble();
        }
    }

    public int ativacao(double somaPonderada) {
        return (somaPonderada >= 0) ? 1 : 0;
    }

    public void treinar(int[][] entradas, int[] saidasDesejadas) {
        for (int epoca = 0; epoca < epocas; epoca++) {
            for (int i = 0; i < entradas.length; i++) {
                double somaPonderada = 0;
                for (int j = 0; j < entradas[i].length; j++) {
                    somaPonderada += entradas[i][j] * pesos[j];
                }
                int saidaCalculada = ativacao(somaPonderada);
                int erro = saidasDesejadas[i] - saidaCalculada;
                for (int j = 0; j < pesos.length; j++) {
                    pesos[j] += taxaAprendizado * erro * entradas[i][j];
                }
            }
        }
    }

    public int prever(int[] entrada) {
        double somaPonderada = 0;
        for (int i = 0; i < entrada.length; i++) {
            somaPonderada += entrada[i] * pesos[i];
        }
        return ativacao(somaPonderada);
    }

    public static void main(String[] args) {
        int[][] entradas = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        int[] saidasDesejadas = {0, 1, 1, 1};

        int tamanhoEntrada = entradas[0].length;
        double taxaAprendizado = 0.1;
        int epocas = 1000;

        PerceptronOR perceptron = new PerceptronOR(tamanhoEntrada, taxaAprendizado, epocas);
        perceptron.treinar(entradas, saidasDesejadas);

        System.out.println("Treinamento concluído. Pesos finais:");
        for (int i = 0; i < perceptron.pesos.length; i++) {
            System.out.println("Peso " + (i + 1) + ": " + perceptron.pesos[i]);
        }

        // Testando as previsões
        System.out.println("Testando previsões:");
        for (int i = 0; i < entradas.length; i++) {
            int[] entrada = entradas[i];
            int saidaPrevista = perceptron.prever(entrada);
            System.out.println("Entrada: [" + entrada[0] + ", " + entrada[1] + "] => Saída Prevista: " + saidaPrevista);
        }
    }
}
