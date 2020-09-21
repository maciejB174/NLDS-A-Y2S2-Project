import java.util.Scanner;
public class RobotMoving {

	public static void main(String[] args) {
		double[] cost1 = new double[3];
		cost1[0] = 1.1;
		cost1[1] = 1.3;
		cost1[2] = 2.5;
		double[] cost2 = new double[3];
		cost2[0] = 1.5;
		cost2[1] = 1.2;
		cost2[2] = 2.3;
		findShortestPath(cost1,cost2);
	}
	
	public static void findShortestPath(double[] cost1, double[] cost2) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the x and y coordinates of the point you want to reach:");
		System.out.println("x >>>");
		int x = sc.nextInt();
		sc.nextLine();
		System.out.println("y >>>");
		int y = sc.nextInt();
		sc.nextLine();
		while (x < 0 || y < 0) {
			System.out.println("The coordinates you entered do not exist, please try again");
			System.out.println("x >>>");
			x = sc.nextInt();
			sc.nextLine();
			System.out.println("y >>>");
			y = sc.nextInt();
			sc.nextLine();
		}
		System.out.println("Starting at [0,0]");
		double totalCost = 0;
		int currentX = 0;
		int currentY = 0;
		//cost 1
		int index = 0;
		if (cost1[0] + cost1[1] > cost1[2]) {
			index = 2;
		}
		else if (cost1[0] > cost1[1]) {
			index = 1;
		}
		while (currentX != x || currentY != y) {
			if (currentX == x && currentY != y) {
				index = 1;
			}
			else if (currentX != x && currentY == y) {
				index = 0;
			}
			if (index == 0) {
				currentX ++;
				System.out.println("Right ---> [" + currentX + "," + currentY + "]");
				totalCost += cost1[index];
				continue;
			}
			if (index == 1) {
				currentY ++;
				System.out.println("Down ---> [" + currentX + "," + currentY + "]");
				totalCost += cost1[index];
				continue;
			}
			else {
				currentY ++;
				currentX ++;
				System.out.println("Diagonal ---> [" + currentX + "," + currentY + "]");
				totalCost += cost1[index];
			}
			
		}
		String finalCost = String.format("%.2f", totalCost);
		System.out.println("The shortest way to reach your destination using cost1 is :" + finalCost);
		//Cost 2
		currentX = 0;
		currentY = 0;
		totalCost = 0;
		index = 0;
		if (cost2[0] + cost2[1] > cost2[2]) {
			index = 2;
		}
		else if (cost2[0] > cost2[1]) {
			index = 1;
		}
		while (currentX != x || currentY != y) {
			if (currentX == x && currentY != y) {
				index = 1;
			}
			else if (currentX != x && currentY == y) {
				index = 0;
			}
			if (index == 0) {
				currentX ++;
				System.out.println("Right ---> [" + currentX + "," + currentY + "]");
				totalCost += cost2[index];
			}
			else if (index == 1) {
				currentY ++;
				System.out.println("Down ---> [" + currentX + "," + currentY + "]");
				totalCost += cost2[index];
			}
			else {
				currentY ++;
				currentX ++;
				System.out.println("Diagonal ---> [" + currentX + "," + currentY + "]");
				totalCost += cost2[index];
			}
			
		}
		finalCost = String.format("%.2f", totalCost);
		System.out.println("The shortest way to reach your destination using cost2 is :" + finalCost);	
	}
}
