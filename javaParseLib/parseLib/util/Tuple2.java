package parseLib.util;

/** Product type -- in fact, the type of pairs. **/

public class Tuple2<T1,T2> {

	public T1 proj1;
	public T2 proj2;
	
	public Tuple2(T1 proj1, T2 proj2) {
		this.proj1 = proj1;
		this.proj2 = proj2;
	}

}
