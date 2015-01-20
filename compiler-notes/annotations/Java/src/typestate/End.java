package typestate;

import java.lang.annotation.*;

// A state with no operations. @End can be used as a shorthand for @Become(End.class).
@Target({ ElementType.METHOD, ElementType.FIELD })
public @interface End {
}
