package typestate;
import java.lang.annotation.*;

/**
 * Use to constrain the type of a variable to a particular state. 
 * ElementType.TYPE_USE is new in Java 1.8.
 */
@Target({ ElementType.TYPE_USE })
public @interface State {
	Class<? extends Object> value ();
}
