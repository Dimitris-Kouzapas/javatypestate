package demos.client_server_HOPP;

// Service requests take their arguments as arguments, rather than returning them as 
// return values. One implements the service by implementing the method; that 
// implementation makes use of the services of other participants via their public
// APIs. 

interface ServerProtocol {
	// Cf. the current signature: 
	// int receiveRequest(): State0
	void request(int): end
}
