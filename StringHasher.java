import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringHasher {
    /**
     * Hashes the given input string using the specified hashing algorithm.
     *
     * @param input the string to be hashed
     * @param algorithm the hash algorithm to be used (MD5, SHA-1, SHA-256)
     * @return the hashed string in hexadecimal format
     * @throws IllegalArgumentException if the provided algorithm is unsupported
     */
    public static String hashString(String input, HashAlgorithm algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm.name().replace('_', '-'));
            byte[] hashedBytes = digest.digest(input.getBytes());
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

