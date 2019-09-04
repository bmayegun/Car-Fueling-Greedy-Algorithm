import java.util.Scanner;

public class CarFueling {

    static int computeMinRefills(int dist, int tank, int[] stops)
    {
        int numOfRefills = 0;
        int tankval = tank;
        stops[0] = 0;
        stops[stops.length - 1] = dist;
        for (int i = 0; i < stops.length; i++) {
            if (i == 0 && stops[1] - tank > 0){
                return -1;
            }
            else if (i > 0 && stops[i] - stops[i - 1] > tank && stops[i] - stops[i - 1] <= tankval){
                numOfRefills++;
                tank = tankval;

            }
            else if (i > 0 && tankval < stops[i] - stops[i-1]){
                return -1;
            }
            if (i > 0){
            tank -= stops[i] - stops[i-1];
            }
            dist -= stops[i];
        }
            return numOfRefills;
        }
    public static void main (String args []){
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
