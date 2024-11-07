-- Schedules 테이블 생성
CREATE TABLE `Schedules` (
                             `id`	INT	NOT NULL PRIMARY KEY,
                             `name` VARCHAR(8) NOT NULL,
                             `password`	VARCHAR(15)	NOT NULL,
                             `title`	VARCHAR(20)	NOT NULL,
                             `start_date`	TIMESTAMP	NULL,
                             `dead_Line`	TIMESTAMP	NULL,
                             `todo`	VARCHAR(2)	NOT NULL
);

-- 일정 생성하기
INSERT INTO Schedules( name, password, title, start_date, dead_Line, todo)
VALUES (1, '하진이', '1234', '일정생성', 'YYYY-MM-DD', 'YYYY-MM-DD', '일정생성해보기');

-- 전체 일정 조회하기
SELECT * FROM Schedules
WHERE name = '하진이';

-- 선택 일정 조회하기
SELECT id,name,title,todo
FROM Schedules
WHERE id = '1';

-- 선택 일정 수정하기
UPDATE Schedules
SET title = '일정수정',
    todo = '일정생성하고 수정하기',
    start_date = 'YYYY-MM-DD',
    dead_Line = 'YYYY-MM-DD'
WHERE id = '1';

-- 일정 삭제하기
DELETE FROM Schedules
WHERE id = '1';
