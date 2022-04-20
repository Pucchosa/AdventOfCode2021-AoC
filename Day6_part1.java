import java.util.*;

public class Day6_part1 {
	public static void main(String[] args) {
		int t=0;
		int r=0;
		LinkedList<Integer> lantern=new LinkedList<Integer>();
		Scanner sc=new Scanner(System.in);

// make List of input
		while(r==0){
			String line = sc.nextLine();
			if (line.equals("stop")){
				r=2;
				break;
			}
			String[] y=line.split(",");
			for (int d=0;d<y.length;d++){
				lantern.add(Integer.parseInt(y[d]));
				System.out.println("int aggiunto: "+Integer.parseInt(y[d]));
			}
		}
		
// 80 days later...
		for (int p=0;p<80; p++){
			for (int s=0;s<lantern.size();s++){
				if (lantern.get(s)==0){
					t++;
					lantern.set(s, 6);
				}
				else{
					lantern.set(s, lantern.get(s)-1);
				}
			}
			for (int u=0;u<t;u++){
				lantern.add(8);}
			t=0;
			System.out.println("Nel Giorno "+p+" ci sono "+lantern.size()+" pesci-lanterna.");
		}
	}
}
