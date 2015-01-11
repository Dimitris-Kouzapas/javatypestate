package typestate;

import java.lang.annotation.*;

/**
 * Identifies the unique start state of a class with typestate.
 */
@Target({ ElementType.TYPE })
public @interface Start {
}
