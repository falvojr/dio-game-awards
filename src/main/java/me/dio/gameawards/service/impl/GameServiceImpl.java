package me.dio.gameawards.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import me.dio.gameawards.domain.model.Game;
import me.dio.gameawards.domain.model.GameRepository;
import me.dio.gameawards.service.GameService;

@Service
public class GameServiceImpl extends BaseCrudService<Game, GameRepository> implements GameService {

	@Autowired
	public GameServiceImpl(GameRepository repository) {
		super(repository);
	}

	@Override
	public void vote(Long gameId) {
		Game game = super.findById(gameId);
		game.setVotes(game.getVotes() + 1);
		
		super.update(gameId, game);
	}

	@Override
	public List<Game> findAll() {
		return super.repository.findAll(Sort.by(Direction.DESC, "votes"));
	}
}
