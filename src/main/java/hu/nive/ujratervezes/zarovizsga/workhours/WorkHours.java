package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class WorkHours {

    public String minWork(String file) {
        Path path = Path.of(file);
        WorkHoursPerDay result = new WorkHoursPerDay(null, Integer.MAX_VALUE, null);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                WorkHoursPerDay actual = new WorkHoursPerDay(parts[0], parts[1], parts[2]);
                if (result.getHours() > actual.getHours()) {
                    result = actual;
                }
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("File cannot read");
        }
        return result.toStringMinHours();
    }


}
