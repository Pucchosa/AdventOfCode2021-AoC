import java.util.*;
// I KNOW ITS SOOOOO SLOOOOW :(
public class Day12-part2 {
	public static void main(String[] args) {
		Day12-Aus au=new Day12-Aus();
		ArrayList<String[]> input=new ArrayList<String[]>();
		int r=0;
		Scanner sc=new Scanner(System.in);
		ArrayList<String[]> inn=new ArrayList<String[]>();
		LinkedList<ArrayList<String>> path=new LinkedList<ArrayList<String>>();
		LinkedList<ArrayList<String>> temp=new LinkedList<ArrayList<String>>();
		LinkedList<ArrayList<String>> finn=new LinkedList<ArrayList<String>>();
		ArrayList<String> start=new ArrayList<String>();
		String sta="start";
		start.add(sta);
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
		
// add inverse directions
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

// add a step to every path
		while (path.size()>0){
			for (ArrayList<String> a:path){
				for (String[] b:input){
					if (b[0].equals(a.get(a.size()-1))){
						ArrayList<String> c=new ArrayList<String>();
						for (String ne:a){
							c.add(ne);
						}
						for (String g:au.aggiungi(b[1], a)){
							c.add(g);
						
							if (c.get(c.size()-1).equals("end")){
								boolean ll=true;
								for (ArrayList<String> q:finn){
									if (q==c){
										ll=false;
									}
								}
								if (ll==true){
									finn.add(c);
								}
							}
							else if (c.get(c.size()-1).equals("zzz")){
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
				boolean oo=true;
				for (ArrayList<String> e:path){
					if (e==d){
						oo=false;
					}
				}
				if (au.check(d)&&oo==true){
					path.add(d);
				}
			}
			temp.clear();
		}
		System.out.println(" TOT "+finn.size());
	}
}
