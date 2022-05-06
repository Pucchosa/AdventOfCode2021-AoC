import java.util.*;

public class Day12-part1 {
// method to check for double
	public static boolean doppio(String x,ArrayList<String> c){
		boolean dop=false;
		boolean ttt=false;
		if (x.charAt(0)>='a'&&x.charAt(0)<='z') {
			for (String h:c) {
				if (h.charAt(0)=='t'){
					ttt=true;
				}
			}
			for (String h : c) {
				if (h.equals(x)){
					dop=true;
				}
			}
		}
		return dop;
	}

	public static void main(String[] args) {
		ArrayList<String[]> input=new ArrayList<String[]>();
		int r=0;
		int t=0;
		Scanner sc=new Scanner(System.in);
		ArrayList<String[]> inn=new ArrayList<String[]>();
		LinkedList<ArrayList<String>> path=new LinkedList<ArrayList<String>>();
		LinkedList<ArrayList<String>> temp=new LinkedList<ArrayList<String>>();
		LinkedList<ArrayList<String>> finn=new LinkedList<ArrayList<String>>();
		ArrayList<String> start=new ArrayList<String>();
		String star="start";
		start.add(star);
		path.add(start);

// make List of input
		while(r==0){
			String line = sc.nextLine();
			if (line.equals("stop")){
				r=2;
				break;
			}
			String[] y=line.split("-");
			input.add(y);
		}

// add inverse direction
		for (String[] a:input){
			boolean ce=false;
			if (a[0].equals("start")||a[1].equals("end")){
				ce=true;
			}
			if (ce==false){
				String[] tt=new String[2];
				for (int i=0;i<2;i++){
					tt[i]=a[a.length-1-i];
				}
				inn.add(tt);
			}
		}
		
// delete road to -start or from end-
		for (String[] a:input){
			boolean ck=false;
			if (a[0].equals("end")||a[1].equals("start")){
				ck=true;
			}
			if (ck==false){
				inn.add(a);
			}
		}
		input.clear();
		for (String[] a:inn){
			input.add(a);
		}

// add a step to every path (and separate the ended or wrong ones)
		while (path.size()>0){
			for (ArrayList<String> a:path){
				for (String[] b:input){
					if (b[0].equals(a.get(a.size()-1))){
						ArrayList<String> c=new ArrayList<String>();
						for (String ne:a){
							c.add(ne);
						}
						if (doppio(b[1], c)==false){
							c.add(b[1]);
							if (c.get(c.size()-1).equals("end")){
								finn.add(c);
							}
							else {
								temp.add(c);
							}
						}
					}
				}
			}
			path.clear();
			for (ArrayList<String> d:temp){
				path.add(d);
			}
			temp.clear();
			t++;
		}
// print result
		System.out.println(" TOT: "+finn.size());
	}
}
