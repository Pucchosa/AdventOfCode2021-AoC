import java.util.*;

public class Day7_part2 {
	public static void main(String[] args) {
		int tot =0;
		float mid =0;
		int media=0;
		int ris=0;
		int ris4 =0;
		int ris5 =0;
		int ris6 =0;
		int ris7 =0;
		int ris8 =0;
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
		
// find mdia
		for (int x:crab){
			tot=tot+x;
		}
		mid=(float)tot/(float)crab.size();
		media=(int)mid;
		if ((mid%(media+0.5))>1){
			media=media+1;
		}
		
// sum crab carb consumption
		for (int x:crab){
			int dist=Math.abs(x-media);
			for(int g=0;g<=dist;g++){
				ris=ris+g;
			}
		}
		System.out.println("Carb totale= "+ris);
	}
}
