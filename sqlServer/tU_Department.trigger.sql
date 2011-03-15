CREATE TRIGGER tU_Department ON Department FOR UPDATE AS
/* ERwin Builtin Trigger */
/* UPDATE trigger on Department */
BEGIN
  DECLARE  @numrows int,
           @nullcnt int,
           @validcnt int,
           @insdepartment_id uniqueidentifier,
           @errno   int,
           @errmsg  varchar(255)

  SELECT @numrows = @@rowcount
  /* ERwin Builtin Trigger */
  /* Department  Employee on parent update no action */
  /* ERWIN_RELATION:CHECKSUM="00027746", PARENT_OWNER="", PARENT_TABLE="Department"
    CHILD_OWNER="", CHILD_TABLE="Employee"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_15", FK_COLUMNS="department_id" */
  IF
    /* %ParentPK(" OR",UPDATE) */
    UPDATE(department_id)
  BEGIN
    IF EXISTS (
      SELECT * FROM deleted,Employee
      WHERE
        /*  %JoinFKPK(Employee,deleted," = "," AND") */
        Employee.department_id = deleted.department_id
    )
    BEGIN
      SELECT @errno  = 30005,
             @errmsg = 'Cannot update Department because Employee exists.'
      GOTO error
    END
  END

  /* ERwin Builtin Trigger */
  /* Company  Department on child update no action */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Company"
    CHILD_OWNER="", CHILD_TABLE="Department"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_11", FK_COLUMNS="company_id" */
  IF
    /* %ChildFK(" OR",UPDATE) */
    UPDATE(company_id)
  BEGIN
    SELECT @nullcnt = 0
    SELECT @validcnt = count(*)
      FROM inserted,Company
        WHERE
          /* %JoinFKPK(inserted,Company) */
          inserted.company_id = Company.company_id
    /* %NotnullFK(inserted," IS NULL","select @nullcnt = count(*) from inserted where"," AND") */
    select @nullcnt = count(*) from inserted where
      inserted.company_id IS NULL
    IF @validcnt + @nullcnt != @numrows
    BEGIN
      SELECT @errno  = 30007,
             @errmsg = 'Cannot update Department because Company does not exist.'
      GOTO error
    END
  END


  /* ERwin Builtin Trigger */
  RETURN
error:
    raiserror @errno @errmsg
    rollback transaction
END


