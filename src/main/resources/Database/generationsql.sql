DO $$
BEGIN
    IF EXISTS
    (SELECT 
      schema_name
    FROM 
      information_schema.schemata 
    WHERE 
      schema_name = 'storage')
    THEN
      DROP SCHEMA STORAGE CASCADE; 
    END IF; 

    CREATE SCHEMA IF NOT EXISTS STORAGE ;
	
CREATE TABLE Storage.lines (
  "id" NUMERIC(18,0),
  "name" varchar(30),

CONSTRAINT Lines_PK PRIMARY KEY (id)
);
CREATE SEQUENCE Storage.SEQ_LINES INCREMENT BY 1 MINVALUE 100 NO MAXVALUE START WITH 100 RESTART WITH 100 CACHE 5 NO CYCLE;


CREATE TABLE Storage.shelfs (
  "id" NUMERIC(18,0),
  "name" varchar(30),

CONSTRAINT Shelfs_PK PRIMARY KEY (id)
);
CREATE SEQUENCE Storage.SEQ_Shelfs INCREMENT BY 1 MINVALUE 100 NO MAXVALUE START WITH 100 RESTART WITH 100 CACHE 5 NO CYCLE;


CREATE TABLE Storage.floors (
  "id" NUMERIC(18,0),
  "name" varchar(30),

CONSTRAINT Floors_PK PRIMARY KEY (id)
);
CREATE SEQUENCE Storage.SEQ_FLOORS INCREMENT BY 1 MINVALUE 100 NO MAXVALUE START WITH 100 RESTART WITH 100 CACHE 5 NO CYCLE;


CREATE TABLE Storage.stores (
  "id" NUMERIC(18,0) NOT NULL,
  "name" varchar(50)NOT NULL,
  "location" varchar(50),
  "mobile" varchar(11),

CONSTRAINT Stores_PK PRIMARY KEY (id)
);
CREATE SEQUENCE Storage.SEQ_STORES INCREMENT BY 1 MINVALUE 100 NO MAXVALUE START WITH 100 RESTART WITH 100 CACHE 5 NO CYCLE;


CREATE TABLE Storage.permissions (
  "id" NUMERIC(18,0) NOT NULL,
  "permission_name" varchar(30) NOT NULL,

CONSTRAINT Permissions_PK PRIMARY KEY (id)
);
CREATE SEQUENCE Storage.SEQ_PERMISSONS INCREMENT BY 1 MINVALUE 100 NO MAXVALUE START WITH 100 RESTART WITH 100 CACHE 5 NO CYCLE;


CREATE TABLE Storage.roles (
  "id" NUMERIC(18,0) NOT NULL,
  "role_name" varchar NOT NULL,

CONSTRAINT Roles_PK PRIMARY KEY (id)
);
CREATE SEQUENCE Storage.SEQ_ROLES INCREMENT BY 1 MINVALUE 100 NO MAXVALUE START WITH 100 RESTART WITH 100 CACHE 5 NO CYCLE;


CREATE TABLE Storage.roles_permissions (
  "id" NUMERIC(18,0) NOT NULL,
  "permission_id" NUMERIC(18,0) NOT NULL,
  "role_id" NUMERIC(18,0) NOT NULL,

CONSTRAINT Roles_permissions_PK PRIMARY KEY (id),
CONSTRAINT Permissons_Roles_FK FOREIGN KEY (permission_id) REFERENCES Storage.permissions (id),
CONSTRAINT Roles_Permissons_FK FOREIGN KEY (role_id) REFERENCES Storage.roles (id)
);
CREATE SEQUENCE Storage.SEQ_ROLES_PERMISSIONS INCREMENT BY 1 MINVALUE 100 NO MAXVALUE START WITH 100 RESTART WITH 100 CACHE 5 NO CYCLE;


