package figures;

import java.util.HashSet;

public aspect PointCaching {
	
	private HashSet<Point> Figure.cache = new HashSet<Point>();
	
	// THIS LOOKUP IS TERRIBLY EXPENSIVE!!!
	// EXERCISE: DO A BETTER CACHE.
	private Point Figure.lookup(int x, int y) {
		for (Point p : cache) {
			if (p.getX() == x && p.getY() == y)
				return p;
		}
		return null;
	}
		
	Point around(Figure f, int x, int y) :
		target(f)
		&& call (Point Figure.makePoint(int, int)) 
		&& args(x, y) {
	    Point ret = f.lookup(x, y);
	    if (ret == null) {
	        ret = proceed(f, x, y);
	        f.cache.add(ret);
	    }
	    return ret;
	}
}
