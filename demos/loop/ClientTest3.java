package demos.loop;

class ClientTest3 {
	void test2() {
		test(new LoopImpl());
	}

  	void test (LoopImpl loop) {
		switch(loop.finished().getEnum()) {
			case Bool.FALSE:
				test(loop);
			case Bool.TRUE:
				break;
		}
  	}
}
