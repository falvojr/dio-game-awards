package me.dio.gameawards.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.gameawards.domain.model.Game;
import me.dio.gameawards.domain.model.GameRepository;
import me.dio.gameawards.service.GameService;

@Service
public class GameServiceImpl extends BaseCrudService<Game> implements GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Override
	protected GameRepository getRepository() {
		return this.gameRepository;
	}

	@Override
	public void votar(Long gameId) {
		Game game = super.buscarUm(gameId);
		game.setVotes(game.getVotes() + 1);
		
		super.alterar(gameId, game);
	}

}
