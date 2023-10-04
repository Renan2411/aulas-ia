import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class BuscaEmProfundidade {
    public static final Stack<No> borda = new Stack<>();
    public static final List<No> expandidos = new ArrayList<>();

    public static void executar(Cidade objetivo, No estadoInicial) {

        borda.push(estadoInicial);

        No noAtual = removerBorda();

        while (!verificarObjetivo(noAtual, objetivo)) {
            expandirNo(noAtual);

            expandidos.add(noAtual);
            noAtual = removerBorda();

        }

        while (!Objects.isNull(noAtual.pai)) {
            System.out.println(noAtual);
            noAtual = noAtual.pai;
        }

        System.out.println(noAtual);

    }

    public static void expandirNo(No no) {
        for (Vizinho vizinho : Mapa.getVizinhos(no.cidade)) {

            No novoNo = new No(vizinho.cidade, vizinho.distancia, no);

            List<No> adicionados = expandidos.stream().filter(x -> x.cidade == novoNo.cidade).collect(Collectors.toList());

            if (adicionados.isEmpty()) {
                borda.push(novoNo);
            }

        }
    }
    public static Boolean verificarObjetivo(No estadoAtual, Cidade objetivo) {
        return estadoAtual.cidade == objetivo;
    }

    public static No removerBorda() {
        return borda.pop();
    }

}
