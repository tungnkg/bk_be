create table clinics
(
    id            int auto_increment,
    name          varchar(255)                       null,
    description   text                               null,
    image_path    text                               null,
    province_id int                           null,
    district_id int                           null,
    ward_id     int                           null,
    address       int                                null,
    created_date  datetime default current_timestamp not null,
    is_deleted    boolean  default false             not null,
    updated_date  datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    constraint clinics_pk
        primary key (id)
);

create table specialties
(
    id            int auto_increment,
    name          varchar(255)                       null,
    description   text                               null,
    image_path    text                               null,
    created_date  datetime default current_timestamp not null,
    is_deleted    boolean  default false             not null,
    updated_date  datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    constraint specities_pk
        primary key (id)
);

