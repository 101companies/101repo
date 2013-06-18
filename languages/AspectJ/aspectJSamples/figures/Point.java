package figures;

public class Point implements FigureElement {
	private Integer x, y;

	public Point() {
		x = 0;
		y = 0;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void moveBy(int dx, int dy) {
		setX(getX() + dx);
		setY(getY() + dy);
	}

	public void draw() {
		if (x != null & y != null)
			System.out.println("Point: (" + x + "," + y + ")");
	}
}
