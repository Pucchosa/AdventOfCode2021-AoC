import java.util.*;

public class Day8_part2 {
	
// method to compare 2 strings and find anagrams
	public static boolean isAnagram(String str1, String str2) {  
        String s1 = str1.replaceAll("\\s", "");  
        String s2 = str2.replaceAll("\\s", "");  
        boolean status = true;  
        if (s1.length() != s2.length()) {  
            status = false;  
        } else {  
            char[] ArrayS1 = s1.toLowerCase().toCharArray();  
            char[] ArrayS2 = s2.toLowerCase().toCharArray();  
            Arrays.sort(ArrayS1);  
            Arrays.sort(ArrayS2);  
            status = Arrays.equals(ArrayS1, ArrayS2);  
        }
		return status;
	}
	
// method to calculate number
	public static int calcola(int indice, LinkedList<String[]> a,LinkedList<String[]> b){
		String[] x=a.get(indice);
		String[] y=b.get(indice);
		int[] num={6,6,6,6};
		LinkedList<String> tutto=new LinkedList<String>();
		LinkedList<String> da5=new LinkedList<String>();
		LinkedList<String> da6=new LinkedList<String>();
		LinkedList<String> temp=new LinkedList<String>();
		String uno="";
		String quattro="";
		String sette="";
		String due="";
		String tre="";
		String cinque="";
		String nove="";
		String zero="";
		
		for (String u:x){
			if (u.length()!=7){
				tutto.add(u);
			}
		}
		for (int u=0;u<y.length;u++){
			if (y[u].length()==7){
				num[u]=8;
			}
			else {
				tutto.add(y[u]);
			}
		}
		for (int u=0;u<y.length;u++){
			if (y[u].length()==2){
				num[u]=1;
				uno=y[u];
			}
			else if (y[u].length()==4){
				num[u]=4;
				quattro=y[u];
			}
			else if (y[u].length()==3){
				num[u]=7;
				sette=y[u];
			}
		}	
		for (String u:tutto){
			
			if (u.length()==2){
				uno=u;
			}
			if (u.length()==4){
				quattro=u;
			}
			if (u.length()==3){
				sette=u;
			}
			if (u.length()==5){
				da5.add(u);
			}
			else if (u.length()==6){
				da6.add(u);
			}
		}
		for (String u:da6){
			int prova=0;
			for (int i=0;i<4;i++){
				if (!u.contains(""+quattro.charAt(i))){
					temp.add(u);
					continue;
				}
				else {
					prova=prova+1;
				}
			}
			if (prova==4){
				nove=u;
			}
		}
		da6.clear();
		for (String u:temp){
			da6.add(u);
		}
		temp.clear();
		for (String u:da5){
			int prova=0;
			for (int i=0;i<3;i++){
				if (!u.contains(""+sette.charAt(i))){
					temp.add(u);
					continue;
				}
				else {
					prova=prova+1;
				}
			}
			if (prova==3){
				tre=u;
			}
		}
		da5.clear();
		for (String u:temp){
			da5.add(u);
		}
		temp.clear();
		for (String u:da6){
			int prova=0;
			for (int i=0;i<2;i++){
				if (!u.contains(""+uno.charAt(i))){
					temp.add(u);
					continue;
				}
				else {
					prova=prova+1;
				}
			}
			if (prova==2){
				zero=u;
			}
		}
		da6.clear();
		for (String u:temp){
			da6.add(u);
		}
		temp.clear();
		for (String u:da5){
			int prova=0;
			for (int i=0;i<4;i++){
				if (!u.contains(""+quattro.charAt(i))){
					continue;
				}
				else {
					prova=prova+1;
				}
			}
			if (prova==3){
				cinque=u;
			}
			else if (prova==2){
				due=u;
			}	
		}
		for (int i=0;i<4;i++){
			if (isAnagram(y[i], zero)){
				num[i]=0;
			}
			else if (isAnagram(y[i], due)){
				num[i]=2;
			}
			else if (isAnagram(y[i], tre)){
				num[i]=3;
			}
			else if (isAnagram(y[i], cinque)){
				num[i]=5;
			}
			else if (isAnagram(y[i], nove)){
				num[i]=9;
			}
		}
		String nn=""+num[0]+num[1]+num[2]+num[3]+"";
		int numeroo=Integer.parseInt(nn);
		return numeroo;
	}

	
	public static void main(String[] args) {
		int t=0;
		int r=0;
		int ris=0;
		LinkedList<String[]> inDieci=new LinkedList<String[]>();
		LinkedList<String[]> inQuattro=new LinkedList<String[]>();
		LinkedList<Integer> valori=new LinkedList<Integer>();
		Scanner sc=new Scanner(System.in);

//  make 2 LinkedList of input
		while(r==0){
			String line = sc.nextLine();
			if (line.equals("stop")){
				r=2;
				break;
			}
			line=line.replaceAll( " | ", " " );
			String[] y=line.split(" ");
			String[] die=new String[10];
			String[] qua=new String[4];
			for (int i=0;i<10;i++){
				die[i]=y[i];
			}
			inDieci.add(die);
			for (int h=11;h<15;h++){
				qua[h-11]=y[h];
			}
			inQuattro.add(qua);
		}

// calculate		
		for (int i=0;i<inDieci.size();i++){
			int v=calcola(i, inDieci, inQuattro);
			valori.add(v);
		}

		for (int u:valori){
			ris=ris+u;
		}
		System.out.println("Totale: "+ris);
	}
}
