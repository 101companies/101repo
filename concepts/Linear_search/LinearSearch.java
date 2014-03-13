public class LinearSearch {
    public static <T> boolean search(Iterable<T> l, T x) {
	for (T y : l)
	    if (x==y)
		return true;
	return false;
    }
}
