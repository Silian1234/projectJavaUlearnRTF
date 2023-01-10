package ivan.silinkin.dao.impl;

import ivan.silinkin.Parser.model.CsvToGame;
import ivan.silinkin.dao.abstracts.MigrationToDatabaseDAO;
import ivan.silinkin.dao.dto.*;
import ivan.silinkin.Parser.ParserCsv;
import ivan.silinkin.dao.dto.converting.Converting;
import ivan.silinkin.util.Util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class MigrationToDatabaseDAOImpl implements MigrationToDatabaseDAO {
    @Override
    public void fillingTableGame() {
        List<Game> games = Converting.csvToGameConvertingToGame();
        try (PreparedStatement preparedStatement = Util.getConn().prepareStatement("INSERT INTO `Game` ('Rank',`Name`,`Year`) VALUES\n" +
                "(?,?,?);")) {
            if (games != null) {
                for (int i = 0; i < games.size(); i++) {
                    preparedStatement.setInt(1, games.get(i).getRank());
                    preparedStatement.setString(2, games.get(i).getName());
                    preparedStatement.setString(3, games.get(i).getYear());
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fillingTableSales() {
        List<Sales> sales = Converting.csvToGameConvertingToSales();
        List<Game> games = Converting.csvToGameConvertingToGame();
        try (PreparedStatement preparedStatement = Util.getConn().prepareStatement("INSERT INTO `Sales` ('NA_Sales',`EU_Sales`,`JP_Sales`,`Other_Sales`,`Global_Sales`,`game_id`) VALUES\n" +
                " (?,?,?,?,?,?);")) {
            if (sales != null & games != null) {
                for (int i = 0; i < sales.size(); i++) {
                    preparedStatement.setFloat(1, sales.get(i).getNASales());
                    preparedStatement.setFloat(2, sales.get(i).getEUSales());
                    preparedStatement.setFloat(3, sales.get(i).getJPSales());
                    preparedStatement.setFloat(4, sales.get(i).getOtherSales());
                    preparedStatement.setFloat(5, sales.get(i).getGlobalSales());
                    preparedStatement.setInt(6, games.get(i).getRank());
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void fillingTablePlatform() {
        List<Platform> platforms = Converting.csvToGameConvertingToPlatform();
        try (PreparedStatement preparedStatement = Util.getConn().prepareStatement("INSERT INTO `Platform` ('id',`name`) VALUES\n" +
                " (?,?);")) {
            for (int i = 0; i < platforms.size(); i++) {
                preparedStatement.setInt(1, platforms.get(i).getId());
                preparedStatement.setString(2, platforms.get(i).getName());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void fillingTableGenre() {
        List<Genre> genres = Converting.csvToGameConvertingToGenre();
        try (PreparedStatement preparedStatement = Util.getConn().prepareStatement("INSERT INTO `Genre` ('id',`name`) VALUES\n" +
                " (?,?);")) {
            for (int i = 0; i < genres.size(); i++) {
                preparedStatement.setInt(1, genres.get(i).getId());
                preparedStatement.setString(2, genres.get(i).getName());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void fillingTablePublisher() {
        List<Publisher> publishers = Converting.csvToGameConvertingToPublisher();
        try (PreparedStatement preparedStatement = Util.getConn().prepareStatement("INSERT INTO `Publisher` ('id',`name`) VALUES\n" +
                " (?,?);")) {
            for (int i = 0; i < publishers.size(); i++) {
                preparedStatement.setInt(1, publishers.get(i).getId());
                preparedStatement.setString(2, publishers.get(i).getName());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fillingTableGamesInGenre() {
        List<CsvToGame> games = ParserCsv.parser(Util.PATH);
        List<Genre> genres = Converting.csvToGameConvertingToGenre();
        try (PreparedStatement preparedStatement = Util.getConn().prepareStatement("INSERT INTO `Games_In_Genre` (`game_id`, 'genre_id') VALUES\n" +
                " (?,?);")) {
            int i = 1;
            int k = 0;
            while (games.get(i).getGenre().length() != 0) {
                if (k == genres.size()) {
                    k = 0;
                    continue;
                }
                if (k >= 0) {
                    if (games.get(i).getGenre().equals(genres.get(k).getName())) {
                            preparedStatement.setInt(1, Integer.parseInt(games.get(i).getRank()));
                            preparedStatement.setInt(2, genres.get(k).getId());
                            preparedStatement.addBatch();
                            i++;
                        if (i >= games.size()) {
                            preparedStatement.executeBatch();
                            break;
                        }
                    }
                    k++;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fillingTableGamesInPlatform() {
        List<CsvToGame> games = ParserCsv.parser(Util.PATH);
        List<Platform> platforms = Converting.csvToGameConvertingToPlatform();
        try (PreparedStatement preparedStatement = Util.getConn().prepareStatement("INSERT INTO `Games_In_Platform` (`game_id`, 'platform_id') VALUES\n" +
                " (?,?);")) {
            int i = 1;
            int k = 0;
            while (games.get(i).getGenre().length() != 0) {
                if (k == platforms.size()) {
                    k = 0;
                    continue;
                }
                if (k >= 0) {
                    if (games.get(i).getPlatform().equals(platforms.get(k).getName())) {
                        preparedStatement.setInt(1, Integer.parseInt(games.get(i).getRank()));
                        preparedStatement.setInt(2, platforms.get(k).getId());
                        preparedStatement.addBatch();
                        i++;
                        if (i >= games.size()) {
                            preparedStatement.executeBatch();
                            break;
                        }
                    }
                    k++;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void fillingTableGamesInPublisher() {
        List<CsvToGame> games = ParserCsv.parser(Util.PATH);
        List<Publisher> publishers = Converting.csvToGameConvertingToPublisher();
        try (PreparedStatement preparedStatement = Util.getConn().prepareStatement("INSERT INTO `Games_In_Publisher` (`game_id`, 'publisher_id') VALUES\n" +
                " (?,?);")) {
            int i = 1;
            int k = 0;
            while (games.get(i).getPublisher().length() != 0) {
                if (k == publishers.size()) {
                    k = 0;
                    continue;
                }
                if (k >= 0) {
                    if (games.get(i).getPublisher().equals(publishers.get(k).getName())) {
                        preparedStatement.setInt(1, Integer.parseInt(games.get(i).getRank()));
                        preparedStatement.setInt(2, publishers.get(k).getId());
                        preparedStatement.addBatch();
                        i++;
                        if (i >= games.size()) {
                            preparedStatement.executeBatch();
                            break;
                        }
                    }
                    k++;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
