import math

def gcd(a, b):
    if b==0:
        return a
    return gcd(b,a%b)

# Function to compute the modular inverse of e modulo phi
def mod_inverse(e, phi):
    for x in range(1, phi):
        if (e * x) % phi == 1:
            return x

# RSA Key Generation (using small prime numbers for simplicity)
p = 3
q = 7
n = p * q
phi = (p - 1) * (q - 1)

# Choose public exponent e (e must be coprime with phi)
e = 2
while gcd(e, phi) != 1:
    e += 1

# Calculate private key d (modular inverse of e mod phi)
d = mod_inverse(e, phi)

# RSA Encryption
msg = 12  # Message data as an integer
print("Message data =", msg)

# Encrypting the message (c = (msg^e) % n)
c = pow(msg, e, n)
print("Encrypted data =", c)

# RSA Decryption
m = pow(c, d, n)
print("Original Message Sent =", m)
