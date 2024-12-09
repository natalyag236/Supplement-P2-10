import java.security.*;

public class BooleanHasher {
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

    public static boolean isHashMatch(String input, String givenHash, HashAlgorithm algorithm) {
        String computedHash = hashString(input, algorithm);
        return computedHash.equals(givenHash);
    }
}

