import java.util.Arrays;
import java.util.Scanner;

public class Psbb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of families
        System.out.print("Input the number of families : ");
        int n = scanner.nextInt();
        scanner.nextLine();

        // Read the number of members in each family
        System.out.print("Input the number of members in the family (separated by a space) : ");
        String inputLine = scanner.nextLine();

        // Split input line into array of strings
        String[] membersString = inputLine.split(" ");

        // Validate number of members input
        if (membersString.length != n) {
            System.out.println("Input must be equal with count of family");
            scanner.close();
            return;
        }

        // Parse membersString into array of integers (family sizes)
        int[] familySizes = new int[n];
        for (int i = 0; i < n; i++) {
            familySizes[i] = Integer.parseInt(membersString[i]);;
        }

        // Sort family sizes to facilitate combining families efficiently
        Arrays.sort(familySizes);

        int i = 0, j = n - 1;
        int totalBuses = 0;

        // Calculate minimum number of minibuses
        while (i <= j) {
            if (familySizes[i] + familySizes[j] <= 4) {
                i++;
                j--;
            } else {
                j--;
            }
            totalBuses++;
        }

        // Output the result
        System.out.println("Minimum bus required is : " + totalBuses);

        scanner.close();
    }
}
