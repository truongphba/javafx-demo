package demo.model;

import demo.entity.Game;

import java.util.ArrayList;

public interface GameModel {

    boolean save(Game game);

    ArrayList<Game> getList();
}
