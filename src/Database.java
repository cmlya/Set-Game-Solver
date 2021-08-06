import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Database {
    private final ArrayList<Card> cards = new ArrayList<>();
    private final ArrayList<SetOfThree> setsOfThree = new ArrayList<>();
    private final ArrayList<Set> sets = new ArrayList<>();

    static Database database;

    static Database getInstance() {
        if (database == null) read();
        return database;
    }

    private Database() {
    }

    static void read() {
        Gson gson = new Gson();
        try {
            FileReader fileReader = new FileReader("cards.json");
            database = gson.fromJson(fileReader, Database.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void write() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("cards.json")) {
            gson.toJson(database, writer);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCard(Card card) { cards.add(card); write();}
    public void addSetOfThree(SetOfThree setOfThree) { setsOfThree.add(setOfThree); write();}
    public void addSet(Set set) { sets.add(set); write();}
    public ArrayList<Card> getCards() { return cards; }
    public ArrayList<SetOfThree> getSetsOfThree() { return setsOfThree; }
    public ArrayList<Set> getSets() { return sets; }
}
