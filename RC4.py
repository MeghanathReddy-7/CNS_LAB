def key_scheduling_algorithm(key):
    S = list(range(256))
    n = len(key)
    j = 0
    for i in range(256):
        j = (j + S[i] + key[i % n]) % 256
        S[j], S[i] = S[i], S[j]
    return S

def PRGA(S, n):
    i, j = 0, 0
    key_stream = []
    for _ in range(n):
        i = (i + 1) % 256
        j = (j + S[i]) % 256
        S[j], S[i] = S[i], S[j]
        k = S[(S[i] + S[j]) % 256]
        key_stream.append(k)
    return key_stream

def RC4(plain_text, key):
    key = [ord(c) for c in key]
    S = key_scheduling_algorithm(key)
    key_stream = PRGA(S, len(plain_text))
    cipher_text = ""
    for p, k in zip(plain_text, key_stream):
        cipher_text += chr(ord(p) ^ k)
    return cipher_text

# Example usage
key = "secretkey"
plaintext = "hello world"

# Encrypt the plaintext
ciphertext = RC4(plaintext, key)
print("Ciphertext:", ciphertext)

# Decrypt the ciphertext (RC4 is symmetric, same function for encryption and decryption)
decrypted_text = RC4(ciphertext, key)
print("Decrypted:", decrypted_text)
