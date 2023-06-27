package tech.example.architecture;

import java.io.File;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FlywayMigrationNamingConventionTest {

    private static final Pattern MIGRATION_FILE_PATTERN = Pattern.compile("V\\d{4}\\.\\d{2}\\.\\d{2}\\.\\d{2}\\.\\d{2}\\.\\d{2}__.*\\.sql");

    @Test
    public void testMigrationFileNamingConvention() {
        String migrationDirectoryPath = "src/main/resources/db/migration/table";
        File migrationDirectory = new File(migrationDirectoryPath);
        assertTrue(migrationDirectory.isDirectory());

        File[] migrationFiles = migrationDirectory.listFiles();
        for (File migrationFile : migrationFiles) {
            String migrationFileName = migrationFile.getName();
            assertTrue(MIGRATION_FILE_PATTERN.matcher(migrationFileName).matches(),
                    "Migration file name does not match naming convention: " + migrationFileName);
        }
    }
}