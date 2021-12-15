package blockchain1;
import java.util.ArrayList;

	public class Blockchainimplementation {
		
		public static ArrayList<Block> blockchain = new ArrayList<Block>();
		public static int difficulty = 2;

		public static void main(String[] args) {	
			
			System.out.println("Mining of  block 1... ");
			addBlock(new Block("This is  the first block in my BlockChain and Hash address is ", "0"));
			
			System.out.println("Mining of block 2... ");
			addBlock(new Block("This is the second block in my BlockChain and present hash address is ",blockchain.get(blockchain.size()-1).hash));
			
			System.out.println("Mining of block 3... ");
			addBlock(new Block("This is the third block in my BlockChain and present hash address is ",blockchain.get(blockchain.size()-1).hash));
			
			System.out.println("Mining of block 4... ");
			addBlock(new Block("This is the forth block in my BlockChain and present hash address is ",blockchain.get(blockchain.size()-1).hash));	
			
			System.out.println("Mining of block 5... ");
			addBlock(new Block("This is the five block in my BlockChain and present hash address is ",blockchain.get(blockchain.size()-1).hash));	
			
			System.out.println("Mining of block 6... ");
			addBlock(new Block("This is the six block in my BlockChain and present hash address is ",blockchain.get(blockchain.size()-1).hash));	
			
			System.out.println("Mining of block 7... ");
			addBlock(new Block("This is the seven block in my BlockChain and present hash address is ",blockchain.get(blockchain.size()-1).hash));	
			
			System.out.println("\nBlockchain is Valid: " + isChainValid());
			
			String blockchainJson = StringUtil.getJson(blockchain);
			System.out.println("\nThe block chain: ");
			System.out.println(blockchainJson);
		}
		
		public static Boolean isChainValid() {
			Block currentBlock; 
			Block previousBlock;
			String hashTarget = new String(new char[difficulty]).replace('\0', '0');
			for(int i=1; i < blockchain.size(); i++) {
				currentBlock = blockchain.get(i);
				previousBlock = blockchain.get(i-1);
				if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
					System.out.println("Current Hashes not equal");			
					return false;
				}
				if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
					System.out.println("Previous Hashes not equal");
					return false;
				}
				if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
					System.out.println("This block hasn't been mined");
					return false;
				}
				
			}
			return true;
		}
		
		public static void addBlock(Block newBlock) {
			newBlock.mineBlock(difficulty);
			blockchain.add(newBlock);
		}
	}