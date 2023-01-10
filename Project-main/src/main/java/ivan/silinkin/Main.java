package ivan.silinkin;

import ivan.silinkin.charts.Chart;
import ivan.silinkin.service.abstracts.ReadDatabaseService;
import ivan.silinkin.service.impl.ReadDatabaseServiceImpl;
import ivan.silinkin.util.Util;

import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {
        //Замер времени программы
        double milVMin = 60000;
        long start = System.currentTimeMillis();

        // Создание схемы базы данных
        Util.createTablesInDB();
        // Заполнение базы данных
        Util.fillingDatabase();

        ReadDatabaseService readDatabaseService = new ReadDatabaseServiceImpl();

        //График первого задания
        Chart.AverageGlobalSalesChart(readDatabaseService.averageValueInGlobalSalesByPlatform());

        //Консольный вывод первого задания
        for (var map : readDatabaseService.averageValueInGlobalSalesByPlatform().entrySet()) {
            System.out.println("Platform : " + map.getKey() + ". Average global sale : " + map.getValue());
        }
        //Консольный вывод второго задания
        System.out.println("---------------------------------");
        readDatabaseService.gameWithHighSalesValueInEU();
        //Консольный вывод третьего задания
        System.out.println("---------------------------------");
        readDatabaseService.gameWithHighSalesValueInJPGenreSports();

        //Замер времени программы
        long finish = System.currentTimeMillis();
        double elapsed = (double) finish - start;
        System.out.println("min: " + elapsed / milVMin);
    }
}
