import java.util.*;

public class Day01_part1 {
	public static void main(String[] args) {
		int ris=0;
		int t=0;
		ArrayList<Integer> lista=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);

// Make List of input
		while(true){
			try{
				int dep = sc.nextInt();
				lista.add(dep);
				}
			catch(Exception e){
				break;}
		}
		
// make sum
		for (int i=0;i<lista.size()-1;i++){
			if(lista.get(i)<lista.get(i+1)){ris=ris+1;}
		}
		System.out.println("Result: "+ris);
	}
}
