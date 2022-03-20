public class RandomNumbers {

	public static String outcome;

	public static void main(String[] args) {

		System.out.println(diceGame(outcome));
		coinFlipper(50);
		coinGame();
	}

	public static String diceGame(String result) {

		int x = (int) (Math.random() * 6) + 1;
		int y = (int) (Math.random() * 6) + 1;

		System.out.println(x + y);

		if ((x + y) < 7) {
			result = ":( You Lose!";
		}

		if ((x + y) == 7) {
			result = "You win a special prize!";
		}
		if ((x + y) > 7) {
			result = ":) You Win!";
		}
		outcome = result;
		return result;
	}

	public static void coinFlipper(int num) {

		int h = 0;
		int t = 0;

		for (int i = 0; i < num; i++) {

			int res = (int) (Math.random() + 0.5);
			if (res == 1) {
				h++;
			}
			if (res == 0) {
				t++;
			}
		}
		System.out.println("Heads: " + h);
		System.out.println("Tails: " + t);
	}

	public static void coinGame() {

		int h1 = 0;
		int h2 = 0;
		while (h1 != 3 && h2 != 3) {
			int res = (int) (Math.random() + 0.5);
			int out = (int) (Math.random() + 0.5);
			if (res == 1) {
				h1++;
				System.out.print("Coin 1: Heads ");
			} else {
				h1 = 0;
				System.out.print("Coin 1: Tails ");
			}
			if (out == 1) {
				h2++;
				System.out.print("Coin 2: Heads");
			} else {
				h2 = 0;
				System.out.print("Coin 2: Tails");
			}
			System.out.println();

		}
			if (h1 < h2) {
				System.out.println("Coin 2 Wins!");
			}
			else if (h1 > h2) {
				System.out.println("Coin 1 Wins!");
			}
			else {
				System.out.println("Tie!");
			}

	}
}
