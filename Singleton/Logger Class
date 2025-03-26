import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Boolean.TRUE;

public class Logger {
    private static volatile Logger logger = null;
    private List<String> logMsg = new ArrayList<>();
    private static String LOG_FILE = "logs";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss");

    private Logger() {};
    public static Logger getInstance() {
        if(logger==null) {
            synchronized (Logger.class) {
                if(logger==null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    public void log( Level level,String message) {
        String timestamp = dateFormat.format(new Date());
        String formatted = String.format("[%s] [%s] %s", timestamp, level, message);
        synchronized (this) {
            logMsg.add(formatted);
        }
        writwToFile(formatted);
    }

    public List<String> getLogs() {
        synchronized (this) {
            return new ArrayList<>(logMsg); //return copy to avoid modification
        }
    }

    private void writwToFile(String msg) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(msg);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.err.println("Error writing log to file: " + e.getMessage());
        }
    }
}
