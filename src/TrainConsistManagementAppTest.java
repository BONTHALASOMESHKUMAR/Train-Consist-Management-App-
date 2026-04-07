import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    @Test
    public void testSearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(TrainConsistManagementApp.linearSearch(arr, "BG309"));
    }

    @Test
    public void testSearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(TrainConsistManagementApp.linearSearch(arr, "BG999"));
    }

    @Test
    public void testSearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309"};

        assertTrue(TrainConsistManagementApp.linearSearch(arr, "BG101"));
    }

    @Test
    public void testSearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG550"};

        assertTrue(TrainConsistManagementApp.linearSearch(arr, "BG550"));
    }

    @Test
    public void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};

        assertTrue(TrainConsistManagementApp.linearSearch(arr, "BG101"));
    }
}