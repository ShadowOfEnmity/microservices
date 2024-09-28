create table experience
(
    id              bigint auto_increment primary key,
    sequence_number int          not null,
    period_from     date         not null,
    period_to       date         null,
    present_time    bit          not null,
    industry_id     bigint       not null,
    company         varchar(40)  not null,
    position        varchar(40)  not null,
    achievements    varchar(200) null,
    link            varchar(255) null
);

create table duties
(
    experience_id bigint       not null,
    duty_name     varchar(120) not null,
    constraint fk_duties_experience_id
        foreign key (experience_id) references experience (id)
);
