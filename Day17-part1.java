import java.util.*;
public class Day17-part1 {
	public static void main(String[] args) {
		int xMax=0;
		int xMin=0;
		int yMax=0;
		int yMin=0;
		int piccolo=0;
		int q=0;
		int ris=0;
		int[] fin= new int[2];
		LinkedList<int[]> possibiliXF=new LinkedList<int[]>();
		LinkedList<int[]> pos=new LinkedList<int[]>();
		Scanner sc=new Scanner(System.in);

// get value out of input
		System.out.println("Inserire istruzioni: ");
		String inp = sc.nextLine();
		String[] first=inp.split(" ");
		String[] ics=first[2].split("\\..");
		String[] ips=first[3].split("\\..");
		String xmm="";
		for (int i=0;i<ics[0].length();i++){
			if (ics[0].charAt(i)>='0'&&ics[0].charAt(i)<='9'){
				xmm=xmm+ics[0].charAt(i);
			}
			if (ics[0].charAt(i)=='-'){
				xmm=xmm+ics[0].charAt(i);
			}
		}
		String xMM="";
		for (int i=0;i<ics[1].length();i++){
			if (ics[1].charAt(i)>='0'&&ics[1].charAt(i)<='9'){
				xMM=xMM+ics[1].charAt(i);
			}
			if (ics[1].charAt(i)=='-'){
				xMM=xMM+ics[1].charAt(i);
			}
		}
		String ymm="";
		for (int i=0;i<ips[0].length();i++){
			if (ips[0].charAt(i)>='0'&&ips[0].charAt(i)<='9'){
				ymm=ymm+ips[0].charAt(i);
			}
			if (ips[0].charAt(i)=='-'){
				ymm=ymm+ips[0].charAt(i);
			}
		}
		String yMM="";
		for (int i=0;i<ips[1].length();i++){
			if (ips[1].charAt(i)>='0'&&ips[1].charAt(i)<='9'){
				yMM=yMM+ips[1].charAt(i);
			}
			if (ips[1].charAt(i)=='-'){
				yMM=yMM+ips[1].charAt(i);
			}
		}
		xMin = Integer.parseInt(xmm);
		xMax = Integer.parseInt(xMM);
		yMin = Integer.parseInt(ymm);
		yMax = Integer.parseInt(yMM);

// calculate evry possible X
		for (int x=0;x<xMax;x++){
			int t=0;
			for (int f=0;f<x;f++){
				t=t+f;
				int X=(x*(f+1))-t;
				if (X>=xMin&&X<=xMax){
					int coor[]={x,f,t};
					possibiliXF.add(coor);
					break;
					}
				}
			}
			
// calculate evry possible Y 
		for (int[] j:possibiliXF){
					
			for (int y=1000;y>yMin;y--){
				int x=j[0];
				int t=j[2]-j[1];
				for (int f=j[1];f<1000;f++){
					t=t+f;
					int Y=(y*(f+1))-t;
					if (Y>=yMin&&Y<=yMax){
						int[] k={x, y};
						pos.add(k);
						break;
						}
					}
				}
			}

// find maximum Y
		for (int[] d:pos){
			if (d[1]>q){
				q=d[1];
				}
			}

// find minimum Y
			int t=0;
			for (int f=0;f<=q+1;f++){
				t=t+f;
				int Y=(q*(f+1))-t;
				if (Y>ris){
					ris=Y;
					}
				}
// print result
		System.out.println("The highest y position reached is: "+ris);
	}
}
