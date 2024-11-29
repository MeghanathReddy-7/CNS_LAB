import java.util.Scanner;
public class PlayfairCipher {
    private static char[][] keyMatrix = new char[5][5];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the key (no repeated characters): ");
        String key = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        System.out.print("Enter the plaintext: ");
        String plaintext = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        generateKeyMatrix(key);
        String encryptedText = encrypt(plaintext);
        System.out.println("Encrypted Text: " + encryptedText);
        String decryptedText = decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
        sc.close();
    }

    private static void generateKeyMatrix(String key) {
        boolean[] used = new boolean[26];
        int row = 0, col = 0;
        for (char c : key.toCharArray()) {
            if (!used[c - 'A']) {
                keyMatrix[row][col] = c;
                used[c - 'A'] = true;
                col++;
                if (col == 5) {
                    col = 0;
                    row++;
                }
            }
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (!used[c - 'A'] && c != 'J') {
                keyMatrix[row][col] = c;
                col++;
                if (col == 5) {
                    col = 0;
                    row++;
                }
            }
        }
    }

    private static String preprocess(String text) {
        StringBuilder processedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            processedText.append(current);
            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
                processedText.append('X');
            }
        }
        if (processedText.length() % 2 != 0) {
            processedText.append('X');
        }
        return processedText.toString();
    }


    private static String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        plaintext = preprocess(plaintext);
        for (int i = 0; i < plaintext.length(); i += 2) {
            char a = plaintext.charAt(i);
            char b = plaintext.charAt(i + 1);
            int[] pos1 = findPosition(a);
            int[] pos2 = findPosition(b);
            if (pos1[0] == pos2[0]) {
                ciphertext.append(keyMatrix[pos1[0]][(pos1[1] + 1) % 5]);
                ciphertext.append(keyMatrix[pos2[0]][(pos2[1] + 1) % 5]);
            } else if (pos1[1] == pos2[1]) {
                ciphertext.append(keyMatrix[(pos1[0] + 1) % 5][pos1[1]]);
                ciphertext.append(keyMatrix[(pos2[0] + 1) % 5][pos2[1]]);
            } else {
                ciphertext.append(keyMatrix[pos1[0]][pos2[1]]);
                ciphertext.append(keyMatrix[pos2[0]][pos1[1]]);
            }
        }
        return ciphertext.toString();
    }

    private static String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i += 2) {
            char a = ciphertext.charAt(i);
            char b = ciphertext.charAt(i + 1);
            int[] pos1 = findPosition(a);
            int[] pos2 = findPosition(b);
            if (pos1[0] == pos2[0]) {
                plaintext.append(keyMatrix[pos1[0]][(pos1[1] + 4) % 5]);
                plaintext.append(keyMatrix[pos2[0]][(pos2[1] + 4) % 5]);
            } else if (pos1[1] == pos2[1]) {
                plaintext.append(keyMatrix[(pos1[0] + 4) % 5][pos1[1]]);
                plaintext.append(keyMatrix[(pos2[0] + 4) % 5][pos2[1]]);
            } else {
                plaintext.append(keyMatrix[pos1[0]][pos2[1]]);
                plaintext.append(keyMatrix[pos2[0]][pos1[1]]);
            }
        }
        return plaintext.toString();
    }

    private static int[] findPosition(char c) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (keyMatrix[row][col] == c) {
                    return new int[]{row, col};                                                                                                                                                                                                                                                               
                }
            }
        }
        return null;
    }
}
