import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BuscaAhEstrela {
    public static final List<No> borda = new ArrayList<>();
    public static final List<No> expandidos = new ArrayList<>();

    public static void executar(Cidade objetivo, No estadoInicial) {
        borda.add(estadoInicial);

        No noAtual = removerBorda();
        expandidos.add(noAtual);
        int n = 0;

        while (!VerificacaoBusca.verificarObjetivo(noAtual, objetivo)) {
            expandirNo(noAtual);
            expandidos.add(noAtual);

            noAtual = VerificacaoBusca.removerBorda(borda);
            n++;
        }

        while (!Objects.isNull(noAtual.pai)) {
            System.out.println(noAtual);
            noAtual = noAtual.pai;
        }

        System.out.println(noAtual);
    }

    public static void expandirNo(No no) {
        for (Vizinho vizinho : Mapa.getVizinhos(no.cidade)) {

            No novoNo = new No(vizinho.cidade, vizinho.ldr + vizinho.distancia + no.custo, no);

            if (VerificacaoBusca.verificarNoExpandido(novoNo, expandidos)) {

                No noBorda = VerificacaoBusca.verificarNoBorda(novoNo, borda);

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

}
