package io.akaitsuki.noobblockchain;

/**
 * Created by jiachiliu on 3/6/18.
 */
public class Main {
    public static void main(String[] args) {
        Block b1 = new Block("first block is genesis block", "0");
        System.out.println(b1);

        Block b2 = new Block("second block", b1.getHash());
        System.out.println(b2);

        Block b3 = new Block("third block", b2.getHash());
        System.out.println(b3);
    }
}
