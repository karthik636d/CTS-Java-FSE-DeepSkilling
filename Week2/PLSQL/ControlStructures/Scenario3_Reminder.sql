DECLARE
BEGIN
FOR l IN (
SELECT c.Name, l.LoanID, l.DueDate
FROM Customers c, Loans l
WHERE c.CustomerID = l.CustomerID
AND l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
)
LOOP
DBMS_OUTPUT.PUT_LINE(
'Reminder: Loan ' || l.LoanID ||
' for ' || l.Name ||
' is due on ' ||
TO_CHAR(l.DueDate, 'DD-MON-YYYY')
);
END LOOP;
END;
/

