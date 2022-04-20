import java.util.*;

public class Day6_part2 {
	public static void main(String[] args) {
		long x=1;
		int t=0;
		int rip=256;
		LinkedList<Integer> lantern=new LinkedList<Integer>();
		Scanner sc=new Scanner(System.in);
		long[] groupA={1,0};
		long[] groupB={2,0};
		long[] groupC={3,0};
		long[] groupD={4,0};
		long[] groupE={5,0};
		long[] groupF={6,0};
		long[] groupG={0,0};
		long[] babyA={1,0};
		long[] babyB={0,0};
		long bb=0;
		long aa=0;
		LinkedList<long[]> pool=new LinkedList<long[]>();

// make List of input
		String line = sc.nextLine();
		String[] y=line.split(",");
		for (int d=0;d<y.length;d++){
			lantern.add(Integer.parseInt(y[d]));
		}

// assegno pesci a gruppi
		for (int u:lantern){
			if (u==0){
				groupG[1]=groupG[1]+x;
			}
			else if (u==1){
				groupA[1]=groupA[1]+x;
			}
			else if (u==2){
				groupB[1]=groupB[1]+x;
			}
			else if (u==3){
				groupC[1]=groupC[1]+x;
			}
			else if (u==4){
				groupD[1]=groupD[1]+x;
			}
			else if (u==5){
				groupE[1]=groupE[1]+x;
			}
			else if (u==6){
				groupF[1]=groupF[1]+x;
			}
		}
		
// metto tutto dentro list pool

		pool.add(groupA);
		pool.add(groupB);
		pool.add(groupC);
		pool.add(groupD);
		pool.add(groupE);
		pool.add(groupF);
		pool.add(groupG);
		
// FACCIO PASSARE GIORNI

		while (t<rip){
			for (long[] u:pool){
				u[0]=u[0]-x;
				if (u[0]<0){
					u[0]=6;
					bb=u[1];
				}
				
			}
			babyA[0]=babyA[0]-x;
			babyB[0]=babyB[0]-x;
			if (babyA[0]<0){
				aa=babyA[1];
				babyA[0]=1;
				babyA[1]=bb;
			}
			else if (babyB[0]<0){
				aa=babyB[1];
				babyB[0]=1;
				babyB[1]=bb;
			}
			for (long[] u:pool){
				if (u[0]==6){
					u[1]=u[1]+aa;
				}
			}
			aa=0;
			bb=0;
			t++;
		}
		long tot=0;
		for (long[] u:pool){
			tot=tot+u[1];
		}
		tot=tot+babyB[1]+babyA[1];
		System.out.println("Nel Giorno "+t+" ci sono "+tot+" pesci-lanterna.");
	}
}
