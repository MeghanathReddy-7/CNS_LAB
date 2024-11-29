// adv columnar
import java.util.Arrays;
import java.util.Scanner;
public class AdvancedColumnarTransposition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String message = scanner.nextLine().replaceAll("\\s+", "").toUpperCase();
        System.out.print("Enter the key: ");
        String key = scanner.nextLine().toUpperCase();
        String cipherText = advancedColumnarTransposition(message, key);
        System.out.println("Advanced Columnar Transposition Cipher Text: " + cipherText);
        scanner.close();
    }
    public static String advancedColumnarTransposition(String message, String key) {
        int numColumns = key.length();
        int numRows = (int) Math.ceil((double) message.length() / numColumns);
        char[][] grid = new char[numRows][numColumns];
        int index = 0;
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numColumns; c++) {
                if (index < message.length()) {
                    grid[r][c] = message.charAt(index++);
                } else {
                    grid[r][c] = 'X'; 
                }
            }
        }
        Integer[] colOrder = new Integer[numColumns];
        for (int i = 0; i < numColumns; i++) {
            colOrder[i] = i;
        }
        Arrays.sort(colOrder, (i1, i2) -> Character.compare(key.charAt(i1), key.charAt(i2)));
        StringBuilder cipherText = new StringBuilder();
        for (int c : colOrder) {
            for (int r = 0; r < numRows; r++) {
                cipherText.append(grid[r][c]);
            }
        }
        return cipherText.toString();
    }
}