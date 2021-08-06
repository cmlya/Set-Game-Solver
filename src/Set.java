public class Set {
    SetOfThree cards;

    public Set(SetOfThree cards) {
        this.cards = cards;
        Database.getInstance().addSet(this);
    }
}