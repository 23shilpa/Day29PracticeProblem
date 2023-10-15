import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StateCensusAnalyser {
    public static void main(String[] args) {
        try {
            List<CSVStateCensus> censusData = loadStateCensusData("IndianStateCensus.csv");

            // You can work with the censusData here.
            for (CSVStateCensus data : censusData) {
                System.out.println(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<CSVStateCensus> loadStateCensusData(String filePath) throws IOException {
        List<CSVStateCensus> censusData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)) ) {
            // Skip the header line
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                while (tokenizer.hasMoreTokens()) {
                    String state = tokenizer.nextToken().trim();
                    String population = tokenizer.nextToken().trim();
                    String area = tokenizer.nextToken().trim();
                    String density = tokenizer.nextToken().trim();

                    CSVStateCensus census = new CSVStateCensus(state, population, area, density);
                    censusData.add(census);
                }
            }
        }

        return censusData;
    }
}

class CSVStateCensus {
    private String state;
    private String population;
    private String area;
    private String density;

    public CSVStateCensus(String state, String population, String area, String density) {
        this.state = state;
        this.population = population;
        this.area = area;
        this.density = density;
    }

    @Override
    public String toString() {
        return "State: " + state +
                ", Population: " + population +
                ", Area: " + area +
                ", Density: " + density;
    }
}
