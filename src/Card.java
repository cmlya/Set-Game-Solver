import java.util.Random;

public class Card {
    final int red, green, purple;
    final int oval, squiggle, rhombus;
    final int one, two, three;
    final int empty, striped, solid;
    int[] specs;

    public Card(int[] s) {
        this.specs = s;
        this.red = specs[0];
        this.green = specs[1];
        this.purple = specs[2];
        this.oval = specs[3];
        this.squiggle = specs[4];
        this.rhombus = specs[5];
        this.one = specs[6];
        this.two = specs[7];
        this.three = specs[8];
        this.empty = specs[9];
        this.striped = specs[10];
        this.solid = specs[11];
        Database.getInstance().addCard(this);
    }

    // Creates one random card
    public static void randomCard() {
        Card card;
        int color, shape, number, fill;
        Random random = new Random();
        color = random.nextInt(3);
        shape = random.nextInt(3);
        number = random.nextInt(3);
        fill = random.nextInt(3);
        int[] specs = new int[12];
        specs[color] = 1;
        specs[shape + 3] = 1;
        specs[number + 6] = 1;
        specs[fill + 9] = 1;
        boolean cardExists = false;
        for (Card c : Database.getInstance().getCards())
            if (c.specs == specs) {
                cardExists = true;
                break;
            }
        while (cardExists) {
            color = random.nextInt(3);
            shape = random.nextInt(3);
            number = random.nextInt(3);
            fill = random.nextInt(3);
            specs = new int[12];
            specs[color] = 1;
            specs[shape + 3] = 1;
            specs[number + 6] = 1;
            specs[fill + 9] = 1;
            cardExists = false;
            for (Card c : Database.getInstance().getCards())
                if (c.specs == specs) {
                    cardExists = true;
                    break;
                }
        }
        card = new Card(specs);
    }

    static void dozen() {
        for (int i = 0; i < 12; i++) randomCard();
    }
}