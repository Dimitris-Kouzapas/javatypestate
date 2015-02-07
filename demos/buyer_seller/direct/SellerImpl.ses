package demos.buyer_seller.direct;

class SellerImpl typestate Seller {
	Exit_price_request price_request(String title) {
		boolean inStock = true;
		if (inStock)
			// buyer1.price_response(15); 
			return new Exit_price_request(Exit_price_request.PRICE_RESPONSE);
		else
			// buyer1.outOfStock();
			// buyer2.outOfStock();
			return new Exit_price_request(Exit_price_request.OUT_OF_STOCK);
	}
	
	void agree() {
	}
	
	void quit() {
	}
}
