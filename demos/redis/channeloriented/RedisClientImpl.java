package demos.redis.channeloriented;

public class RedisClientImpl {
	public static void main (String[] args) {
		RedisClientRole redis = new RedisClientRole();
		redis.sendWATCH(new String[] {}); // TODO
		WATCHING: do {
			switch (redis.sendLabel_Watching(0)) { // TODO
				case GET:
					redis.sendArg_GET(""); // TODO
					String v = redis.receiveGET_response();
					continue WATCHING;
				case WATCH:
					redis.sendArg_WATCH(new String[] {}); // TODO
					continue WATCHING;
				case MULTI:
					QUEUED: do {
						switch (redis.sendLabel_Queued(0)) { // TODO
							case SET:
								redis.sendArg0_SET(""); // TODO
								redis.sendArg1_SET(""); // TODO
								continue QUEUED;
							case DISCARD:
								break WATCHING;
							case EXEC:
								switch (redis.receiveEXEC_response()) {
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
