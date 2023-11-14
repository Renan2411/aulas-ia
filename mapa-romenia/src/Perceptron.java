import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Perceptron {

    public static void teste(){
        double n = 1.5;
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

    public static void testeExclusivo(){
        double n = 1.5;
        double[] peso = {-1.4, 2.8, 0.5, 0.5};

        int[] entrada = {1, 0};

        double y1 = peso[0] * entrada[0] + peso[1] * entrada[1];
        double y2 = peso[0] * entrada[0] + peso[1] * entrada[1];
        double y3 = peso[2] * entrada[0] + peso[3] * y1;
        double y4 = peso[2] * entrada[1] + peso[3] * y2;
        double y5 = peso[2] * y3 + peso[3] * y4;

        double saidaAtual = 0.0;

        if(y5 >= n){
            saidaAtual = 1.0;
        }else{
            saidaAtual = 0.0;
        }

        System.out.println(saidaAtual);

    }

    public static void executeOU() {
        int[][] entrada = {{1, 1}, {0, 0}, {1, 0}, {0, 1}};
        int[] saida = {1, 0, 1, 1};
        double n = 1.5;
        double[] pesos = {0.5, 0.5};

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
                pesos[2] = pesos[2] + 0.01 * erro * entrada[i][0];
                pesos[3] = pesos[3] + 0.01 * erro * entrada[i][1];

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

    public static void executeOuExclusivo() {
        int[][] entrada = {{1, 1}, {0, 0}, {1, 0}, {0, 1}};
        int[] saida = {0, 0, 1, 1};
        double n = 1.5;
        double[] pesos = {0.5, 0.5, 0.5, 0.5};

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

                double y1 = pesos[0] * entrada[i][0] + pesos[1] * entrada[i][1];
                if(y1 >= n){ //limiar
                    saidaAtual = 1.0;
                }else{
                    saidaAtual = 0.0;
                }
                erro += saida[i] - saidaAtual;

                double y2 = pesos[0] * entrada[i][0] + pesos[1] * entrada[i][1];
                if(y2 >= n){ //limiar
                    saidaAtual = 1.0;
                }else{
                    saidaAtual = 0.0;
                }
                erro += saida[i] - saidaAtual;

                double y3 = pesos[2] * entrada[i][0] + pesos[3] * y1;
                if(y3 >= n){ //limiar
                    saidaAtual = 1.0;
                }else{
                    saidaAtual = 0.0;
                }
                erro += saida[i] - saidaAtual;

                double y4 = pesos[2] * entrada[i][1] + pesos[3] * y2;
                if(y4 >= n){ //limiar
                    saidaAtual = 1.0;
                }else{
                    saidaAtual = 0.0;
                }
                erro += saida[i] - saidaAtual;

                double y5 = pesos[2] * y3 + pesos[3] * y4;
                if(y5 >= n){ //limiar
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
                pesos[2] = pesos[2] + 0.01 * erro * y1;
                pesos[3] = pesos[3] + 0.01 * erro * y2;

                i++;
                interacoes++;
            }

            if (erro != 0.0) {
                System.out.println("PESO: " + pesos[0] + " " + pesos[1] + "" + pesos[2] + " " + pesos[3]);
                indexPesoAtual++;
            }

        }

        System.out.println("PESO: " + pesos[0] + " " + pesos[1] + " " + pesos[2] + " " + pesos[3]);
    }

}
