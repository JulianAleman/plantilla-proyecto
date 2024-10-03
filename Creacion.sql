CREATE TABLE Sucursal(
Id NUMBER PRIMARY KEY,
Nombre VARCHAR2(50) NOT NULL UNIQUE ,
Tamaño NUMBER NOT NULL ,
Direccion VARCHAR2(50) NOT NULL UNIQUE,
telefono VARCHAR2(10) NOT NULL UNIQUE,
Codigo_Ciudad NUMBER NOT NULL
);

CREATE TABLE Ciudad (
Codigo NUMBER PRIMARY KEY,
Nombre VARCHAR2(50) NOT NULL UNIQUE
);

CREATE TABLE Cliente(
Cedula VARCHAR2(10) PRIMARY KEY,
Nombre VARCHAR2(50) NOT NULL UNIQUE
);

CREATE TABLE Producto_Perecedero(
Codigo_Barras_Producto NUMBER NOT NULL UNIQUE,
fecha_Vencimiento DATE NOT NULL
);

CREATE TABLE Venta(
Id NUMBER PRIMARY KEY ,
Fecha DATE NOT NULL,
Id_Sucursal NUMBER,
Cedula_Cliente VARCHAR2(10)
);

CREATE TABLE Bodega(
Id NUMBER PRIMARY KEY,
Nombre VARCHAR(50) NOT NULL UNIQUE,
Tamaño NUMBER NOT NULL,
Id_Sucursal NUMBER
);

CREATE TABLE Recepcion_Productos(
Id NUMBER PRIMARY KEY,
fecha_Recepcion DATE NOT NULL,
Id_Bodega NUMBER,
Id_Orden_Compra NUMBER
);

CREATE TABLE Orden_Compra(
Id NUMBER PRIMARY KEY,
Fecha_Creacion DATE NOT NULL,
Estado VARCHAR2(20) DEFAULT 'vigente',
Fecha_Entrega DATE NOT NULL,
Nit_Proveedor VARCHAR2(11),
Id_Sucursal NUMBER
);

CREATE TABLE Proveedor(
Nit VARCHAR2(11) PRIMARY KEY,
Nombre VARCHAR2(50) NOT NULL UNIQUE,
Direccion VARCHAR2(20) NOT NULL UNIQUE,
Nombre_Contacto VARCHAR2(50) NOT NULL UNIQUE,
Telefono_Contacto VARCHAR2(10) NOT NULL UNIQUE
);

CREATE TABLE Producto(
Codigo_Barras NUMBER PRIMARY KEY,
Nombre VARCHAR2(50) NOT NULL UNIQUE,
Precio_Unitario_Venta NUMBER NOT NULL,
Presentacion VARCHAR2(100) NOT NULL,
Cantidad_Presentacion NUMBER NOT NULL,
Unidad_Medida VARCHAR2(5) NOT NULL,
Fecha_Expiracion DATE,
Codigo_Categoria NUMBER,
Id_Especificacion_Empacado NUMBER
);

CREATE TABLE Especificacion_Empacado(
Id NUMBER PRIMARY KEY,
Volumen_cm3 NUMBER NOT NULL,
Peso_Gr NUMBER NOT NULL
);
CREATE TABLE Info_Extra_Orden(
Codigo_Barras_Producto NUMBER,
Id_Orden_Compra NUMBER,
Cantidad NUMBER NOT NULL,
Costo_Unitario_Compra NUMBER NOT NULL,
CONSTRAINT unique_infoExtraOrden UNIQUE ( Codigo_Barras_Producto, Id_Orden_Compra));

CREATE TABLE Info_Extra_Bodega(
Codigo_Barras_Producto NUMBER, 
Id_Bodega NUMBER,
Total_Existencia NUMBER NOT NULL,
Costo_Promedio NUMBER NOT NULL,
Capacidad_Almacenamiento NUMBER NOT NULL,
Nivel_Minimo_Re_Orden NUMBER NOT NULL,
Id_detalle_Costo_Bodega NUMBER,
CONSTRAINT unique_extraBodega UNIQUE ( Codigo_Barras_Producto, Id_Bodega)

);

CREATE TABLE Detalle_Costo_Bodega(
Id NUMBER PRIMARY KEY,
Costo_Unitario_Bodega NUMBER NOT NULL,
Cantidad_Existencias NUMBER NOT NULL
);

CREATE TABLE Categoria(
Codigo NUMBER PRIMARY KEY,
Nombre VARCHAR2(50) NOT NULL UNIQUE,
Descripcion VARCHAR2(100) NOT NULL,
Caracteristicas_Almacenamiento VARCHAR(200) NOT NULL
);
CREATE TABLE Info_Extra_Venta(
Codigo_Barras_Producto NUMBER,
Id_Venta NUMBER,
Cantidad NUMBER NOT NULL,
Precio_Unitario_Venta NUMBER NOT NULL,
CONSTRAINT unique_extraVentao UNIQUE (Codigo_Barras_Producto, Id_Venta)

);
CREATE TABLE Info_Extra_Proveedor(
Nit_Proveedor VARCHAR2(11), 
Codigo_Barras_Producto NUMBER,
CONSTRAINT unique_proveedor_producto UNIQUE (Nit_Proveedor, Codigo_Barras_Producto));

