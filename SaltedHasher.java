import java.security.*;

public class SaltedHasher {

    
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
