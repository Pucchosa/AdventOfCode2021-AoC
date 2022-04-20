import java.util.*;

public class Day11_obj {
	int cont=0;
	ArrayList<int[]> input=new ArrayList<int[]>();
	Scanner sc=new Scanner(System.in);

// make List of input
	public void crea(){
		int r=0;
		while(r==0){
			String line = sc.nextLine();
			int[] coor=new int[line.length()];
			if (line.equals("stop")){
				r=2;
				break;
			}
			String[] y=line.split("");
			for (int d=0;d<y.length;d++){
				coor[d]=Integer.parseInt(y[d]);
			}
			input.add(coor);
		}
	}
	
// take a step
	public void flash(int x,int y){
		if (x>0&&y>0&&x<input.size()-1&&y<input.get(x).length-1){
			this.input.get(x)[y]=-1000;
			this.input.get(x-1)[y-1]=this.input.get(x-1)[y-1]+1;
			this.input.get(x-1)[y]=this.input.get(x-1)[y]+1;
			this.input.get(x-1)[y+1]=this.input.get(x-1)[y+1]+1;
			this.input.get(x)[y-1]=this.input.get(x)[y-1]+1;
			this.input.get(x)[y+1]=this.input.get(x)[y+1]+1;
			this.input.get(x+1)[y-1]=this.input.get(x+1)[y-1]+1;
			this.input.get(x+1)[y]=this.input.get(x+1)[y]+1;
			this.input.get(x+1)[y+1]=this.input.get(x+1)[y+1]+1;
			this.cont++;
		}
		else if (x==0&&y>0&&y<input.get(x).length-1){
			this.input.get(x)[y]=-1000;
			this.input.get(x)[y-1]=this.input.get(x)[y-1]+1;
			this.input.get(x)[y+1]=this.input.get(x)[y+1]+1;
			this.input.get(x+1)[y-1]=this.input.get(x+1)[y-1]+1;
			this.input.get(x+1)[y]=this.input.get(x+1)[y]+1;
			this.input.get(x+1)[y+1]=this.input.get(x+1)[y+1]+1;
			this.cont++;
		}
		else if (x>0&&y==0&&x<input.size()-1){
			this.input.get(x)[y]=-1000;
			this.input.get(x-1)[y]=this.input.get(x-1)[y]+1;
			this.input.get(x-1)[y+1]=this.input.get(x-1)[y+1]+1;
			this.input.get(x)[y+1]=this.input.get(x)[y+1]+1;
			this.input.get(x+1)[y]=this.input.get(x+1)[y]+1;
			this.input.get(x+1)[y+1]=this.input.get(x+1)[y+1]+1;
			this.cont++;
		}
		if (y>0&&x==input.size()-1&&y<input.get(x).length-1){
			this.input.get(x)[y]=-1000;
			this.input.get(x-1)[y-1]=this.input.get(x-1)[y-1]+1;
			this.input.get(x-1)[y]=this.input.get(x-1)[y]+1;
			this.input.get(x-1)[y+1]=this.input.get(x-1)[y+1]+1;
			this.input.get(x)[y-1]=this.input.get(x)[y-1]+1;
			this.input.get(x)[y+1]=this.input.get(x)[y+1]+1;
			this.cont++;
		}
		if (x>0&&x<input.size()-1&&y==input.get(x).length-1){
			this.input.get(x)[y]=-1000;
			this.input.get(x-1)[y-1]=this.input.get(x-1)[y-1]+1;
			this.input.get(x-1)[y]=this.input.get(x-1)[y]+1;
			this.input.get(x)[y-1]=this.input.get(x)[y-1]+1;
			this.input.get(x+1)[y-1]=this.input.get(x+1)[y-1]+1;
			this.input.get(x+1)[y]=this.input.get(x+1)[y]+1;
			this.cont++;
		}
		if (x==0&&y==0){
			this.input.get(x)[y]=-1000;
			this.input.get(x)[y+1]=this.input.get(x)[y+1]+1;
			this.input.get(x+1)[y]=this.input.get(x+1)[y]+1;
			this.input.get(x+1)[y+1]=this.input.get(x+1)[y+1]+1;
			this.cont++;
		}
		if (x==input.size()-1&&y==input.get(x).length-1){
			this.input.get(x)[y]=-1000;
			this.input.get(x-1)[y-1]=this.input.get(x-1)[y-1]+1;
			this.input.get(x-1)[y]=this.input.get(x-1)[y]+1;
			this.input.get(x)[y-1]=this.input.get(x)[y-1]+1;
			this.cont++;
		}
		if (x==0&&y==input.get(x).length-1){
			this.input.get(x)[y]=-1000;
			this.input.get(x)[y-1]=this.input.get(x)[y-1]+1;
			this.input.get(x+1)[y-1]=this.input.get(x+1)[y-1]+1;
			this.input.get(x+1)[y]=this.input.get(x+1)[y]+1;
			this.cont++;
		}
		if (y==0&&x==input.size()-1){
			this.input.get(x)[y]=-1000;
			this.input.get(x-1)[y]=this.input.get(x-1)[y]+1;
			this.input.get(x-1)[y+1]=this.input.get(x-1)[y+1]+1;
			this.input.get(x)[y+1]=this.input.get(x)[y+1]+1;
			this.cont++;
		}
	}
	
// flash
	public void adda(){
		for (int a=0;a<input.size();a++){
			for (int b=0;b<input.get(a).length;b++){
				input.get(a)[b]=input.get(a)[b]+1;
			}
		}
	}
	
// print
	public void print(){
		for (int[] a:input){
			System.out.println(Arrays.toString(a));
		}
	}
	
// check if absolute 
	public boolean azzera(){
		int quanti=0;
		for (int a=0;a<input.size();a++){
			for (int b=0;b<input.get(a).length;b++){
				if (input.get(a)[b]<0){
					input.get(a)[b]=0;
					quanti++;
				}
			}
		}
		int tott=(input.size()*input.get(0).length);
		System.out.println("flash "+quanti+" su "+tott);
		if (quanti==tott){
			return true;
		}
		return false;
	}
}
