package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Ponto {
    double x, y;
    double distancia;
    String classe;

    public Ponto(double x, double y, String classe) {
        this.x = x;
        this.y = y;
        this.classe = classe;
    }
}

public class KNN {
    private List<Ponto> pontos;

    public KNN(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    public String classificarPonto(Ponto ponto, int k) {
        List<Ponto> vizinhos = encontrarVizinhosMaisProximos(ponto, k);
        return obterClasseMaisFrequente(vizinhos);
    }

    private List<Ponto> encontrarVizinhosMaisProximos(Ponto ponto, int k) {
        List<Ponto> vizinhos = new ArrayList<>();

        for (Ponto outroPonto : pontos) {
            double distancia = calcularDistancia(ponto, outroPonto);
            outroPonto.distancia = distancia;
            vizinhos.add(outroPonto);
        }

        // Ordenar os pontos pela distância
        Collections.sort(vizinhos, Comparator.comparingDouble(p -> p.distancia));

        // Retornar os k vizinhos mais próximos
        return vizinhos.subList(0, k);
    }

    private double calcularDistancia(Ponto ponto1, Ponto ponto2) {
        return Math.sqrt(Math.pow(ponto1.x - ponto2.x, 2) + Math.pow(ponto1.y - ponto2.y, 2));
    }

    private String obterClasseMaisFrequente(List<Ponto> vizinhos) {
        int classeA = 0, classeB = 0;

        for (Ponto vizinho : vizinhos) {
            if (vizinho.classe.equals("A")) {
                classeA++;
            } else if (vizinho.classe.equals("B")) {
                classeB++;
            }
        }

        return classeA > classeB ? "A" : "B";
    }

    public static void main(String[] args) {
        List<Ponto> dados = new ArrayList<>();
        dados.add(new Ponto(1.0, 2.0, "A"));
        dados.add(new Ponto(2.0, 3.0, "A"));
        dados.add(new Ponto(3.0, 4.0, "B"));
        dados.add(new Ponto(4.0, 5.0, "B"));

        KNN knn = new KNN(dados);

        // Ponto a ser classificado
        Ponto pontoDesconhecido = new Ponto(3.5, 3.5, "");

        // Classificar o ponto desconhecido com k = 3
        String classePredita = knn.classificarPonto(pontoDesconhecido, 3);

        System.out.println("O ponto pertence à classe: " + classePredita);
    }
}