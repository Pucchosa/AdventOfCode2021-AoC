import java.util.*;
// this is SLOW even for part 1, better use part 2 for both!
public class Day06_part1 {
	public static void main(String[] args) {
		int t=0;
		int r=0;
		int days=80;
		LinkedList<Integer> lantern=new LinkedList<Integer>();
		Scanner sc=new Scanner(System.in);

// make List of input
		while(r==0){
			String line = sc.nextLine();
			if (line.equals("stop")){
				r=2;
				break;
			}
			String[] y=line.split(",");
			for (int d=0;d<y.length;d++){
				lantern.add(Integer.parseInt(y[d]));
				System.out.println("int added: "+Integer.parseInt(y[d]));
			}
		}
		
// 80 days later...
		for (int p=0;p<days; p++){
			for (int s=0;s<lantern.size();s++){
				if (lantern.get(s)==0){
					t++;
					lantern.set(s, 6);
				}
				else{
					lantern.set(s, lantern.get(s)-1);
				}
			}
			for (int u=0;u<t;u++){
				lantern.add(8);}
			t=0;
			System.out.println("After day "+p+" we have "+lantern.size()+" lanternfish.");
		}
	}
}
