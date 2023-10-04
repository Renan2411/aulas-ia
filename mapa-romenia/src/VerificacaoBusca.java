import java.util.List;
import java.util.stream.Collectors;

public class VerificacaoBusca {
    public static Boolean verificarNoExpandido(No no, List<No> expandidos) {
        List<No> adicionado = expandidos.stream().filter(x -> x.cidade == no.cidade).collect(Collectors.toList());

        return adicionado.isEmpty();
    }

    public static No verificarNoBorda(No no, List<No> borda) {
        List<No> noBorda = borda.stream().filter(x -> x.cidade == no.cidade).collect(Collectors.toList());

        return noBorda.isEmpty() ? null : noBorda.get(0);
    }

    public static Boolean verificarObjetivo(No estadoAtual, Cidade objetivo) {
        return estadoAtual.cidade == objetivo;
    }

    public static No removerBorda(List<No> borda) {
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