ALTER TABLE Sucursal 
ADD CONSTRAINT FK_codigo_ciudad 
FOREIGN KEY (Codigo_Ciudad) REFERENCES Ciudad(Codigo); 

ALTER TABLE Producto_Perecedero 
ADD CONSTRAINT FK_p_codigoBarras_producto 
FOREIGN KEY (Codigo_Barras_Producto) REFERENCES Producto(Codigo_Barras);  

ALTER TABLE Venta 
ADD CONSTRAINT FK_Id_Sucursal 
FOREIGN KEY (Id_Sucursal) REFERENCES Sucursal(Id); 

ALTER TABLE Venta 
ADD CONSTRAINT FK_Cedula_Cliente 
FOREIGN KEY (Cedula_Cliente) REFERENCES Cliente(Cedula); 

ALTER TABLE Bodega
ADD CONSTRAINT FK_Id_Sucursal1  
FOREIGN KEY (Id_Sucursal) REFERENCES Sucursal(Id); 

ALTER TABLE Recepcion_Productos 
ADD CONSTRAINT FK_Id_Bodega 
FOREIGN KEY (Id_Bodega) REFERENCES Bodega(Id); 

ALTER TABLE Recepcion_Productos 
ADD CONSTRAINT FK_Id_OrdenCompra1  
FOREIGN KEY (Id_Orden_Compra) REFERENCES Orden_Compra(Id); 

ALTER TABLE Orden_Compra 
ADD CONSTRAINT FK_Nit_Proveedor  
FOREIGN KEY (Nit_Proveedor) REFERENCES Proveedor (Nit); 

ALTER TABLE Orden_Compra 
ADD CONSTRAINT FK_OC_Id_Sucursal 
FOREIGN KEY (Id_Sucursal) REFERENCES Sucursal (Id); 

ALTER TABLE Producto 
ADD CONSTRAINT FK_Codigo_Categoria 
FOREIGN KEY (Codigo_Categoria) REFERENCES Categoria (Codigo); 

ALTER TABLE Producto 
ADD CONSTRAINT FK_Id_Especificacion_Empacado 
FOREIGN KEY (Id_Especificacion_Empacado) REFERENCES  Especificacion_Empacado (Id); 
 
ALTER TABLE Info_Extra_Orden 
ADD CONSTRAINT FK_CodigoBarras_Producto 
FOREIGN KEY (Codigo_Barras_Producto) REFERENCES Producto (Codigo_Barras); 

ALTER TABLE Info_Extra_Orden 
ADD CONSTRAINT FK_IE_Id_OrdenCompra 
FOREIGN KEY (Id_Orden_Compra) REFERENCES Orden_Compra (Id); 

ALTER TABLE Info_Extra_Bodega 
ADD CONSTRAINT FK_IEB_codigoBarras_producto 
FOREIGN KEY (Codigo_Barras_Producto) REFERENCES Producto(Codigo_Barras); 

ALTER TABLE Info_Extra_Bodega 
ADD CONSTRAINT FK_IE_Id_Bodega 
FOREIGN KEY (Id_Bodega) REFERENCES Bodega(Id); 

ALTER TABLE Info_Extra_Bodega 
ADD CONSTRAINT FK_IE_Id_detalleCostoBodega 
FOREIGN KEY (Id_detalle_Costo_Bodega) REFERENCES Detalle_Costo_Bodega(Id); 

ALTER TABLE Info_Extra_Venta 
ADD CONSTRAINT FK_IEV_codigoBarras_producto 
FOREIGN KEY (Codigo_Barras_Producto) REFERENCES Producto(Codigo_Barras); 

ALTER TABLE Info_Extra_Venta 
ADD CONSTRAINT FK_Id_Venta 
FOREIGN KEY (Id_Venta) REFERENCES Venta(id); 

ALTER TABLE Info_Extra_Proveedor  
ADD CONSTRAINT FK_IE_Nit_Proveedor  
FOREIGN KEY (Nit_Proveedor) REFERENCES Proveedor (Nit); 

ALTER TABLE Info_Extra_Proveedor 
ADD CONSTRAINT FK_codigo_Barras_producto 
FOREIGN KEY (Codigo_Barras_Producto) REFERENCES Producto(Codigo_Barras);


CREATE SEQUENCE bodega_seq START WITH 1 INCREMENT BY 1 ;
CREATE SEQUENCE sucursal_seq START WITH 1 INCREMENT BY 1 ;
CREATE SEQUENCE producto_seq START WITH 1001 INCREMENT BY 1 ;
CREATE SEQUENCE ciudad_seq START WITH 1 INCREMENT BY 1 ;
CREATE SEQUENCE venta_seq START WITH 1 INCREMENT BY 1 ;
CREATE SEQUENCE recepcion_productos_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE categoria_seq START WITH 1 INCREMENT BY 1 ;
CREATE SEQUENCE Orden_Compra_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE Detalle_Costo_Bodega_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE Especificacion_Empacado_seq START WITH 1 INCREMENT BY 1;