package demos.redis.hopp;

class RedisServerSkel {
	public void mainLoop () {
		RedisServerImpl redis = new RedisServerImpl();
		while (true)
			switch (receiveMethodLabel()) {
				case GET_request:
					redis.GET_request(receiveStringArg());
					break;
				case SET:
					redis.SET(receiveStringArg(),receiveStringArg());
					break;
				case WATCH:
					redis.WATCH(receiveStringArrayArg());
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
