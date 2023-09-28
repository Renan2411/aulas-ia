import java.util.ArrayList;
import java.util.List;

public class No {
    public No pai;
    int[][] estado;

    public int custo;

    List<No> caminho = new ArrayList<>();
    public int profundidade;

    public No() {
        this.custo = 1;
    }

    public No(No pai, int[][] estado, int profundidade) {
        this();
        this.pai = pai;
        this.estado = estado;
        this.profundidade = profundidade;
    }


    public void adicionarCaminho(No no){
        caminho.add(no);
    }

}
