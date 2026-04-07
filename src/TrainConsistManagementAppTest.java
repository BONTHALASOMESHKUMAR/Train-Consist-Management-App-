import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    @Test
    public void testCargo_SafeAssignment() {
        TrainConsistManagementApp.GoodsBogie b =
                new TrainConsistManagementApp.GoodsBogie("Cylindrical");

        b.assignCargo("Petroleum");

        assertEquals("Petroleum", b.cargo);
    }

    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        TrainConsistManagementApp.GoodsBogie b =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        b.assignCargo("Petroleum");

        assertNull(b.cargo);
    }

    @Test
    public void testCargo_CargoNotAssignedAfterFailure() {
        TrainConsistManagementApp.GoodsBogie b =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        b.assignCargo("Petroleum");

        assertNull(b.cargo);
    }

    @Test
    public void testCargo_ProgramContinuesAfterException() {
        TrainConsistManagementApp.GoodsBogie b1 =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        TrainConsistManagementApp.GoodsBogie b2 =
                new TrainConsistManagementApp.GoodsBogie("Cylindrical");

        b1.assignCargo("Petroleum");
        b2.assignCargo("Coal");

        assertEquals("Coal", b2.cargo);
    }

    @Test
    public void testCargo_FinallyBlockExecution() {
        TrainConsistManagementApp.GoodsBogie b =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        b.assignCargo("Petroleum");

        assertNull(b.cargo); // ensures execution completed safely
    }
}