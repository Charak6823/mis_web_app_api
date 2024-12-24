ALTER TABLE products
DROP
CONSTRAINT FK4jrye1dmcuiykyrdp2qb40jn8
GO

ALTER TABLE products
DROP
CONSTRAINT FKej2ob3ifydf846t2a2tntna4e
GO

ALTER TABLE categories
DROP
CONSTRAINT FKg0bpmlxxp99ol8tahi0aohk0x
GO

ALTER TABLE products
DROP
CONSTRAINT FKh5l4pix4d0mc61aibdt3gj898
GO

ALTER TABLE categories
DROP
CONSTRAINT FKodlpvnu5doun3tpjcnef8raro
GO

ALTER TABLE products
DROP
CONSTRAINT FKoxpvjg9c463906x8llbss8tn7
GO

CREATE TABLE suppliers
(
    supplier_id   int NOT NULL,
    supplier_name NVARCHAR(50(50),
    sex           nvarchar(20),
    contact_name  NVARCHAR(50(50),
    contact_phone varchar(255),
    address       nvarchar(255),
    description   nvarchar(255),
    warehouse_id  int,
    created_at    datetime,
    created_by    varchar(255),
    updated_at    datetime,
    updated_by    varchar(255),
    CONSTRAINT pk_suppliers PRIMARY KEY (supplier_id)
)
    GO

ALTER TABLE products
    ADD batch_no varchar(255)
GO

ALTER TABLE products
    ADD brand_id int
GO

ALTER TABLE products
    ADD category_id int
GO

ALTER TABLE products
    ADD company_id int
GO

ALTER TABLE products
    ADD day_alert int
GO

ALTER TABLE products
    ADD old_meter_per_kg int
GO

ALTER TABLE products
    ADD product_code varchar(255)
GO

ALTER TABLE products
    ADD product_id int
GO

ALTER TABLE products
    ADD product_name varchar(255)
GO

ALTER TABLE products
    ADD qty_alert int
GO

ALTER TABLE products
    ADD qty_on_hand int
GO

ALTER TABLE products
    ADD start_balance int
GO

ALTER TABLE products
    ADD stock_type varchar(255)
GO

ALTER TABLE products
    ADD supplier_id int
GO

ALTER TABLE products
    ADD warehouse_id int
GO

ALTER TABLE brands
    ADD brand_id int
GO

ALTER TABLE brands
    ADD brand_name nvarchar(255)
GO

ALTER TABLE brands
    ADD short_name nvarchar(255)
GO

ALTER TABLE brands
    ALTER COLUMN brand_id int NOT NULL
GO

ALTER TABLE categories
    ADD category_id int
GO

ALTER TABLE categories
    ADD category_main_id int
GO

ALTER TABLE categories
    ADD category_name varchar(255)
GO

ALTER TABLE categories
    ADD category_name_kh varchar(255)
GO

ALTER TABLE categories
    ADD printer_id int
GO

ALTER TABLE categories
    ALTER COLUMN category_id int NOT NULL
GO

ALTER TABLE category_mains
    ADD category_main_id int
GO

ALTER TABLE category_mains
    ADD short_name varchar(255)
GO

ALTER TABLE category_mains
    ALTER COLUMN category_main_id int NOT NULL
GO

ALTER TABLE companies
    ADD company_id int
GO

ALTER TABLE companies
    ADD company_name varchar(255)
GO

ALTER TABLE companies
    ALTER COLUMN company_id int NOT NULL
GO

ALTER TABLE deliveries
    ADD contact_name varchar(255)
GO

ALTER TABLE deliveries
    ADD delivery_id int
GO

ALTER TABLE deliveries
    ADD delivery_name varchar(255)
GO

ALTER TABLE deliveries
    ADD phone_number varchar(255)
GO

ALTER TABLE deliveries
    ALTER COLUMN delivery_id int NOT NULL
GO

ALTER TABLE employees
    ADD employee_id int
GO

ALTER TABLE employees
    ADD name_kh nvarchar(255)
GO

ALTER TABLE employees
    ALTER COLUMN employee_id int NOT NULL
GO

ALTER TABLE warehouse
    ADD owner_name varchar(255)
GO

ALTER TABLE warehouse
    ADD warehouse_code varchar(255)
GO

ALTER TABLE warehouse
    ADD warehouse_id int
GO

ALTER TABLE warehouse
    ADD warehouse_name varchar(255)
GO

ALTER TABLE printers
    ADD printer_id int
GO

ALTER TABLE printers
    ADD printer_name varchar(255)
GO

ALTER TABLE printers
    ALTER COLUMN printer_id int NOT NULL
GO

ALTER TABLE products
    ALTER COLUMN product_id int NOT NULL
GO

ALTER TABLE unit_types
    ADD unit_qty varchar(255)
GO

ALTER TABLE unit_types
    ADD unit_type_id int
GO

ALTER TABLE unit_types
    ADD unit_type_name varchar(255)
GO

ALTER TABLE unit_types
    ADD unit_type_name_kh varchar(255)
GO

ALTER TABLE unit_types
    ALTER COLUMN unit_type_id int NOT NULL
GO

ALTER TABLE warehouse
    ALTER COLUMN warehouse_id int NOT NULL
GO

ALTER TABLE categories
    ADD CONSTRAINT FK_CATEGORIES_ON_CATEGORYMAINID FOREIGN KEY (category_main_id) REFERENCES category_mains (category_main_id)
GO

ALTER TABLE categories
    ADD CONSTRAINT FK_CATEGORIES_ON_PRINTERID FOREIGN KEY (printer_id) REFERENCES printers (printer_id)
GO

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_BRANDID FOREIGN KEY (brand_id) REFERENCES brands (brand_id)
GO

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORYID FOREIGN KEY (category_id) REFERENCES categories (category_id)
GO

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_COMPANYID FOREIGN KEY (company_id) REFERENCES companies (company_id)
GO

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_SUPPLIERID FOREIGN KEY (supplier_id) REFERENCES suppliers (supplier_id)
GO

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_WAREHOUSEID FOREIGN KEY (warehouse_id) REFERENCES warehouse (warehouse_id)
GO

ALTER TABLE suppliers
    ADD CONSTRAINT FK_SUPPLIERS_ON_WAREHOUSEID FOREIGN KEY (warehouse_id) REFERENCES warehouse (warehouse_id)
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE brands DROP CONSTRAINT ' + QUOTENAME([kc].[name])
FROM [sys].[key_constraints] AS [kc]
WHERE [kc].[parent_object_id] = OBJECT_ID(N'brands')
  AND [kc].[type] = 'PK'
EXEC sp_executesql @sql
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE brands DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'brands')
  AND [c].[name] = N'brandId'
EXEC sp_executesql @sql
GO

ALTER TABLE brands
    DROP COLUMN brandId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE brands DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'brands')
  AND [c].[name] = N'brandName'
