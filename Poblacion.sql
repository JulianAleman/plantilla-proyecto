INSERT INTO Cliente (Cedula, nombre) VALUES ('1234567890', 'a');
INSERT INTO Cliente (Cedula, nombre) VALUES ('0987654321', 'b');
INSERT INTO Cliente (Cedula, nombre) VALUES ('1122334455', 'c');
INSERT INTO Cliente (Cedula, nombre) VALUES ('2233445566', 'd');
INSERT INTO Cliente (Cedula, nombre) VALUES ('3344556677', 'e');

INSERT INTO Ciudad (codigo, nombre) VALUES (ciudad_seq.NEXTVAL, 'Bogota');
INSERT INTO Ciudad (codigo, nombre) VALUES (ciudad_seq.NEXTVAL, 'Cali');
INSERT INTO Ciudad (codigo, nombre) VALUES (ciudad_seq.NEXTVAL, 'Pasto');
INSERT INTO Ciudad (codigo, nombre) VALUES (ciudad_seq.NEXTVAL, 'Medellin');
INSERT INTO Ciudad (codigo, nombre) VALUES (ciudad_seq.NEXTVAL, 'Boyaca');

INSERT INTO Sucursal (Id, Nombre, Tamaño, Direccion, telefono, Codigo_Ciudad) VALUES (sucursal_seq.NEXTVAL, 'Sucursal Central', 500, 'Calle 1', '3001234567', 1);
INSERT INTO Sucursal (Id, Nombre, Tamaño, Direccion, telefono, Codigo_Ciudad) VALUES (sucursal_seq.NEXTVAL, 'Sucursal Norte', 300, 'Calle 2', '3002345678', 2);
INSERT INTO Sucursal (Id, Nombre, Tamaño, Direccion, telefono, Codigo_Ciudad) VALUES (sucursal_seq.NEXTVAL, 'Sucursal Sur', 400, 'Calle 3', '3003456789', 3);
INSERT INTO Sucursal (Id, Nombre, Tamaño, Direccion, telefono, Codigo_Ciudad) VALUES (sucursal_seq.NEXTVAL, 'Sucursal Este', 600, 'Calle 4', '3004567890', 4);
INSERT INTO Sucursal (Id, Nombre, Tamaño, Direccion, telefono, Codigo_Ciudad) VALUES (sucursal_seq.NEXTVAL, 'Sucursal Oeste', 700, 'Calle 5', '3005678901', 5);

INSERT INTO Bodega (Id, Nombre, Tamaño, Id_Sucursal) VALUES (bodega_seq.NEXTVAL, 'Bodega Central', 500, 1);
INSERT INTO Bodega (Id, Nombre, Tamaño, Id_Sucursal) VALUES (bodega_seq.NEXTVAL, 'Bodega Norte', 300, 2);
INSERT INTO Bodega (Id, Nombre, Tamaño, Id_Sucursal) VALUES (bodega_seq.NEXTVAL, 'Bodega Sur', 400, 3);
INSERT INTO Bodega (Id, Nombre, Tamaño, Id_Sucursal) VALUES (bodega_seq.NEXTVAL, 'Bodega Este', 600, 4);
INSERT INTO Bodega (Id, Nombre, Tamaño, Id_Sucursal) VALUES (bodega_seq.NEXTVAL, 'Bodega Oeste', 700, 5);

