package demos.redis.hopp;

public class RedisServerStub implements RedisServer {
    public void GET_request(String k) {
    	sendMethodLabel(RedisServerMethods.GET_request);
    	sendStringArg(k);
    }
    
    public void SET(String k, String v) {
    	sendMethodLabel(RedisServerMethods.SET);
    	sendStringArg(k);
    	sendStringArg(v);
    }

	public void WATCH(String[] keys) {
    }

    public void MULTI () {
    	sendMethodLabel(RedisServerMethods.MULTI);
    }

    public void DISCARD () {
    	sendMethodLabel(RedisServerMethods.DISCARD);
    }
    
    public void EXEC_request () {
    	sendMethodLabel(RedisServerMethods.EXEC_request);
    } 

	void sendMethodLabel(RedisServerMethods method) {
	}
	
	void sendStringArg(String arg) {
	}
	
	void sendStringArrayArg(String arg) {
	}

}
