import hashlib
message = "hello"
hash_object = hashlib.md5(message.encode())
md5_hash = hash_object.hexdigest()
print("MD5 Hash:", md5_hash)


#sha
import hashlib
message = "hello"
hash_object = hashlib.sha1(message.encode())
sha_hash = hash_object.hexdigest()
print("SHA_1 Hash:", sha_hash)