EXEC sp_executesql @sql
GO

ALTER TABLE brands
    DROP COLUMN brandName
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE brands DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'brands')
  AND [c].[name] = N'shortName'
EXEC sp_executesql @sql
GO

ALTER TABLE brands
    DROP COLUMN shortName
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE categories DROP CONSTRAINT ' + QUOTENAME([kc].[name])
FROM [sys].[key_constraints] AS [kc]
WHERE [kc].[parent_object_id] = OBJECT_ID(N'categories')
  AND [kc].[type] = 'PK'
EXEC sp_executesql @sql
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE categories DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'categories')
  AND [c].[name] = N'categoryId'
EXEC sp_executesql @sql
GO

ALTER TABLE categories
    DROP COLUMN categoryId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE categories DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'categories')
  AND [c].[name] = N'categoryMainId'
EXEC sp_executesql @sql
GO

ALTER TABLE categories
    DROP COLUMN categoryMainId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE categories DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'categories')
  AND [c].[name] = N'categoryName'
EXEC sp_executesql @sql
GO

ALTER TABLE categories
    DROP COLUMN categoryName
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE categories DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'categories')
  AND [c].[name] = N'categoryNameKh'
EXEC sp_executesql @sql
GO

ALTER TABLE categories
    DROP COLUMN categoryNameKh
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE categories DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'categories')
  AND [c].[name] = N'printerId'
EXEC sp_executesql @sql
GO

ALTER TABLE categories
    DROP COLUMN printerId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE category_mains DROP CONSTRAINT ' + QUOTENAME([kc].[name])
FROM [sys].[key_constraints] AS [kc]
WHERE [kc].[parent_object_id] = OBJECT_ID(N'category_mains')
  AND [kc].[type] = 'PK'
EXEC sp_executesql @sql
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE category_mains DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'category_mains')
  AND [c].[name] = N'categoryMainId'
EXEC sp_executesql @sql
GO

ALTER TABLE category_mains
    DROP COLUMN categoryMainId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE category_mains DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'category_mains')
  AND [c].[name] = N'shortName'
EXEC sp_executesql @sql
GO

ALTER TABLE category_mains
    DROP COLUMN shortName
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE companies DROP CONSTRAINT ' + QUOTENAME([kc].[name])
FROM [sys].[key_constraints] AS [kc]
WHERE [kc].[parent_object_id] = OBJECT_ID(N'companies')
  AND [kc].[type] = 'PK'
