# XOR Encryption with CBC Mode

Implementation of xor-cbc encryption for personal training purposes. When running `main`, the user is asked for a key and an initialization vector; both are numbers between 0 and 63. If the user enters invalid numbers, they have to be re-entered. After that, the user is asked to enter a plaintext to be decrypted. Each letter of the plaintext is mapped to a number between 0 and 63 before the encryption takes place and the ciphertext is output. Afterwards, the ciphertext is decrypted again and the plaintext is output.

## Encryption Scheme
![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/8/80/CBC_encryption.svg/1920px-CBC_encryption.svg.png)

## Decryption Scheme
![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/CBC_decryption.svg/1920px-CBC_decryption.svg.png)
