/*==============================================================*/
/* DBMS name:      Sybase AS Anywhere 9                         */
/* Created on:     26/03/2015 22:10:07                          */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_ESTUDANT_ASSOCIATI_CURSO') then
    alter table Estudante
       delete foreign key FK_ESTUDANT_ASSOCIATI_CURSO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MODULO_ASSOCIATI_DOCENTE') then
    alter table Modulo
       delete foreign key FK_MODULO_ASSOCIATI_DOCENTE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_QUESTOES_ASSOCIATI_DOCENTE') then
    alter table Questoes
       delete foreign key FK_QUESTOES_ASSOCIATI_DOCENTE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_QUESTOES_ASSOCIATI_NIVEL_DI') then
    alter table Questoes
       delete foreign key FK_QUESTOES_ASSOCIATI_NIVEL_DI
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_QUESTOES_ASSOCIATI_UC') then
    alter table Questoes
       delete foreign key FK_QUESTOES_ASSOCIATI_UC
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_RESPOSTA_ASSOCIATI_ESTUDANT') then
    alter table Resposta
       delete foreign key FK_RESPOSTA_ASSOCIATI_ESTUDANT
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_RESPOSTA_ASSOCIATI_QUESTOES') then
    alter table Resposta
       delete foreign key FK_RESPOSTA_ASSOCIATI_QUESTOES
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_SUB_MODU_ASSOCIATI_MODULO') then
    alter table Sub_Modulo
       delete foreign key FK_SUB_MODU_ASSOCIATI_MODULO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_SUB_MODU_ASSOCIATI_QUESTOES') then
    alter table Sub_Modulo
       delete foreign key FK_SUB_MODU_ASSOCIATI_QUESTOES
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_SUB_MODU_ASSOCIATI_DOCENTE') then
    alter table Sub_Modulo
       delete foreign key FK_SUB_MODU_ASSOCIATI_DOCENTE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_UC_CURSO_ASSOCIATI_CURSO') then
    alter table UC_Curso
       delete foreign key FK_UC_CURSO_ASSOCIATI_CURSO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_UC_CURSO_ASSOCIATI_UC') then
    alter table UC_Curso
       delete foreign key FK_UC_CURSO_ASSOCIATI_UC
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='CURSO_PK'
     and t.table_name='Curso'
) then
   drop index Curso.CURSO_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='Curso'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table Curso
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='DOCENTE_PK'
     and t.table_name='Docente'
) then
   drop index Docente.DOCENTE_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='Docente'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table Docente
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='ASSOCIATION_9_FK'
     and t.table_name='Estudante'
) then
   drop index Estudante.ASSOCIATION_9_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='ESTUDANTE_PK'
     and t.table_name='Estudante'
) then
   drop index Estudante.ESTUDANTE_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='Estudante'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table Estudante
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='ASSOCIATION_8_FK'
     and t.table_name='Modulo'
) then
   drop index Modulo.ASSOCIATION_8_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='MODULO_PK'
     and t.table_name='Modulo'
) then
   drop index Modulo.MODULO_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='Modulo'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table Modulo
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='NIVEL_DIFICULDADE_PK'
     and t.table_name='Nivel_Dificuldade'
) then
   drop index Nivel_Dificuldade.NIVEL_DIFICULDADE_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='Nivel_Dificuldade'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table Nivel_Dificuldade
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='ASSOCIATION_10_FK'
     and t.table_name='Questoes'
) then
   drop index Questoes.ASSOCIATION_10_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='ASSOCIATION_4_FK'
     and t.table_name='Questoes'
) then
   drop index Questoes.ASSOCIATION_4_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='ASSOCIATION_2_FK'
     and t.table_name='Questoes'
) then
   drop index Questoes.ASSOCIATION_2_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='QUESTOES_PK'
     and t.table_name='Questoes'
) then
   drop index Questoes.QUESTOES_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='Questoes'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table Questoes
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='ASSOCIATION_6_FK2'
     and t.table_name='Resposta'
) then
   drop index Resposta.ASSOCIATION_6_FK2
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='ASSOCIATION_6_FK'
     and t.table_name='Resposta'
) then
   drop index Resposta.ASSOCIATION_6_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RESPOSTA_PK'
     and t.table_name='Resposta'
) then
   drop index Resposta.RESPOSTA_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='Resposta'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table Resposta
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='ASSOCIATION_7_FK'
     and t.table_name='Sub_Modulo'
) then
   drop index Sub_Modulo.ASSOCIATION_7_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='ASSOCIATION_3_FK'
     and t.table_name='Sub_Modulo'
) then
   drop index Sub_Modulo.ASSOCIATION_3_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='SUB_MODULO_PK'
     and t.table_name='Sub_Modulo'
) then
   drop index Sub_Modulo.SUB_MODULO_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='Sub_Modulo'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table Sub_Modulo
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='UC_PK'
     and t.table_name='UC'
) then
   drop index UC.UC_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='UC'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table UC
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='ASSOCIATION_5_FK2'
     and t.table_name='UC_Curso'
) then
   drop index UC_Curso.ASSOCIATION_5_FK2
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='ASSOCIATION_5_FK'
     and t.table_name='UC_Curso'
) then
   drop index UC_Curso.ASSOCIATION_5_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='UC_CURSO_PK'
     and t.table_name='UC_Curso'
) then
   drop index UC_Curso.UC_CURSO_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='UC_Curso'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table UC_Curso
