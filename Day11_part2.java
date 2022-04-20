import java.util.*;

public class Day11_part2 {
	public static void main(String[] args) {
		Obb obj=new Obb();
		int gg=0;
		int giri=0;
		int rip=1000;

		obj.crea();
		while (giri<rip){
			obj.adda();
			boolean tr=true;
			while (tr==true){
				tr=false;
				for (int x=0;x<obj.input.size();x++){
					for (int y=0;y<obj.input.get(x).length;y++){
						if (obj.input.get(x)[y]>9){
							obj.flash(x,y);
							tr=true;
						}
					}
				}
			}
			if (obj.azzera()){
				gg=giri+1;
				break;
			}
			giri++;
		}
		System.out.println("First complete flash after round: "+gg);
	}
}
