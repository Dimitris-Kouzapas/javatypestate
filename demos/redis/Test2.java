package demos.redis;

public class Test2 {
	public static void main (String[] args) {
		new Test2().run();
	}
	
	void run () {
	   	Redis redis = new Redis();
	   	redis.WATCH(new String[]{ "name" });
	   	redis.WATCH(new String[]{ "address" });
	   	doTransaction(redis);
		redis.MULTI();
	}
	
    // These methods seem to have a useful type inferred. We don't allow
    // inheritance, which simplifies things.
	void doTransaction (Redis redis) {
	   	switch (redis.EXEC()) {
	   	case OK:
	      	break;
	   	case FAIL:
  			discardTransaction(redis);
			break;
	   	}
	}

    void discardTransaction (Redis redis) {
    	redis.DISCARD();
    }
}
