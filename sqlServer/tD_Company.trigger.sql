CREATE TRIGGER tD_Company ON Company FOR DELETE AS
/* ERwin Builtin Trigger */
/* DELETE trigger on Company */
BEGIN
  DECLARE  @errno   int,
           @errmsg  varchar(255)
    /* ERwin Builtin Trigger */
    /* Company  Department on parent delete no action */
    /* ERWIN_RELATION:CHECKSUM="0000e922", PARENT_OWNER="", PARENT_TABLE="Company"
    CHILD_OWNER="", CHILD_TABLE="Department"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_11", FK_COLUMNS="company_id" */
    IF EXISTS (
      SELECT * FROM deleted,Department
      WHERE
        /*  %JoinFKPK(Department,deleted," = "," AND") */
        Department.company_id = deleted.company_id
    )
    BEGIN
      SELECT @errno  = 30001,
             @errmsg = 'Cannot delete Company because Department exists.'
      GOTO error
    END


    /* ERwin Builtin Trigger */
    RETURN
error:
    raiserror @errno @errmsg
    rollback transaction
END


