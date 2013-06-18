package figures;

public aspect FactoryCheck {
	declare error:
			(call(FigureElement+.new(..)))
			&& !withincode(* Figure.make*(..)) :

		"Use of factory methods required.";
}
