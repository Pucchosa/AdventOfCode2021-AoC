import java.util.*;

public class Day1_part2 {
	public static void main(String[] args) {
		int ris=0;
		int t=0;
		ArrayList<Integer> lista=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);

// make List of input
		while(true){
			try{
				int dep = sc.nextInt();
				lista.add(dep);
				}
			catch(Exception e){
				break;}
		}
		
// make sum
		for (int i=0;i<lista.size()-3;i++){
			int A=lista.get(i)+lista.get(i+1)+lista.get(i+2);
			int B=lista.get(i+1)+lista.get(i+2)+lista.get(i+3);
			if(A<B){ris=ris+1;}
		}
		System.out.println("Result: "+ris);
	}
}
