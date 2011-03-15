CREATE TRIGGER tU_Person ON Person FOR UPDATE AS
/* ERwin Builtin Trigger */
/* UPDATE trigger on Person */
BEGIN
  DECLARE  @numrows int,
           @nullcnt int,
           @validcnt int,
           @insperson_id uniqueidentifier,
           @errno   int,
           @errmsg  varchar(255)

  SELECT @numrows = @@rowcount
  /* ERwin Builtin Trigger */
  /* Person  Employee on parent update no action */
  /* ERWIN_RELATION:CHECKSUM="0001058c", PARENT_OWNER="", PARENT_TABLE="Person"
    CHILD_OWNER="", CHILD_TABLE="Employee"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_14", FK_COLUMNS="person_id" */
  IF
    /* %ParentPK(" OR",UPDATE) */
    UPDATE(person_id)
  BEGIN
    IF EXISTS (
      SELECT * FROM deleted,Employee
      WHERE
        /*  %JoinFKPK(Employee,deleted," = "," AND") */
        Employee.person_id = deleted.person_id
    )
    BEGIN
      SELECT @errno  = 30005,
             @errmsg = 'Cannot update Person because Employee exists.'
      GOTO error
    END
  END


  /* ERwin Builtin Trigger */
  RETURN
error:
    raiserror @errno @errmsg
    rollback transaction
END


