package Assignment_11;

public class SignalCapacity {

    public static void main(String[] args) {
        
        int[] tHeights = {100, 80, 60, 70, 60, 75, 85};

       
        int[] tPowers = TowerPowers(tHeights);
        for (int i = 0; i < tHeights.length; i++) {
            System.out.print(tPowers[i] + " ");
        }
    }

    private static int[] TowerPowers(int[] tHeights) {
        int n = tHeights.length;
        int[] towerPowers = new int[n];

        for (int i = 0; i < n; i++) {
            int p = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (tHeights[j] <= tHeights[i]) {
                    p++;
                } else {
                    break; 
                }
            }
            towerPowers[i] = p + 1; 
        }

        return towerPowers;
    }
}
