import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    @Test
    public void testBinarySearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(TrainConsistManagementApp.binarySearch(arr, "BG309"));
    }

    @Test
    public void testBinarySearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(TrainConsistManagementApp.binarySearch(arr, "BG999"));
    }

    @Test
    public void testBinarySearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309"};

        assertTrue(TrainConsistManagementApp.binarySearch(arr, "BG101"));
    }

    @Test
    public void testBinarySearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG550"};

        assertTrue(TrainConsistManagementApp.binarySearch(arr, "BG550"));
    }

    @Test
    public void testBinarySearch_SingleElementArray() {
        String[] arr = {"BG101"};

        assertTrue(TrainConsistManagementApp.binarySearch(arr, "BG101"));
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        String[] arr = {};

        assertFalse(TrainConsistManagementApp.binarySearch(arr, "BG101"));
    }

    @Test
    public void testBinarySearch_UnsortedInputHandled() {
        String[] arr = {"BG309","BG101","BG550","BG205","BG412"};

        assertTrue(TrainConsistManagementApp.binarySearch(arr, "BG205"));
    }
}