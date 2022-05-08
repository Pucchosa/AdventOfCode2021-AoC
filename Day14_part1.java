import java.util.*;

public class Day14_part1 {
	public static void main(String[] args) {
		int t=0;
		int r=0;
		String cod ="";
		String codBis ="";
		int max=0;
		int ris=0;
		int min=1000;
		HashMap<String, String> rules=new HashMap<String, String>();
		HashMap<String, Integer> conta=new HashMap<String, Integer>();
		ArrayList<String> poli=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);

// take imput
		cod = sc.nextLine();
		while(r==0){
			
			String line = sc.nextLine();
			if (line.equals("stop")){
				r=2;
				break;
				}
			if (line.equals("")){
				continue;
			}

			line=line.replaceAll( "\\-\\>", "" );
			String[] y=line.split("  ");
			rules.put(y[0], y[1]);
			}

// apply rules for 10 times
		while (t<10){

			for (int i=0;i<cod.length()-1;i++){
				String sub=""+cod.charAt(i)+cod.charAt(i+1);
				codBis=codBis+cod.charAt(i)+rules.get(sub);}
			codBis=codBis+cod.charAt(cod.length()-1);
			cod=codBis;
			codBis="";
			t++;
			}

// make map:
		for (int i=0;i<cod.length();i++){
			conta.put(String.valueOf(cod.charAt(i)), 0);
			}


// count letters
		for (int i=0;i<cod.length();i++){
			conta.put(String.valueOf(cod.charAt(i)), conta.get(String.valueOf(cod.charAt(i)))+1);
			}

// find max e min rep
		for (int value : conta.values()) {
			if (max<value){max=value;}
			if (min>value){min=value;}
			}
// print difference
		ris=max-min;
		System.out.println("DIFFERENCE: "+ris);
	}
}
