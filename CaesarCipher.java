public class CaesarCipher {
    public static void main(String[] args) {
        String plaintext = "HELLO";
        int shift = 3;

        String ciphertext = encrypt(plaintext, shift);
        System.out.println("Ciphertext: " + ciphertext);

        String decryptedText = decrypt(ciphertext, shift);
        System.out.println("Decrypted Text: " + decryptedText);
    }

    public static String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char shifted = (char) ('A' + (c - 'A' + shift) % 26);
                ciphertext.append(shifted);
            } else if (Character.isLowerCase(c)) {
                char shifted = (char) ('a' + (c - 'a' + shift) % 26);
                ciphertext.append(shifted);
            } else {
                ciphertext.append(c); // Keep non-alphabetic characters as is
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int shift) {
        StringBuilder plaintext = new StringBuilder();
        for (char c : ciphertext.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char shifted = (char) ('A' + (c - 'A' - shift + 26) % 26);
                plaintext.append(shifted);
            } else if (Character.isLowerCase(c)) {
                char shifted = (char) ('a' + (c - 'a' - shift + 26) % 26);
                plaintext.append(shifted);
            } else {
                plaintext.append(c); // Keep non-alphabetic characters as is
            }
        }
        return plaintext.toString();
    }
}
