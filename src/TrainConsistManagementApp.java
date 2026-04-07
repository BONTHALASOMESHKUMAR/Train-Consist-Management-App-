import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.Bogie("A", 50));
        list.add(new TrainConsistManagementApp.Bogie("B", 70));

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.loopFilter(list);

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.Bogie("A", 50));
        list.add(new TrainConsistManagementApp.Bogie("B", 70));

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.streamFilter(list);

        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.Bogie("A", 80));
        list.add(new TrainConsistManagementApp.Bogie("B", 40));

        int loopSize = TrainConsistManagementApp.loopFilter(list).size();
        int streamSize = TrainConsistManagementApp.streamFilter(list).size();

        assertEquals(loopSize, streamSize);
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.Bogie("A", 80));

        long start = System.nanoTime();
        TrainConsistManagementApp.loopFilter(list);
        long end = System.nanoTime();

        assertTrue(end - start > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(new TrainConsistManagementApp.Bogie("T", i));
        }

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.streamFilter(list);

        assertNotNull(result);
    }
}