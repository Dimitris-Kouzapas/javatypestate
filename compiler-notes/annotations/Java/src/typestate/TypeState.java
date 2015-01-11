package typestate;

import java.lang.annotation.*;

/**
 * Indicates that my member interfaces are to be considered typestates of any class which implements me.
 */
@Target({ ElementType.TYPE })
public @interface TypeState {
}