EXEC sp_executesql @sql
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE companies DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'companies')
  AND [c].[name] = N'companyId'
EXEC sp_executesql @sql
GO

ALTER TABLE companies
    DROP COLUMN companyId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE companies DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'companies')
  AND [c].[name] = N'companyName'
EXEC sp_executesql @sql
GO

ALTER TABLE companies
    DROP COLUMN companyName
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE deliveries DROP CONSTRAINT ' + QUOTENAME([kc].[name])
FROM [sys].[key_constraints] AS [kc]
WHERE [kc].[parent_object_id] = OBJECT_ID(N'deliveries')
  AND [kc].[type] = 'PK'
EXEC sp_executesql @sql
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE deliveries DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'deliveries')
  AND [c].[name] = N'deliveryId'
EXEC sp_executesql @sql
GO

ALTER TABLE deliveries
    DROP COLUMN deliveryId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE deliveries DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'deliveries')
  AND [c].[name] = N'contactName'
EXEC sp_executesql @sql
GO

ALTER TABLE deliveries
    DROP COLUMN contactName
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE deliveries DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'deliveries')
  AND [c].[name] = N'deliveryName'
EXEC sp_executesql @sql
GO

ALTER TABLE deliveries
    DROP COLUMN deliveryName
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE deliveries DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'deliveries')
  AND [c].[name] = N'phoneNumber'
EXEC sp_executesql @sql
GO

ALTER TABLE deliveries
    DROP COLUMN phoneNumber
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE employees DROP CONSTRAINT ' + QUOTENAME([kc].[name])
FROM [sys].[key_constraints] AS [kc]
WHERE [kc].[parent_object_id] = OBJECT_ID(N'employees')
  AND [kc].[type] = 'PK'
EXEC sp_executesql @sql
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE employees DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'employees')
  AND [c].[name] = N'employeeId'
EXEC sp_executesql @sql
GO

ALTER TABLE employees
    DROP COLUMN employeeId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE employees DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'employees')
  AND [c].[name] = N'nameKh'
EXEC sp_executesql @sql
GO

ALTER TABLE employees
    DROP COLUMN nameKh
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE printers DROP CONSTRAINT ' + QUOTENAME([kc].[name])
FROM [sys].[key_constraints] AS [kc]
WHERE [kc].[parent_object_id] = OBJECT_ID(N'printers')
  AND [kc].[type] = 'PK'
EXEC sp_executesql @sql
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE printers DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'printers')
  AND [c].[name] = N'printerId'
EXEC sp_executesql @sql
GO

ALTER TABLE printers
    DROP COLUMN printerId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE printers DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'printers')
  AND [c].[name] = N'printerName'
EXEC sp_executesql @sql
GO

ALTER TABLE printers
    DROP COLUMN printerName
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([kc].[name])
FROM [sys].[key_constraints] AS [kc]
WHERE [kc].[parent_object_id] = OBJECT_ID(N'products')
  AND [kc].[type] = 'PK'
EXEC sp_executesql @sql
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'products')
  AND [c].[name] = N'productId'
EXEC sp_executesql @sql
GO

ALTER TABLE products
    DROP COLUMN productId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'products')
  AND [c].[name] = N'batchNo'
EXEC sp_executesql @sql
GO

ALTER TABLE products
    DROP COLUMN batchNo
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'products')
  AND [c].[name] = N'brandId'
EXEC sp_executesql @sql
GO

ALTER TABLE products
    DROP COLUMN brandId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'products')
  AND [c].[name] = N'categoryId'
EXEC sp_executesql @sql
GO

ALTER TABLE products
    DROP COLUMN categoryId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'products')
  AND [c].[name] = N'companyId'
EXEC sp_executesql @sql
GO

ALTER TABLE products
    DROP COLUMN companyId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'products')
  AND [c].[name] = N'dayAlert'
EXEC sp_executesql @sql
GO

ALTER TABLE products
    DROP COLUMN dayAlert
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'products')
  AND [c].[name] = N'oldMeterPerKg'
EXEC sp_executesql @sql
GO

ALTER TABLE products
    DROP COLUMN oldMeterPerKg
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'products')
  AND [c].[name] = N'productCode'
EXEC sp_executesql @sql
GO

ALTER TABLE products
    DROP COLUMN productCode
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'products')
  AND [c].[name] = N'productName'
EXEC sp_executesql @sql
GO

ALTER TABLE products
    DROP COLUMN productName
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'products')
  AND [c].[name] = N'qtyAlert'
