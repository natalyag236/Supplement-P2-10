import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class SaltedHasherTest {

    @Test
    public void testGenerateSaltedHash() {
        String input = "secretPassword";
        String salt = "randomSalt";
        HashAlgorithm algorithm = HashAlgorithm.SHA_256;

        String saltedHash = SaltedHasher.generateSaltedHash(input, salt, algorithm);

        assertNotNull(saltedHash, "The salted hash should not be null");
        assertFalse(saltedHash.isEmpty(), "The salted hash should not be empty");

        String anotherSaltedHash = SaltedHasher.generateSaltedHash(input, salt, algorithm);
        assertEquals(saltedHash, anotherSaltedHash, "Salted hash should be consistent for the same input and salt");

        String differentSaltedHash = SaltedHasher.generateSaltedHash(input, "differentSalt", algorithm);
        assertNotEquals(saltedHash, differentSaltedHash, "Different salts should produce different hashes");
    }
}

