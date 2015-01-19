package demos.redis.async;

// Each method that isn't statically associated with a unique state change 
// must specify its state change via a value of an enumerated type.

public class RedisClientImpl {
	private RedisServerImpl server = new RedisServerImpl();  
	
	Init_Exit init () {
		server.WATCH(new String[] {"name", "address"});
		server.WATCH(new String[] {"DOB"});
		server.GET_request("name");
		return Init_Exit.GET;
	}

	Init_Exit GET_response(String v) {
		server.MULTI();
		server.SET("DOB", "05/12/70");
		server.EXEC_request();
		return Init_Exit.EXEC;
	}
	 
	void EXEC_response_OK() {
		server = null;
	}
	
	EXEC_responseExit EXEC_response_FAIL() {
		server.DISCARD();
		server = null;
		return EXEC_responseExit.OTHERWISE;
	}	
}
