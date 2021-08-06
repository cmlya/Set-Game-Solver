import java.util.ArrayList;

public class SetOfThree {
    Card[] cards;

    public SetOfThree(Card[] cards) {
        this.cards = cards;
        Database.getInstance().addSetOfThree(this);
    }

    public void checkSet() {
        ArrayList<Integer> sums = new ArrayList<>();
        int red = cards[0].red + cards[1].red + cards[2].red;
        int green = cards[0].green + cards[1].green + cards[2].green;
        int purple = cards[0].purple + cards[1].purple + cards[2].purple;
        int oval = cards[0].oval + cards[1].oval + cards[2].oval;
        int squiggle = cards[0].squiggle + cards[1].squiggle + cards[2].squiggle;
        int rhombus = cards[0].rhombus + cards[1].rhombus + cards[2].rhombus;
        int one = cards[0].one + cards[1].one + cards[2].one;
        int two = cards[0].two + cards[1].two + cards[2].two;
        int three = cards[0].three + cards[1].three + cards[2].three;
        int empty = cards[0].empty + cards[1].empty + cards[2].empty;
        int striped = cards[0].striped + cards[1].striped + cards[2].striped;
        int solid = cards[0].solid + cards[1].solid + cards[2].solid;
        sums.add(red);
        sums.add(green);
        sums.add(purple);
        sums.add(oval);
        sums.add(squiggle);
        sums.add(rhombus);
        sums.add(one);
        sums.add(two);
        sums.add(three);
        sums.add(empty);
        sums.add(striped);
        sums.add(solid);
        if (!sums.contains(2)) new Set(this);
    }
}