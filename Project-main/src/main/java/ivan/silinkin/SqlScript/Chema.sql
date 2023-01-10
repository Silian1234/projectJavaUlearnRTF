-- ---
-- Table 'Game'
--
-- ---

DROP TABLE IF EXISTS `Game`;

CREATE TABLE `Game` (
                        `Rank` INTEGER PRIMARY KEY,
                        `Name` VARCHAR(50) NULL DEFAULT NULL,
                        `Year` VARCHAR NULL DEFAULT NULL
);

-- ---
-- Table 'Platform'
--
-- ---

DROP TABLE IF EXISTS `Platform`;

CREATE TABLE `Platform` (
                            `id` INTEGER DEFAULT NULL,
                            `name` VARCHAR(50) NULL DEFAULT NULL,
                            PRIMARY KEY (`id`)
);

-- ---
-- Table 'Game_In_Platform'
--
-- ---

DROP TABLE IF EXISTS `Games_In_Platform`;

CREATE TABLE `Games_In_Platform` (
                                    `id` INTEGER DEFAULT NULL,
                                    `game_id` INTEGER NULL DEFAULT NULL,
                                    `platform_id` INTEGER NULL DEFAULT NULL,
                                    PRIMARY KEY (`id`),
                                    FOREIGN KEY (game_id) REFERENCES `Game` (`Rank`),
                                    FOREIGN KEY (platform_id) REFERENCES `Platform` (`id`)
);

-- ---
-- Table 'Genre'
--
-- ---

DROP TABLE IF EXISTS `Genre`;

CREATE TABLE `Genre` (
                         `id` INTEGER DEFAULT NULL,
                         `name` VARCHAR(50) NULL DEFAULT NULL,
                         PRIMARY KEY (`id`)
);

-- ---
-- Table 'Games_In_Genre'
--
-- ---

DROP TABLE IF EXISTS `Games_In_Genre`;

CREATE TABLE `Games_In_Genre` (
                                  `id` INTEGER DEFAULT NULL,
                                  `game_id` INTEGER NULL DEFAULT NULL,
                                  `genre_id` INTEGER NULL DEFAULT NULL,
                                  PRIMARY KEY (`id`),
                                  FOREIGN KEY (game_id) REFERENCES `Game` (`Rank`),
                                  FOREIGN KEY (genre_id) REFERENCES `Genre` (`id`)
);

-- ---
-- Table 'Publisher'
--
-- ---

DROP TABLE IF EXISTS `Publisher`;

CREATE TABLE `Publisher` (
                             `id` INTEGER DEFAULT NULL,
                             `name` VARCHAR(50) NULL DEFAULT NULL,
                             PRIMARY KEY (`id`)
);

-- ---
-- Table 'Games_In_Publisher'
--
-- ---

DROP TABLE IF EXISTS `Games_In_Publisher`;

CREATE TABLE `Games_In_Publisher` (
                                      `id` INTEGER DEFAULT NULL,
                                      `game_id` INTEGER NULL DEFAULT NULL,
                                      `publisher_id` INTEGER NULL DEFAULT NULL,
                                      PRIMARY KEY (`id`),
                                      FOREIGN KEY (game_id) REFERENCES `Game` (`Rank`),
                                      FOREIGN KEY (publisher_id) REFERENCES `Publisher` (`id`)
);

-- ---
-- Table 'Sales'
--
-- ---

DROP TABLE IF EXISTS `Sales`;

CREATE TABLE `Sales` (
                         `NA_Sales` REAL NULL DEFAULT NULL,
                         `EU_Sales` REAL NULL DEFAULT NULL,
                         `JP_Sales` REAL NULL DEFAULT NULL,
                         `Other_Sales` REAL NULL DEFAULT NULL,
                         `Global_Sales` REAL NULL DEFAULT NULL,
                         `game_id` INTEGER PRIMARY KEY NULL DEFAULT NULL,
                         FOREIGN KEY (game_id) REFERENCES `Game` (`Rank`)
);
