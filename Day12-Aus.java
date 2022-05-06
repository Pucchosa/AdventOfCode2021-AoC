import java.util.*;

	public class Day12-Aus {
	
// check if there is a double already	
	public static boolean check(ArrayList<String> d){
		boolean ck=true;
		for (String a:d){
			if (a.equals("zzz")){
				ck=false;
			}
		}
		return ck;
	}

// add next step and signal double
	public static ArrayList<String> aggiungi(String u,ArrayList<String> c){
	//	char x=u.charAt(0);
		ArrayList<String> a=new ArrayList<String>();
		boolean dop=false;
		boolean ttt=false;
		if (u.charAt(0)>='a'&&u.charAt(0)<='z') {
			for (String h:c) {
				if (h.equals("tt")){
					ttt=true;
				}
				if (h.equals(u)){
					dop=true;
				}
			}
			if (ttt){
				if (dop){
					a.add("zzz");
				}
				else {
					a.add(u);
				}
			}
			else {
				if (dop){
					a.add("tt");
					a.add(u);
				}
				else {
					a.add(u);
				}
			}
		}
		else {
			a.add(u);
		}
		return a;
	}
}
