package me.dio.gameawards.service;

import me.dio.gameawards.domain.model.Game;

public interface GameService extends CrudService<Game> {

	/**
	 * Metódo responsável por contabilizar um voto para um {@link Game}.
	 * 
	 * @param gameId Identificador (ID) do {@link Game}.
	 */
	public void vote(Long gameId);
}