end if;

/*==============================================================*/
/* Table: Curso                                                 */
/*==============================================================*/
create table Curso 
(
    Sigla_Curso          varchar(254)                   not null,
    Designacao_Curso     varchar(254)                   null,
    constraint PK_CURSO primary key (Sigla_Curso)
);

/*==============================================================*/
/* Index: CURSO_PK                                              */
/*==============================================================*/
create unique index CURSO_PK on Curso (
Sigla_Curso ASC
);

/*==============================================================*/
/* Table: Docente                                               */
/*==============================================================*/
create table Docente 
(
    Email_Docente        varchar(254)                   not null,
    Nome                 varchar(254)                   null,
    Senha                varchar(254)                   null,
    constraint PK_DOCENTE primary key (Email_Docente)
);

/*==============================================================*/
/* Index: DOCENTE_PK                                            */
/*==============================================================*/
create unique index DOCENTE_PK on Docente (
Email_Docente ASC
);

/*==============================================================*/
/* Table: Estudante                                             */
/*==============================================================*/
create table Estudante 
(
    Email_Aluno          varchar(254)                   not null,
    Sigla_Curso          varchar(254)                   null,
    Curso                varchar(254)                   null,
    Nome                 varchar(254)                   null,
    Senha                varchar(254)                   null,
    constraint PK_ESTUDANTE primary key (Email_Aluno)
);

/*==============================================================*/
/* Index: ESTUDANTE_PK                                          */
/*==============================================================*/
create unique index ESTUDANTE_PK on Estudante (
Email_Aluno ASC
);

/*==============================================================*/
/* Index: ASSOCIATION_9_FK                                      */
/*==============================================================*/
create  index ASSOCIATION_9_FK on Estudante (
Sigla_Curso ASC
);

/*==============================================================*/
/* Table: Modulo                                                */
/*==============================================================*/
create table Modulo 
(
    Designacao_Modulo    varchar(254)                   not null,
    Email_Docente        varchar(254)                   null,
    constraint PK_MODULO primary key (Designacao_Modulo)
);

/*==============================================================*/
/* Index: MODULO_PK                                             */
/*==============================================================*/
create unique index MODULO_PK on Modulo (
Designacao_Modulo ASC
);

/*==============================================================*/
/* Index: ASSOCIATION_8_FK                                      */
/*==============================================================*/
create  index ASSOCIATION_8_FK on Modulo (
Email_Docente ASC
);

