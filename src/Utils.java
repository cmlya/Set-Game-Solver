import java.util.ArrayList;
import java.util.Random;

public class Utils {
    public static int random01() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public static ArrayList<ArrayList<Integer>> allSetsOfThree(int[] set) {
        ArrayList<Integer> tmp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> tmpArray = new ArrayList<>();
        int n = set.length;
        for (int i = 0; i < (1<<n); i++) {
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) > 0)
                    tmp.add(set[j]);
            if (tmp.size() == 3) tmpArray.add(tmp);
            tmp = new ArrayList<>();
        }
        return tmpArray;
    }
}
