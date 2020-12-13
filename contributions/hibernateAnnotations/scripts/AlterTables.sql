alter table DEPARTMENT add constraint FK4F782F5255C77F64 foreign key (DEPT_ID) references DEPARTMENT;
alter table DEPARTMENT add constraint FK4F782F52C7CB872B foreign key (COMP_ID) references COMPANY;
alter table EMPLOYEE add constraint FK75C8D6AE55C77F64 foreign key (DEPT_ID) references DEPARTMENT;
alter table EMPLOYEE add constraint FK75C8D6AE800BE06C foreign key (MENTOR) references EMPLOYEE;
