import java.util.*;
import java.math.*;

public class Day21-part1 {
	public static void main(String[] args) {
		int p1=0;
		int p2=0;
		int score1=0;
		int score2=0;
		int x=1000;
		int t=0;
		int q=0;
		int ok=0;
		int ko=0;
		ArrayList<Integer> conta=new ArrayList<Integer>();
		ArrayList<Integer> roll=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);

		System.out.println("Type Player1 starting position: ");
		p1 = sc.nextInt();
		System.out.println("Type Player2 starting position: ");
		p2 = sc.nextInt();

		for (int i=1;i<101;i++){
			conta.add(i);
			}

		while (roll.size()<1500){
			if (q<=(conta.size()-3)){
				int num=conta.get(q)+conta.get(q+1)+conta.get(q+2);
				int nu=num%10;
				roll.add(num);
				q=q+3;
				}
			else if (q==(conta.size()-2)){
				int num=conta.get(q)+conta.get(q+1)+conta.get(0);
				int nu=num%10;
				roll.add(num);
				q=1;
				}
			else if (q==(conta.size()-1)){
				int num=conta.get(q)+conta.get(0)+conta.get(1);
				int nu=num%10;
				roll.add(num);
				q=2;
				}
			else if (q==(conta.size())){
				int num=conta.get(0)+conta.get(1)+conta.get(2);
				int nu=num%10;
				roll.add(num);
				q=3;
				}
			}

//		for (int p: roll){System.out.println("Tiro: "+p);}
		for (int h=0;h<1000;h++){
			if ((h+1)%2==1){
				p1=p1+roll.get(h);
				if (p1>10){
					if(p1%10!=0){p1=p1%10;}
					else {p1=10;}
					}
				score1=score1+p1;
	//			System.out.println("Number of rolls: "+(h+1)+" p1 score: "+score1);
				}
			else if ((h+1)%2==0){
				p2=p2+roll.get(h);
				if (p2>10){
					if(p2%10!=0){p2=p2%10;}
					else {p2=10;}
					}
				score2=score2+p2;
	//			System.out.println("Number of rolls: "+(h+1)+" p2 score: "+score2);
				}
			if (score1>=x||score2>=x){
				t=h+1;
	//			System.out.println("Player 1 score: "+score1);
	//			System.out.println("Player 2 score: "+score2);
	//			System.out.println("Number of rolls: "+(t*3));
				ok=t*3*score1;
				ko=t*3*score2;
	//			System.out.println("result if p2 win: "+ok+" result if p1 win: "+ko);
				break;
				}
			}
			if (score1>score2){
				System.out.println("Result: "+ko);
			}
			else {
				System.out.println("Result: "+ok);
			}

//		for (int i=0;i<t;i++){
//			System.out.println("tiro: "+roll.get(i));
//			}
	}	}
