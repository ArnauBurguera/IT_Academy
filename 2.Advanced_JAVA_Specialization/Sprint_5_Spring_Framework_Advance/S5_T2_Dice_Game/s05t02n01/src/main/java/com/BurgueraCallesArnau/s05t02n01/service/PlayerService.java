package com.BurgueraCallesArnau.s05t02n01.service;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.repository.PlayerRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private GameService gameService;

    public Player createPlayer(Player player) {
        player.setRegistrationDate(new Date());

        if (player.getName() == null || player.getName().isEmpty()) {
            player.setName("ANÒNIM");
        }

        return playerRepository.save(player);
    }

   /* public Player updatePlayerName(Integer id, String name) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found"));
        player.setName(name);
        return playerRepository.save(player);
    }*/

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public List<Game> getPlayerGames(Integer playerId) {
        return gameService.getGamesForPlayer(playerId);
    }

    public double calculateSuccessPercentage(Integer playerId) {
        List<Game> games = getPlayerGames(playerId);
        if (games.isEmpty()) {
            return 0.0;
        }
        long wonGames = games.stream().filter(Game::isWon).count();
        return (double) wonGames / games.size() * 100;
    }

    public double calculateAverageSuccessPercentage() {
        List<Player> players = getAllPlayers();
        if (players.isEmpty()) {
            return 0.0;
        }
        double totalPercentage = players.stream()
                .mapToDouble(player -> calculateSuccessPercentage(player.getId()))
                .sum();
        return totalPercentage / players.size();
    }
}
