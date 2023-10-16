import java.util.ArrayList;
import java.util.List;

public class Mapa {

    public static List<Vizinho> getVizinhos(Cidade cidade) {
        List<Vizinho> vizinhos = new ArrayList<>();
        switch (cidade) {
            case ARAD:
                vizinhos.add(new Vizinho(Cidade.SIBIU, 140, 253));
                vizinhos.add(new Vizinho(Cidade.TIMISOARA, 118, 329));
                vizinhos.add(new Vizinho(Cidade.ZERIND, 75, 374));
                break;
            case BUCHAREST:
                vizinhos.add(new Vizinho(Cidade.FAGARAS, 211, 176));
                vizinhos.add(new Vizinho(Cidade.GIURGIU, 90, 77));
                vizinhos.add(new Vizinho(Cidade.PITESTI, 101, 10));
                vizinhos.add(new Vizinho(Cidade.URZICENI, 85, 80));
                break;
            case CRAIOVA:
                vizinhos.add(new Vizinho(Cidade.DOBRETA, 120, 242));
                vizinhos.add(new Vizinho(Cidade.PITESTI, 138, 10));
                vizinhos.add(new Vizinho(Cidade.RIMNICU_VILCEA, 146, 193));
                break;
            case DOBRETA:
                vizinhos.add(new Vizinho(Cidade.CRAIOVA, 120, 160));
                vizinhos.add(new Vizinho(Cidade.MEHADIA, 75, 241));
                break;
            case EFORIE:
                vizinhos.add(new Vizinho(Cidade.HIRSOWA, 86, 151));
                break;
            case FAGARAS:
                vizinhos.add(new Vizinho(Cidade.BUCHAREST, 211, 0));
                vizinhos.add(new Vizinho(Cidade.SIBIU, 99, 253));
                break;
            case GIURGIU:
                vizinhos.add(new Vizinho(Cidade.BUCHAREST, 90, 0));
                break;
            case HIRSOWA:
                vizinhos.add(new Vizinho(Cidade.EFORIE, 86, 161));
                vizinhos.add(new Vizinho(Cidade.URZICENI, 211, 80));
                break;
            case LASI:
                vizinhos.add(new Vizinho(Cidade.NEAMT, 87, 234));
                vizinhos.add(new Vizinho(Cidade.VASLUI, 92, 199));
                break;
            case LUGOJ:
                vizinhos.add(new Vizinho(Cidade.MEHADIA, 70, 241));
                vizinhos.add(new Vizinho(Cidade.TIMISOARA, 111, 329));
                break;
            case MEHADIA:
                vizinhos.add(new Vizinho(Cidade.DOBRETA, 75, 242));
                vizinhos.add(new Vizinho(Cidade.LUGOJ, 70, 244));
                break;
            case NEAMT:
                vizinhos.add(new Vizinho(Cidade.LASI, 87, 226));
                break;
            case ORADEA:
                vizinhos.add(new Vizinho(Cidade.SIBIU, 151, 253));
                vizinhos.add(new Vizinho(Cidade.ZERIND, 71, 374));
                break;
            case PITESTI:
                vizinhos.add(new Vizinho(Cidade.BUCHAREST, 101, 0));
                vizinhos.add(new Vizinho(Cidade.CRAIOVA, 138, 160));
                vizinhos.add(new Vizinho(Cidade.RIMNICU_VILCEA, 97, 193));
                break;
            case RIMNICU_VILCEA:
                vizinhos.add(new Vizinho(Cidade.CRAIOVA, 146, 160));
                vizinhos.add(new Vizinho(Cidade.PITESTI, 97, 100));
                vizinhos.add(new Vizinho(Cidade.SIBIU, 80, 253));
                break;
            case SIBIU:
                vizinhos.add(new Vizinho(Cidade.ARAD, 140, 366));
                vizinhos.add(new Vizinho(Cidade.FAGARAS, 99, 176));
                vizinhos.add(new Vizinho(Cidade.ORADEA, 151, 380));
                vizinhos.add(new Vizinho(Cidade.RIMNICU_VILCEA, 80, 193));
                break;
            case TIMISOARA:
                vizinhos.add(new Vizinho(Cidade.ARAD, 118, 366));
                vizinhos.add(new Vizinho(Cidade.LUGOJ, 111, 244));
                break;
            case URZICENI:
                vizinhos.add(new Vizinho(Cidade.BUCHAREST, 85, 0));
                vizinhos.add(new Vizinho(Cidade.HIRSOWA, 98, 151));
                vizinhos.add(new Vizinho(Cidade.VASLUI, 142, 199));
                break;
            case VASLUI:
                vizinhos.add(new Vizinho(Cidade.LASI, 92, 226));
                vizinhos.add(new Vizinho(Cidade.URZICENI, 142, 80));
                break;
            case ZERIND:
                vizinhos.add(new Vizinho(Cidade.ARAD, 75, 366));
                vizinhos.add(new Vizinho(Cidade.ORADEA, 71, 380));

        }
        return vizinhos;
    }

}
