import java.util.HashMap;
import java.util.Map;
public class SubstitutionCipher {
    public static void main(String[] args) {
        String plaintext = "HELLO";
        String key = "QWERTYUIOPASDFGHJKLZXCVBNM"; // Random substitution key
        String ciphertext = encrypt(plaintext, key);
        System.out.println("Ciphertext: " + ciphertext);
        String decryptedText = decrypt(ciphertext, key);
        System.out.println("Decrypted Text: " + decryptedText);
    }
    public static String encrypt(String plaintext, String key) {
        Map<Character, Character> substitutionMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            substitutionMap.put((char) ('A' + i), key.charAt(i));
        }
        StringBuilder ciphertext = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            if (substitutionMap.containsKey(c)) {
                ciphertext.append(substitutionMap.get(c));
            } else {
                ciphertext.append(c); // Keep non-alphabetic characters as is
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        Map<Character, Character> reverseMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            reverseMap.put(key.charAt(i), (char) ('A' + i));
        }
        StringBuilder plaintext = new StringBuilder();
        for (char c : ciphertext.toCharArray()) {
            if (reverseMap.containsKey(c)) {
                plaintext.append(reverseMap.get(c));
            } else {
                plaintext.append(c);
            }
        }
        return plaintext.toString();
    }
}
