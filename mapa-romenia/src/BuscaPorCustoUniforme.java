import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class BuscaPorCustoUniforme {
    public static final List<No> borda = new ArrayList<>();
    public static final List<No> expandidos = new ArrayList<>();

    public static void executar(Cidade objetivo, No estadoInicial) {
        borda.add(estadoInicial);

        No noAtual = removerBorda();
        int n = 0;

        while (!verificarObjetivo(noAtual, objetivo)) {
            expandirNo(noAtual);
            expandidos.add(noAtual);

            noAtual = removerBorda();
            n++;
        }

        while (!Objects.isNull(noAtual.pai)) {
            System.out.println(noAtual);
            noAtual = noAtual.pai;
        }

        System.out.println(noAtual);
        System.out.println();
        System.out.println("Borda");
        imprimirBorda();

        System.out.println();
        System.out.println("Expandidos");
        imprimirExpandidos();
    }

    public static void imprimirBorda(){
        for(No noBorda : borda){
            System.out.println(noBorda);
        }
    }

    public static void imprimirExpandidos(){
        for(No noBorda : expandidos){
            System.out.println(noBorda);
        }
    }

    public static void expandirNo(No no) {
        for (Vizinho vizinho : Mapa.getVizinhos(no.cidade)) {

            No novoNo = new No(vizinho.cidade, vizinho.distancia + no.custo, no);

            if (verificarNoExpandido(novoNo)) {

                No noBorda = verificarNoBorda(novoNo);

                if (!Objects.isNull(noBorda)) {
                    if (novoNo.custo < noBorda.custo) {
                        borda.add(borda.indexOf(noBorda), novoNo);
                    } else {
                        borda.add(novoNo);
                    }
                } else {
                    borda.add(novoNo);
                }
            }
        }
    }

    public static Boolean verificarNoExpandido(No no) {
        List<No> adicionado = expandidos.stream().filter(x -> x.cidade == no.cidade).collect(Collectors.toList());

        return adicionado.isEmpty();
    }

    public static No verificarNoBorda(No no) {
        List<No> noBorda = borda.stream().filter(x -> x.cidade == no.cidade).collect(Collectors.toList());

        return noBorda.isEmpty() ? null : noBorda.get(0);
    }

    public static Boolean verificarObjetivo(No estadoAtual, Cidade objetivo) {
        return estadoAtual.cidade == objetivo;
    }

    public static No removerBorda() {
        No no = borda.get(0);

        for (No noBorda : borda) {
            if (noBorda.custo < no.custo) {
                no = noBorda;
            }
        }

        borda.remove(no);

        return no;
    }
}
