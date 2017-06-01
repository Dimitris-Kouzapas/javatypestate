package demos.redis.channeloriented;

import mungo.lib.Typestate;

@Typestate("RedisServerProtocol")
public class RedisServerRole{
    String[] receiveWATCH() {
    	return null;
    }

	WatchingLabel receiveLabel_Watching() {
		return null;
	}

	String receiveArg_GET () {
		return null;
	}

	void sendGET_response(String v) {
	}
		
	String[] receiveArg_WATCH() {
		return null;
	}
		
	String receiveArg0_SET() {
		return null;
	}		
		
	String receiveArg1_SET() {
		return null;
	}		
		
	QueuedLabel receiveLabel_Queued() {
		return null;
	}
		
	ResultLabel sendEXEC_response(int label) {
		return null;
	}
}
