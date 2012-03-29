CREATE TRIGGER tD_Person ON Person FOR DELETE AS
/* ERwin Builtin Trigger */
/* DELETE trigger on Person */
BEGIN
  DECLARE  @errno   int,
           @errmsg  varchar(255)
    /* ERwin Builtin Trigger */
    /* Person  Employee on parent delete no action */
    /* ERWIN_RELATION:CHECKSUM="0000ec14", PARENT_OWNER="", PARENT_TABLE="Person"
    CHILD_OWNER="", CHILD_TABLE="Employee"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_14", FK_COLUMNS="person_id" */
    IF EXISTS (
      SELECT * FROM deleted,Employee
      WHERE
        /*  %JoinFKPK(Employee,deleted," = "," AND") */
        Employee.person_id = deleted.person_id
    )
    BEGIN
      SELECT @errno  = 30001,
             @errmsg = 'Cannot delete Person because Employee exists.'
      GOTO error
    END


    /* ERwin Builtin Trigger */
    RETURN
error:
    raiserror @errno @errmsg
    rollback transaction
END


