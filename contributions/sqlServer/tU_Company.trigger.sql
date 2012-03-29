CREATE TRIGGER tU_Company ON Company FOR UPDATE AS
/* ERwin Builtin Trigger */
/* UPDATE trigger on Company */
BEGIN
  DECLARE  @numrows int,
           @nullcnt int,
           @validcnt int,
           @inscompany_id uniqueidentifier,
           @errno   int,
           @errmsg  varchar(255)

  SELECT @numrows = @@rowcount
  /* ERwin Builtin Trigger */
  /* Company  Department on parent update no action */
  /* ERWIN_RELATION:CHECKSUM="00011066", PARENT_OWNER="", PARENT_TABLE="Company"
    CHILD_OWNER="", CHILD_TABLE="Department"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_11", FK_COLUMNS="company_id" */
  IF
    /* %ParentPK(" OR",UPDATE) */
    UPDATE(company_id)
  BEGIN
    IF EXISTS (
      SELECT * FROM deleted,Department
      WHERE
        /*  %JoinFKPK(Department,deleted," = "," AND") */
        Department.company_id = deleted.company_id
    )
    BEGIN
      SELECT @errno  = 30005,
             @errmsg = 'Cannot update Company because Department exists.'
      GOTO error
    END
  END


  /* ERwin Builtin Trigger */
  RETURN
error:
    raiserror @errno @errmsg
    rollback transaction
END


