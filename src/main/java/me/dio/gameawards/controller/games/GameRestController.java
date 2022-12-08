package me.dio.gameawards.controller.games;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.dio.gameawards.controller.BaseRestController;
import me.dio.gameawards.domain.model.Game;
import me.dio.gameawards.service.GameService;

@CrossOrigin
@RestController
public class GameRestController extends BaseRestController {
	
	@Autowired
	private GameService businessLayer;

	/**
	 * Enpoint que lista todos os {@link Game}s. Consumido por um App React Native:<br>
	 * <a href="https://youtu.be/Ity0Aa_ytPM">DIO Fullstack Labs - Dia 1 (API Java 17)<a/><br>
	 * <a href="https://youtu.be/QXeXmKPOmvo">DIO Fullstack Labs - Dia 2 (App React Native)<a/>
	 * 
	 * @return Lista de {@link Game}s ordenada pela quantidade de votos.
	 */
	@GetMapping("games")
	public ResponseEntity<List<Game>> findAll() {
		return ResponseEntity.ok(this.businessLayer.findAll());
	}

	/**
	 * Enpoint que vota em um {@link Game} específico, também consumido pelo App React Native:<br>
	 * <a href="https://youtu.be/Ity0Aa_ytPM">DIO Fullstack Labs - Dia 1 (API Java 17)<a/><br>
	 * <a href="https://youtu.be/QXeXmKPOmvo">DIO Fullstack Labs - Dia 2 (App React Native)<a/>
	 * 
	 * @param id Identificador do {@link Game} para contabilizarmos o voto.
	 */
	@PatchMapping("games/{id}/vote")
	public ResponseEntity<Void> vote(@PathVariable Long id) {
		this.businessLayer.vote(id);
		return ResponseEntity.ok().build();
	}
	
	/*
	 * Os endpoints a seguir foram criados apenas para fins didáticos ;)
	 */
	
	@GetMapping("games/{id}")
	public ResponseEntity<Game> findById(@PathVariable Long id) {
		return ResponseEntity.ok(this.businessLayer.findById(id));
	}
	
	@PostMapping("games")
	public ResponseEntity<Game> insert(@RequestBody Game game) {
		businessLayer.insert(game);
		return ResponseEntity.status(HttpStatus.CREATED).body(game);
	}
	
	@PutMapping("games/{id}")
	public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody Game game) {
		businessLayer.update(id, game);
		return ResponseEntity.ok(game);
	}
	
	@DeleteMapping("games/{id}")
	public ResponseEntity<Game> delete(@PathVariable Long id) {
		businessLayer.delete(id);
		return ResponseEntity.ok().build();
	}

}