INSERT INTO Categoria (Codigo, Nombre, Descripcion, Caracteristicas_Almacenamiento) VALUES (categoria_seq.NEXTVAL, 'Alimentos', 'Productos comestibles y perecederos', 'Almacenar en lugar fresco y seco');
INSERT INTO Categoria (Codigo, Nombre, Descripcion, Caracteristicas_Almacenamiento) VALUES (categoria_seq.NEXTVAL, 'Ropa', 'Prendas de vestir para diferentes climas', 'Almacenar en lugar seco y ventilado');
INSERT INTO Categoria (Codigo, Nombre, Descripcion, Caracteristicas_Almacenamiento) VALUES (categoria_seq.NEXTVAL, 'Electr?nica', 'Dispositivos electr?nicos y electrodom?sticos', 'Almacenar en lugar seco, evitar humedad');
INSERT INTO Categoria (Codigo, Nombre, Descripcion, Caracteristicas_Almacenamiento) VALUES (categoria_seq.NEXTVAL, 'Muebles', 'Art?culos para el hogar y oficina', 'Almacenar en lugar seco, evitar golpes');
INSERT INTO Categoria (Codigo, Nombre, Descripcion, Caracteristicas_Almacenamiento) VALUES (categoria_seq.NEXTVAL, 'Juguetes', 'Art?culos de entretenimiento para ni?os', 'Almacenar en lugar seco, evitar exposici?n al sol');

INSERT INTO Detalle_Costo_Bodega (Id, Costo_Unitario_Bodega, Cantidad_Existencias) VALUES (Detalle_Costo_Bodega_seq.NEXTVAL, 100.00, 50);
INSERT INTO Detalle_Costo_Bodega (Id, Costo_Unitario_Bodega, Cantidad_Existencias) VALUES (Detalle_Costo_Bodega_seq.NEXTVAL, 150.50, 100);
INSERT INTO Detalle_Costo_Bodega (Id, Costo_Unitario_Bodega, Cantidad_Existencias) VALUES (Detalle_Costo_Bodega_seq.NEXTVAL, 200.75, 75);
INSERT INTO Detalle_Costo_Bodega (Id, Costo_Unitario_Bodega, Cantidad_Existencias) VALUES (Detalle_Costo_Bodega_seq.NEXTVAL, 250.00, 30);
INSERT INTO Detalle_Costo_Bodega (Id, Costo_Unitario_Bodega, Cantidad_Existencias) VALUES (Detalle_Costo_Bodega_seq.NEXTVAL, 300.25, 20);

INSERT INTO Especificacion_Empacado (Id, Volumen_cm3, Peso_Gr) VALUES (Especificacion_Empacado_seq.NEXTVAL, 1000, 200);
INSERT INTO Especificacion_Empacado (Id, Volumen_cm3, Peso_Gr) VALUES (Especificacion_Empacado_seq.NEXTVAL, 1500, 150);
INSERT INTO Especificacion_Empacado (Id, Volumen_cm3, Peso_Gr) VALUES (Especificacion_Empacado_seq.NEXTVAL, 2000, 100);
INSERT INTO Especificacion_Empacado (Id, Volumen_cm3, Peso_Gr) VALUES (Especificacion_Empacado_seq.NEXTVAL, 2500, 50);
INSERT INTO Especificacion_Empacado (Id, Volumen_cm3, Peso_Gr) VALUES (Especificacion_Empacado_seq.NEXTVAL, 3000, 25);

INSERT INTO Producto (Codigo_Barras, Nombre, Precio_Unitario_Venta, Presentacion, Cantidad_Presentacion, Unidad_Medida, Fecha_Expiracion, Codigo_Categoria, Id_Especificacion_Empacado) VALUES (producto_seq.NEXTVAL, 'Manzana', 1.50, 'Bolsa de 1 kg', 1, 'kg', TO_DATE('2024-12-31', 'YYYY-MM-DD'), 1, 1);
INSERT INTO Producto (Codigo_Barras, Nombre, Precio_Unitario_Venta, Presentacion, Cantidad_Presentacion, Unidad_Medida,  Fecha_Expiracion, Codigo_Categoria, Id_Especificacion_Empacado) VALUES (producto_seq.NEXTVAL, 'Camiseta', 15.00, 'Unidad', 1, 'kg', NULL, 2, 2);
INSERT INTO Producto (Codigo_Barras, Nombre, Precio_Unitario_Venta, Presentacion, Cantidad_Presentacion, Unidad_Medida,  Fecha_Expiracion, Codigo_Categoria, Id_Especificacion_Empacado) VALUES (producto_seq.NEXTVAL, 'Televisor', 500.00, 'Unidad', 1, 'ml', NULL, 3, 3);
INSERT INTO Producto (Codigo_Barras, Nombre, Precio_Unitario_Venta, Presentacion, Cantidad_Presentacion, Unidad_Medida,  Fecha_Expiracion, Codigo_Categoria, Id_Especificacion_Empacado) VALUES (producto_seq.NEXTVAL, 'Sof?', 300.00, 'Unidad', 1, 'ml', NULL, 4, 4);
INSERT INTO Producto (Codigo_Barras, Nombre, Precio_Unitario_Venta, Presentacion, Cantidad_Presentacion, Unidad_Medida,  Fecha_Expiracion, Codigo_Categoria, Id_Especificacion_Empacado) VALUES (producto_seq.NEXTVAL, 'Mu?eca', 20.00, 'Unidad', 1, 'kg', NULL, 5, 5);

