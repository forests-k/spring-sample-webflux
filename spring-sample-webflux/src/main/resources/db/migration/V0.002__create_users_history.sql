CREATE SEQUENCE users_history_users_history_id_seq
    INCREMENT BY 1
    MAXVALUE 99999999
    START WITH 1
    NO CYCLE
;

CREATE TABLE IF NOT EXISTS users_history(
  id INT PRIMARY KEY NOT NULL DEFAULT nextval('users_history_users_history_id_seq'::regclass)
  , user_id INTEGER NOT NULL
  , mail VARCHAR (256) NOT NULL UNIQUE
  , gender INTEGER NOT NULL
  , password VARCHAR(256) NOT NULL
  , birthdate DATE NOT NULL
  , note VARCHAR(256)
  , created_at TIMESTAMP NOT NULL
);

COMMENT ON TABLE users_history IS 'ユーザ履歴';
COMMENT ON COLUMN users_history.user_id IS 'ユーザ履歴ID';
COMMENT ON COLUMN users_history.id IS 'IユーザD';
COMMENT ON COLUMN users_history.mail IS 'メールアドレス';
COMMENT ON COLUMN users_history.gender IS '性別';
COMMENT ON COLUMN users_history.birthdate IS '生年月日';
COMMENT ON COLUMN users_history.password IS 'パスワード';
COMMENT ON COLUMN users_history.note IS '事由';
COMMENT ON COLUMN users_history.created_at IS '作成日時';