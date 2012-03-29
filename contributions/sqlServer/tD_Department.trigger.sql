CREATE TRIGGER tD_Department ON Department FOR DELETE AS
/* ERwin Builtin Trigger */
/* DELETE trigger on Department */
BEGIN
  DECLARE  @errno   int,
           @errmsg  varchar(255)
    /* ERwin Builtin Trigger */
    /* Department  Employee on parent delete no action */
    /* ERWIN_RELATION:CHECKSUM="00021e26", PARENT_OWNER="", PARENT_TABLE="Department"
    CHILD_OWNER="", CHILD_TABLE="Employee"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_15", FK_COLUMNS="department_id" */
    IF EXISTS (
      SELECT * FROM deleted,Employee
      WHERE
        /*  %JoinFKPK(Employee,deleted," = "," AND") */
        Employee.department_id = deleted.department_id
    )
    BEGIN
      SELECT @errno  = 30001,
             @errmsg = 'Cannot delete Department because Employee exists.'
      GOTO error
    END

    /* ERwin Builtin Trigger */
    /* Company  Department on child delete no action */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Company"
    CHILD_OWNER="", CHILD_TABLE="Department"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_11", FK_COLUMNS="company_id" */
    IF EXISTS (SELECT * FROM deleted,Company
      WHERE
        /* %JoinFKPK(deleted,Company," = "," AND") */
        deleted.company_id = Company.company_id AND
        NOT EXISTS (
          SELECT * FROM Department
          WHERE
            /* %JoinFKPK(Department,Company," = "," AND") */
            Department.company_id = Company.company_id
        )
    )
    BEGIN
      SELECT @errno  = 30010,
             @errmsg = 'Cannot delete last Department because Company exists.'
      GOTO error
    END


    /* ERwin Builtin Trigger */
    RETURN
error:
    raiserror @errno @errmsg
    rollback transaction
END


