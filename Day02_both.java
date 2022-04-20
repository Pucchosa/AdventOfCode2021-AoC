import java.util.*;

public class Day02_both {
	public static void main(String[] args) {
		int dep=0;
		int dis=0;
		int aim=0;
		int t=0;
		Scanner sc=new Scanner(System.in);
		String x="";
		int val=0;
		
// calculate 
		while(t==0){
			x=sc.next();
			val=sc.nextInt();
			if (x.equals("up")){
				aim=aim-val;
			}
			else if(x.equals("forward")){
				dis=dis+val;
				dep=dep+(val*aim);
			}
			else if(x.equals("down")){
				aim=aim+val;
			}
			else if (x.equals("stop")){
				t=3;
				break;
			}
		}
		
		int res=dis*dep;
		int ris=dis*aim;
		System.out.println("risultato Part1: "+ris);
		System.out.println("risultato Part2: "+res);
	}
}
