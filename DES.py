#pip install pycryptodome
import base64;
from Crypto.Cipher import DES
from Crypto.Util.Padding import pad,unpad
from Crypto.Random import get_random_bytes

def encrypt(plaintext,key):
    cipher=DES.new(key,DES.MODE_ECB)
    encode_the_planetext=plaintext.encode()
    pad_the_text=pad(encode_the_planetext,DES.block_size)
    encryption=cipher.encrypt(pad_the_text)
    return base64.b64encode(encryption).decode()
def decrypt(cipher_text,key):
    cipher=DES.new(key,DES.MODE_ECB)
    decode_to_bytes=base64.b64decode(cipher_text)
    decryption=cipher.decrypt(decode_to_bytes)
    unpad_the_text=unpad(decryption,DES.block_size)
    return unpad_the_text.decode()
plaintext=input("Enter the text:")
key=get_random_bytes(8)
ciphet_text=encrypt(plaintext,key)
print("Cipher text:",ciphet_text)
print(decrypt(ciphet_text,key))