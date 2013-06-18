package figures;

public class Line implements FigureElement {
	private Point p1, p2;

	public Point getP1() {
		return p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public void moveBy(int dx, int dy) {
		p1.moveBy(dx, dy);
		p2.moveBy(dx, dy);
	}

	public void draw() {
		System.out.println("Line: from ("
				+ (p1 != null ? p1.getX() + "," + p1.getY() : "?,?") + ") to ("
				+ (p2 != null ? p2.getX() + "," + p2.getY() : "?,?") + ")");
	}
}
