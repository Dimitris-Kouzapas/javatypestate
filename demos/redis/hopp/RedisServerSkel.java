package demos.redis.hopp;

class RedisServerSkel {
	public void mainLoop () {
		RedisServerImpl redis = new RedisServerImpl();
		while (true)
			switch (receiveMethodLabel()) {
				case GET_request:
					String k = receiveStringArg();
					redis.GET_request(k);
					break;
				case SET:
					String k2 = receiveStringArg();
					String v = receiveStringArg();
					redis.SET(k2,v);
					break;
				case WATCH:
					String[] ks2 = receiveStringArrayArg();
					redis.WATCH(ks2);
					break;
				case MULTI:
					redis.MULTI();
					break;
				case DISCARD:
					redis.DISCARD();
					break;
				case EXEC_request:
					redis.EXEC_request();
					break;
			}
	}

    RedisServerMethods receiveMethodLabel() {
    	return null;
    }

	String receiveStringArg() {
		return null;
	}

	String[] receiveStringArrayArg() {
		return null;
	}
}
