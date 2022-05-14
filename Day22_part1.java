import java.util.*;

public class Day22_part1 {
	public static void main(String[] args) {
		int r=0;
		int ris=0;
		int[][][] cubo=new int[110][110][110];
		LinkedList<int[]> comandi=new LinkedList<int[]>();
		Scanner sc=new Scanner(System.in);

// make command list:
		while(r==0){
			String line = sc.nextLine();
			if (line.equals("stop")){
				r=2;
				break;
				}

			line=line.replaceAll( ",", " " );
			line=line.replaceAll( "\\.\\.", " " );
			line=line.replaceAll( "=", " " );
			line=line.replaceAll( " x ", " " );
			line=line.replaceAll( " y ", " " );
			line=line.replaceAll( " z ", " " );
			String[] y=line.split(" ");

			int[] riga=new int[y.length];
			for (int i=0;i<y.length;i++){
				if (y[i].equals("on")){riga[i]=1;}
				else if (y[i].equals("off")){riga[i]=0;}
				else {riga[i]=Integer.valueOf(y[i]);}
				}
			comandi.add(riga);	
			}

// switch on-off points
		for (int[] i:comandi){
			for(int x=i[1]+51;x<=i[2]+51;x++){
				for(int y=i[3]+51;y<=i[4]+51;y++){
					for(int z=i[5]+51;z<=i[6]+51;z++){
						cubo[x][y][z]=i[0];
			}	}	}	}

// count lit points
		for(int x = 0; x < cubo.length; x++){
			for(int y = 0; y < cubo[0].length; y++){
				for(int z = 0; z < cubo[0][0].length; z++){
					if(cubo[x][y][z]==1){ris=ris+1;}
			}	}	}
		System.out.println("Punti accesi: "+ris);
		}
	}
