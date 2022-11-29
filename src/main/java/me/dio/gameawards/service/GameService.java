package me.dio.gameawards.service;

import me.dio.gameawards.domain.model.Game;

public interface GameService extends CrudService<Game> {

	public void votar(Long gameId);
}
