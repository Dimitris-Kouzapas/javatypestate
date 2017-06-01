package demos.redis;

public class Test1 {
	public static void main (String[] args) {
	   Redis redis = new Redis();
	   redis.WATCH(new String[]{ "name", "address" });
	   redis.MULTI();
	   redis.SET("name", "Alan");
	   // Nested MULTI is not allowed
	   redis.MULTI();   
	   redis.SET("address", "Milton Keynes");
	   // Adding watches after MULTI is not allowed
       // redis.WATCH(new String[]{ "address" });
	   switch (redis.EXEC()) {
	   case OK:
	      // Can't exec again:
	      // redis.EXEC();
	      break;
	   case FAIL:
	      // On fail I can do extra stuff (presumably pointlessly):
     	  redis.SET("name", "Turing");
	      redis.DISCARD();
	      break;
	   }
	}
}
