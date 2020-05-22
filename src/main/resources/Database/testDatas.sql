INSERT INTO storage.stores(id, name, location, mobile)	VALUES (1, 'teszt1', 'Budapest', '06201231231');
INSERT INTO storage.stores(id, name, location, mobile)	VALUES (2, 'teszt2', 'Szeged', '06304564566');
INSERT INTO storage.stores(id, name, location, mobile)	VALUES (3, 'teszt3', 'Debrecen', '06709999995');

INSERT INTO storage.lines(id, name) VALUES (1, 'A');
INSERT INTO storage.lines(id, name) VALUES (2, 'B');
INSERT INTO storage.lines(id, name) VALUES (3, 'C');

INSERT INTO storage.shelfs(id, name) VALUES (1, '/1');
INSERT INTO storage.shelfs(id, name) VALUES (2, '/2');
INSERT INTO storage.shelfs(id, name) VALUES (3, '/3');
INSERT INTO storage.shelfs(id, name) VALUES (4, '/4');
INSERT INTO storage.shelfs(id, name) VALUES (5, '/5');

INSERT INTO storage.floors(id, name) VALUES (1, '0');
INSERT INTO storage.floors(id, name) VALUES (2, '1');
INSERT INTO storage.floors(id, name) VALUES (3, '2');
INSERT INTO storage.floors(id, name) VALUES (4, '3');
INSERT INTO storage.floors(id, name) VALUES (5, '4');

INSERT INTO storage.roles(id, role_name) VALUES (1, 'ADMIN');
INSERT INTO storage.roles(id, role_name) VALUES (2, 'DESIGNER');
INSERT INTO storage.roles(id, role_name) VALUES (3, 'STOREKEEPER');

INSERT INTO storage.permissions(id, permission_name) VALUES (23, 'READ_WORKPIECE');
INSERT INTO storage.permissions(id, permission_name) VALUES (1, 'CREATE_WORKPIECE');
INSERT INTO storage.permissions(id, permission_name) VALUES (2, 'UPDATE_WORKPIECE');
INSERT INTO storage.permissions(id, permission_name) VALUES (3, 'DELETE_WORKPIECE');
INSERT INTO storage.permissions(id, permission_name) VALUES (13, 'ORDER_WORKPIECE');
INSERT INTO storage.permissions(id, permission_name) VALUES (14, 'RESERVED_WORKPIECE');
INSERT INTO storage.permissions(id, permission_name) VALUES (18, 'SUBTRACTION_WORKPIECE');
INSERT INTO storage.permissions(id, permission_name) VALUES (19, 'TAKEOVER_WORKPIECE');

INSERT INTO storage.permissions(id, permission_name) VALUES (24, 'READ_BLUEPRINT');
INSERT INTO storage.permissions(id, permission_name) VALUES (4, 'CREATE_BLUEPRINT');
INSERT INTO storage.permissions(id, permission_name) VALUES (5, 'DELETE_BLUEPRINT');
INSERT INTO storage.permissions(id, permission_name) VALUES (6, 'UPDATE_BLUEPRINT');

INSERT INTO storage.permissions(id, permission_name) VALUES (25, 'READ_USER');
INSERT INTO storage.permissions(id, permission_name) VALUES (7, 'CREATE_USER');
INSERT INTO storage.permissions(id, permission_name) VALUES (8, 'DELETE_USER');
INSERT INTO storage.permissions(id, permission_name) VALUES (9, 'UPDATE_USER');

INSERT INTO storage.permissions(id, permission_name) VALUES (26, 'READ_ROLE');
INSERT INTO storage.permissions(id, permission_name) VALUES (10, 'CREATE_ROLE');
INSERT INTO storage.permissions(id, permission_name) VALUES (11, 'UPDATE_ROLE');
INSERT INTO storage.permissions(id, permission_name) VALUES (12, 'DELETE_ROLE');

INSERT INTO storage.permissions(id, permission_name) VALUES (27, 'READ_LOCATION');
INSERT INTO storage.permissions(id, permission_name) VALUES (15, 'CREATE_LOCATION');
INSERT INTO storage.permissions(id, permission_name) VALUES (16, 'UPDATE_LOCATION');
INSERT INTO storage.permissions(id, permission_name) VALUES (17, 'DELETE_LOCATION');

INSERT INTO storage.permissions(id, permission_name) VALUES (28, 'READ_STORE');
INSERT INTO storage.permissions(id, permission_name) VALUES (20, 'CREATE_STORE');
INSERT INTO storage.permissions(id, permission_name) VALUES (21, 'UPDATE_STORE');
INSERT INTO storage.permissions(id, permission_name) VALUES (22, 'DELETE_STORE');


