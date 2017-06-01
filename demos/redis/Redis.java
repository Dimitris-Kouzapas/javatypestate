package demos.redis;

import mungo.lib.Typestate;

@Typestate("RedisServer")
public class Redis{
    void WATCH(String[] keys) {
    }

    String GET(String keys) {
       throw new RuntimeException();
    }

	String LPOP(String key) {
       throw new RuntimeException();
	}
	
	void MULTI () {
	}

    void SET(String key, String value) {
    }

    void DISCARD () {
    }
    
    Result EXEC () {
       return null;
    } 
}
