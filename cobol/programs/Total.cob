       IDENTIFICATION DIVISION.
        PROGRAM-ID. Total

       ENVIRONMENT DIVISION.
        INPUT-OUTPUT SECTION.
         FILE-CONTROL.
          COPY "copybooks/employee.fc".

       DATA DIVISION.
        FILE SECTION.
         COPY "copybooks/employee.fd".

        WORKING-STORAGE SECTION.
         COPY "copybooks/file-status.ws".
         78 MEGANALYSIS   VALUE "meganalysis".
         01 TOTAL         PIC 9(9)V99.

       PROCEDURE DIVISION.

      *
        OPEN INPUT EMPL-FILE.
      *
        INITIALIZE TOTAL.
        MOVE MEGANALYSIS TO EMPL-COMPANY.
        START EMPL-FILE KEY IS >= EMPL-KEY.
        READ EMPL-FILE NEXT RECORD.
        PERFORM WITH TEST BEFORE
                UNTIL END-OF-FILE
                   OR EMPL-COMPANY NOT = MEGANALYSIS
          ADD EMPL-SALARY TO TOTAL
          READ EMPL-FILE NEXT RECORD
        END-PERFORM.
      *
        CLOSE EMPL-FILE.      
      *
        DISPLAY TOTAL.
      * 
        STOP RUN.
