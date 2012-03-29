CREATE PROC dbo.ShowHierarchy
(
	@Root uniqueidentifier
)
AS
BEGIN
	SET NOCOUNT ON
	DECLARE @DeptID uniqueidentifier, @DeptName varchar(30)

	SET @DeptName = (SELECT Name FROM dbo.Department WHERE department_id = @Root)
	PRINT REPLICATE('-', @@NESTLEVEL * 4) + @DeptName
	PRINT 'Depth:' + Cast(@@NESTLEVEL as nvarchar(40)) 

	SET @DeptID = (SELECT (department_id) FROM dbo.Department WHERE parent_id = @Root)

	WHILE @DeptID IS NOT NULL
	BEGIN
		EXEC dbo.ShowHierarchy @DeptID
		SET @DeptID = (SELECT (department_id) FROM dbo.Department WHERE parent_id = @Root AND department_id > @DeptID)
	END
END
GO