INSERT INTO Producto_Perecedero (Codigo_Barras_Producto, fecha_Vencimiento) VALUES (1001, TO_DATE('2024-12-31', 'YYYY-MM-DD'));
INSERT INTO Producto_Perecedero (Codigo_Barras_Producto, fecha_Vencimiento) VALUES (1002, TO_DATE('2024-11-30', 'YYYY-MM-DD'));
INSERT INTO Producto_Perecedero (Codigo_Barras_Producto, fecha_Vencimiento) VALUES (1003, TO_DATE('2024-10-15', 'YYYY-MM-DD'));
INSERT INTO Producto_Perecedero (Codigo_Barras_Producto, fecha_Vencimiento) VALUES (1004, TO_DATE('2024-09-01', 'YYYY-MM-DD'));
INSERT INTO Producto_Perecedero (Codigo_Barras_Producto, fecha_Vencimiento) VALUES (1005, TO_DATE('2024-08-20', 'YYYY-MM-DD'));

INSERT INTO Proveedor (Nit, Nombre, Direccion, Nombre_Contacto, Telefono_Contacto) VALUES ('12345678901', 'Proveedor A', 'Calle Proveedor A', 'Juan P?rez', '3001112233');
INSERT INTO Proveedor (Nit, Nombre, Direccion, Nombre_Contacto, Telefono_Contacto) VALUES ('23456789012', 'Proveedor B', 'Calle Proveedor B', 'Ana G?mez', '3002223344');
INSERT INTO Proveedor (Nit, Nombre, Direccion, Nombre_Contacto, Telefono_Contacto) VALUES ('34567890123', 'Proveedor C', 'Calle Proveedor C', 'Luis Mart?nez', '3003334455');
INSERT INTO Proveedor (Nit, Nombre, Direccion, Nombre_Contacto, Telefono_Contacto) VALUES ('45678901234', 'Proveedor D', 'Calle Proveedor D', 'Sof?a L?pez', '3004445566');
INSERT INTO Proveedor (Nit, Nombre, Direccion, Nombre_Contacto, Telefono_Contacto) VALUES ('56789012345', 'Proveedor E', 'Calle Proveedor E', 'Carlos S?nchez', '3005556677');

