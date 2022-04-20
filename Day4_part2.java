import java.util.*;

public class Day4_part2 {
// method to put chosen number as -10 in all tablets
	public static void pesca(LinkedList<int[][]> x, int y){
		for (int[][] i: x){
			for (int a=0;a<5;a++){
				for (int b=0;b<5;b++){
					if (i[a][b]==y){
						i[a][b]=-10;
					}
				}
			}
		}
	}
	
// method to verify if a table has won
	public static boolean check(int[][] m){
		for (int i = 0; i < 5; i++) {
			if (m[i][0] + m[i][1] + m[i][2] + m[i][3] + m[i][4] < (-45) || m[0][i] + m[1][i] + m[2][i] + m[3][i] + m[4][i] < (-45)) {
			return true;}
		}
		return false;
	}
		
	public static void main(String[] args) {
		String ggg="scemo chi legge";
		int r=0;
		int ris=0;
		int tot=0;
		int[][] win=new int[5][5];
		Scanner sc=new Scanner(System.in);
		
		LinkedList<int[][]> originali=new LinkedList<int[][]>();
		LinkedList<int[][]> temp=new LinkedList<int[][]>();

// make int[] from 1 input 
		String line = sc.nextLine().trim();
		String[] numbers = line.split(",");
		int[] pescati=new  int[numbers.length];
		for(int i=0;i<pescati.length;i++) {
			pescati[i]=Integer.valueOf(numbers[i]);
			}

// make List of input talet
		while (r==0){
			try{
				for (int y=0; y>-1; y++){
					int[][] num=new int[5][5];
					for (int i=0; i<5;i++){
						for(int j=0;j<5;j++) {
							int numeri = sc.nextInt();
							num[i][j]=numeri;
						}
					}
				originali.add(y, num);
				}
		  	}
			catch (Exception e){r=1;}
		}

// 	play
		for (int m:pescati){
			ris=m;
			pesca(originali, m);
			for (int[][] u:originali){
				if (check(u)==false){
					temp.add(u);
				}
			}
			if (originali.size()==1){
				break;
			}
			originali.clear();
			for (int[][] u:temp){
				originali.add(u);
			}
			temp.clear();
		}
		win=originali.get(0);
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (win[i][j] == (-10)) {
					win[i][j] = 0;
				} else if (win[i][j] == (999)) {
				win[i][j] = 0;}
				else {
					tot = tot + win[i][j];
				}
			}
		}
		System.out.println("Risultato Finale= " + tot * ris);
	}
}
