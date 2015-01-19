package demos.redis.async;

public class RedisServerImpl /*typestate RedisServer*/ {
	private RedisClientImpl client = new RedisClientImpl();
	
	RedisServerImpl () {
		client.init();
	}

	void WATCH(String[] keys) {
    	System.out.println("Initiating WATCH on keys " + keys);
    }

    void GET_request(String key) {
    	client.GET_response("hello"); // lookup in DB
    }
    
    void MULTI () {
		// initiate transaction
    }

    void SET(String key, String value) {
    	// perform set
    }

    void DISCARD () {
    	client = null;
    }
    
    EXEC_requestExit EXEC_request () {
    	// do the commit, and suppose we succeed:
    	client.EXEC_response_OK();
    	return EXEC_requestExit.OK;
    } 
}
