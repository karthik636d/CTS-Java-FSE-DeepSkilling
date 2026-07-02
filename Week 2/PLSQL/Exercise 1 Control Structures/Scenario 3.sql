DECLARE
    CURSOR c_loans IS
        SELECT c.customer_name, l.loan_id, l.due_date
        FROM Customers c
        JOIN Loans l ON c.customer_id = l.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR loan IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || loan.customer_name || ', your loan ' || loan.loan_id || ' is due on ' || TO_CHAR(loan.due_date, 'YYYY-MM-DD'));
    END LOOP;
END;
/
