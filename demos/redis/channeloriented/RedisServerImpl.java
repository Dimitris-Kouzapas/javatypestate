package demos.redis.channeloriented;

// I have to write highly non-idiomatic code to implement the server interface.
// So this encoding isn't really a "solution" to the limitations of typestate.
	
public class RedisServerImpl {
	public static void main (String[] args) {
		RedisServerRole redis = new RedisServerRole();
		String[] ks = redis.receiveWATCH();
		WATCHING: do {
			switch (redis.receiveLabel_Watching()) {
				case GET:
					String k = redis.receiveArg_GET();
					redis.sendGET_response(""); // TODO
					continue WATCHING;
				case WATCH:
					String[] ks2 = redis.receiveArg_WATCH();
					continue WATCHING;
				case MULTI:
					QUEUED: do {
						switch (redis.receiveLabel_Queued()) {
							case SET:
								String k2 = redis.receiveArg0_SET();
								String v = redis.receiveArg1_SET();
								continue QUEUED;
							case DISCARD:
								break WATCHING;
							case EXEC:
								switch (redis.sendEXEC_response(0)) { // TODO
									case OK:
										break WATCHING;
									case FAIL:
										continue QUEUED;
								}
						}
					} while (false);
			}
		} while (false);
	}
}
