import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

@Component
public class DBInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DBInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
        try {
            // Load SQL script from classpath
            ClassPathResource resource = new ClassPathResource("init_db.sql");

            // Read the content of the SQL script
            String sql = new String(Files.readAllBytes(Paths.get(resource.getURI())), StandardCharsets.UTF_8);

            // Execute the SQL script
            jdbcTemplate.execute(sql);
            System.out.println("Database initialized successfully.");
        } catch (IOException e) {
            System.err.println("Failed to read SQL script: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Failed to execute SQL script: " + e.getMessage());
        }
    }
}