EXEC sp_executesql @sql
GO

ALTER TABLE products
    DROP COLUMN qtyAlert
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'products')
  AND [c].[name] = N'qtyOnHand'
EXEC sp_executesql @sql
GO

ALTER TABLE products
    DROP COLUMN qtyOnHand
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'products')
  AND [c].[name] = N'startBalance'
EXEC sp_executesql @sql
GO

ALTER TABLE products
    DROP COLUMN startBalance
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'products')
  AND [c].[name] = N'stockType'
EXEC sp_executesql @sql
GO

ALTER TABLE products
    DROP COLUMN stockType
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'products')
  AND [c].[name] = N'supplierId'
EXEC sp_executesql @sql
GO

ALTER TABLE products
    DROP COLUMN supplierId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE products DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'products')
  AND [c].[name] = N'warehouseId'
EXEC sp_executesql @sql
GO

ALTER TABLE products
    DROP COLUMN warehouseId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE unit_types DROP CONSTRAINT ' + QUOTENAME([kc].[name])
FROM [sys].[key_constraints] AS [kc]
WHERE [kc].[parent_object_id] = OBJECT_ID(N'unit_types')
  AND [kc].[type] = 'PK'
EXEC sp_executesql @sql
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE unit_types DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'unit_types')
  AND [c].[name] = N'unitTypeId'
EXEC sp_executesql @sql
GO

ALTER TABLE unit_types
    DROP COLUMN unitTypeId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE unit_types DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'unit_types')
  AND [c].[name] = N'unitQty'
EXEC sp_executesql @sql
GO

ALTER TABLE unit_types
    DROP COLUMN unitQty
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE unit_types DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'unit_types')
  AND [c].[name] = N'unitTypeName'
EXEC sp_executesql @sql
GO

ALTER TABLE unit_types
    DROP COLUMN unitTypeName
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE unit_types DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'unit_types')
  AND [c].[name] = N'unitTypeNameKh'
EXEC sp_executesql @sql
GO

ALTER TABLE unit_types
    DROP COLUMN unitTypeNameKh
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE warehouse DROP CONSTRAINT ' + QUOTENAME([kc].[name])
FROM [sys].[key_constraints] AS [kc]
WHERE [kc].[parent_object_id] = OBJECT_ID(N'warehouse')
  AND [kc].[type] = 'PK'
EXEC sp_executesql @sql
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE warehouse DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'warehouse')
  AND [c].[name] = N'warehouseId'
EXEC sp_executesql @sql
GO

ALTER TABLE warehouse
    DROP COLUMN warehouseId
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE warehouse DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'warehouse')
  AND [c].[name] = N'ownerName'
EXEC sp_executesql @sql
GO

ALTER TABLE warehouse
    DROP COLUMN ownerName
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE warehouse DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'warehouse')
  AND [c].[name] = N'warehouseCode'
EXEC sp_executesql @sql
GO

ALTER TABLE warehouse
    DROP COLUMN warehouseCode
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE warehouse DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'warehouse')
  AND [c].[name] = N'warehouseName'
EXEC sp_executesql @sql
GO

ALTER TABLE warehouse
    DROP COLUMN warehouseName
GO

ALTER TABLE brands
    ADD CONSTRAINT DF_brands_status DEFAULT 'ACT' FOR status
GO

ALTER TABLE employees
    ADD CONSTRAINT DF_employees_status DEFAULT 'ACT' FOR status
GO

ALTER TABLE brands
    ADD CONSTRAINT pk_brands PRIMARY KEY (brand_id)
GO

ALTER TABLE categories
    ADD CONSTRAINT pk_categories PRIMARY KEY (category_id)
GO

ALTER TABLE category_mains
    ADD CONSTRAINT pk_category_mains PRIMARY KEY (category_main_id)
GO

ALTER TABLE companies
    ADD CONSTRAINT pk_companies PRIMARY KEY (company_id)
GO

ALTER TABLE deliveries
    ADD CONSTRAINT pk_deliveries PRIMARY KEY (delivery_id)
GO

ALTER TABLE employees
    ADD CONSTRAINT pk_employees PRIMARY KEY (employee_id)
GO

ALTER TABLE printers
    ADD CONSTRAINT pk_printers PRIMARY KEY (printer_id)
GO

ALTER TABLE products
    ADD CONSTRAINT pk_products PRIMARY KEY (product_id)
GO

ALTER TABLE unit_types
    ADD CONSTRAINT pk_unit_types PRIMARY KEY (unit_type_id)
GO

ALTER TABLE warehouse
    ADD CONSTRAINT pk_warehouse PRIMARY KEY (warehouse_id)
GO