INSERT INTO Orden_Compra (Id, Fecha_Creacion, Estado, Fecha_Entrega, Nit_Proveedor, Id_Sucursal) VALUES (Orden_Compra_seq.NEXTVAL, TO_DATE('2024-01-01', 'YYYY-MM-DD'), 'vigente', TO_DATE('2024-01-15', 'YYYY-MM-DD'), '12345678901', 1);
INSERT INTO Orden_Compra (Id, Fecha_Creacion, Estado, Fecha_Entrega, Nit_Proveedor, Id_Sucursal) VALUES (Orden_Compra_seq.NEXTVAL, TO_DATE('2024-01-02', 'YYYY-MM-DD'), 'vigente', TO_DATE('2024-01-16', 'YYYY-MM-DD'), '23456789012', 2);
INSERT INTO Orden_Compra (Id, Fecha_Creacion, Estado, Fecha_Entrega, Nit_Proveedor, Id_Sucursal) VALUES (Orden_Compra_seq.NEXTVAL, TO_DATE('2024-01-03', 'YYYY-MM-DD'), 'vigente', TO_DATE('2024-01-17', 'YYYY-MM-DD'), '34567890123', 3);
INSERT INTO Orden_Compra (Id, Fecha_Creacion, Estado, Fecha_Entrega, Nit_Proveedor, Id_Sucursal) VALUES (Orden_Compra_seq.NEXTVAL, TO_DATE('2024-01-04', 'YYYY-MM-DD'), 'vigente', TO_DATE('2024-01-18', 'YYYY-MM-DD'), '45678901234', 4);
INSERT INTO Orden_Compra (Id, Fecha_Creacion, Estado, Fecha_Entrega, Nit_Proveedor, Id_Sucursal) VALUES (Orden_Compra_seq.NEXTVAL, TO_DATE('2024-01-05', 'YYYY-MM-DD'), 'vigente', TO_DATE('2024-01-19', 'YYYY-MM-DD'), '56789012345', 5);

INSERT INTO Recepcion_Productos (Id, fecha_Recepcion, Id_Bodega, Id_Orden_Compra) VALUES (recepcion_productos_seq.NEXTVAL, TO_DATE('2024-01-10', 'YYYY-MM-DD'), 1, 1);
INSERT INTO Recepcion_Productos (Id, fecha_Recepcion, Id_Bodega, Id_Orden_Compra) VALUES (recepcion_productos_seq.NEXTVAL, TO_DATE('2024-01-11', 'YYYY-MM-DD'), 2, 2);
INSERT INTO Recepcion_Productos (Id, fecha_Recepcion, Id_Bodega, Id_Orden_Compra) VALUES (recepcion_productos_seq.NEXTVAL, TO_DATE('2024-01-12', 'YYYY-MM-DD'), 3, 3);
INSERT INTO Recepcion_Productos (Id, fecha_Recepcion, Id_Bodega, Id_Orden_Compra) VALUES (recepcion_productos_seq.NEXTVAL, TO_DATE('2024-01-13', 'YYYY-MM-DD'), 4, 4);
INSERT INTO Recepcion_Productos (Id, fecha_Recepcion, Id_Bodega, Id_Orden_Compra) VALUES (recepcion_productos_seq.NEXTVAL, TO_DATE('2024-01-14', 'YYYY-MM-DD'), 5, 5);

INSERT INTO Venta (Id, Fecha, Id_Sucursal, Cedula_Cliente) VALUES (venta_seq.NEXTVAL, TO_DATE('2024-01-15', 'YYYY-MM-DD'), 1, '1234567890');
INSERT INTO Venta (Id, Fecha, Id_Sucursal, Cedula_Cliente) VALUES (venta_seq.NEXTVAL, TO_DATE('2024-01-16', 'YYYY-MM-DD'), 2, '0987654321');
INSERT INTO Venta (Id, Fecha, Id_Sucursal, Cedula_Cliente) VALUES (venta_seq.NEXTVAL, TO_DATE('2024-01-17', 'YYYY-MM-DD'), 3, '1122334455');
INSERT INTO Venta (Id, Fecha, Id_Sucursal, Cedula_Cliente) VALUES (venta_seq.NEXTVAL, TO_DATE('2024-01-18', 'YYYY-MM-DD'), 4, '2233445566');
INSERT INTO Venta (Id, Fecha, Id_Sucursal, Cedula_Cliente) VALUES (venta_seq.NEXTVAL, TO_DATE('2024-01-19', 'YYYY-MM-DD'), 5, '3344556677');

