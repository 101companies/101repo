       IDENTIFICATION DIVISION.
        PROGRAM-ID. SampleCompany

       ENVIRONMENT DIVISION.
        INPUT-OUTPUT SECTION.
         FILE-CONTROL.
          COPY "copybooks/department.fc".
          COPY "copybooks/employee.fc".

       DATA DIVISION.
        FILE SECTION.
         COPY "copybooks/department.fd".
         COPY "copybooks/employee.fd".

        WORKING-STORAGE SECTION.
         COPY "copybooks/file-status.ws".
         78 MEGANALYSIS VALUE "meganalysis".
         78 RESEARCH    VALUE "Research".
         78 DEVELOPMENT VALUE "Development".
         78 DEV1        VALUE "Dev1".
         78 DEV11       VALUE "Dev1.1".

       PROCEDURE DIVISION.

      * 
        OPEN OUTPUT DEPT-FILE.
      * 
        INITIALIZE DEPT-RECORD.
        MOVE MEGANALYSIS TO DEPT-COMPANY.
        MOVE RESEARCH    TO DEPT-NAME.
        MOVE "Craig"     TO DEPT-MANAGER.
        WRITE DEPT-RECORD.
      * 
        INITIALIZE DEPT-RECORD.
        MOVE MEGANALYSIS TO DEPT-COMPANY.
        MOVE DEVELOPMENT TO DEPT-NAME.
        MOVE "Ray"       TO DEPT-MANAGER.
        WRITE DEPT-RECORD.
      * 
        INITIALIZE DEPT-RECORD.
        MOVE MEGANALYSIS TO DEPT-COMPANY.
        MOVE DEV1        TO DEPT-NAME.
        MOVE "Klaus"     TO DEPT-MANAGER.
        MOVE DEVELOPMENT TO DEPT-ANCESTOR.
        WRITE DEPT-RECORD.
      * 
        INITIALIZE DEPT-RECORD.
        MOVE MEGANALYSIS TO DEPT-COMPANY.
        MOVE DEV11       TO DEPT-NAME.
        MOVE "Karl"      TO DEPT-MANAGER.
        MOVE DEV1        TO DEPT-ANCESTOR.
        WRITE DEPT-RECORD.
      * 
        CLOSE DEPT-FILE.      
      * 
        OPEN OUTPUT EMPL-FILE.
      *
        INITIALIZE EMPL-RECORD.
        MOVE MEGANALYSIS TO EMPL-COMPANY.
        MOVE RESEARCH    TO EMPL-DEPT.
        MOVE "Craig"     TO EMPL-NAME.
        MOVE "Redmond"   TO EMPL-ADDR.
        MOVE 123456      TO EMPL-SALARY.
        WRITE EMPL-RECORD.
      *
        INITIALIZE EMPL-RECORD.
        MOVE MEGANALYSIS TO EMPL-COMPANY.
        MOVE RESEARCH    TO EMPL-DEPT.
        MOVE "Erik"      TO EMPL-NAME.
        MOVE "Utrecht"   TO EMPL-ADDR.
        MOVE 12345       TO EMPL-SALARY.
        WRITE EMPL-RECORD.
      *
        INITIALIZE EMPL-RECORD.
        MOVE MEGANALYSIS TO EMPL-COMPANY.
        MOVE RESEARCH    TO EMPL-DEPT.
        MOVE "Ralf"      TO EMPL-NAME.
        MOVE "Koblenz"   TO EMPL-ADDR.
        MOVE 1234        TO EMPL-SALARY.
        WRITE EMPL-RECORD.
      *
        INITIALIZE EMPL-RECORD.
        MOVE MEGANALYSIS TO EMPL-COMPANY.
        MOVE DEVELOPMENT TO EMPL-DEPT.
        MOVE "Ray"       TO EMPL-NAME.
        MOVE "Redmond"   TO EMPL-ADDR.
        MOVE 234567      TO EMPL-SALARY.
        WRITE EMPL-RECORD.
      *
        INITIALIZE EMPL-RECORD.
        MOVE MEGANALYSIS TO EMPL-COMPANY.
        MOVE DEV1        TO EMPL-DEPT.
        MOVE "Klaus"     TO EMPL-NAME.
        MOVE "Boston"    TO EMPL-ADDR.
        MOVE 23456       TO EMPL-SALARY.
        WRITE EMPL-RECORD.
      *
        INITIALIZE EMPL-RECORD.
        MOVE MEGANALYSIS TO EMPL-COMPANY.
        MOVE DEV11       TO EMPL-DEPT.
        MOVE "Karl"      TO EMPL-NAME.
        MOVE "Riga"      TO EMPL-ADDR.
        MOVE 2345        TO EMPL-SALARY.
        WRITE EMPL-RECORD.
      *
        INITIALIZE EMPL-RECORD.
        MOVE MEGANALYSIS TO EMPL-COMPANY.
        MOVE DEV11       TO EMPL-DEPT.
        MOVE "Joe"       TO EMPL-NAME.
        MOVE "Wifi City" TO EMPL-ADDR.
        MOVE 2344        TO EMPL-SALARY.
        WRITE EMPL-RECORD.
      * 
        CLOSE EMPL-FILE.      
      * 
        STOP RUN.
