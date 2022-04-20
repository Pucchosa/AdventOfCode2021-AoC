import java.util.*;

public class Day05_part2 {
	public static void main(String[] args) {
		int t=0;
		int r=0;
		int punti=0;
		int[][] schema= new int[1000][1000];
		LinkedList<int[]> input=new LinkedList<int[]>();
		LinkedList<int[]> soloX=new LinkedList<int[]>();
		LinkedList<int[]> soloY=new LinkedList<int[]>();
		LinkedList<int[]> diago=new LinkedList<int[]>();
		Scanner sc=new Scanner(System.in);
		
// make LinkedList of input
		while(r==0){
			int[] coor=new int[4];
			String line = sc.nextLine();
			if (line.equals("stop")){
				r=2;
				break;
			}
			line=line.replaceAll( ",", " " );
			line=line.replaceAll( " -> ", " " );
			String[] y=line.split(" ");
			for (int d=0;d<y.length;d++){
				coor[d]=Integer.parseInt(y[d]);
			}
			input.add(coor);
		}

// separate vertical from orizzontal from diagonal
		for (int[] m : input) {
			if (m[0] == m[2]) {
				soloX.add(m);
			}
			else if (m[1]==m[3]){
				soloY.add(m);
			}
			else {diago.add(m);}
		}

// draw map
		for (int[] n : soloX) {
			int x=n[0];
			int y1=n[1];
			int y2=n[3];
			if (y2>y1){
				for (int p=0; p<=(y2-y1);p++){
					schema[x][y1+p]=(schema[x][y1+p])+1;
				}
			}
			else {
				for (int p=0; p<=(y1-y2);p++){
					schema[x][y2+p]=(schema[x][y2+p])+1;
				}
			}
		}
		for (int[] o : soloY) {
			int y=o[1];
			int x1=o[0];
			int x2=o[2];
			if (x2>x1){
				for (int p=0; p<=(x2-x1);p++){
					schema[x1+p][y]=(schema[x1+p][y])+1;
				}
			}
			else {
				for (int p=0; p<=(x1-x2);p++){
					schema[x2+p][y]=(schema[x2+p][y])+1;
				}
			}
		}
		for (int[] o : diago) {
			int y1=o[1];
			int y2=o[3];
			int x1=o[0];
			int x2=o[2];
			if (x1>x2&&y1>y2){
				for (int p=0; p<=(x1-x2);p++){
					schema[x2+p][y2+p]=(schema[x2+p][y2+p])+1;
				}
			}
			else if (x1<x2&&y1<y2){
				for (int p=0; p<=(x2-x1);p++){
					schema[x2-p][y2-p]=(schema[x2-p][y2-p])+1;
				}
			}
			else if (x1>x2&&y1<y2){
				for (int p=0; p<=(x1-x2);p++){
					schema[x2+p][y2-p]=(schema[x2+p][y2-p])+1;
				}
			}
			else if (x1<x2&&y1>y2){
				for (int p=0; p<=(x2-x1);p++){
					schema[x2-p][y2+p]=(schema[x2-p][y2+p])+1;
				}
			}
		}
			
// count >=2

		for (int[] u: schema){
			for(int l:u){
				if (l>=2){
					punti++;
				}
			}
		}
		System.out.println("punti da evitare: "+punti);
	}
}
