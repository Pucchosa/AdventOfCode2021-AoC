import java.util.*;

public class Prog {
	public static void main(String[] args) {
		int t=0;
		int r=0;
		int ris=0;
		int piegaX=0;
		int piegaY=0;
		LinkedList<int[]> input=new LinkedList<int[]>();
		Scanner sc=new Scanner(System.in);

// make List of coordinates
		System.out.println(" \n ---- Enter coordinates points and fold instuction (end with \"stop\"): ---- \n");
		while(r==0){
			String line = sc.nextLine();
			int[] coor=new int[2];
			if (line.equals("")){
				r=2;
				break;
			}
			String[] y=line.split(",");
			for (int d=0;d<y.length;d++){
				coor[d]=Integer.parseInt(y[d]);
			}
			input.add(coor);
		}
// fold the paper
		ArrayList<String[]> pieghe=new ArrayList<String[]>();
	    while (t==0){
			sc.useDelimiter(System.lineSeparator());
			String inn=sc.next();
			if (inn.equals("stop")){
				t=2;
				break;
			}
			String[] intera=inn.split(" ");
			String[] pieg=intera[2].split("=");
			pieghe.add(pieg);
		}
		for (String[] a:pieghe){
			if (a[0].equals("x")){
				piegaX=Integer.parseInt(a[1]);}
			else if (a[0].equals("y")){
				piegaY=Integer.parseInt(a[1]);}

			if (piegaY>0){
				for (int[] i:input){
					if (i[1]>piegaY){
						i[1]=piegaY-(i[1]-piegaY);
					}
				}
			}
			if (piegaX>0){
				for (int[] i:input){
					if (i[0]>piegaX){
						i[0]=piegaX-(i[0]-piegaX);
					}
				}
			}
			piegaX=0;
			piegaY=0;
		}
// find x max and y max
		int xMax=0;
		int yMax=0;
		for (int[] i:input){
			if (i[0]>xMax){
				xMax=i[0];
			}
			if (i[1]>yMax){
				yMax=i[1];
			}
		}
// create the paper
		char[][] fin=new char[yMax+1][xMax+1];
		for (int i=0;i<xMax;i++){
			for (int h=0;h<yMax;h++){
				fin[h][i]=' ';
			}
		}
// draw the points
		for (int[] i:input){
			if (fin[i[1]][i[0]]!='$'){
				fin[i[1]][i[0]]='$';
				ris++;
			}
		}
// print results
		System.out.println("Paper: ");
		for (char[] a: fin){
			System.out.println(Arrays.toString(a));
		}
		System.out.println("Total points: "+ris);
	}
}
