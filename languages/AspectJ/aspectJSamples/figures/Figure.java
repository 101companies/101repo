package figures;
import java.util.*;

public class Figure {
	public Point makePoint(int x, int y) {
		Point p = new Point();
		p.setX(x);
		p.setY(y);
		return p;
	}
	public Line makeLine(Point p1, Point p2) {
		Line l = new Line();
		l.setP1(p1);
		l.setP2(p2);
		return l;
	}
}
