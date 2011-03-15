CREATE TRIGGER tD_Employee ON Employee FOR DELETE AS
/* ERwin Builtin Trigger */
/* DELETE trigger on Employee */
BEGIN
  DECLARE  @errno   int,
           @errmsg  varchar(255)
    /* ERwin Builtin Trigger */
    /* Department  Employee on child delete no action */
    /* ERWIN_RELATION:CHECKSUM="00025d6f", PARENT_OWNER="", PARENT_TABLE="Department"
    CHILD_OWNER="", CHILD_TABLE="Employee"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_15", FK_COLUMNS="department_id" */
    IF EXISTS (SELECT * FROM deleted,Department
      WHERE
        /* %JoinFKPK(deleted,Department," = "," AND") */
        deleted.department_id = Department.department_id AND
        NOT EXISTS (
          SELECT * FROM Employee
          WHERE
            /* %JoinFKPK(Employee,Department," = "," AND") */
            Employee.department_id = Department.department_id
        )
    )
    BEGIN
      SELECT @errno  = 30010,
             @errmsg = 'Cannot delete last Employee because Department exists.'
      GOTO error
    END

    /* ERwin Builtin Trigger */
    /* Person  Employee on child delete no action */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="Person"
    CHILD_OWNER="", CHILD_TABLE="Employee"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_14", FK_COLUMNS="person_id" */
    IF EXISTS (SELECT * FROM deleted,Person
      WHERE
        /* %JoinFKPK(deleted,Person," = "," AND") */
        deleted.person_id = Person.person_id AND
        NOT EXISTS (
          SELECT * FROM Employee
          WHERE
            /* %JoinFKPK(Employee,Person," = "," AND") */
            Employee.person_id = Person.person_id
        )
    )
    BEGIN
      SELECT @errno  = 30010,
             @errmsg = 'Cannot delete last Employee because Person exists.'
      GOTO error
    END


    /* ERwin Builtin Trigger */
    RETURN
error:
    raiserror @errno @errmsg
    rollback transaction
END


