package demos.redis.channeloriented;

import mungo.lib.Typestate;

@Typestate("RedisClientProtocol")
public class RedisClientRole{
    void sendWATCH(String[] ks) {
	}
	
	WatchingLabel sendLabel_Watching(int l) {
		return null;
	}
	
	void sendArg_GET(String k) {
	}
	
	String receiveGET_response() {
		return null;
	}
	
	void sendArg_WATCH(String[] ks) {
	}
	
	QueuedLabel sendLabel_Queued(int l) {
		return null;
	}
	
	void sendArg0_SET(String k) {
	}
	
	void sendArg1_SET(String v) {
	}

	ResultLabel receiveEXEC_response() {
		return null;
	}
}
