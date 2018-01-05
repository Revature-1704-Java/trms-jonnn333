-- NEW tables (improved since last wk from 12/26/17)
-- Using tables: Employee, EmployeeType, EventType,
-- File (Storage), Reimbursements, and GradingFormat

---------------------------------------------------------------------------
------------ Tables, Constraints (no FK), and sample data -----------------
---------------------------------------------------------------------------

-- DROP TABLE Employee;
CREATE TABLE Employee (
    Employee_ID integer Primary Key,
    first_name varchar2(255) not NULL,
    last_name varchar2(255) not NULL,
    email varchar2(255) not NULL,
    password varchar2(255) default 'some_p4ssw0rd',
    supervisorID integer,
    Dept_HeadID integer,
    EmployeeType_ID integer
)
Insert into Employee(employee_ID, first_name, last_name, email, dept_HeadID) values (301, 'pizza', 'hut', 'pizzaz@hut.com', 336);

-- DROP TABLE Reimbursements
CREATE TABLE Reimbursements (
    Reimbursement_ID integer Primary Key,
    Employee_ID integer, -- NOT unique; is it currently unique?
    Event_ID integer,
    Event_Description varchar2(255),
    Event_Address varchar2(255),
    Event_City varchar2(255),
    Event_State varchar2(255),
    Event_Country varchar2(255),
    Event_zipCode varchar2(255),
    Event_Justification varchar(255),
    Event_timeStamp DATE,
    GradeFormat_ID integer,
    ReimbursementCost number(6,2) default 0,
    ReimburseAward number(6,2) default 0,
    submissionTime DATE,
    timeMissed integer default 0,
    Status integer,
    exceedsAmount number(6,2) default 0,
    exceedsReason varchar2(255) default 'n/a',
    deniedReason varchar2(255)  default 'n/a',
    supervisorApprove DATE default NULL,
    deptHeadApprove DATE default NULL,
    benCoApprove DATE default NULL
)
INSERT INTO Reimbursements(Reimbursement_ID, Employee_ID, Status) VALUES(111, 301, 1);
---------------------------------------------------------------------------

-- DROP TABLE EmployeeType
CREATE TABLE EmployeeType (
    EmployeeType_ID integer Primary Key,
    Employee_Type varchar2(255)
)
-- 4 employee types (not yet inserted, as of 1/2/18 12:34pm EDT)
INSERT INTO EmployeeType VALUES (1, 'employee');
INSERT INTO EmployeeType VALUES (2, 'supervisor');
INSERT INTO EmployeeType VALUES (3, 'department_head');
INSERT INTO EmployeeType VALUES (4, 'benCo');

---------------------------------------------------------------------------

-- DROP TABLE EventType
CREATE TABLE EventType (
    Event_ID integer Primary Key,
    Event_Type varchar2(255),
    Event_Coverage number(6,2) -- ehh, number(3,2) would be better...
)
-- foreign key reference in the way; cannot run these 2 lines below without errors
--alter table EventType drop constraint SYS_C007193 ;
--alter table EventType add constraint number(3,2) references Event_Coverage enable novalidate;

-- In accordance to biz requirements (not yet inserted, as of 1/2/18 12:34pm EDT)
INSERT INTO EventType VALUES (1, 'UniversityCourse', 0.80);
INSERT INTO EventType VALUES (2, 'Seminar', 0.60);
INSERT INTO EventType VALUES (3, 'CertificationPreparationClass', 0.75);
INSERT INTO EventType VALUES (4, 'Certification', 1.00);
INSERT INTO EventType VALUES (5, 'TechnicalTraining', 0.90);
INSERT INTO EventType VALUES (6, 'Other', 0.30);

---------------------------------------------------------------------------

-- DROP TABLE FileStorage
CREATE TABLE FileStorage (
    File_ID varchar2(255) Primary Key,
    Reimbursement_ID integer unique,
    File_Description varchar2(255),
    File_Path varchar2(255)
)
-- TEST FILES (not yet inserted, as of 1/2/18 12:34pm EDT)
Insert INTO FileStorage VALUES('file_one', 111, 'test file uno', '../file_storage/file_one');
Insert INTO FileStorage VALUES('file_two', 222, 'test file dos', '../file_storage/file_two');
Insert INTO FileStorage VALUES('file_three', 333, 'test file tres', '../file_storage/file_three');
Insert INTO FileStorage VALUES('file_four', 444, 'test file quatros', '../file_storage/file_four');
Insert INTO FileStorage VALUES('file_five', 555, 'test file cinco', '../file_storage/file_five');

