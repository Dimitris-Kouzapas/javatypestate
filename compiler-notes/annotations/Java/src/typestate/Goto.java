package typestate;
import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.FIELD })
public @interface Goto {
	Class<? extends Object> value ();
}
