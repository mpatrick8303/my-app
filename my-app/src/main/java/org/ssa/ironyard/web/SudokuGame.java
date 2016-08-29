package org.ssa.ironyard.web;

public class SudokuGame {
    private  int id;
   
    private String difficulty;
    private String game;
    private String solution;

    public SudokuGame(int id, String difficulty, String game) {
	if (!(game.matches("\\d+") && game.length() == 81))
	    throw new IllegalArgumentException();

	this.id = id;
	this.difficulty = difficulty;
	this.game = game;
	// this.solution = new SudokuSolverImpl(this).solve();
    }

    public int getId() {
	return id;
    }

    

    public String getDifficulty() {
	return difficulty;
    }

    public String getGame() {
	return game;
    }

    public String getSolution() {
	return solution;
    }
    
    
    

    

}