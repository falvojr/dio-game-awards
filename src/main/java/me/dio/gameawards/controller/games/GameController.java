package me.dio.gameawards.controller.games;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import me.dio.gameawards.controller.BaseRestController;
import me.dio.gameawards.domain.model.Game;
import me.dio.gameawards.service.GameService;

@CrossOrigin
@RestController
public class GameController extends BaseRestController {
	
	@Autowired
	private GameService camadaDeNegocio;
	
	@GetMapping("games")
	public ResponseEntity<List<Game>> buscarTodos() {
		return ResponseEntity.ok(camadaDeNegocio.findAll());
	}
	
	@GetMapping("games/{id}")
	public ResponseEntity<Game> buscarUm(@PathVariable Long id) {
		return ResponseEntity.ok(camadaDeNegocio.findById(id));
	}

	@PatchMapping("games/{id}/vote")
	public ResponseEntity<Game> votar(@PathVariable Long id) {
		camadaDeNegocio.vote(id);
		return ResponseEntity.ok().build();
	}

}
