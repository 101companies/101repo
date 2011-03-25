       IDENTIFICATION DIVISION.
        PROGRAM-ID. Cut

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

       PROCEDURE DIVISION.

      *
        OPEN I-O EMPL-FILE.
      *
        MOVE MEGANALYSIS TO EMPL-COMPANY.
        START EMPL-FILE KEY IS >= EMPL-KEY.
        READ EMPL-FILE NEXT RECORD.
        PERFORM WITH TEST BEFORE
                UNTIL END-OF-FILE
                   OR EMPL-COMPANY NOT = MEGANALYSIS
          DIVIDE EMPL-SALARY BY 2 GIVING EMPL-SALARY
          REWRITE EMPL-RECORD
          READ EMPL-FILE NEXT RECORD
        END-PERFORM.
      *
        CLOSE EMPL-FILE.      
      * 
        STOP RUN.
