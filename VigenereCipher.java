public class VigenereCipher {

    public static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        key = key.toUpperCase();
        plaintext = plaintext.toUpperCase();
        
        int keyIndex = 0;
        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            if (Character.isLetter(currentChar)) {
                char keyChar = key.charAt(keyIndex % key.length());
                int shift = keyChar - 'A';
                char encryptedChar = (char) ((currentChar - 'A' + shift) % 26 + 'A');
                ciphertext.append(encryptedChar);
                keyIndex++;
            } else {
                ciphertext.append(currentChar);
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();
        key = key.toUpperCase();
        ciphertext = ciphertext.toUpperCase();
        
        int keyIndex = 0;
        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);
            if (Character.isLetter(currentChar)) {
                char keyChar = key.charAt(keyIndex % key.length());
                int shift = keyChar - 'A';
                char decryptedChar = (char) ((currentChar - 'A' - shift + 26) % 26 + 'A');
                plaintext.append(decryptedChar);
                keyIndex++;
            } else {
                plaintext.append(currentChar);
            }
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        String plaintext = "HELLO";
        String key = "KEY";
        
        String encrypted = encrypt(plaintext, key);
        System.out.println("Encrypted Text: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted Text: " + decrypted);
    }
}
