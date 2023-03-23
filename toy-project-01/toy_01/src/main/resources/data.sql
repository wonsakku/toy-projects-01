--CREATE TABLE content (
--    content_id BIGINT,
--    reference VARCHAR(255),
--    body VARCHAR(2000) NOT NULL,
--    created_date_time TIMESTAMP,
--    modified_date_time TIMESTAMP,
--    CONSTRAINT content_pk PRIMARY KEY(content_id)
--);
--
--CREATE TABLE classification(
--    classification_id BIGINT,
--    name VARCHAR(50) NOT NULL,
--    created_date_time TIMESTAMP,
--    modified_date_time TIMESTAMP,
--    CONSTRAINT classification_pk PRIMARY KEY(classification_id)
--);
--
--CREATE TABLE content_classification(
--    content_classification_id BIGINT,
--    content_id BIGINT,
--    classification_id BIGINT,
--    created_date_time TIMESTAMP,
--    modified_date_time TIMESTAMP,
--    CONSTRAINT fk_content FOREIGN KEY(content_id) REFERENCES content(content_id),
--    CONSTRAINT fk_classification FOREIGN KEY(classification_id) REFERENCES classification(classification_id)
--);
--
--INSERT INTO content (content_id, reference, body, created_date_time, modified_date_time)
--VALUES
--(1, 'a', 'bb', now(), now()),
--(2, 'a', 'bb', now(), now()),
--(3, 'a', 'bb', now(), now()),
--(4, 'a', 'bb', now(), now()),
--(5, 'a', 'bb', now(), now()),
--(6, 'a', 'bb', now(), now()),
--(7, 'a', 'bb', now(), now()),
--(8, 'a', 'bb', now(), now()),
--(9, 'a', 'bb', now(), now()),
--(10, 'a', 'bb', now(), now());
--
INSERT INTO classification(classification_id, name, created_date_time, modified_date_time)
VALUES
(1001, '노력', now(), now()),
(1002, '응원', now(), now()),
(1003, '인생관', now(), now()),
(1004, '교육관', now(), now()),
(1005, '기타', now(), now());

--INSERT INTO content_classification(content_classification_id, content_id, classification_id, created_date_time, modified_date_time)
--VALUES
--(16, 1, 11, now(), now()),
--(17, 1, 12, now(), now()),
--(18, 1, 13, now(), now()),
--(19, 2, 15, now(), now()),
--(20, 3, 14, now(), now());