CREATE TABLE Storage.users (
  "id" NUMERIC(18,0) NOT NULL,
  "user_name" varchar(30) NOT NULL,
  "pwd" varchar(500) NOT NULL,
  "first_name" varchar(30)NOT NULL,
  "last_name" varchar(30)NOT NULL,
  "email" varchar(30) NOT NULL,
  "role_id" NUMERIC(18,0),
  "language" varchar(30),
  "unit" varchar(5),
  "dark_mode" boolean,

CONSTRAINT Users_PK PRIMARY KEY (id),
CONSTRAINT Users_Roles_FK FOREIGN KEY (role_id) REFERENCES Storage.roles (id)
);
CREATE SEQUENCE Storage.SEQ_USERS INCREMENT BY 1 MINVALUE 100 NO MAXVALUE START WITH 100 RESTART WITH 100 CACHE 5 NO CYCLE;


CREATE TABLE Storage.workpieces (
  "id" NUMERIC(18,0) NOT NULL,
  "width" integer,
  "depth" integer,
  "lenght" integer,
  "external_diameter" integer,
  "internal_diameter" integer,
  "material" varchar(50),
  "shape" varchar(50),
  "reserved_date" TIMESTAMP(6) WITH TIME ZONE,
  "reserved_user_id" NUMERIC(18,0),
  "under_order" boolean,
  "order_user_id" NUMERIC(18,0),
  "order_date" TIMESTAMP(6) WITH TIME ZONE,

CONSTRAINT Workpieces_PK PRIMARY KEY (id),
CONSTRAINT Workpieces_Users_FK FOREIGN KEY (reserved_user_id) REFERENCES Storage.users (id),
CONSTRAINT Workpieces_Users_FK2 FOREIGN KEY (order_user_id) REFERENCES Storage.users (id)
);
CREATE SEQUENCE Storage.SEQ_WORKPIECES INCREMENT BY 1 MINVALUE 100 NO MAXVALUE START WITH 100 RESTART WITH 100 CACHE 5 NO CYCLE;


CREATE TABLE Storage.locations (
  "id" NUMERIC(18,0),
  "store_id" NUMERIC(18,0),
  "line_id" NUMERIC(18,0),
  "shelf_id" NUMERIC(18,0),
  "floor_id" NUMERIC(18,0),
  "workpiece_id" NUMERIC(18,0),

CONSTRAINT Locations_PK PRIMARY KEY (id),
CONSTRAINT Locations_Stores_FK FOREIGN KEY (store_id) REFERENCES Storage.Stores (id),
CONSTRAINT Locations_Lines_FK FOREIGN KEY (line_id) REFERENCES Storage.Lines (id),
CONSTRAINT Locations_Shelf_FK FOREIGN KEY (shelf_id) REFERENCES Storage.Shelfs (id),
CONSTRAINT Locations_Floor_FK2 FOREIGN KEY (floor_id) REFERENCES Storage.Floors (id),
CONSTRAINT Locations_Workpiece_FK FOREIGN KEY (workpiece_id) REFERENCES Storage.Workpieces (id)
);
CREATE SEQUENCE Storage.SEQ_LOCATIONS INCREMENT BY 1 MINVALUE 100 NO MAXVALUE START WITH 100 RESTART WITH 100 CACHE 5 NO CYCLE;


CREATE TABLE Storage.blueprints (
  "id" varchar(50),
  "desinger_id" NUMERIC(18,0),
  "created_date" TIMESTAMP(6) WITH TIME ZONE,
  "last_updated_date" TIMESTAMP(6) WITH TIME ZONE,
  "last_updater_id" NUMERIC(18,0),
  "workpiece_id" NUMERIC(18,0),

CONSTRAINT Blueprints_PK PRIMARY KEY (id),
CONSTRAINT Blueprints_Users_FK FOREIGN KEY (desinger_id) REFERENCES Storage.Users (id),
CONSTRAINT Blueprints_Users_FK2 FOREIGN KEY (last_updater_id) REFERENCES Storage.Users (id),
CONSTRAINT Blueprints_Workpieces_FK FOREIGN KEY (workpiece_id) REFERENCES Storage.Workpieces (id)
);
CREATE SEQUENCE Storage.SEQ_BLUEPRINTS INCREMENT BY 1 MINVALUE 100 NO MAXVALUE START WITH 100 RESTART WITH 100 CACHE 5 NO CYCLE;

END$$;