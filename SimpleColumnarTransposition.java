// simple columnar

import java.util.Scanner;
public class SimpleColumnarTransposition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String message = scanner.nextLine().replaceAll("\\s+", "").toUpperCase();
        System.out.print("Enter the key: ");
        String key = scanner.nextLine().toUpperCase();
        String cipherText = simpleColumnarTransposition(message, key);
        System.out.println("Simple Columnar Transposition Cipher Text: " + cipherText);
        scanner.close();
    }
    public static String simpleColumnarTransposition(String message, String key) {
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
        StringBuilder cipherText = new StringBuilder();
        for (int c = 0; c < numColumns; c++) {
            for (int r = 0; r < numRows; r++) {
                cipherText.append(grid[r][c]);
            }
        }
        return cipherText.toString();
    }
}
