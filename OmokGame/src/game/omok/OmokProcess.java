package game.omok;

public class OmokProcess {

	private int[][] pan = new int[19][19];
	private int win;
	int x, y;

	public int gamePrint(int row, int col, int temp) {
		x = row;
		y = col;

		if ((temp % 2) == 1) {// 백

			pan[x][y] = 1;
		} else {// 흑
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

	public int winCondition(int temp) { // 승리 조건 확인
		if (win >= 4) {
			if ((temp % 2) == 1) { // 백 승리
				return 1;
			} else {// 흑 승리
				return 2;
			}
		}
		return 0;
	}

	public void garo() {// 가로줄 확인
		win = 0;

		for (int i = 1; i < pan.length - y; i++) { // 오른쪽 확인
			if (pan[x][y] == pan[x][y + i])
				win++;
			else
				break;
		}

		for (int i = 1; i <= y; i++) { // 왼쪽 확인
			if (pan[x][y] == pan[x][y - i])
				win++;
			else
				break;
		}
	}

	public void sero() {// 세로줄 확인
		win = 0;

		for (int i = 1; i < pan.length - x; i++) { // 아래
			if (pan[x][y] == pan[x + i][y])
				win += 1;
			else
				break;
		}

		for (int i = 1; i <= x; i++) { // 위
			if (pan[x][y] == pan[x - i][y])
				win += 1;
			else
				break;
		}
	}

	public void rightDae() {// 오른쪽 위
		win = 0;

		for (int i = 1; i <= x && i < pan.length - y; i++) { // 위
			if (pan[x][y] == pan[x - i][y + i])
				win += 1;
			else
				break;
		}

		for (int i = 1; i < pan.length - x && i <= y; i++) { // 아래
			if (pan[x][y] == pan[x + i][y - i])
				win += 1;
			else
				break;

		}
	}

	public void leftDae() {// 왼쪽 위
		win = 0;
		for (int i = 1; i <= x && i <= y; i++) { // 위
			if (pan[x][y] == pan[x - i][y - i]) {
				win += 1;
			} else
				break;
		}

		for (int i = 1; i < pan.length - x && i < pan.length - y; i++) { // 아래
			if (pan[x][y] == pan[x + i][y + i]) {
				win += 1;
			} else
				break;
		}
	}

}
