public class VernamCipher {
    public static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        if (plaintext.length() != key.length()) {
            throw new IllegalArgumentException("Key length must be equal to the message length.");
        }
        for (int i = 0; i < plaintext.length(); i++) {
            char encryptedChar = (char) (plaintext.charAt(i) ^ key.charAt(i));
            ciphertext.append(encryptedChar);
        } 
        return ciphertext.toString();
    }
    public static String decrypt(String ciphertext, String key) {
        StringBuilder decryptedText = new StringBuilder();
        
        if (ciphertext.length() != key.length()) {
            throw new IllegalArgumentException("Key length must be equal to the ciphertext length.");
        }
        
        for (int i = 0; i < ciphertext.length(); i++) {
            char decryptedChar = (char) (ciphertext.charAt(i) ^ key.charAt(i));
            decryptedText.append(decryptedChar);
        }
        
        return decryptedText.toString();
    }

    public static void main(String[] args) {
        String plaintext = "HELLO";
        String key = "XMCKL"; 
        
        String encrypted = encrypt(plaintext, key);
        System.out.println("Encrypted Text: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted Text: " + decrypted);
    }
}
