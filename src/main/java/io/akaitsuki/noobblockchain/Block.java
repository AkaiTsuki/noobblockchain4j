package io.akaitsuki.noobblockchain;

import java.util.Date;

/**
 * Created by jiachiliu on 3/6/18.
 * <p>
 * A simple implementation for block
 */
public class Block {
    /**
     * Hash for current block
     */
    private String hash;

    /**
     * Hash for previous block
     */
    private String previousHash;

    /**
     * transaction data
     */
    private String data;

    /**
     * time block created
     */
    private long timestamp;

    public Block(String data, String previousHash) {
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        return CredUtil.applySha256(previousHash + Long.toString(timestamp) + data);
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Block{" +
                "hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", data='" + data + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
