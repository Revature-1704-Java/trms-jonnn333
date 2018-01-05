-- SQL Stored Procedures (and some Triggers)
-- Written as per requirement specified in 1712-Java Project 1 TRMS instruction set
-- &copy; Jon Cheng (Jonnn333) (wait...this isn't html)

create or replace procedure addEmployee(eid in integer, firstN in varchar2, lastN in varchar2, email in varchar2)
as 
begin
    insert into addEmployee (employeeID, first_name, last_name, email) 
    values(eid, firstN, lastN, email);
    commit;
end;
/

create or replace procedure deleteReimburseEntry (inp_ReimburseID in Reimbursements.ReimbursementID % TYPE) 
as
begin
    savepoint LastSave;
    delete from Reimbursements where reimbursementID = inp_ReimburseID;
    delete from FileStorage where reimbursementID = inp_ReimburseID;
    commit;
    -- Note: may need to alter/drop foreign keys, and/or change order of statements
    -- possibly use keywork: CASCADE?
    
    exception when others then
        DBMS_OUTPUT.PUT_LINE('Delete unsuccessful');
        rollback to LastSave;
end;
/

create or replace trigger triggerInsertEmployee
after insert on employee
begin
    DBMS_OUTPUT.PUT_LINE('New employee record inserted');
end;
/

create or replace trigger triggerUpdateReimburse
after update on Reimbursements 
begin
    DBMS_output.put_line('The Reimbursements table was updated');
end;
/

