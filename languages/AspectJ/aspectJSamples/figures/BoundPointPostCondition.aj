package figures;

/**
 * We remove this part from the buildpath.
 * Otherwise our condition enforcement cannot be illustrated.
 * That is, the post-condition does not hold in the view of repair.
 */
public aspect BoundPointPostCondition {

	after(Point p, int newX) returning:
		call(void Point.setX(int)) && target(p) && args(newX) {
	    	assert p.getX() == newX;
	}

	after(Point p, int newY) returning:
		call(void Point.setY(int)) && target(p) && args(newY) {
			assert p.getY() == newY;
	}
}
