       IDENTIFICATION DIVISION.
        PROGRAM-ID. Depth

       ENVIRONMENT DIVISION.
        INPUT-OUTPUT SECTION.
         FILE-CONTROL.
          COPY "copybooks/department.fc".

       DATA DIVISION.
        FILE SECTION.
         COPY "copybooks/department.fd".

        WORKING-STORAGE SECTION.
         COPY "copybooks/file-status.ws".
         78 MEGANALYSIS   VALUE "meganalysis".
         01 DEPTH         PIC 999.
         01 ANCESTORS     PIC 999.
         01 MEMO          PIC X(42).

       PROCEDURE DIVISION.

      *
        OPEN INPUT DEPT-FILE.
      *
        INITIALIZE DEPTH.
      *
        MOVE MEGANALYSIS TO DEPT-COMPANY.
      *
        START DEPT-FILE KEY IS >= DEPT-KEY.
        READ DEPT-FILE NEXT RECORD.
        PERFORM WITH TEST BEFORE
                UNTIL END-OF-FILE
                   OR DEPT-COMPANY NOT = MEGANALYSIS
          MOVE DEPT-NAME TO MEMO
          PERFORM GET-ANCESTORS
          IF ANCESTORS + 1 > DEPTH
            COMPUTE DEPTH = ANCESTORS + 1
          END-IF
          MOVE MEGANALYSIS TO DEPT-COMPANY
          MOVE MEMO TO DEPT-NAME
          START DEPT-FILE KEY IS > DEPT-KEY
          READ DEPT-FILE NEXT RECORD
        END-PERFORM.
      *
        CLOSE DEPT-FILE.      
      *
        DISPLAY DEPTH.
      * 
        STOP RUN.
      *
        GET-ANCESTORS.
         INITIALIZE ANCESTORS.
         PERFORM WITH TEST BEFORE
                 UNTIL DEPT-ANCESTOR = SPACES
           ADD 1 TO ANCESTORS
           MOVE DEPT-ANCESTOR TO DEPT-NAME
           READ DEPT-FILE KEY IS DEPT-KEY
         END-PERFORM.
