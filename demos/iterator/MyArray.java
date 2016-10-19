package demos.iterator;

class MyArray {
	private Object [] array;

	MyArray(int size) {
		array = new Object[size];
	}

	int size() {
		return array.length;
	}

	void add(int i, Object o) {
		array[i] = o;
	}

	Object get(int i) {
		return array[i];
	}

	Object remove(int i) {
		Object o = array[i];
		array[i] = null;
		return o;
	}

	//public StateIterator iterator() {
	//	return new StateIterator(this);
	//}

	public static void main(String[] args) {
		MyArray a = new MyArray(32);
		a.add(1, new String("a"));
		a.add(2, new String("b"));
		a.add(11, new String("c"));
		a.add(9, new String("d"));

		StateIterator i = new StateIterator(a);
		//StateIterator i = a.iterator();

		iterate:
		do {
			switch(i.hasNext()) {
				case True:
					System.out.println(i.next());
					System.out.println("removed " + i.remove());
					continue iterate;
				case False:
					break iterate;
			}
		} while(true);
	}
	
}
