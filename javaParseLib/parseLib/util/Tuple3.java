package parseLib.util;

/** Product type -- in fact, the type of triples. **/

public class Tuple3<T1,T2,T3> {

	public T1 proj1;
	public T2 proj2;
	public T3 proj3;
	
	public Tuple3(T1 proj1, T2 proj2, T3 proj3) {
		this.proj1 = proj1;
		this.proj2 = proj2;
		this.proj3 = proj3;
	}
}
