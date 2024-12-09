import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class BooleanHasherTest {
    @Test
    public void testHashStringWithMatchingHash() {
        String input = "blue";
        HashAlgorithm algorithm = HashAlgorithm.SHA_256;
        String expectedHash = BooleanHasher.hashString(input, algorithm);

        assertTrue(BooleanHasher.isHashMatch(input, expectedHash, algorithm), "The hash should match");
    }

    @Test
    public void testHashStringWithNonMatchingHash() {
        String input = "blue";
        HashAlgorithm algorithm = HashAlgorithm.SHA_256;
        String nonMatchingHash = "nonMatchingHashValue";

        assertFalse(BooleanHasher.isHashMatch(input, nonMatchingHash, algorithm), "The hash should not match");
    }
}
