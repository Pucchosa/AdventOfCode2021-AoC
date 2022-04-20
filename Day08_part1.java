import java.util.*;

public class Day08_part1 {
	public static void main(String[] args) {
		int t=0;
		int r=0;
		int ris=0;
		LinkedList<String> inDieci=new LinkedList<String>();
		LinkedList<String> inQuattro=new LinkedList<String>();
		Scanner sc=new Scanner(System.in);

//  make 2 LinkedList of input 
		while(r==0){
			String line = sc.nextLine();
			if (line.equals("stop")){
				r=2;
				break;
			}
			line=line.replaceAll( " | ", " " );
			System.out.println("riga inserita: "+line);
			String[] y=line.split(" ");
			for (int i=0;i<10;i++){
				inDieci.add(y[i]);
			}
			for (int h=11;h<15;h++){
				inQuattro.add(y[h]);
			}
		}
		
// look for numbers
	    for (String g: inQuattro){
			if (g.length()==2||g.length()==4||g.length()==3||g.length()==7){
				ris=ris+1;
			}
		}
		System.out.println("Numeri unici: "+ris);
	}
}
