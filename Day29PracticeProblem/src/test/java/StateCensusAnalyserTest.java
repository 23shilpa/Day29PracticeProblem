import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;

public class StateCensusAnalyserTest {
    private StateCensusAnalyser analyser;

    @BeforeEach
    public void setUp() {
        analyser = new StateCensusAnalyser();
    }

    @Test
    public void testIncorrectCSVDataException() {
        String testFilePath = "IncorrectStateCensus.csv";

        assertThrows(IncorrectCSVDataException.class, () -> {
            analyser.loadStateCensusData(testFilePath);
        });
    }
}
