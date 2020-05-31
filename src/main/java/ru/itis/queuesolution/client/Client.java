package ru.itis.queuesolution.client;

import reactor.core.publisher.Flux;

public interface Client {
    Flux<Client> getRecipe(String query);
}
