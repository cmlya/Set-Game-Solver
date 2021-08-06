import java.util.ArrayList;

public class SetSolver {
    public void run() {
        // Database.read();
        Card.dozen();
        createSetsOfThree();
        findSets();
    }

    private void createSetsOfThree() {
        int[] tmp = new int[Database.getInstance().getCards().size()];
        for (int i = 0; i < tmp.length; i++) tmp[i] = i;
        Card[] cards = new Card[3];
        ArrayList<ArrayList<Integer>> allSetsOfThree = Utils.allSetsOfThree(tmp);
        for (ArrayList<Integer> integers : allSetsOfThree) {
            for (int j = 0; j < 3; j++) cards[j] = Database.getInstance().getCards().get(integers.get(j));
            new SetOfThree(cards);
            cards = new Card[3];
        }
    }

    private void findSets() {
        for (SetOfThree setOfThree : Database.getInstance().getSetsOfThree()) setOfThree.checkSet();
    }
}