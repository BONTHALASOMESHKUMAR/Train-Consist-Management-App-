import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    @Test(expected = IllegalStateException.class)
    public void testSearch_ThrowsExceptionWhenEmpty() {
        String[] arr = {};

        TrainConsistManagementApp.searchBogie(arr, "BG101");
    }

    @Test
    public void testSearch_AllowsSearchWhenDataExists() {
        String[] arr = {"BG101","BG205"};

        boolean result = TrainConsistManagementApp.searchBogie(arr, "BG101");

        assertTrue(result);
    }

    @Test
    public void testSearch_BogieFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};

        assertTrue(TrainConsistManagementApp.searchBogie(arr, "BG205"));
    }

    @Test
    public void testSearch_BogieNotFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};

        assertFalse(TrainConsistManagementApp.searchBogie(arr, "BG999"));
    }

    @Test
    public void testSearch_SingleElementValidCase() {
        String[] arr = {"BG101"};

        assertTrue(TrainConsistManagementApp.searchBogie(arr, "BG101"));
    }
}