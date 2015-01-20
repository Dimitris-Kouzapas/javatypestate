package typestate;

import java.lang.annotation.*;

/**
 * Indicates that the method returns an enumeration whose value determines the state to transition to.
 */
@Target({ ElementType.METHOD, ElementType.FIELD })
public @interface SwitchOn {
}
