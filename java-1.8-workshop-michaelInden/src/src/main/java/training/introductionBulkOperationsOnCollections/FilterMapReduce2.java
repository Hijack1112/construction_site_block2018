package src.main.java.training.introductionBulkOperationsOnCollections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Hijack
 */
public class FilterMapReduce2 {

    public static void main(String[] args) {

        //Task: Ermittle alle Zeilen aus einer Log-Dateien die den Text «Error» enthalten, beschränke die
        //Treffermenge auf die ersten 10 Vorkommen
    }

    public List<String> getLogErrors(int maxCount) throws IOException {

        //maxCount == 10
        final List<String> errorLines = new ArrayList<>();
        try (final BufferedReader reader = new BufferedReader(new FileReader("PathToLogFile"))) {
            String currentLine = reader.readLine();
            while (errorLines.size() < maxCount && currentLine != null) {
                if (currentLine.contains("ERROR")) {
                    errorLines.add(currentLine);
                }
                currentLine = reader.readLine();
            }
        }
        return errorLines;
    }

    public List<String> getLogErrors2(int maxCount) throws IOException {
        
        final List<String> errorLines = Files.lines(new File("PathToLogFile").toPath())
                .filter(line -> line.contains("ERROR"))
                .limit(maxCount)
                .collect(Collectors.toList());

        return errorLines;
    }
}
