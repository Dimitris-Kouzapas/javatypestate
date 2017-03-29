package demos.loop;

class ClientTest4 {
  	void test () {
  		LoopImpl loop = new LoopImpl();
  		out: do {
  			switch (loop.finished().getEnum()) {
  			case Bool.FALSE:
  				continue out;
  			case Bool.TRUE:
  				break out;
  			}
  		} while(false);
  	}
}
