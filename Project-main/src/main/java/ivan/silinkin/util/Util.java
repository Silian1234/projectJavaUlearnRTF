package ivan.silinkin.util;

import ivan.silinkin.service.abstracts.MigrationToDatabaseService;
import ivan.silinkin.service.impl.MigrationToDatabaseServiceImpl;
import org.apache.ibatis.jdbc.ScriptRunner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;

public class Util {

    //Путь до Базы данных
    private static final String URL = "jdbc:sqlite:C:\\sqlite\\mydatabace.db";

    //Путь до Схемы Sql
    private static final String SCRIPT_FILE_PATH = "src/main/java/ivan/silinkin/SqlScript/Chema.sql";

    //Путь до CSV файла
    public static final String PATH = "C:\\Users\\isili\\Игры.csv";


    public static Connection getConn() {
        try {
            Connection connection = DriverManager.getConnection(URL);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void createTablesInDB() {
        try (Reader reader = new FileReader(SCRIPT_FILE_PATH)) {
            ScriptRunner scriptRunner = new ScriptRunner(getConn());
            scriptRunner.runScript(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fillingDatabase() {
        MigrationToDatabaseService migrationToDatabaseService = new MigrationToDatabaseServiceImpl();
        migrationToDatabaseService.fillingTableGame();
        migrationToDatabaseService.fillingTableSales();
        migrationToDatabaseService.fillingTableGenre();
        migrationToDatabaseService.fillingTablePlatform();
        migrationToDatabaseService.fillingTablePublisher();
        migrationToDatabaseService.fillingTableGamesInGenre();
        migrationToDatabaseService.fillingTableGamesInPlatform();
        migrationToDatabaseService.fillingTableGamesInPublisher();
        System.out.println("Base full");
    }





}
