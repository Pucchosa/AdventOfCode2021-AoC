import java.util.*;

public class Day10_both {
	public static void main(String[] args) {
		int r=0;
		int s=0;
		int error=0;
		double ris=0;
		double med=0;
		LinkedList<Double> valori=new LinkedList<Double>();
		LinkedList<String> lineeIn=new LinkedList<String>();
		LinkedList<String> lineeOut=new LinkedList<String>();
		LinkedList<String> sbagliate=new LinkedList<String>();
		LinkedList<String> giuste=new LinkedList<String>();
		Scanner sc=new Scanner(System.in);

// make List of input
		while(r==0){
			String line = sc.nextLine();
			if (line.equals("stop")){
				r=2;
				break;
			}
			lineeIn.add(line);
		}
		
// eliminate closed ones
		for (String a:lineeIn){
			while(s==0){
			    if (a.contains("()")||a.contains("[]")||a.contains("{}")||a.contains("<>")){
					a=a.replaceAll( "\\(\\)", "" );
					a=a.replaceAll( "\\[\\]", "" );
					a=a.replaceAll( "\\{\\}", "" );
					a=a.replaceAll( "\\<\\>", "" );
					s++;
				}
				s--;
			}
			lineeOut.add(a);
			s=0;
		}

// sort missing from errors 
		for (String a:lineeOut){
			boolean errore=false;
			for (int i=1;i<a.length();i++){
				if(a.charAt(i)==')'||a.charAt(i)==']'||a.charAt(i)=='}'||a.charAt(i)=='>'){
					sbagliate.add(a);
					errore=true;
					break;
					}
				}
			if (errore==false){giuste.add(a);}
		}

// sum errors in corrupted lines (PART 1)
		for (String a:sbagliate){
			for (int i=0;i<a.length();i++){
				if(a.charAt(i)==')'){
					error=error+3;
					break;
				}
				if(a.charAt(i)==']'){
					error=error+57;
					break;
				}
				if(a.charAt(i)=='}'){
					error=error+1197;
					break;
				}
				if(a.charAt(i)=='>'){
					error=error+25137;
					break;
				}
			}
		}
		
// sum points for missing clesedones (PART 2)
		for (String a:giuste){
			ris=0;
			for (int i=a.length()-1;i>=0;i--){
				if(a.charAt(i)=='('){
					ris=(ris*5)+1;
					}
				if(a.charAt(i)=='['){
					ris=(ris*5)+2;
					}
				if(a.charAt(i)=='{'){
					ris=(ris*5)+3;
					}
				if(a.charAt(i)=='<'){
					ris=(ris*5)+4;
					}
				}
			valori.add(ris);
		}
		
// find middle n print result
		Collections.sort(valori);
		med=valori.get((valori.size()-1)/2);
		System.out.println("Part 1 result: "+error);
		System.out.println("Part 2 result: "+med);
	}
}
