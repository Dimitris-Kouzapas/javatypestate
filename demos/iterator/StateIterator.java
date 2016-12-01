package demos.iterator;

import java.util.Iterator;

@Typestate("StateIteratorProtocol")
class StateIterator {
	Iterator iter;
	public StateIterator(Iterator i) {
		iter = i;
	}

	public Object next() {
		return iter.next();
	}

	public Boolean hasNext() {
		if(iter.hasNext())
			return Boolean.True;
		return Boolean.False;
	}

	public void remove() {
		iter.remove();
	}
}
