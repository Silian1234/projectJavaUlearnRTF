package ivan.silinkin.dao.impl;

import ivan.silinkin.dao.abstracts.ReadDatabaseDao;
import ivan.silinkin.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ReadDatabaseDaoImpl implements ReadDatabaseDao {

    @Override
    public HashMap<String, Double> averageValueInGlobalSalesByPlatform(){
        HashMap<String, Double> map = new HashMap<>();
        try (ResultSet resultSet = Util.getConn().prepareStatement("SELECT AVG(`Sales`.'Global_Sales') as average_sales, Platform.name\n" +
                "FROM `Games_In_Platform` INNER JOIN `Sales` ON `Games_In_Platform`.`game_id`=`Sales`.`game_id`\n" +
                "INNER JOIN Platform ON Games_In_Platform.platform_id = Platform.id\n" +
                "group by Platform.name;").executeQuery()) {
            while (resultSet.next()) {
                map.put(resultSet.getString(2), resultSet.getDouble(1));
                /*System.out.println(resultSet.getString(2) + " " + resultSet.getDouble(1));*/
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    @Override
    public void gameWithHighSalesValueInEU() {
        try (ResultSet resultSet = Util.getConn().prepareStatement("SELECT max('Sales'.'EU_Sales'), 'Game'.'Name', Game.Year\n" +
                "FROM Game INNER JOIN  Sales on Game.Rank = Sales.game_id WHERE Year = 2000;").executeQuery()) {
            while (resultSet.next()) {
                System.out.println("Best selling game of 2000 in Europe : " + resultSet.getString(2) + ". \nSales amount = " + resultSet.getDouble(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void gameWithHighSalesValueInJPGenreSports() {
        try (ResultSet resultSet = Util.getConn().prepareStatement("SELECT 'Game'.'Name', Game.Year,Genre.name, max(Sales.JP_Sales) as 'Sales JP'\n" +
                "FROM Games_In_Genre\n" +
                "INNER JOIN Genre on Games_In_Genre.genre_id = Genre.id\n" +
                "INNER JOIN  'Sales' ON Games_In_Genre.game_id = Sales.game_id\n" +
                "INNER JOIN Game ON Games_In_Genre.game_id = Game.Rank\n" +
                "WHERE (Year >= 2000 and Year <= 2006) and Genre.Name = 'Sports';").executeQuery()) {
            while (resultSet.next()) {
                System.out.println("The game, created between 2000 and 2006 in the sports genre, has the highest sales in Japan. "
                        + ": " + resultSet.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
