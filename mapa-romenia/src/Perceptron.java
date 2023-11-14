import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Perceptron {

    public static int[][] entrada = {{1, 1}, {0, 0}, {1, 0}, {0, 1}};
    public static int[] saida = {1, 0, 1, 1};
    public static double n = 1.5;
    public static double[] pesos = {0.5, 0.5};

    public static void teste(){
        double[] pesoTeste = {0.899, 0.899};

        int[] entrada = {1, 1};

        double u = pesoTeste[0] * entrada[0] + pesoTeste[1] * entrada[1];

        double saidaAtual = 0.0;

        if(u >= n){
            saidaAtual = 1.0;
        }else{
            saidaAtual = 0.0;
        }

        System.out.println(saidaAtual);

    }

    public static void execute() {
        double erro = 1;
        int i = 0;
        int indexPesoAtual = 0;
        erro = 1;
        int interacoes = 1;
        double saidaAtual = 0.0;
        while (erro != 0) {
            i = 0;
            erro = 0;
            while (i != 4) {

                System.out.println("Interação: " + interacoes);
                System.out.println("Pesos: " + pesos[0] + " " + pesos[1]);

                double u = pesos[0] * entrada[i][0] + pesos[1] * entrada[i][1];

                if(u >= n){ //limiar
                    saidaAtual = 1.0;
                }else{
                    saidaAtual = 0.0;
                }


                erro += saida[i] - saidaAtual;

                System.out.println("ERRO: " + erro);
                System.out.println("=======================");
                System.out.println();

                pesos[0] = pesos[0] + 0.01 * erro * entrada[i][0];
                pesos[1] = pesos[1] + 0.01 * erro * entrada[i][1];

                i++;
                interacoes++;
            }

            if (erro != 0.0) {
                System.out.println("PESO: " + pesos[0] + " " + pesos[1]);
                indexPesoAtual++;
            }

        }

        System.out.println("PESO: " + pesos[0] + " " + pesos[1]);
    }

}
