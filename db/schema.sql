# article table 생성
CREATE TABLE article (
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    `body` TEXT NOT NULL,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL
);

# 테스트 데이터 삽입
INSERT INTO article(title, BODY, regDate, updateDate)
VALUES ("test title", "test body", NOW(), NOW());