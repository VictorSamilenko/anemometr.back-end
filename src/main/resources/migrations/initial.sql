create table devices (
	id bigserial not null constraint devices_pkey primary key,
	imei varchar(17) not null,
	latitude numeric,
	longitude numeric);

create unique index devices_id_uindex on devices (id);

create unique index devices_imei_uindex	on devices (imei);

create table settings (
	device_id bigint not null constraint settings_pkey primary key
		constraint settings_device_fk
			references devices
				on delete cascade,
	delay integer default 300
);

create table states
(
	id bigserial not null
		constraint states_pkey
			primary key,
	device_id bigint
		constraint states_device_fk
			references devices
				on delete cascade,
	state_time timestamp default (now())::timestamp(0) without time zone,
	wind_speed numeric(4,2),
	wind_direction integer,
	voltage numeric(4,2)
)
;

create unique index states_id_uindex
	on states (id)
;

