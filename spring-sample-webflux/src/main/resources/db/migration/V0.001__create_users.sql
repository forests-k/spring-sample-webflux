CREATE SEQUENCE users_user_id_seq
    INCREMENT BY 1
    MAXVALUE 99999999
    START WITH 1
    NO CYCLE
;

CREATE TABLE IF NOT EXISTS users(
  id INT PRIMARY KEY NOT NULL DEFAULT nextval('users_user_id_seq'::regclass)
  , mail VARCHAR (256) NOT NULL UNIQUE
  , gender INTEGER NOT NULL
  , password VARCHAR(256) NOT NULL
  , birthdate DATE NOT NULL
  , created_at TIMESTAMP NOT NULL
);

COMMENT ON TABLE users IS 'ユーザ';
COMMENT ON COLUMN users.id IS 'ユーザID';
COMMENT ON COLUMN users.mail IS 'メールアドレス';
COMMENT ON COLUMN users.gender IS '性別';
COMMENT ON COLUMN users.birthdate IS '生年月日';
COMMENT ON COLUMN users.password IS 'パスワード';
COMMENT ON COLUMN users.created_at IS '作成日時';