INSERT INTO Info_Extra_Bodega (Codigo_Barras_Producto, Id_Bodega, Total_Existencia, Costo_Promedio, Capacidad_Almacenamiento, Nivel_Minimo_Re_Orden, Id_detalle_Costo_Bodega) VALUES (1001, 1, 150, 1.30, 500, 50, 1);
INSERT INTO Info_Extra_Bodega (Codigo_Barras_Producto, Id_Bodega, Total_Existencia, Costo_Promedio, Capacidad_Almacenamiento, Nivel_Minimo_Re_Orden, Id_detalle_Costo_Bodega) VALUES (1002, 2, 100, 14.50, 300, 30, 2);
INSERT INTO Info_Extra_Bodega (Codigo_Barras_Producto, Id_Bodega, Total_Existencia, Costo_Promedio, Capacidad_Almacenamiento, Nivel_Minimo_Re_Orden, Id_detalle_Costo_Bodega) VALUES (1003, 3, 75, 490.00, 400, 20, 3);
INSERT INTO Info_Extra_Bodega (Codigo_Barras_Producto, Id_Bodega, Total_Existencia, Costo_Promedio, Capacidad_Almacenamiento, Nivel_Minimo_Re_Orden, Id_detalle_Costo_Bodega) VALUES (1004, 4, 30, 280.00, 600, 10, 4);
INSERT INTO Info_Extra_Bodega (Codigo_Barras_Producto, Id_Bodega, Total_Existencia, Costo_Promedio, Capacidad_Almacenamiento, Nivel_Minimo_Re_Orden, Id_detalle_Costo_Bodega) VALUES (1005, 5, 20, 17.00, 700, 5, 5);

INSERT INTO Info_Extra_Orden (Codigo_Barras_Producto, Id_Orden_Compra, Cantidad, Costo_Unitario_Compra) VALUES (1001, 1, 10, 1.20);
INSERT INTO Info_Extra_Orden (Codigo_Barras_Producto, Id_Orden_Compra, Cantidad, Costo_Unitario_Compra) VALUES (1002, 2, 5, 14.00);
INSERT INTO Info_Extra_Orden (Codigo_Barras_Producto, Id_Orden_Compra, Cantidad, Costo_Unitario_Compra) VALUES (1003, 3, 2, 480.00);
INSERT INTO Info_Extra_Orden (Codigo_Barras_Producto, Id_Orden_Compra, Cantidad, Costo_Unitario_Compra) VALUES (1004, 4, 1, 290.00);
INSERT INTO Info_Extra_Orden (Codigo_Barras_Producto, Id_Orden_Compra, Cantidad, Costo_Unitario_Compra) VALUES (1005, 5, 3, 18.00);

INSERT INTO Info_Extra_Proveedor (Nit_Proveedor, codigo_barras_producto) VALUES ('12345678901', 1001);
INSERT INTO Info_Extra_Proveedor (Nit_Proveedor, codigo_barras_producto) VALUES ('23456789012', 1002);
INSERT INTO Info_Extra_Proveedor (Nit_Proveedor, codigo_barras_producto) VALUES ('34567890123', 1003);
INSERT INTO Info_Extra_Proveedor (Nit_Proveedor, codigo_barras_producto) VALUES ('45678901234', 1004);
INSERT INTO Info_Extra_Proveedor (Nit_Proveedor, codigo_barras_producto) VALUES ('56789012345', 1005);

INSERT INTO Info_Extra_Venta (Codigo_Barras_Producto, Id_Venta, Cantidad, Precio_Unitario_Venta) VALUES (1001, 1, 5, 1.50);
INSERT INTO Info_Extra_Venta (Codigo_Barras_Producto, Id_Venta, Cantidad, Precio_Unitario_Venta) VALUES (1002, 2, 2, 15.00);
INSERT INTO Info_Extra_Venta (Codigo_Barras_Producto, Id_Venta, Cantidad, Precio_Unitario_Venta) VALUES (1003, 3, 1, 500.00);
INSERT INTO Info_Extra_Venta (Codigo_Barras_Producto, Id_Venta, Cantidad, Precio_Unitario_Venta) VALUES (1004, 4, 1, 300.00);
INSERT INTO Info_Extra_Venta (Codigo_Barras_Producto, Id_Venta, Cantidad, Precio_Unitario_Venta) VALUES (1005, 5, 3, 20.00);