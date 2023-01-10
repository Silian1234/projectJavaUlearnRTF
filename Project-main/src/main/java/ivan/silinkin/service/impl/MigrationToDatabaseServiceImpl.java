package ivan.silinkin.service.impl;

import ivan.silinkin.dao.abstracts.MigrationToDatabaseDAO;
import ivan.silinkin.dao.impl.MigrationToDatabaseDAOImpl;
import ivan.silinkin.service.abstracts.MigrationToDatabaseService;

public class MigrationToDatabaseServiceImpl implements MigrationToDatabaseService {
    MigrationToDatabaseDAO migrationToDatabaseDAO = new MigrationToDatabaseDAOImpl();

    @Override
    public void fillingTableGame() {
        migrationToDatabaseDAO.fillingTableGame();
    }

    @Override
    public void fillingTableSales() {
        migrationToDatabaseDAO.fillingTableSales();
    }

    @Override
    public void fillingTablePlatform() {
        migrationToDatabaseDAO.fillingTablePlatform();
    }

    @Override
    public void fillingTableGenre() {
        migrationToDatabaseDAO.fillingTableGenre();
    }

    @Override
    public void fillingTablePublisher() {
        migrationToDatabaseDAO.fillingTablePublisher();
    }

    @Override
    public void fillingTableGamesInGenre() {
        migrationToDatabaseDAO.fillingTableGamesInGenre();
    }

    @Override
    public void fillingTableGamesInPlatform() {
        migrationToDatabaseDAO.fillingTableGamesInPlatform();
    }

    @Override
    public void fillingTableGamesInPublisher() {
        migrationToDatabaseDAO.fillingTableGamesInPublisher();
    }
}
