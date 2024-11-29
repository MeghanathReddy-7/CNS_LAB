import java.util.Scanner;
public class SimpleHillCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] keyMatrix = {
            {3, 3},
            {2, 5}
        };
        System.out.print("Enter plaintext (must have even length): ");
        String plaintext = sc.nextLine().toUpperCase().replaceAll("\\s", "");

        if (plaintext.length() % 2 != 0) {
            plaintext += "X";
        }

        String ciphertext = encrypt(plaintext, keyMatrix);
        System.out.println("Ciphertext: " + ciphertext);

        String decryptedText = decrypt(ciphertext, keyMatrix);
        System.out.println("Decrypted Text: " + decryptedText);

        sc.close();
    }

    public static String encrypt(String plaintext, int[][] keyMatrix) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i += 2) {
            int x1 = plaintext.charAt(i) - 'A';
            int x2 = plaintext.charAt(i + 1) - 'A';
            int c1 = (keyMatrix[0][0] * x1 + keyMatrix[0][1] * x2) % 26;
            int c2 = (keyMatrix[1][0] * x1 + keyMatrix[1][1] * x2) % 26;
            ciphertext.append((char) (c1 + 'A'));
            ciphertext.append((char) (c2 + 'A'));
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int[][] keyMatrix) {
        StringBuilder plaintext = new StringBuilder();
        int determinant = (keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0]) % 26;
        determinant = (determinant + 26) % 26;
        int determinantInverse = modInverse(determinant, 26);

        int[][] inverseMatrix = new int[2][2];
        inverseMatrix[0][0] = (keyMatrix[1][1] * determinantInverse) % 26;
        inverseMatrix[0][1] = (-keyMatrix[0][1] * determinantInverse + 26) % 26;
        inverseMatrix[1][0] = (-keyMatrix[1][0] * determinantInverse + 26) % 26;
        inverseMatrix[1][1] = (keyMatrix[0][0] * determinantInverse) % 26;

        for (int i = 0; i < ciphertext.length(); i += 2) {
            int c1 = ciphertext.charAt(i) - 'A';
            int c2 = ciphertext.charAt(i + 1) - 'A';
            int p1 = (inverseMatrix[0][0] * c1 + inverseMatrix[0][1] * c2) % 26;
            int p2 = (inverseMatrix[1][0] * c1 + inverseMatrix[1][1] * c2) % 26;
            plaintext.append((char) (p1 + 'A'));
            plaintext.append((char) (p2 + 'A'));
        }
        return plaintext.toString();
    }

    public static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        throw new ArithmeticException("Modular inverse does not exist!");
    }
}
