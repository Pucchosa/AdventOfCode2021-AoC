import java.util.*;

public class Day09_part1 {
	public static void main(String[] args) {
		int t=0;
		int r=0;
		int ris=0;
		LinkedList<int[]> input=new LinkedList<int[]>();
		LinkedList<Integer> basso=new LinkedList<Integer>();
		LinkedList<int[]> puntiB=new LinkedList<int[]>();
		Scanner sc=new Scanner(System.in);

// make List of input
		while(r==0){
			
			String line = sc.nextLine();
			int[] coor=new int[line.length()];
			if (line.equals("stop")){
				r=2;
				break;
				}
 // /*24	test*/		System.out.println("line: "+line);

			String[] y=line.split("");
			for (int d=0;d<y.length;d++){
				coor[d]=Integer.parseInt(y[d]);
				}
			input.add(coor);
			}

/* test */	System.out.println("tot coordinats: "+input.size());

// filter out
		for (int m=1;m<input.size()-1;m++) {
			for (int n=1;n<input.get(1).length-1;n++){
				if (input.get(m)[n]<input.get(m-1)[n]&&input.get(m)[n]<input.get(m+1)[n]&&input.get(m)[n]<input.get(m)[n-1]&&input.get(m)[n]<input.get(m)[n+1]){
					basso.add(input.get(m)[n]+1);
					
					}
				}
			}
		for (int n=1;n<input.get(0).length-1;n++){
			if (input.get(0)[n]<input.get(1)[n]&&input.get(0)[n]<input.get(0)[n-1]&&input.get(0)[n]<input.get(0)[n+1]){
				basso.add(input.get(0)[n]+1);
				}
			}
		for (int n=1;n<input.get(input.size()-1).length-1;n++){
			if (input.get(input.size()-1)[n]<input.get(input.size()-2)[n]&&input.get(input.size()-1)[n]<input.get(input.size()-1)[n-1]&&input.get(input.size()-1)[n]<input.get(input.size()-1)[n+1]){
				basso.add(input.get(input.size()-1)[n]+1);
				}
			}
		for (int m=1;m<input.size()-1;m++) {
			if (input.get(m)[0]<input.get(m-1)[0]&&input.get(m)[0]<input.get(m+1)[0]&&input.get(m)[0]<input.get(m)[1]){
				basso.add(input.get(m)[0]+1);
				}
			}
		for (int m=1;m<input.size()-1;m++) {
			if (input.get(m)[input.get(m).length-1]<input.get(m-1)[input.get(m).length-1]&&input.get(m)[input.get(m).length-1]<input.get(m+1)[input.get(m).length-1]&&input.get(m)[input.get(m).length-1]<input.get(m)[input.get(m).length-2]){
				basso.add(input.get(m)[input.get(m).length-1]+1);
				}
			}
		if (input.get(0)[0]<input.get(0)[1]&&input.get(0)[0]<input.get(1)[0]){
			basso.add(input.get(0)[0]+1);
			}
		if (input.get(input.size()-1)[0]<input.get(input.size()-1)[1]&&input.get(input.size()-1)[0]<input.get(input.size()-2)[0]){
			basso.add(input.get(input.size()-1)[0]+1);
			}
		if (input.get(input.size()-1)[input.get(1).length-1]<input.get(input.size()-1)[input.get(1).length-2]&&input.get(input.size()-1)[input.get(1).length-1]<input.get(input.size()-2)[input.get(1).length-1]){
			basso.add(input.get(input.size()-1)[input.get(1).length-1]+1);
			}
		if (input.get(0)[input.get(1).length-1]<input.get(0)[input.get(1).length-2]&&input.get(0)[input.get(1).length-1]<input.get(1)[input.get(1).length-1]){
			basso.add(input.get(0)[input.get(1).length-1]+1);
			}
		for (int u:basso){
			ris=ris+u;
			}
		System.out.println("Totals of low points: "+ris);
		}
	}
