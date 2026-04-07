import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    @Test
    public void testException_ValidCapacityCreation() throws Exception {
        TrainConsistManagementApp.PassengerBogie b =
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 50);

        assertEquals(50, b.capacity);
    }

    @Test(expected = TrainConsistManagementApp.InvalidCapacityException.class)
    public void testException_NegativeCapacityThrowsException() throws Exception {
        new TrainConsistManagementApp.PassengerBogie("Sleeper", -10);
    }

    @Test(expected = TrainConsistManagementApp.InvalidCapacityException.class)
    public void testException_ZeroCapacityThrowsException() throws Exception {
        new TrainConsistManagementApp.PassengerBogie("AC", 0);
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        try {
            new TrainConsistManagementApp.PassengerBogie("AC", 0);
            fail("Expected exception not thrown");
        } catch (TrainConsistManagementApp.InvalidCapacityException e) {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() throws Exception {
        TrainConsistManagementApp.PassengerBogie b =
                new TrainConsistManagementApp.PassengerBogie("AC Chair", 60);

        assertEquals("AC Chair", b.type);
        assertEquals(60, b.capacity);
    }

    @Test
    public void testException_MultipleValidBogiesCreation() throws Exception {
        TrainConsistManagementApp.PassengerBogie b1 =
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);

        TrainConsistManagementApp.PassengerBogie b2 =
                new TrainConsistManagementApp.PassengerBogie("AC", 56);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}