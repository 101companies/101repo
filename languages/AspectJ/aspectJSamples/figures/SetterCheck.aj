package figures;

public aspect SetterCheck {
	declare error: 
		(set(int Point.*) &&
		!withincode(void Point.set*(int)) &&
		!withincode(Point.new()) &&
		!initialization(Point.new()) && 
		!preinitialization(Point.new()) && 
		!staticinitialization(Point)) 
		||
		(set(Point Line.*) &&
		!withincode(void Line.set*(Point))&&
		!withincode(Line.new()) &&
		!initialization(Line.new()) && 
		!preinitialization(Line.new()) && 
		!staticinitialization(Line)) :
		
	"Use setter method by all means.";
}
