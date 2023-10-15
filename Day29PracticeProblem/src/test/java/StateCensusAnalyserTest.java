import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

public class StateCensusAnalyserTest {
    private StateCensusAnalyser analyser;

    @BeforeEach
    public void setUp() {
        analyser = new StateCensusAnalyser();
    }

    @Test
    public void testNumberOfRecordsInCSV() throws IOException {
        String testFilePath = "IndianStateCensus.csv";
        List<CSVStateCensus> data = StateCensusAnalyser.loadStateCensusData(testFilePath);

        // Define your expected number of records
        int expectedRecordCount = 10; // Replace with the actual expected count

        assertEquals(expectedRecordCount, data.size());
    }
}
