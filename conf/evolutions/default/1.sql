# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table comment (
  id                        bigint not null,
  race_id                   bigint not null,
  comment                   varchar(255),
  constraint pk_comment primary key (id))
;

create table persistable_token (
  uuid                      varchar(255) not null,
  email                     varchar(255),
  creation_time             timestamp,
  expiration_time           timestamp,
  is_sign_up                boolean,
  constraint pk_persistable_token primary key (uuid))
;

create table race (
  id                        bigint not null,
  name                      varchar(255),
  state                     varchar(255),
  suburb                    varchar(255),
  date                      timestamp,
  is_approved               boolean not null,
  constraint pk_race primary key (id))
;

create table rating (
  id                        bigint not null,
  race_id                   bigint not null,
  rating                    integer,
  constraint pk_rating primary key (id))
;

create table SecureSocialuser (
  id                        bigint not null,
  user_id                   varchar(255),
  provider_id               varchar(255),
  first_name                varchar(255),
  last_name                 varchar(255),
  full_name                 varchar(255),
  email                     varchar(255),
  avatar_url                varchar(255),
  hasher                    varchar(255),
  password                  varchar(255),
  salt                      varchar(255),
  role                      varchar(255),
  constraint pk_SecureSocialuser primary key (id))
;

create sequence comment_seq;

create sequence persistable_token_seq;

create sequence race_seq;

create sequence rating_seq;

create sequence SecureSocialuser_seq;

alter table comment add constraint fk_comment_race_1 foreign key (race_id) references race (id);
create index ix_comment_race_1 on comment (race_id);
alter table rating add constraint fk_rating_race_2 foreign key (race_id) references race (id);
create index ix_rating_race_2 on rating (race_id);



# --- !Downs

drop table if exists comment cascade;

drop table if exists persistable_token cascade;

drop table if exists race cascade;

drop table if exists rating cascade;

drop table if exists SecureSocialuser cascade;

drop sequence if exists comment_seq;

drop sequence if exists persistable_token_seq;

drop sequence if exists race_seq;

drop sequence if exists rating_seq;

drop sequence if exists SecureSocialuser_seq;