/*==============================================================*/
/* Table: Nivel_Dificuldade                                     */
/*==============================================================*/
create table Nivel_Dificuldade 
(
    Designacao_Nivel     varchar(254)                   null,
    ID_Nivel             integer                        not null,
    constraint PK_NIVEL_DIFICULDADE primary key (ID_Nivel)
);

/*==============================================================*/
/* Index: NIVEL_DIFICULDADE_PK                                  */
/*==============================================================*/
create unique index NIVEL_DIFICULDADE_PK on Nivel_Dificuldade (
ID_Nivel ASC
);

/*==============================================================*/
/* Table: Questoes                                              */
/*==============================================================*/
create table Questoes 
(
    Texto                varchar(254)                   null,
    Resposta             integer                        null,
    Explicacao           varchar(254)                   null,
    LinkFicheiro         varchar(254)                   null,
    ID_Questao           integer                        not null,
    Sigla_UC             varchar(254)                   not null,
    Email_Docente        varchar(254)                   not null,
    ID_Nivel             integer                        not null,
    constraint PK_QUESTOES primary key (ID_Questao)
);

/*==============================================================*/
/* Index: QUESTOES_PK                                           */
/*==============================================================*/
create unique index QUESTOES_PK on Questoes (
ID_Questao ASC
);

/*==============================================================*/
/* Index: ASSOCIATION_2_FK                                      */
/*==============================================================*/
create  index ASSOCIATION_2_FK on Questoes (
ID_Nivel ASC
);

/*==============================================================*/
/* Index: ASSOCIATION_4_FK                                      */
/*==============================================================*/
create  index ASSOCIATION_4_FK on Questoes (
Sigla_UC ASC
);

/*==============================================================*/
/* Index: ASSOCIATION_10_FK                                     */
/*==============================================================*/
create  index ASSOCIATION_10_FK on Questoes (
Email_Docente ASC
);

/*==============================================================*/
/* Table: Resposta                                              */
/*==============================================================*/
create table Resposta 
(
    Email_Aluno          varchar(254)                   not null,
    ID_Questao           integer                        not null,
    Resposta_Escolhida   integer                        null,
    Data_Resposta        timestamp                      null,
    constraint PK_RESPOSTA primary key clustered (Email_Aluno, ID_Questao)
);

/*==============================================================*/
/* Index: RESPOSTA_PK                                           */
/*==============================================================*/
create unique index RESPOSTA_PK on Resposta (
Email_Aluno ASC,
ID_Questao ASC
);

/*==============================================================*/
/* Index: ASSOCIATION_6_FK                                      */
/*==============================================================*/
create  index ASSOCIATION_6_FK on Resposta (
Email_Aluno ASC
);

/*==============================================================*/
/* Index: ASSOCIATION_6_FK2                                     */
/*==============================================================*/
create  index ASSOCIATION_6_FK2 on Resposta (
ID_Questao ASC
);

/*==============================================================*/
/* Table: Sub_Modulo                                            */
/*==============================================================*/
create table Sub_Modulo 
(
    Designacao_Modulo    varchar(254)                   not null,
    Designacao_Sub_Modulo varchar(254)                   not null,
    ID_Questao           integer                        null,
    Email_Docente        varchar(254)                   null,
    constraint PK_SUB_MODULO primary key clustered (Designacao_Modulo, Designacao_Sub_Modulo)
);

/*==============================================================*/
/* Index: SUB_MODULO_PK                                         */
/*==============================================================*/
create unique index SUB_MODULO_PK on Sub_Modulo (
Designacao_Modulo ASC,
Designacao_Sub_Modulo ASC
);

/*==============================================================*/
/* Index: ASSOCIATION_3_FK                                      */
/*==============================================================*/
create  index ASSOCIATION_3_FK on Sub_Modulo (
ID_Questao ASC
);

/*==============================================================*/
/* Index: ASSOCIATION_7_FK                                      */
/*==============================================================*/
create  index ASSOCIATION_7_FK on Sub_Modulo (
Email_Docente ASC
);

