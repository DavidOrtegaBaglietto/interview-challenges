package com.inatlas.challenge.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientsRepoInMemory implements ClientsRepo {

	private Map<Integer, Client> clients = new HashMap<Integer, Client>();
	
	@Override
	public List<Client> findAllClients() {
		return new ArrayList<Client>(clients.values());
	}

	@Override
	public void addClient(Client client) {
		clients.put(client.getId(), client);		
	}

	@Override
	public Client findClientById(Integer clientId) {
		return clients.get(clientId);
	}

}
