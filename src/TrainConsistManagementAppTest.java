import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

}import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testValidTrainID() {
        assertTrue(TrainConsistManagementApp.isValidTrainId("TRN-1234"));
    }

    @Test
    void testInvalidTrainIDFormat() {
        assertFalse(TrainConsistManagementApp.isValidTrainId("TRAIN12"));
        assertFalse(TrainConsistManagementApp.isValidTrainId("TRN12A"));
        assertFalse(TrainConsistManagementApp.isValidTrainId("1234-TRN"));
    }

    @Test
    void testTrainIDDigitLength() {
        assertFalse(TrainConsistManagementApp.isValidTrainId("TRN-123"));
        assertFalse(TrainConsistManagementApp.isValidTrainId("TRN-12345"));
    }

    @Test
    void testValidCargoCode() {
        assertTrue(TrainConsistManagementApp.isValidCargoCode("PET-AB"));
    }

    @Test
    void testInvalidCargoCodeFormat() {
        assertFalse(TrainConsistManagementApp.isValidCargoCode("PET-ab"));
        assertFalse(TrainConsistManagementApp.isValidCargoCode("PET123"));
        assertFalse(TrainConsistManagementApp.isValidCargoCode("AB-PET"));
    }

    @Test
    void testEmptyInput() {
        assertFalse(TrainConsistManagementApp.isValidTrainId(""));
        assertFalse(TrainConsistManagementApp.isValidCargoCode(""));
    }

    @Test
    void testExactPatternMatch() {
        assertFalse(TrainConsistManagementApp.isValidTrainId("TRN-1234X"));
        assertFalse(TrainConsistManagementApp.isValidCargoCode("PET-ABC"));
    }
}