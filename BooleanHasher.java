import java.security.*;

public class BooleanHasher {
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
     /**
     * Verifies whether a given string matches a given hash using the specified algorithm.
     *
     * @param input      The original string to verify.
     * @param givenHash  The hash to compare against.
     * @param algorithm  The hashing algorithm used to compute the hash.
     * @return True if the hash of the input matches the given hash; false otherwise.
     */

    public static boolean isHashMatch(String input, String givenHash, HashAlgorithm algorithm) {
        String computedHash = hashString(input, algorithm);
        return computedHash.equals(givenHash);
    }
}

