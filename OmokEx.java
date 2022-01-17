package game.omok;

import java.util.Scanner;

public class OmokEx {

	private int[][]pan =new int [10][10];
	private int win;
	Scanner scanner =new Scanner(System.in);
	private int x,y;
	
	public int xPrint() {
		
		System.out.println("x��ǥ");
		x=scanner.nextInt()-1;
		if(x>=pan.length) {
			System.out.println("���� ���� �Ѿ�ϴ� �ٽ� ����!");
			xPrint();
		}
		return x;
	}
	
	public int yPrint() {
		System.out.println("y��ǥ");
		y=scanner.nextInt()-1;
		if(y>=pan.length) {
			System.out.println("���� ���� �Ѿ�ϴ� �ٽ� ����!");
			yPrint();
		}
		return y;
	}
	
	public void gamePrint() {
		int temp=1;
		
		while (true) {
		
			if ((temp % 2) == 1) {//��
				System.out.println("�鵹 ��");
			} else {//��
				System.out.println("�浹 ��");
			}
			
			xPrint();
			yPrint();

			
			if (pan[x][y] > 0) {
				System.out.println("�̹� ���� �ٽ� ����!");
				continue;
			}
		
			if ((temp % 2) == 1) {//��
				
				pan[x][y] = 1;
			} else {//��
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
	
	
	public int winCondition(int temp) { //�¸� ���� Ȯ��
		if(win>=4) {
			System.out.println("���� ����");
			if ((temp % 2) == 1) {
				System.out.println("�鵹 �¸�!");
			}else {
				System.out.println("�浹 �¸�!");
			}
			return 0;	
		}
		return 1;
	}
	
	public void garo() {//������ Ȯ�� 
		win=0;
		
		for (int i = 1; i < pan.length-y; i++) { //������ Ȯ�� 
			if (pan[x][y] == pan[x][y + i]) win++;
			else break;
		}
		
		for (int i = 1; i<=y; i++) { //���� Ȯ�� 
			if (pan[x][y] == pan[x][y-i]) 
				win++;
			else break;
		}
		
	}

	
	public void sero() {//������ Ȯ�� 
		win=0;
		
		for (int i = 1; i < pan.length - x; i++) { // �Ʒ�
			if (pan[x][y] == pan[x + i][y])
				win += 1;
			else break;
		}

		for (int i = 1; i <= x; i++) { // ��
			if (pan[x][y] == pan[x - i][y])
				win += 1;
			else break;
		}
	}
	
	
	public void rightDae() {//�밢�� ������ �� 
		win=0;
		
		for (int i = 1; i <= x && i < pan.length - y; i++) { // ��
			if (pan[x][y] == pan[x - i][y + i])
				win += 1;
			else break;
		}
		
		for (int i = 1; i <pan.length-x && i <= y; i++) { //�Ʒ� 
			if (pan[x][y] == pan[x+i][y-i])
				win += 1;
			else break;
			
		}
	}
	
	public void leftDae() {//�밢�� ���� �� 
		win = 0;
		for (int i = 1; i <= x && i <= y; i++) { // ��
			if (pan[x][y] == pan[x - i][y - i]) {
				win += 1;
			} else break;
		}

		for (int i = 1; i < pan.length - x && i < pan.length - y; i++) { // �Ʒ�
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
