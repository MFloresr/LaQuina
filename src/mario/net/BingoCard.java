package mario.net;

import java.util.Arrays;
import java.util.Random;


public class BingoCard {
    private static final int NumeroMaximo = 90;
	private static final int NumeroMinimo = 1;
	private static final int MaximodeNumeros = 15;
    private static final int FILAS = 3;
    private int[] bingo = new int[MaximodeNumeros];
	private int[] contador=new int[9];
    private int[] Linia1=new int[9];
    private int[] Linia2=new int[9];
    private int[] Linia3=new int[9];
	
	public BingoCard(){
		Random rand = new Random();
		for(int i=0;i<MaximodeNumeros;i++){
			int numero= rand.nextInt(NumeroMaximo)+NumeroMinimo;
			int decena = numero/10;
			if (decena==9){
				decena = 8;
			}
			if(contador[decena]< FILAS){
				if(isRepeat(numero)==true){
					i--;
				}else{
					bingo[i]=numero;
					contador[decena]=contador[decena]+1;
                    boolean esnull1 = Linia1[decena] == 0;
                    boolean esnull2 = Linia2[decena] == 0;
                    boolean esnull3 = Linia3[decena] == 0;
                    if (esnull1){
                        Linia1[decena]=numero;
                    }else if(esnull2){
                        Linia2[decena]=numero;
                    }else if(esnull3){
                        Linia3[decena]=numero;
                    }
				}
			}else{
				i--;
			}
		}
		Arrays.sort(bingo);//ordenar Arrays
	}

	private boolean isRepeat(int numero){
        for(int i = 0;i<bingo.length;i++){
            if (numero == bingo[i]){
                return true;
            }
        }
		return false;
	}
	
	public int[] getBingo() {
		return bingo;
	}

	public void setBingo(int[] bingo) {
		this.bingo = bingo;
	}
	
	public void printToConsole(){
        System.out.print("[");
        for(int i=0;i<Linia1.length;i++){
            System.out.printf("  %-2d",Linia1[i]);
            if (i+1<Linia1.length){
                System.out.print(",");
            }
        }
        System.out.println("]");
        System.out.print("[");
        for(int i=0;i<Linia2.length;i++){
            System.out.printf("  %-2d",Linia2[i]);
            if (i+1<Linia2.length){
                System.out.print(",");
            }
        }
        System.out.println("]");
        System.out.print("[");
        for(int i=0;i<Linia3.length;i++){
            System.out.printf("  %-2d",Linia3[i]);
            if (i+1<Linia3.length){
                System.out.print(",");
            }
        }
        System.out.println("]");
        System.out.println(" ");
	} 	
	
	public void PrintToScreen(){
		System.out.print("[");
		for(int i=0;i<bingo.length;i++){
			System.out.print(bingo[i]);
			if (i+1<bingo.length){
				System.out.print(",");
			}
		}
		System.out.println("]");
	}
}
