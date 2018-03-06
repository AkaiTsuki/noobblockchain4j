package io.akaitsuki.noobblockchain;

/**
 * Created by jiachiliu on 3/6/18.
 */
public class Main {
    public static void main(String[] args) {
        Block b1 = new Block("first block is genesis block", "0");
        Block b2 = new Block("second block", b1.getHash());
        Block b3 = new Block("third block", b2.getHash());

        BlockChain blockChain = new BlockChain();
        blockChain.addBlock(b1);
        blockChain.addBlock(b2);
        blockChain.addBlock(b3);

        System.out.println(blockChain.toGsonString());

        // print true
        System.out.println(blockChain.isChainValid());

        // modify existing block will cause validation fail
        b2.setData("new data");
        System.out.println(blockChain.isChainValid());
    }
}
