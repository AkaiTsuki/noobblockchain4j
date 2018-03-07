package io.akaitsuki.noobblockchain;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import static io.akaitsuki.noobblockchain.CredUtil.getKeyString;

/**
 * Created by jiachiliu on 3/7/18.
 */
public class Transaction {
    private String transactionId;
    private PublicKey sender;
    private PublicKey reciepient;
    private float value;
    private byte[] signature;

    private List<TransactionInput> transactionInputs = new ArrayList<>();
    private List<TransactionOutput> transactionOutputs = new ArrayList<>();

    /**
     * a rough count of how many transactions have been generated.
     */
    private static int sequence = 0;

    public Transaction(PublicKey sender, PublicKey reciepient, float value, List<TransactionInput> transactionInputs) {
        this.sender = sender;
        this.reciepient = reciepient;
        this.value = value;
        this.transactionInputs = transactionInputs;
    }

    /**
     * Calculates the transaction hash (which will be used as its Id)
     * @return
     */
    public String calculateHash() {
        ++sequence;
        return CredUtil.applySha256(
                getKeyString(sender)
                        + getKeyString(reciepient)
                        + Float.toString(value)
                        + sequence);
    }

    public void generateSignature(PrivateKey privateKey) {
        String data = CredUtil.getKeyString(sender) + CredUtil.getKeyString(reciepient) + Float.toString(value);
        signature = CredUtil.applyECDSASig(privateKey, data);
    }

    public boolean verifySignature() {
        String data = CredUtil.getKeyString(sender) + CredUtil.getKeyString(reciepient) + Float.toString(value);
        return CredUtil.verifyECDSASig(sender, data, signature);
    }

    public static class TransactionInput {

    }

    public static class TransactionOutput {

    }
}
