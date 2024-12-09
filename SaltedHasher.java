import java.security.*;

public class SaltedHasher {

     /**
     * Generates a salted hash using the provided input string, salt, and hashing algorithm.
     *
     * @param input The input string to be hashed. Cannot be null.
     * @param salt The salt to be combined with the input. Cannot be null.
     * @param algorithm The hashing algorithm to use (e.g., SHA-256, MD5). 
     *                  Must be a valid algorithm supported by {@link MessageDigest}.
     * @return The salted hash as a hexadecimal string.
     * @throws IllegalArgumentException if the input or salt is null, or if an invalid hashing algorithm is specified.
     */
    public static String generateSaltedHash(String input, String salt, HashAlgorithm algorithm) {
        if (input == null || salt == null) {
            throw new IllegalArgumentException("Input and salt cannot be null");
        }

        try {
            String saltedInput = input + salt;

            MessageDigest digest = MessageDigest.getInstance(algorithm.name().replace('_', '-'));

            byte[] hashedBytes = digest.digest(saltedInput.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Invalid hash algorithm: " + algorithm, e);
        }
    }
}
