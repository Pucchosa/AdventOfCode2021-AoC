import java.util.*;

public class Day25-part1 {
	public static void main(String[] args) {
		
		int t=0;
		int r=0;
		int ris=0;
		ArrayList<int[]> tavola=new ArrayList<int[]>();
		ArrayList<int[]> muoveE=new ArrayList<int[]>();
		ArrayList<int[]> muoveS=new ArrayList<int[]>();
		ArrayList<Integer> est0=new ArrayList<Integer>();
		ArrayList<Integer> sud0=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);

// make list of input
		while(r==0){
			String line = sc.nextLine();
			if (line.equals("stop")){
				r=2;
				break;
				}

			String[] y=line.split("");
			int[] x=new int[y.length];
			for (int d=0;d<y.length;d++){
				if (y[d].equals(".")){
					x[d]=0;}
				else if (y[d].equals(">")){
					x[d]=1;}
				else if (y[d].equals("v")){
					x[d]=2;}
				}
			tavola.add(x);
			}

// move EST

		while (t<6){

			for (int i=0;i<tavola.size();i++){
				for (int h=0;h<tavola.get(0).length-1;h++){
					if (tavola.get(i)[h]==1){
						if (tavola.get(i)[h+1]==0){
							int[] w={i,h};
							muoveE.add(w);
				}	}	}	}
			for (int i=0;i<tavola.size();i++){
				if (tavola.get(i)[(tavola.get(0).length)-1]==1){
					if (tavola.get(i)[0]==0){
						int z=i;
						est0.add(z);
				}	}	}

			for (int[] i:muoveE){
				tavola.get(i[0])[i[1]]=0;
				tavola.get(i[0])[(i[1]+1)]=1;
				}
			

			for (int i:est0){
				tavola.get(i)[(tavola.get(0).length)-1]=0;
				tavola.get(i)[0]=1;
				}
			

// move SOUTH
			for (int i=0;i<tavola.size()-1;i++){
				for (int h=0;h<tavola.get(0).length;h++){
					if (tavola.get(i)[h]==2){
						if (tavola.get(i+1)[h]==0){
							int[] w={i,h};
							muoveS.add(w);
				}	}	}	}
			for (int h=0;h<tavola.get(0).length;h++){
				if (tavola.get(tavola.size()-1)[h]==2){
					if (tavola.get(0)[h]==0){
						int z=h;
						sud0.add(z);
				}	}	}

			for (int[] i:muoveS){
				tavola.get(i[0])[i[1]]=0;
				tavola.get(i[0]+1)[i[1]]=2;
				}
			
	
			for (int i:sud0){
				tavola.get(tavola.size()-1)[i]=0;
				tavola.get(0)[i]=2;
				}
			int rip=(est0.size()+sud0.size()+muoveE.size()+muoveS.size());

			if (rip==0){
				t=7;
				break;
				}
			ris=ris+1;
			rip=0;
			est0.clear();
			muoveE.clear();
			muoveS.clear();
			sud0.clear();
			}

		System.out.println("Total: "+(ris+1));
		}
	}
