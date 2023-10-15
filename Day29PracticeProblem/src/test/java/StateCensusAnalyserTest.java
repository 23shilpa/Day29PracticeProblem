import com.bl.IncorrectCSVDataTypeException;
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
    public void testIncorrectCSVDataTypeException() {
        String testFilePath = "IncorrectTypeStateCensus.csv";

        assertThrows(IncorrectCSVDataTypeException.class, () -> {
            analyser.loadStateCensusData(testFilePath);
        });
    }
}
