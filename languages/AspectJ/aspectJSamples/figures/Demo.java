package figures;

public class Demo {

	public static void main(String[] args) {
		Figure f = new Figure();
		f.setDisplay(new Display());
		
		System.out.println("-> Construct line ...");
		Line l = f.makeLine(f.makePoint(5, 5), f.makePoint(10, 10));

		System.out.println("-> Move line ...");
		l.moveBy(1, 2);

		System.out.println("-> Set point ...");
		l.setP1(f.makePoint(3,99));
	}

}
