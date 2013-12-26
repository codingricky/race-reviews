# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table comment (
  id                        bigint not null,
  race_id                   bigint not null,
  comment                   varchar(255),
  constraint pk_comment primary key (id))
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

create sequence comment_seq;

create sequence race_seq;

create sequence rating_seq;

alter table comment add constraint fk_comment_race_1 foreign key (race_id) references race (id) on delete restrict on update restrict;
create index ix_comment_race_1 on comment (race_id);
alter table rating add constraint fk_rating_race_2 foreign key (race_id) references race (id) on delete restrict on update restrict;
create index ix_rating_race_2 on rating (race_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists comment;

drop table if exists race;

drop table if exists rating;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists comment_seq;

drop sequence if exists race_seq;

drop sequence if exists rating_seq;

