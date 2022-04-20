import java.util.*;

public class Day3_part1 {
	public static void main(String[] args) {
		int t=0;
		int ris=0;
		int gam=0;
		int eps=0;
		int tot=0;
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[12];
		int[] bin={2048,1024,512,256,128,64,32,16,8,4,2,1};
		int[] gamma=new int[12];
		int[] epsilon=new int[12];
		
// make int[] from input
		while(t==0){
 	      	String line = sc.nextLine();
			if(line.equals("stop")){
				t=1;
			}
			else{
				String[] numbers = line.split("");
				for(int i=0;i<12;i++) {
					arr[i]=arr[i]+Integer.valueOf(numbers[i]);
					tot++;
				}
			}
		}
	
// calculate
		for(int h=0;h<12;h++) {
			if(arr[h]>(tot/24))
				{gamma[h]=1;}
			else {epsilon[h]=1;}
		}
		for(int g=0;g<12;g++) {
			gam=gam+(gamma[g]*bin[g]);
			eps=eps+(epsilon[g]*bin[g]);
		}
		ris=gam*eps;
		System.out.println("Risultato: "+ris);
	}
}
