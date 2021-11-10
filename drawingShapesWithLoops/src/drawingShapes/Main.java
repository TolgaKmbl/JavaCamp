package drawingShapes;

public class Main {

	public static void main(String[] args) {
		drawFilledRectangle(10, 5);
		drawVoidRectangle(10, 5);
		drawTriangle(8);
		drawLeftTriangle(9);

	}

	static void drawFilledRectangle(int row, int column) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print("*"); // Prints side by side
				if (j == column - 1) {
					System.out.println();
				}
			}
		}
	}

	static void drawVoidRectangle(int row, int column) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (i == 0 || i == row - 1) {
					System.out.print("*");
				} else {
					if (j == 0 || j == column - 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

	static void drawTriangle(int row) {
		for (int i = 0, star = 0; i < row; i++, star += 2) {
			for (int space = row; space > i; space--)
				System.out.print(" ");
			for (int j = 0; j <= star; j++)
				System.out.print("*");
			System.out.println();
		}
	}

	static void drawLeftTriangle(int row) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
	}

}
