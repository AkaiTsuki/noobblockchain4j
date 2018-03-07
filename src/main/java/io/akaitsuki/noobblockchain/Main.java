package io.akaitsuki.noobblockchain;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

/**
 * Created by jiachiliu on 3/6/18.
 */
public class Main {
//
//    public static void main(String[] args) {
//        BlockChain blockChain = new BlockChain();
//
//        Block b1 = new Block("first block is genesis block", "0");
//        b1.mineBlock(BlockChain.difficulty);
//        Block b2 = new Block("second block", b1.getHash());
//        b2.mineBlock(BlockChain.difficulty);
//        Block b3 = new Block("third block", b2.getHash());
//        b3.mineBlock(BlockChain.difficulty);
//
//
//        blockChain.addBlock(b1);
//        blockChain.addBlock(b2);
//        blockChain.addBlock(b3);
//
//        System.out.println(blockChain.toGsonString());
//
//        // print true
//        System.out.println(blockChain.isChainValid());
//
//        // modify existing block will cause validation fail
//        b2.setData("new data");
//        System.out.println(blockChain.isChainValid());
//    }

    public static void main(String[] args) {
        //Setup Bouncey castle as a Security Provider
        Security.addProvider(new BouncyCastleProvider());

        Wallet walletA = new Wallet();
        Wallet walletB = new Wallet();

        //Test public and private keys
        System.out.println("Private and public keys:");
        System.out.println(CredUtil.getKeyString(walletA.getPrivateKey()));
        System.out.println(CredUtil.getKeyString(walletA.getPublicKey()));
        //Create a test transaction from WalletA to walletB
        Transaction transaction = new Transaction(walletA.getPublicKey(), walletB.getPublicKey(), 5, null);
        transaction.generateSignature(walletA.getPrivateKey());
        //Verify the signature works and verify it from the public key
        System.out.println("Is signature verified");
        System.out.println(transaction.verifySignature());
    }
}
