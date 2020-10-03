CREATE TABLE USUARIO
(
    id            INT          NOT NULL AUTO_INCREMENT,
    nome          VARCHAR(255) NOT NULL,
    email         VARCHAR(255) NOT NULL,
    data_insercao DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_usuario
        PRIMARY KEY (id)
);


CREATE TABLE FUNCIONARIO
(
    id              INT NOT NULL AUTO_INCREMENT,
    login           VARCHAR(255),
    nome_tecnico    VARCHAR(255),
    unidade_negocio VARCHAR(255),
    cidade          VARCHAR(255),
    foto_app        BIT,
    certificado_in  BIT,
    CONSTRAINT pk_funcionario
        PRIMARY KEY (id)
);


CREATE TABLE PRODUCAO
(
    id                 INT          NOT NULL AUTO_INCREMENT,
    id_funcionario     INT          NOT NULL,
    mes_referencia     VARCHAR(255) NOT NULL,
    pct_mes_referencia VARCHAR(255),
    dias_escalados     INT,
    total_geral        INT,
    instalacoes         INT,
    servicos           INT,
    manutencoes        INT,
    retornos           INT,
    total              INT,
    media_ctt_dias     INT,
    CONSTRAINT pk_producao
        PRIMARY KEY (id),
    CONSTRAINT fk_funcionario_producao
        FOREIGN KEY (id_funcionario) REFERENCES FUNCIONARIO (id)
);


CREATE TABLE QUEBRA
(
    id             INT NOT NULL AUTO_INCREMENT,
    id_funcionario INT NOT NULL,
    id_producao    INT NOT NULL,
    total_quebra   INT,
    pct_quebra     VARCHAR(255),
    pct_aderencia  VARCHAR(255),
    CONSTRAINT pk_quebra
        PRIMARY KEY (id),
    CONSTRAINT fk_funcionario_quebra
        FOREIGN KEY (id_funcionario) REFERENCES FUNCIONARIO (id),
    CONSTRAINT fk_producao_quebra
        FOREIGN KEY (id_producao) REFERENCES PRODUCAO (id)
);


CREATE TABLE CUMPRIMENTO_AGENDA
(
    id                      INT NOT NULL AUTO_INCREMENT,
    id_funcionario          INT NOT NULL,
    id_producao             INT NOT NULL,
    tec1                    VARCHAR(255),
    pct_execucao_sobreposta VARCHAR(255),
    altera_horario_dias     INT,
    CONSTRAINT pk_cumprimento_agenda
        PRIMARY KEY (id),
    CONSTRAINT fk_funcionario_cump_agenda
        FOREIGN KEY (id_funcionario) REFERENCES FUNCIONARIO (id),
    CONSTRAINT fk_producao_cump_agenda
        FOREIGN KEY (id_producao) REFERENCES PRODUCAO (id)
);


CREATE TABLE BAIXA
(
    id             INT NOT NULL AUTO_INCREMENT,
    id_funcionario INT NOT NULL,
    id_producao    INT NOT NULL,
    uso_pda        BIT,
    pct_wa         VARCHAR(255),
    pct_ura        VARCHAR(255),
    pct_humano     VARCHAR(255),
    CONSTRAINT pk_baixa
        PRIMARY KEY (id),
    CONSTRAINT fk_funcionario_baixa
        FOREIGN KEY (id_funcionario) REFERENCES FUNCIONARIO (id),
    CONSTRAINT fk_producao_baixa
        FOREIGN KEY (id_producao) REFERENCES PRODUCAO (id)
);


CREATE TABLE ATUALIZACAO_STATUS_WA
(
    id                  INT NOT NULL AUTO_INCREMENT,
    id_funcionario      INT NOT NULL,
    id_producao         INT NOT NULL,
    primeiro_trabalho   VARCHAR(255),
    pct_deslocamento    VARCHAR(255),
    pct_status_refeicao VARCHAR(255),
    CONSTRAINT pk_atualizacao_status_wa
        PRIMARY KEY (id),
    CONSTRAINT fk_funcionario_att_sts_wa
        FOREIGN KEY (id_funcionario) REFERENCES FUNCIONARIO (id),
    CONSTRAINT fk_producao_att_sts_wa
        FOREIGN KEY (id_producao) REFERENCES PRODUCAO (id)
);