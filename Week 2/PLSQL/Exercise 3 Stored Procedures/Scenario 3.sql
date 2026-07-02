CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account_id IN NUMBER,
    p_target_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    v_source_balance NUMBER;
BEGIN
    -- Check balance of source account
    SELECT balance INTO v_source_balance
    FROM Accounts
    WHERE account_id = p_source_account_id
    FOR UPDATE; -- Lock the row to prevent concurrent updates
    
    IF v_source_balance >= p_amount THEN
        -- Deduct from source account
        UPDATE Accounts
        SET balance = balance - p_amount
        WHERE account_id = p_source_account_id;
        
        -- Add to target account
        UPDATE Accounts
        SET balance = balance + p_amount
        WHERE account_id = p_target_account_id;
        
        COMMIT;
    ELSE
        -- Handle insufficient funds
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20002, 'Source account does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END TransferFunds;
/
