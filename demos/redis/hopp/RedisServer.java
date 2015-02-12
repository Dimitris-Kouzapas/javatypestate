package demos.redis.hopp;

public interface RedisServer {
	void WATCH(String[] keys) {
    }

    void GET_request(String k) {
    	sendMethodLabel(RedisServerMethods.GET_request);
    	sendStringArg(k);
    }
    
    void SET(String k, String v) {
    	sendMethodLabel(RedisServerMethods.SET);
    	sendStringArg(k);
    	sendStringArg(v);
    }

    void MULTI () {
    	sendMethodLabel(RedisServerMethods.MULTI);
    }

    void DISCARD () {
    	sendMethodLabel(RedisServerMethods.DISCARD);
    }
    
    void EXEC_request () {
    	sendMethodLabel(RedisServerMethods.EXEC_request);
    } 
}