---------------------------------------------------------------------------

-- DROP TABLE GradingFormat
CREATE TABLE GradingFormat (
    GradeFormat_ID integer default 1 Primary Key,
    GradeFormat_Type varchar2(100),
    GradeFormat_Passing varchar2(100)
)

-- almost-finalized grading formats (not yet inserted, as of 1/2/18 12:34pm EDT)
INSERT INTO GradingFormat VALUES(1, 'A-F', 'C'); -- grade scale A-F
INSERT INTO GradingFormat VALUES(2, 'pass/fail', 'pass'); -- all or nothing 
INSERT INTO GradingFormat VALUES(3, 'percentage', '60'); -- percentage 60%+ passing
INSERT INTO GradingFormat VALUES(4, 'GPA', '2.0'); -- GPA 2.0 C

---------------------------------------------------------------------------
------------------------------- FOREIGN KEYS ------------------------------
---------------------------------------------------------------------------
-- Resources
-- https://stackoverflow.com/questions/18435065/foreign-key-to-non-primary-key

-- Format; from https://www.techonthenet.com/oracle/foreign_keys/foreign_keys.php
-- ALTER TABLE table_name
-- ADD CONSTRAINT constraint_name
-- FOREIGN KEY (column1, column2, ... column_n)
-- REFERENCES parent_table (column1, column2, ... column_n);

ALTER TABLE Reimbursements -- switch to Reimbursements b/c you want that table's column ref to be FK
ADD CONSTRAINT FK_EmployeeReimburseEntries
FOREIGN KEY (Employee_ID) REFERENCES Employee(Employee_ID);

ALTER TABLE Employee
ADD CONSTRAINT FK_EmployeeTypeMatch
FOREIGN KEY (EmployeeType_ID) REFERENCES EmployeeType(EmployeeType_ID);

ALTER TABLE Employee
ADD CONSTRAINT FK_EmployeeSupervisor 
FOREIGN KEY (SupervisorID) REFERENCES Employee(Employee_ID);

ALTER TABLE Employee
ADD CONSTRAINT FK_EmployeeDEPT_HEADID
FOREIGN KEY (Dept_HeadID) REFERENCES Employee(Employee_ID);

-- drop all foreign key constraints for Employee w/ the following lines:
-- ALTER TABLE Employee DROP CONSTRAINT FK_EmployeeReimburseEntries; 
-- ALTER TABLE Employee DROP CONSTRAINT FK_EmployeeTypeMatch; 
-- ALTER TABLE Employee DROP CONSTRAINT FK_EmployeeSupervisor;
-- ALTER TABLE Employee DROP CONSTRAINT FK_EmployeeDEPT_HEADID;

---------------------------------------------------------------------------
ALTER TABLE FileStorage
ADD CONSTRAINT FK_ReimburseMatchAnyFile
FOREIGN KEY (Reimbursement_ID) REFERENCES Reimbursements(Reimbursement_ID); 

ALTER TABLE Reimbursements
ADD CONSTRAINT FK_MatchEventType
FOREIGN KEY (Event_ID) REFERENCES EventType(Event_ID);  

ALTER TABLE Reimbursements
ADD CONSTRAINT FK_MatchGradeFormat
FOREIGN KEY (GradeFormat_ID) REFERENCES GradingFormat(GradeFormat_ID); 

-- drop all foreign key constraints for Reimbursements w/ the following lines:
-- ALTER TABLE Reimbursements DROP CONSTRAINT FK_ReimburseMatchAnyFile;
-- ALTER TABLE Reimbursements DROP CONSTRAINT FK_MatchEventType;
-- ALTER TABLE Reimbursements DROP CONSTRAINT FK_MatchGradeFormat; 

-- This is just removing original constraint of status (integer) check > 0 and < 5
-- ALTER TABLE Reimbursements DROP CONSTRAINT SYS_C007212;
---------------------------------------------------------------------------

-- what is varchar2 using when you declare varchar2(number)?
-- bytes! 
SELECT value
FROM NLS_DATABASE_PARAMETERS
WHERE parameter='NLS_LENGTH_SEMANTICS';

commit;