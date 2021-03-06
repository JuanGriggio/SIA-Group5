package geneticAlgorithm.selection;

import models.player.Player;

import java.util.Collection;

public class Selector {
    private final SelectionMethod method1;
    private final SelectionMethod method2;
    private final int k1;
    private final int k2;

    public Selector(SelectionMethod method1, SelectionMethod method2, double a, int k) {
        this.method1 = method1;
        this.method2 = method2;
        this.k1 = (int) (a*k);
        this.k2 = k - k1;
    }

    public Collection<Player> select(Collection<Player> players, int generation){
        Collection<Player> selection1 = method1.select(players, k1, generation);
        Collection<Player> selection2 = method2.select(players, k2, generation);
        selection1.addAll(selection2);
        return selection1;
    }
}
