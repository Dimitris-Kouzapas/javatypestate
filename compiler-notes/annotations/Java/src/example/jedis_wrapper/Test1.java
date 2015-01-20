package example.jedis_wrapper;

public class Test1 {
	public static void main (String[] args) {
	   JedisWrapper jedis = new JedisWrapper();
	   jedis.WATCH(new String[]{ "name", "address" });
	   jedis.MULTI();
	   jedis.SET("name", "Alan");
	   jedis.SET("address", "Milton Keynes");
	   jedis.LPOP("fred");
	   switch (jedis.EXEC()) {
	   case OK:
	      break;
	   case FAIL:
	      jedis.DISCARD();
	      break;
	   }
	}
}
