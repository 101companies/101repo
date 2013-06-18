package figures;

public aspect BoundPointPreCondition extends BoundPoint {	
	
	  before(int newX):
	      call(void Point.setX(int)) && args(newX) {
		  	assert newX >= MIN_X;
		    assert newX <= MAX_X;
		  }
	  before(int newY):
	      call(void Point.setY(int)) && args(newY) {
		    assert newY >= MIN_Y;
		    assert newY <= MAX_Y;
		  }
}
