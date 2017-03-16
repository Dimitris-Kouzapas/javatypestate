package demos.iterator;

import mungo.lib.Typestate;
import mungo.lib.Boolean;
import java.util.Iterator;

@Typestate(value="StateIteratorProtocol")
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
