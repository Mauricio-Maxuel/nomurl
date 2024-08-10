

CREATE TABLE CompleteUrl (
  id BIGINT NOT NULL,
   url VARCHAR(255),
   short_url VARCHAR(255),
   ttl BIGINT,
   CONSTRAINT pk_completeurl PRIMARY KEY (id)
);

INSERT INTO CompleteUrl (id, url, short_url, ttl) VALUES (1, 'test','test1',100);
