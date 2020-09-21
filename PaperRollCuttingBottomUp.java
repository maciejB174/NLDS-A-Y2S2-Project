import java.util.Scanner;
public class PaperRollCuttingBottomUp {

	public static void main(String[] args) {
		double prices[] = new double[6];
		prices[0] = 0.0;
		prices[1] = 1.2;
		prices[2] = 3.0;
		prices[3] = 5.8;
		prices[5] = 10.1;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int length = 0;
		while (length <= 0) {
			System.out.println("Please enter the length of the roll >>>");
			length = sc.nextInt();
			if (length < 0) {
				System.out.println("The value entered is lower than 0");
			}
			else {
				break;
			}
		}
		sc.nextLine();
		calculate(length, prices);
	}

	public static void calculate(int size, double[] prices) {
		double res[] = new double[size + 1];
		res[0] = 0;
		for (int i = 1; i <= size; i ++) {
			double r = 0;
			double currentMax = 0;
			for (int j = 1; j <= i; j ++) {
				if (j > 5) {
					continue;
				}
				r = prices[j] + res[i-j];
				if (r > currentMax) {
					currentMax = r;
				}
			}
			res[i] = currentMax;
			double max = 0;
			for (int p = 1; p <= res.length - 1; p ++) {
				if (res[p] > max) {
					max = res[p];				
				}
			}
		}
		System.out.println(res[size]);		
	}
}
