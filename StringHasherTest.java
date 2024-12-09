import static org.junit.Assert.*;
import org.junit.Test;

public class StringHasherTest {

    @Test
    public void testHashString_MD5() {
        String input = "purple";
        String expected = "bb7aedfa61007447dd6efaf9f37641e3"; 
        String result = StringHasher.hashString(input, HashAlgorithm.MD5);
        assertEquals("MD5 hash should match", expected, result);
    }

    @Test
    public void testHashString_SHA1() {
        String input = "purple";
        String expected = "afaed75406bd414820cea4a5119f90c259c05755"; 
        String result = StringHasher.hashString(input, HashAlgorithm.SHA_1);
        assertEquals("SHA-1 hash should match", expected, result);
    }

    @Test
    public void testHashString_SHA256() {
        String input = "purple";
        String expected = "8e0a1b0ada42172886fd1297e25abf99f14396a9400acbd5f20da20289cff02f"; 
        String result = StringHasher.hashString(input, HashAlgorithm.SHA_256);
        assertEquals("SHA-256 hash should match", expected, result);
    
}    }