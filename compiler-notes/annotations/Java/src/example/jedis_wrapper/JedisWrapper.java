package example.jedis_wrapper;

import java.util.*;
import typestate.*;
import redis.clients.jedis.*;

public @TypeState class JedisWrapper implements RedisServer.Init, RedisServer.Watching, RedisServer.Queued {
	private final Jedis jedis = new Jedis();
	private Transaction transaction = null;

    @Override
	public void WATCH(String[] keys) {
    	jedis.watch(keys);
    }

    @Override
	public String GET(String key) {
    	return jedis.get(key);
    }

	@Override
	public List<String> LRANGE(String key, long start, long end) {
		return jedis.lrange(key, start, end);
	}

	@Override
	public void MULTI () {
		transaction = jedis.multi();
	}

    @Override
	public void SET(String key, String value) {
    	jedis.set(key, value);
    }

    @Override
	public String LPOP (String key) {
    	return jedis.lpop(key);
    }

    @Override
	public void DISCARD () {
    	transaction.discard();
    	transaction = null;
    }

    @Override
	public Result EXEC () {
    	// Not sure what counts as failure. Let's just say any exception.
    	try {
    		transaction.exec();
    		return Result.OK;
    	}
    	catch (Exception e) {
    		return Result.FAIL;
    	}
    	finally {
    		transaction = null;
    	}
    }
}
