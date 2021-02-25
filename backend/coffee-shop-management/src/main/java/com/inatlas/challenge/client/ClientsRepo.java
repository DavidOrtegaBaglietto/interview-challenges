package com.inatlas.challenge.client;

import java.util.List;

public interface ClientsRepo {
	public List<Client> findAllClients();
	public void addClient(Client client);
	public Client findClientById(Integer clientId);
}
