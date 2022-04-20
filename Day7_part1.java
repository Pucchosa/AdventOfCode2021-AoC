import java.util.*;

public class Day7_part1 {
	public static void main(String[] args) {
		int ris =0;
		int tot =1000000;
		int r=0;
		LinkedList<Integer> crab=new LinkedList<Integer>();
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
				crab.add(Integer.parseInt(y[d]));
			}
		}
		
// find minor cost
		for (int y=0;y<2500;y++){
			for (int x:crab){
				ris=ris+Math.abs(x-y);
			}
			if (tot>ris){
				tot=ris;}
			ris=0;
		}
		System.out.println("Fuel cost= "+tot);
	}
}
