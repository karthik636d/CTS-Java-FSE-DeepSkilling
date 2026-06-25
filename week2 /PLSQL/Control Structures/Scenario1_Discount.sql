DECLARE
BEGIN
FOR c IN (
SELECT c.CustomerID, l.LoanID
FROM Customers c, Loans l
WHERE c.CustomerID = l.CustomerID
AND c.Age > 60
)
LOOP
UPDATE Loans
SET InterestRate = InterestRate - 1
WHERE LoanID = c.LoanID;

```
    DBMS_OUTPUT.PUT_LINE('Discount given to Customer ' || c.CustomerID);
END LOOP;

COMMIT;
```

END;
/
