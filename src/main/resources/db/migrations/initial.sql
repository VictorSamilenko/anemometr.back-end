DROP TABLE IF EXISTS public.states CASCADE;
DROP TABLE IF EXISTS public.settings CASCADE;
DROP TABLE IF EXISTS public.devices CASCADE;

CREATE TABLE public.devices
(
  id BIGSERIAL PRIMARY KEY NOT NULL,
  imei VARCHAR(17) NOT NULL,
  name VARCHAR(255),
  latitude NUMERIC,
  longitude NUMERIC
);
CREATE UNIQUE INDEX devices_id_uindex ON public.devices (id);
CREATE UNIQUE INDEX devices_imei_uindex ON public.devices (imei);

CREATE TABLE public.settings
(
  device_id BIGINT PRIMARY KEY NOT NULL,
  delay INT DEFAULT 300,
  CONSTRAINT settings_device_fk FOREIGN KEY (device_id) REFERENCES devices (id) ON DELETE CASCADE
);


CREATE TABLE public.states
(
  id BIGSERIAL PRIMARY KEY NOT NULL,
  device_id BIGINT,
  state_time TIMESTAMP DEFAULT now()::timestamp(0),
  wind_speed NUMERIC(4,2),
  wind_direction INT,
  voltage NUMERIC(4,2),
  CONSTRAINT states_device_fk FOREIGN KEY (device_id) REFERENCES devices (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX states_id_uindex ON public.states (id);