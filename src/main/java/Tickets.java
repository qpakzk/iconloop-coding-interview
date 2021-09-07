import java.util.*;

public class Tickets {

    public Boolean tickets(List<Integer> people) {
        Map<Integer, Integer> wallet = createWallet();

        for (int person : people) {
            if (person == 25) {
                int count25 = wallet.get(25);
                wallet.put(25, ++count25);
            } else if (person == 50) {
                int count25 = wallet.get(25);
                int count50 = wallet.get(50);

                if (count25 == 0) return false;

                wallet.put(25, --count25);
                wallet.put(50, ++count50);
            } else {
                int count25 = wallet.get(25);
                int count50 = wallet.get(50);
                int count100 = wallet.get(100);

                if (count25 == 0 || count50 == 0 && (count25 < 3)) return false;

                if (count50 == 0) {
                    count25 -= 3;
                    wallet.put(25, count25);
                } else {
                    wallet.put(25, --count25);
                    wallet.put(50, --count50);
                }

                wallet.put(100, ++count100);
            }
        }

        return true;
    }

    private Map<Integer, Integer> createWallet() {
        Map<Integer, Integer> wallet = new HashMap<>();
        wallet.put(25, 0);
        wallet.put(50, 0);
        wallet.put(100, 0);
        return wallet;
    }
}
