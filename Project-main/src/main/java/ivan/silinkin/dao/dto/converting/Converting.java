package ivan.silinkin.dao.dto.converting;

import ivan.silinkin.Parser.ParserCsv;
import ivan.silinkin.Parser.model.CsvToGame;
import ivan.silinkin.dao.dto.*;
import ivan.silinkin.util.Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Converting {
    public static List<Game> csvToGameConvertingToGame() {
        List<CsvToGame> csvToGames = ParserCsv.parser(Util.PATH);
        List<Game> games = new ArrayList<>();
        if (csvToGames != null) {
            for (int i = 1; i < csvToGames.size(); i++) {
                games.add(new Game(Integer.parseInt(csvToGames.get(i).getRank()),
                        csvToGames.get(i).getName(), csvToGames.get(i).getYear()));
            }
            return games;
        }
        return null;
    }
    public static List<Genre> csvToGameConvertingToGenre() {
        List<CsvToGame> csvToGames = ParserCsv.parser(Util.PATH);
        Comparator<Genre> comparator = Comparator.comparing(obj -> obj.getName());
        List<Genre> genres = new ArrayList<>();
        List<Genre> genresAndId = new ArrayList<>();
        if (csvToGames != null) {
            for (int i = 1; i < csvToGames.size(); i++) {
                genres.add(new Genre(csvToGames.get(i).getGenre()));
            }
        }
        List<Genre> genresDistinct = genres.stream().distinct().sorted(comparator).toList();
        for (int i = 0; i < genresDistinct.size(); i++) {
            genresAndId.add(new Genre(i + 1, genresDistinct.get(i).getName()));
        }
        return genresAndId;
    }
    public static List<Platform> csvToGameConvertingToPlatform () {
        List<CsvToGame> csvToGames = ParserCsv.parser(Util.PATH);
        Comparator<Platform> comparator = Comparator.comparing(obj -> obj.getName());
        List<Platform> platforms = new ArrayList<>();
        List<Platform> platformsAndId = new ArrayList<>();
        if (csvToGames != null) {
            for (int i = 1; i < csvToGames.size(); i++) {
                platforms.add(new Platform(csvToGames.get(i).getPlatform()));
            }
        }
        List<Platform> platformsDistinct = platforms.stream().distinct().sorted(comparator).toList();
        for (int i = 0; i < platformsDistinct.size(); i++) {
            platformsAndId.add(new Platform(i + 1, platformsDistinct.get(i).getName()));
        }
        return platformsAndId;
    }
    public static List<Publisher> csvToGameConvertingToPublisher () {
        List<CsvToGame> csvToGames = ParserCsv.parser(Util.PATH);
        Comparator<Publisher> comparator = Comparator.comparing(obj -> obj.getName());
        List<Publisher> publishers = new ArrayList<>();
        List<Publisher> publishersAndId = new ArrayList<>();
        if (csvToGames != null) {
            for (int i = 1; i < csvToGames.size(); i++) {
                publishers.add(new Publisher(csvToGames.get(i).getPublisher()));
            }
        }
        List<Publisher> publishersDistinct = publishers.stream().distinct().sorted(comparator).collect(Collectors.toList());
        for (int i = 0; i < publishersDistinct.size(); i++) {
            publishersAndId.add(new Publisher(i + 1, publishersDistinct.get(i).getName()));
        }
        return publishersAndId;
    }
    public static List<Sales> csvToGameConvertingToSales () {
        List<CsvToGame> csvToGames = ParserCsv.parser(Util.PATH);
        List<Sales> sales = new ArrayList<>();
        if (csvToGames != null) {
            for (int i = 1; i < csvToGames.size(); i++) {
                sales.add(new Sales(Float.parseFloat(csvToGames.get(i).getNASales()), Float.parseFloat(csvToGames.get(i).getEUSales()),
                        Float.parseFloat(csvToGames.get(i).getJPSales()), Float.parseFloat(csvToGames.get(i).getOtherSales()),
                        Float.parseFloat(csvToGames.get(i).getGlobalSales())));
            }
            return sales;
        }
        return null;
    }

}
