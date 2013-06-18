package figures;

public aspect DisplayUpdating {

  private Display Figure.display;
  
  private Figure FigureElement.figure;

  public void Figure.setDisplay(Display display) {
	  this.display = display;
  }

  public void Display.update(FigureElement fe) {
		// potentially delete all element
		fe.draw();
  }
  
  
  pointcut move(FigureElement fe):
	  target(fe) &&
	  (call(void Point.setX(int)) || 
	   call(void Point.setY(int)) ||
       call(void Line.setP1(Point)) || 
       call(void Line.setP2(Point)) ||
       call (void FigureElement.moveBy(..)));

  pointcut topLevelMove(FigureElement fe):
	  move(fe) && !cflowbelow(move(FigureElement));
  
  after(FigureElement fe) returning: topLevelMove(fe) {
	  System.out.println(thisJoinPoint);
	  fe.figure.display.update(fe);
  }
 
  Object around(Figure f) :
	     call (FigureElement+.new())
	  && this(f){
	  	FigureElement cache = (FigureElement)proceed(f);
	  	cache.figure = f;
	  	return cache;
  }  
}
