package io.akaitsuki.noobblockchain;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiachiliu on 3/6/18.
 */
public class BlockChain {
    private List<Block> chain = new ArrayList<Block>();

    public static int difficulty = 5;

    public void addBlock(Block block) {
        chain.add(block);
    }

    public boolean isChainValid() {
        Block prev, cur;

        for(int i=1; i<chain.size(); i++) {
            prev = chain.get(i-1);
            cur = chain.get(i);

            // current block get modified
            if(!cur.getHash().equals(cur.calculateHash())) {
                return false;
            }

            // previous hash in current block is not same as registered hash in previous block
            if(!cur.getPreviousHash().equals(prev.getHash())) {
                return false;
            }
        }

        return true;
    }

    public String toGsonString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(chain);
    }
}
