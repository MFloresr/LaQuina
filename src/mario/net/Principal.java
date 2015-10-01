package mario.net;

import java.util.ArrayList;

public class Principal {


	private static final int Cartones = 20;

	public static void main(String[] args) {
		
		ArrayList<BingoCard> bingoList= new ArrayList<BingoCard>();
		
		for(int i=0;i<Cartones;i++){
			BingoCard bingo=new BingoCard();
			bingoList.add(bingo);
			bingo.printToConsole();
		}
		
		
	}
}
