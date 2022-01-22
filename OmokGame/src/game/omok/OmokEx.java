package game.omok;

import java.util.Scanner;

public class OmokEx {

	private int[][]pan =new int [10][10];
	private int win;
	Scanner scanner =new Scanner(System.in);
	private int x,y;
	
	public int xPrint() {
		
		System.out.println("x좌표");
		x=scanner.nextInt()-1;
		if(x>=pan.length) {
			System.out.println("판의 수를 넘어갑니다 다시 선택!");
			xPrint();
		}
		return x;
	}
	
	public int yPrint() {
		System.out.println("y좌표");
		y=scanner.nextInt()-1;
		if(y>=pan.length) {
			System.out.println("판의 수를 넘어갑니다 다시 선택!");
			yPrint();
		}
		return y;
	}
	
	public void gamePrint() {
		int temp=1;
		
		while (true) {
		
			if ((temp % 2) == 1) {//백
				System.out.println("백돌 턴");
			} else {//흑
				System.out.println("흑돌 턴");
			}
			
			xPrint();
			yPrint();

			
			if (pan[x][y] > 0) {
				System.out.println("이미 존재 다시 선택!");
				continue;
			}
		
			if ((temp % 2) == 1) {//백
				
				pan[x][y] = 1;
			} else {//흑
				pan[x][y] = 2;
			}

			list();

			garo();
			if (winCondition(temp) == 0) return;
			sero();
			if (winCondition(temp) == 0) return;
			rightDae();
			if (winCondition(temp) == 0) return;
			leftDae();
			if (winCondition(temp) == 0) return;
			
			temp++;
		}
	
	}
	
	public void list() {
		for (int[]i : pan) {
			for(int j:i) {
				System.out.printf("%2d", j);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public int winCondition(int temp) { //승리 조건 확인
		if(win>=4) {
			System.out.println("게임 종료");
			if ((temp % 2) == 1) {
				System.out.println("백돌 승리!");
			}else {
				System.out.println("흑돌 승리!");
			}
			return 0;	
		}
		return 1;
	}
	
	public void garo() {//가로줄 확인 
		win=0;
		
		for (int i = 1; i < pan.length-y; i++) { //오른쪽 확인 
			if (pan[x][y] == pan[x][y + i]) win++;
			else break;
		}
		
		for (int i = 1; i<=y; i++) { //왼쪽 확인 
			if (pan[x][y] == pan[x][y-i]) 
				win++;
			else break;
		}
		
	}

	
	public void sero() {//세로줄 확인 
		win=0;
		
		for (int i = 1; i < pan.length - x; i++) { // 아래
			if (pan[x][y] == pan[x + i][y])
				win += 1;
			else break;
		}

		for (int i = 1; i <= x; i++) { // 위
			if (pan[x][y] == pan[x - i][y])
				win += 1;
			else break;
		}
	}
	
	
	public void rightDae() {//대각선 오른쪽 위 
		win=0;
		
		for (int i = 1; i <= x && i < pan.length - y; i++) { // 위
			if (pan[x][y] == pan[x - i][y + i])
				win += 1;
			else break;
		}
		
		for (int i = 1; i <pan.length-x && i <= y; i++) { //아래 
			if (pan[x][y] == pan[x+i][y-i])
				win += 1;
			else break;
			
		}
	}
	
	public void leftDae() {//대각선 왼쪽 위 
		win = 0;
		for (int i = 1; i <= x && i <= y; i++) { // 위
			if (pan[x][y] == pan[x - i][y - i]) {
				win += 1;
			} else break;
		}

		for (int i = 1; i < pan.length - x && i < pan.length - y; i++) { // 아래
			if (pan[x][y] == pan[x + i][y + i]) {
				win += 1;
			} else break;
		}
	}
	
	
	public static void main(String[] args) {
		OmokEx o =new OmokEx();
		o.gamePrint();
	}
}
