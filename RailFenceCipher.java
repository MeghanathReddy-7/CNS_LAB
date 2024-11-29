public class RailFenceCipher {
    public static String encrypt(String text, int key) {
        char[][] rail = new char[key][text.length()];
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < text.length(); j++) {
                rail[i][j] = '\n';
            }
        }

        int row = 0;
        boolean down = false;
        for (int i = 0; i < text.length(); i++) {
            rail[row][i] = text.charAt(i);
            if (row == 0 || row == key - 1) {
                down = !down;
            }
            row = down ? row + 1 : row - 1;
        }

        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < text.length(); j++) {
                if (rail[i][j] != '\n') {
                    cipherText.append(rail[i][j]);
                }
            }
        }
        return cipherText.toString();
    }

    public static String decrypt(String cipherText, int key) {
        char[][] rail = new char[key][cipherText.length()];
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < cipherText.length(); j++) {
                rail[i][j] = '\n';
            }
        }

        int row = 0;
        boolean down = false;
        for (int i = 0; i < cipherText.length(); i++) {
            rail[row][i] = '*';
            if (row == 0 || row == key - 1) {
                down = !down;
            }
            row = down ? row + 1 : row - 1;
        }

        int index = 0;
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < cipherText.length(); j++) {
                if (rail[i][j] == '*' && index < cipherText.length()) {
                    rail[i][j] = cipherText.charAt(index++);
                }
            }
        }

        StringBuilder decryptedText = new StringBuilder();
        row = 0;
        down = false;
        for (int i = 0; i < cipherText.length(); i++) {
            decryptedText.append(rail[row][i]);
            if (row == 0 || row == key - 1) {
                down = !down;
            }
            row = down ? row + 1 : row - 1;
        }
        return decryptedText.toString();
    }

    public static void main(String[] args) {
        String text = "HELLO";
        int key = 3;
        
        String encrypted = encrypt(text, key);
        System.out.println("Encrypted Text: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted Text: " + decrypted);
    }
}
