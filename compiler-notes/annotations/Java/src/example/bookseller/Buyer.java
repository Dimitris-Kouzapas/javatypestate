package example.bookseller;

import typestate.*;

class Product {
}

class Price {
}

class Payment {
}

public interface Buyer {
	interface Init {
		@Goto(Shop.class) void init (Channel u);
	}

	interface Shop {
	    @Goto(Shop.class) Price price (Product p);

	    enum Result {
	    	@Goto(Pay.class) OK,
	    	@Goto(Shop.class) ERROR
	    }
	    @SwitchOn Result buy (Product p);

	    @Goto(End.class) void stop ();
	}

	interface Pay {
	    @Goto(Shop.class) void pay (Payment p);
	}
}

class BuyerImpl implements Buyer.Init, Buyer.Shop, Buyer.Pay {
	@Override
	public void init (Channel u) {
	}

	@Override
	public void pay(Payment p) {
	}

	@Override
	public Price price (Product p) {
		throw new NotYetImplementedException();
	}

	@Override
	public Result buy (Product p) {
		throw new NotYetImplementedException();
	}

	@Override
	public void stop() {
	}
}

// Channel would also be modelled as a class with its own typestate.
class Channel {
}
