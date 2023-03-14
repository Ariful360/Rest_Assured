package endpoints;

import utils.RestSpecifications;

public class Cities extends RestSpecifications{
	
private final String ENDPOINT = "/players";
	
	public void getPlayers() {
		getCall(ENDPOINT);
	}

}
