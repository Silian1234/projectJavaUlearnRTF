package ivan.silinkin.Parser;

import com.opencsv.bean.CsvToBeanBuilder;
import ivan.silinkin.Parser.model.CsvToGame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserCsv {
    public static ArrayList<CsvToGame> parser(String path) {
        try (FileReader fileReader = new FileReader(path)) {
            ArrayList<CsvToGame> all = new ArrayList<>();
            List<CsvToGame> beans = new CsvToBeanBuilder(fileReader)
                    .withType(CsvToGame.class)
                    .build()
                    .parse();
            all.addAll(beans);
            return all;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
