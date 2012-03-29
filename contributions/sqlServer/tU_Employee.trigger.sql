CREATE TRIGGER tU_Employee ON Employee FOR UPDATE AS
/* ERwin Builtin Trigger */
/* UPDATE trigger on Employee */
BEGIN
  DECLARE  @numrows int,
           @nullcnt int,
           @validcnt int,
           @insemployee_id uniqueidentifier, 
           @insperson_id uniqueidentifier, 
           @insdepartment_id uniqueidentifier,
           @errno   int,
           @errmsg  varchar(255)

  SELECT @numrows = @@rowcount
  /* ERwin Builtin Trigger */
  /* Department  Employee on child update no action */
  /* ERWIN_RELATION:CHECKSUM="00028c9d", PARENT_OWNER="", PARENT_TABLE="Department"
    CHILD_OWNER="", CHILD_TABLE="Employee"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_15", FK_COLUMNS="department_id" */
  IF
    /* %ChildFK(" OR",UPDATE) */
    UPDATE(department_id)
  BEGIN
    SELECT @nullcnt = 0
    SELECT @validcnt = count(*)
      FROM inserted,Department
        WHERE
          /* %JoinFKPK(inserted,Department) */
          inserted.department_id = Department.department_id
    /* %NotnullFK(inserted," IS NULL","select @nullcnt = count(*) from inserted where"," AND") */
    
    IF @validcnt + @nullcnt != @numrows
    BEGIN
      SELECT @errno  = 30007,
             @errmsg = 'Cannot update Employee because Department does not exist.'
      GOTO error
    END
  END

  /* ERwin Builtin Trigger */
  /* Person  Employee on child update no action */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Person"
    CHILD_OWNER="", CHILD_TABLE="Employee"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_14", FK_COLUMNS="person_id" */
  IF
    /* %ChildFK(" OR",UPDATE) */
    UPDATE(person_id)
  BEGIN
    SELECT @nullcnt = 0
    SELECT @validcnt = count(*)
      FROM inserted,Person
        WHERE
          /* %JoinFKPK(inserted,Person) */
          inserted.person_id = Person.person_id
    /* %NotnullFK(inserted," IS NULL","select @nullcnt = count(*) from inserted where"," AND") */
    
    IF @validcnt + @nullcnt != @numrows
    BEGIN
      SELECT @errno  = 30007,
             @errmsg = 'Cannot update Employee because Person does not exist.'
      GOTO error
    END
  END


  /* ERwin Builtin Trigger */
  RETURN
error:
    raiserror @errno @errmsg
    rollback transaction
END


