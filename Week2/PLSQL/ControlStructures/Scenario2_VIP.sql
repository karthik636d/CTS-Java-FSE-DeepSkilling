DECLARE
BEGIN
FOR c IN (
SELECT CustomerID
FROM Customers
WHERE Balance > 10000
)
LOOP
UPDATE Customers
SET IsVIP = 'TRUE'
WHERE CustomerID = c.CustomerID;

```
    DBMS_OUTPUT.PUT_LINE(
        'Customer ' || c.CustomerID || ' promoted to VIP'
    );
END LOOP;

COMMIT;
```

END;
/

