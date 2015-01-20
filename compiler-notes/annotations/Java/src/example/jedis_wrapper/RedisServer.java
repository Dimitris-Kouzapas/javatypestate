package example.jedis_wrapper;

import java.util.*;
import typestate.*;

/**
 * Example of annotation-based approach to adding typestate to Java.
 *
 * Advantages:
 *   1) Familiar Java syntax
 *   2) No duplicated signatures
 *   3) Backwards-compatible (by default annotations ignored)
 *   4) Reuses Java's existing rules for typestate method signatures, overloading, etc
 *   5) Compatible with IDEs like Eclipse
 *   6) Annotation-processing API can be used to plug type system extension into javac
 *   7) Commonly used for this purpose already
 *
 * Usage (sketch):
 *   1) @TypeState indicates that member interfaces are to be treated as typestates.
 *   2) @Start picks out the unique start state.
 *   3) @Goto specifies a state change. Only required if the method actually changes the state.
 *   4) @End is a synonym for @Goto(End.class).
 *   5) @SwitchOn indicates that a method returns an enum where each field specifies a @Become.
 */
@TypeState interface RedisServer {
	@Start interface Init {
       @Goto(Watching.class) void WATCH(String[] keys);
	}

	interface Watching {
		String GET(String key);
		List<String> LRANGE(String key, long start, long end);
		void WATCH(String[] keys);
		@Goto(Queued.class) void MULTI();
	}

	interface Queued {
		void SET(String key, String value);
		String LPOP (String key);
		@End void DISCARD();

		enum Result {
			@End OK,
			@Goto(Queued.class) FAIL
		}
		@SwitchOn Result EXEC();
	}
}
