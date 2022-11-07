create database fateczsdmn20222;

create table fateczsdmn20222.usuarios (
  id BIGINT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255),
  senha VARCHAR(255),
  status VARCHAR(255),
  tipo VARCHAR(255),
  primary key (id));
  
create table fateczsdmn20222.pessoas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  rg VARCHAR(255),
  cpf VARCHAR(255),
  email VARCHAR(255),
  primary key (id));

create table fateczsdmn20222.logradouros (
  id BIGINT NOT NULL AUTO_INCREMENT,
  end VARCHAR(255),
  cep VARCHAR(255),
  comp VARCHAR(255),
  primary key (id));
  
  create table fateczsdmn20222.Status (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  obs VARCHAR(255),
    primary key (id));
    
  create table fateczsdmn20222.treinadores (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  cpf VARCHAR(255),
    primary key (id));    
    
  create table fateczsdmn20222.pokemon (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  tipo VARCHAR(255),
    primary key (id));
    
  create table fateczsdmn20222.ginasio (
  id BIGINT NOT NULL AUTO_INCREMENT,
  estado VARCHAR(255),
  pais VARCHAR(255),
    primary key (id));   
    
    
 create table fateczsdmn20222.treinador_pokemon (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idPokemon BIGINT,
  idTreinador BIGINT, 
  obs VARCHAR(255),
  primary key (id));    
    

  create table fateczsdmn20222.usuarios_pessoas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idPessoa BIGINT,
  idUsuario BIGINT, 
  obs VARCHAR(255),
  primary key (id));
  
  create table fateczsdmn20222.logradouros_pessoas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idPessoa BIGINT,
  idLogradouro BIGINT, 
  obs VARCHAR(255),
  primary key (id));
  
ALTER TABLE fateczsdmn20222.usuarios_pessoas ADD CONSTRAINT FK_PES_USU_ID FOREIGN KEY (IDPESSOA) REFERENCES fateczsdmn20222.PESSOAS (ID);

ALTER TABLE fateczsdmn20222.usuarios_pessoas ADD CONSTRAINT FK_USU_PES_ID FOREIGN KEY (IDUSUARIO) REFERENCES fateczsdmn20222.USUARIOS (ID);  

ALTER TABLE fateczsdmn20222.logradouros_pessoas ADD CONSTRAINT FK_PES_USU_ID FOREIGN KEY (IDPESSOA) REFERENCES fateczsdmn20222.PESSOAS (ID);

ALTER TABLE fateczsdmn20222.logradouros_pessoas ADD CONSTRAINT FK_USU_PES_ID FOREIGN KEY (IDLOGRADOURO) REFERENCES fateczsdmn20222.LOGRADOUROS (ID);  

  
INSERT INTO `fateczsdmn20222`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('BITTENCOURT', 'ABFABF010101', 'ATIVO', 'ADM');
INSERT INTO `fateczsdmn20222`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('SCURACCHIO', 'ABFABF010101', 'ATIVO', 'VISITANTE');

select * from fateczsdmn20222.usuarios_pessoas 
select * from fateczsdmn20222.logradouros_PESSOAS
select * from fateczsdmn20222.pokemon