INSERT INTO storage.roles_permissions(id, permission_id, role_id) VALUES (1, 1, 1);
INSERT INTO storage.roles_permissions(id, permission_id, role_id) VALUES (2, 2, 1);
INSERT INTO storage.roles_permissions(id, permission_id, role_id) VALUES (3, 3, 1);
INSERT INTO storage.roles_permissions(id, permission_id, role_id) VALUES (4, 4, 1);
INSERT INTO storage.roles_permissions(id, permission_id, role_id) VALUES (5, 5, 1);
INSERT INTO storage.roles_permissions(id, permission_id, role_id) VALUES (6, 1, 2);
INSERT INTO storage.roles_permissions(id, permission_id, role_id) VALUES (7, 2, 2);

INSERT INTO storage.users(id, user_name, pwd, first_name, last_name, email, role_id, language, unit, dark_mode)VALUES (1, 'teszt', '1', 'Béla', 'Teszt', 'teszt@teszt.hu', 1, 'EN', 'MM', TRUE);
INSERT INTO storage.users(id, user_name, pwd, first_name, last_name, email, role_id, language, unit, dark_mode)VALUES (2, 'teszt2', '1', 'PETI', 'Teszt', 'teszt2@teszt2.hu2', 2, 'HU', 'COL', FALSE);

INSERT INTO storage.workpieces(id, width, depth, lenght, external_diameter, internal_diameter, material, shape, reserved_date, reserved_user_id, under_order, order_user_id, order_date) VALUES (1, 30, 40, 33, 0, 0, 'ALU', 'TABLE', '2004-10-19 10:23:54+02', 1, FALSE, 1, '2004-10-10 10:23:54+02');
INSERT INTO storage.workpieces(id, width, depth, lenght, external_diameter, internal_diameter, material, shape, reserved_date, reserved_user_id, under_order, order_user_id, order_date) VALUES (2, 0, 0, 33, 40, 38, 'STE', 'PIPE', '2004-10-19 10:23:54+02', 1, FALSE, 1, '2004-10-10 10:23:54+02');
INSERT INTO storage.workpieces(id, width, depth, lenght, external_diameter, internal_diameter, material, shape, reserved_date, reserved_user_id, under_order, order_user_id, order_date) VALUES (3, 60, 6000, 33, 0, 0, 'ALU', 'TABLE', '2004-10-19 10:23:54+02', 1, FALSE, 1, '2004-10-10 10:23:54+02');
INSERT INTO storage.workpieces(id, width, depth, lenght, external_diameter, internal_diameter, material, shape, reserved_date, reserved_user_id, under_order, order_user_id, order_date) VALUES (4, 110, 400, 300, 0, 0, 'ALU', 'TABLE', '2004-10-19 10:23:54+02', 1, FALSE, 1, NULL);
INSERT INTO storage.workpieces(id, width, depth, lenght, external_diameter, internal_diameter, material, shape, reserved_date, reserved_user_id, under_order, order_user_id, order_date) VALUES (5, 0, 0, 300, 30, 20, 'STE', 'PIPE', '2004-10-19 10:23:54+02', 1, FALSE, 1, '2004-10-10 10:23:54+02');
INSERT INTO storage.workpieces(id, width, depth, lenght, external_diameter, internal_diameter, material, shape, reserved_date, reserved_user_id, under_order, order_user_id, order_date) VALUES (6, 10, 30, 10, 0, 0, 'ALU', 'TABLE', '2004-10-19 10:23:54+02', 1, FALSE, 1, NULL);

INSERT INTO storage.blueprints(id, desinger_id, created_date, last_updated_date, last_updater_id, workpiece_id)VALUES (1, 1, '2004-10-19 10:23:54+02', '2004-10-19 10:23:54+02', 1, 1);
INSERT INTO storage.blueprints(id, desinger_id, created_date, last_updated_date, last_updater_id, workpiece_id)VALUES (2, 2, '2004-10-19 10:23:54+02', '2004-10-14 10:23:54+02', 2, 2);
INSERT INTO storage.blueprints(id, desinger_id, created_date, last_updated_date, last_updater_id, workpiece_id)VALUES (3, 2, '2004-10-19 10:23:54+02', '2004-10-20 10:23:54+02', 2, 3);
INSERT INTO storage.blueprints(id, desinger_id, created_date, last_updated_date, last_updater_id, workpiece_id)VALUES (4, 1, '2004-10-19 10:23:54+02', '2004-10-19 10:23:54+02', 1, 4);

INSERT INTO storage.locations(id, store_id, line_id, shelf_id, floor_id, workpiece_id) VALUES (1, 1, 1, 1, 1, 1);
INSERT INTO storage.locations(id, store_id, line_id, shelf_id, floor_id, workpiece_id) VALUES (2, 2, 2, 2, 1, 2);
INSERT INTO storage.locations(id, store_id, line_id, shelf_id, floor_id, workpiece_id) VALUES (3, 1, 1, 3, 1, 3);
INSERT INTO storage.locations(id, store_id, line_id, shelf_id, floor_id, workpiece_id) VALUES (4, 1, 2, 1, 1, 4);