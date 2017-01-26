# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table url (
  id                            bigint not null,
  url                           varchar(255),
  constraint pk_url primary key (id)
);
create sequence url_seq;


# --- !Downs

drop table if exists url;
drop sequence if exists url_seq;

