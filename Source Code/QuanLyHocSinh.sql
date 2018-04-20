CREATE DATABASE QuanLyHocSinh

GO
USE QuanLyHocSinh

GO
CREATE TABLE HocSinh
    (
      MaHS INT NOT NULL
               PRIMARY KEY ,
      TenHS NVARCHAR(50) ,
      NgaySinh DATETIME ,
      Ghichu NVARCHAR(100) ,
      ExtInfo IMAGE
    )
GO

SELECT * FROM dbo.HocSinh

--INSERT  dbo.HocSinh
--        ( MaHS ,
--          TenHS ,
--          NgaySinh ,
--          Ghichu ,
--          ExtInfo
--        )
--VALUES  ( 0 , -- MaHS - int
--          N'Quang' , -- TenHS - nvarchar(50)
--          '19970328' , -- NgaySinh - datetime
--          N'hihi' , -- Ghichu - nvarchar(100)
--          NULL  -- ExtInfo - image
--        )

--GO
		
--CREATE PROC USP_InsertStudent
--    @id INT ,
--    @name NVARCHAR(50) ,
--    @birth DATE ,
--    @note NVARCHAR(100) ,
--    @image IMAGE
--AS
--    BEGIN
--        INSERT  dbo.HocSinh
--                ( MaHS ,
--                  TenHS ,
--                  NgaySinh ,
--                  Ghichu ,
--                  ExtInfo
--                )
--        VALUES  ( @id , -- MaHS - int
--                  @name , -- TenHS - nvarchar(50)
--                  @birth , -- NgaySinh - datetime
--                  @note , -- Ghichu - nvarchar(100)
--                  @image -- ExtInfo - image
--                ) 
--    END
--GO


----/////////////////////////
--INSERT  dbo.HocSinh
--        ( MaHS ,
--          TenHS ,
--          NgaySinh ,
--          Ghichu ,
--          ExtInfo
--        )
--VALUES  ( 2 , -- MaHS - int
--          N'quangg' , -- TenHS - nvarchar(50)
--          '19110303' , -- NgaySinh - datetime
--          N'dd' , -- Ghichu - nvarchar(100)
--          NULL  -- ExtInfo - image
--        )


--GO


--EXEC dbo.USP_InsertStudent @id = 10, -- int
--    @name = N'qqq', -- nvarchar(50)
--    @birth = '20180330', -- date
--    @note = N'ss', -- nvarchar(100)
--    @image = NULL
-- -- image
         

--GO

--CREATE PROC USP_GetImageById @id INT
--AS
--    BEGIN
--        SELECT  ExtInfo
--        FROM    dbo.HocSinh
--        WHERE   MaHS = @id
--    END

--GO

--CREATE PROC USP_UpdateStuById
--    @id INT ,
--    @name NVARCHAR(50) ,
--    @birth DATE ,
--    @notes NVARCHAR(100) ,
--    @img IMAGE
--AS
--    BEGIN

--        UPDATE  dbo.HocSinh
--        SET     TenHS = @name ,
--                NgaySinh = @birth ,
--                Ghichu = @notes ,
--                ExtInfo = @img
--        WHERE   MaHS = @id
--    END
--GO

--EXEC dbo.USP_UpdateStuById @id = 0, -- int
--    @name = N'', -- nvarchar(50)
--    @birth = '2018-03-30 19:10:32', -- date
--    @notes = N'', -- nvarchar(100)
--    @img = NULL
-- -- image


--EXEC dbo.USP_GetImageById @id = 0
-- -- int


--SELECT  *
--FROM    dbo.HocSinh
