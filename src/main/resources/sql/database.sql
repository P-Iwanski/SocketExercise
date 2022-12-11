CREATE SCHEMA IF NOT EXISTS `RecruitmentExercise` DEFAULT CHARACTER SET utf8 ;
USE `RecruitmentExercise` ;


Create table RecruitmentExercise.users
(
    id          int         not null AUTO_INCREMENT comment 'id',
    nick       varchar(60) not null comment 'nick',
    login       varchar(60) not null comment 'login',
    password    varchar(60) not null comment 'password',
    insert_time timestamp   not null comment 'insert_time',
    primary key(id),
    UNIQUE INDEX `user_id_UNIQUE` (`id` ASC),
    UNIQUE INDEX `user_login_UNIQUE` (`login` ASC)
);
create table RecruitmentExercise.vehicles
(
    id          int         not null AUTO_INCREMENT comment 'id',
    user_id int not null comment 'user_id',
    user_login     varchar(60)       not null comment 'user_login',
    brand       varchar(60) not null comment 'brand',
    model       varchar(60) not null comment 'model',
    insert_time timestamp   not null comment 'insert_time',
    primary key(id),
        CONSTRAINT user_id foreign key (user_id) references RecruitmentExercise.users (id),
    CONSTRAINT user_login  foreign key (user_login) references RecruitmentExercise.users (login)
);


create table RecruitmentExercise.insurance_offers
(
    id          int         not null AUTO_INCREMENT comment 'id',
    vehicle_id  int         not null comment 'vehicle_id',
    user__id    int  not null comment 'user_id',
    insurer     varchar(60) not null comment 'insurer',
    price       float       not null comment 'price',
    insert_time timestamp   not null comment 'insert_time',
    primary key (id),
    constraint vehicle_id
        foreign key (vehicle_id) references RecruitmentExercise.vehicles (id),
    constraint user__id
        foreign key (user__id) references RecruitmentExercise.users (id)
);