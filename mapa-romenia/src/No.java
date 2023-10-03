import java.util.ArrayList;
import java.util.List;

public class No {
    public Cidade cidade;
    public List<Vizinho> vizinhos = new ArrayList<>();
    public int custo;

    public  No pai;

    public No(Cidade cidade, int custo, No pai) {
        this.cidade = cidade;
        this.custo = custo;
        this.pai = pai;
    }

    @Override
    public String toString(){
        return "Cidade = " + this.cidade + " Custo = " + this.custo;
    }
}
