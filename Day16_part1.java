import java.util.*;

public class Day16_part1 {
	public static void main(String[] args) {
		int tot=0;
		int r=0;
		String binario="";
		int risultato=0;
		LinkedList<Integer> valoriH=new LinkedList<Integer>();
		Scanner sc=new Scanner(System.in);

//  make string  BINARy 
		String line = sc.nextLine();
		char[] input=new char[line.length()];
		for (int c=0;c<line.length();c++){
			input[c]=line.charAt(c);
		}
		for (char a:input){
			binario=converti(binario, a);
		}
// verify immissione		
	//	System.out.println("Dimensuione: "+input.length);
	//	System.out.println("CONTENUTO: "+Arrays.toString(input));
	//	System.out.println("Binario: "+binario);
		System.out.println("Dimensione: "+binario.length());
	//	int fine=decimale(binario);
	//	System.out.println("Decimale: "+fine);

// find
		int h=0;
//		valoriH.add(h);
		while (h<binario.length()-11){
			valoriH.add(h);
			h=conta(h, binario);
//			System.out.println(h);
//			valoriH.add(h);
		}
		
//		System.out.println(" numero pacchetti: "+valoriH.size()+" INDICI H:");
		for (int u:valoriH){
//			System.out.println(u);
		}
		for (int e:valoriH){
			int ver=decimale(binario.substring(e,e+3));
			tot=tot+ver;
//			System.out.println(" per H: "+e+" Versione: "+ver);
		}
		System.out.println("Number of Version: "+tot);
	}
	
// method to convert bin to esa (ugly yes)
	public static String converti(String a, char x){
		if (x=='1'){
			a=a+"0001";
		}
		else if (x=='2'){
			a=a+"0010";
		}
		else if (x=='3'){
			a=a+"0011";
		}
		else if (x=='4'){
			a=a+"0100";
		}
		else if (x=='5'){
			a=a+"0101";
		}
		else if (x=='6'){
			a=a+"0110";
		}
		else if (x=='7'){
			a=a+"0111";
		}
		else if (x=='8'){
			a=a+"1000";
		}
		else if (x=='9'){
			a=a+"1001";
		}
		else if (x=='A'){
			a=a+"1010";
		}
		else if (x=='B'){
			a=a+"1011";
		}
		else if (x=='C'){
			a=a+"1100";
		}
		else if (x=='D'){
			a=a+"1101";
		}
		else if (x=='E'){
			a=a+"1110";
		}
		else if (x=='F'){
			a=a+"1111";
		}
		else if (x=='0'){
			a=a+"0000";
		}
		return a;
	}
		
// method to convert bin to dec
	public static int decimale(String a){
		String[] d=a.split("");
		int[] w=new int[d.length];
		for (int i=0;i<w.length;i++){
			w[i]=Integer.parseInt(d[i]);
		}
		int[] bib=new int[w.length];
		for (int i=0;i<w.length;i++){
			bib[w.length-1-i]=(int)Math.pow(2, i);
		}
		int val=0;
		for(int g=0;g<w.length;g++) {
			val=val+(w[g]*bib[g]);
			}
		return val;
	}	
		
// method to find h
	public static int conta(int x,String binario){
		int h=x;
		int versione=decimale(binario.substring(h,h+3));
		int tipo=decimale(binario.substring(h+3,h+6));
//		System.out.println(" versione: "+versione+" tipo: "+tipo);
		h=h+6;
//		if (versione==0&&tipo==0){return 10000;}
		if (tipo!=4){
			if (binario.charAt(h)=='0'){
				String temp=binario.substring(h+1,h+16);
				h=h+16;
				int val=decimale(temp);
		//		System.out.println(" temp: "+temp+" val: "+val);
		//		h=h+val;
			}
			else if (binario.charAt(h)=='1'){
				String temp=binario.substring(h+1,h+11);
				h=h+12;
				int val=decimale(temp);
		//		System.out.println(" è composto da pacchetti n: "+val);
		//		for(int i=0; i<val;i++){
		//			h=conta(h, binario);
		//		}
					
			}
		}
		else {
//			System.out.println(" è un LETTERALE!!! ");
			int q=0;
			while (q==0) {
	//			System.out.println(" INIZIO H: "+h+" Valore: "+binario.charAt(h));
				if (binario.charAt(h)=='0'){
	//				System.out.println(" penultima H: "+h+" Valore: "+binario.charAt(h));
					h=h+5;
	//				System.out.println(" ULTIMA H: "+h+" Valore: "+binario.charAt(h));
					q=1;
					break;
				}
				else {
	//				System.out.println(" prima H: "+h+" Valore: "+binario.charAt(h));
					h=h+5;
	//				System.out.println(" seconda H: "+h+" Valore: "+binario.charAt(h));
				}
			}
		}
		return h;
	}
}
