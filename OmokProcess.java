package game.omok;

public class OmokProcess {

	private int[][] pan = new int[19][19];
	private int win;
	int x, y;

	public int gamePrint(int row, int col, int temp) {
		x = row;
		y = col;

		if ((temp % 2) == 1) {// ��

			pan[x][y] = 1;
		} else {// ��
			pan[x][y] = 2;
		}

		garo();
		if (winCondition(temp) > 0)
			return winCondition(temp);
		sero();
		if (winCondition(temp) > 0)
			return winCondition(temp);
		rightDae();
		if (winCondition(temp) > 0)
			return winCondition(temp);
		leftDae();
		if (winCondition(temp) > 0)
			return winCondition(temp);

		temp++;

		return 0;

	}

	public int winCondition(int temp) { // �¸� ���� Ȯ��
		if (win >= 4) {
			if ((temp % 2) == 1) { // �� �¸�
				return 1;
			} else {// �� �¸�
				return 2;
			}
		}
		return 0;
	}

	public void garo() {// ������ Ȯ��
		win = 0;

		for (int i = 1; i < pan.length - y; i++) { // ������ Ȯ��
			if (pan[x][y] == pan[x][y + i])
				win++;
			else
				break;
		}

		for (int i = 1; i <= y; i++) { // ���� Ȯ��
			if (pan[x][y] == pan[x][y - i])
				win++;
			else
				break;
		}
	}

	public void sero() {// ������ Ȯ��
		win = 0;

		for (int i = 1; i < pan.length - x; i++) { // �Ʒ�
			if (pan[x][y] == pan[x + i][y])
				win += 1;
			else
				break;
		}

		for (int i = 1; i <= x; i++) { // ��
			if (pan[x][y] == pan[x - i][y])
				win += 1;
			else
				break;
		}
	}

	public void rightDae() {// ������ ��
		win = 0;

		for (int i = 1; i <= x && i < pan.length - y; i++) { // ��
			if (pan[x][y] == pan[x - i][y + i])
				win += 1;
			else
				break;
		}

		for (int i = 1; i < pan.length - x && i <= y; i++) { // �Ʒ�
			if (pan[x][y] == pan[x + i][y - i])
				win += 1;
			else
				break;

		}
	}

	public void leftDae() {// ���� ��
		win = 0;
		for (int i = 1; i <= x && i <= y; i++) { // ��
			if (pan[x][y] == pan[x - i][y - i]) {
				win += 1;
			} else
				break;
		}

		for (int i = 1; i < pan.length - x && i < pan.length - y; i++) { // �Ʒ�
			if (pan[x][y] == pan[x + i][y + i]) {
				win += 1;
			} else
				break;
		}
	}

}