/*==============================================================*/
/* Table: UC                                                    */
/*==============================================================*/
create table UC 
(
    Sigla_UC             varchar(254)                   not null,
    Designacao_UC        varchar(254)                   null,
    constraint PK_UC primary key (Sigla_UC)
);

/*==============================================================*/
/* Index: UC_PK                                                 */
/*==============================================================*/
create unique index UC_PK on UC (
Sigla_UC ASC
);

/*==============================================================*/
/* Table: UC_Curso                                              */
/*==============================================================*/
create table UC_Curso 
(
    Sigla_Curso          varchar(254)                   not null,
    Sigla_UC             varchar(254)                   not null,
    constraint PK_UC_CURSO primary key clustered (Sigla_Curso, Sigla_UC)
);

/*==============================================================*/
/* Index: UC_CURSO_PK                                           */
/*==============================================================*/
create unique index UC_CURSO_PK on UC_Curso (
Sigla_Curso ASC,
Sigla_UC ASC
);

/*==============================================================*/
/* Index: ASSOCIATION_5_FK                                      */
/*==============================================================*/
create  index ASSOCIATION_5_FK on UC_Curso (
Sigla_Curso ASC
);

/*==============================================================*/
/* Index: ASSOCIATION_5_FK2                                     */
/*==============================================================*/
create  index ASSOCIATION_5_FK2 on UC_Curso (
Sigla_UC ASC
);

alter table Estudante
   add constraint FK_ESTUDANT_ASSOCIATI_CURSO foreign key (Sigla_Curso)
      references Curso (Sigla_Curso)
      on update restrict
      on delete restrict;

alter table Modulo
   add constraint FK_MODULO_ASSOCIATI_DOCENTE foreign key (Email_Docente)
      references Docente (Email_Docente)
      on update restrict
      on delete restrict;

alter table Questoes
   add constraint FK_QUESTOES_ASSOCIATI_DOCENTE foreign key (Email_Docente)
      references Docente (Email_Docente)
      on update restrict
      on delete restrict;

alter table Questoes
   add constraint FK_QUESTOES_ASSOCIATI_NIVEL_DI foreign key (ID_Nivel)
      references Nivel_Dificuldade (ID_Nivel)
      on update restrict
      on delete restrict;

alter table Questoes
   add constraint FK_QUESTOES_ASSOCIATI_UC foreign key (Sigla_UC)
      references UC (Sigla_UC)
      on update restrict
      on delete restrict;

alter table Resposta
   add constraint FK_RESPOSTA_ASSOCIATI_ESTUDANT foreign key (Email_Aluno)
      references Estudante (Email_Aluno)
      on update restrict
      on delete restrict;

alter table Resposta
   add constraint FK_RESPOSTA_ASSOCIATI_QUESTOES foreign key (ID_Questao)
      references Questoes (ID_Questao)
      on update restrict
      on delete restrict;

alter table Sub_Modulo
   add constraint FK_SUB_MODU_ASSOCIATI_MODULO foreign key (Designacao_Modulo)
      references Modulo (Designacao_Modulo)
      on update restrict
      on delete restrict;

alter table Sub_Modulo
   add constraint FK_SUB_MODU_ASSOCIATI_QUESTOES foreign key (ID_Questao)
      references Questoes (ID_Questao)
      on update restrict
      on delete restrict;

alter table Sub_Modulo
   add constraint FK_SUB_MODU_ASSOCIATI_DOCENTE foreign key (Email_Docente)
      references Docente (Email_Docente)
      on update restrict
      on delete restrict;

alter table UC_Curso
   add constraint FK_UC_CURSO_ASSOCIATI_CURSO foreign key (Sigla_Curso)
      references Curso (Sigla_Curso)
      on update restrict
      on delete restrict;

alter table UC_Curso
   add constraint FK_UC_CURSO_ASSOCIATI_UC foreign key (Sigla_UC)
      references UC (Sigla_UC)
      on update restrict
      on delete restrict;

