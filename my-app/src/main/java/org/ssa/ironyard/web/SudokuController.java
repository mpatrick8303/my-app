package org.ssa.ironyard.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

@RestController
@RequestMapping("/sudoku")
public class SudokuController
{
    @Autowired
    SudokuGames sg;

    String solutionB;
    String initial;

    static final Logger LOGGER = LogManager.getLogger(SudokuController.class);

    @RequestMapping(value = "")
    public View home()
    {
        return new InternalResourceView("home-sudoku.html");
    }

    @RequestMapping("/{difficulty}")
    @ResponseBody
    public Map<String, String> gameBoard(@PathVariable String difficulty)
    {
        
        Map<String, String> games = new HashMap<>();

        Random rand = new Random();
        int randomNum = 1 + rand.nextInt((10 - 1) + 1);
        int choice;

        if (difficulty.equals("easy"))
        {
            if (randomNum <= 5)
                choice = 1;
            else
                choice = 2;
            switch (choice)
            {

                case 1:
                    games.put("initial", sg.easy1.getGame());
                    games.put("game", Integer.toString(sg.easy1.getId()));
                    solutionB = BTSudokuSolver.solve(games.get("initial"));
                    break;
                case 2:

                    games.put("initial", sg.easy2.getGame());
                    games.put("game", Integer.toString(sg.easy2.getId()));
                    solutionB = BTSudokuSolver.solve(games.get("initial"));
                    break;
            }
        }
            
        if (difficulty.equals("medium"))
        {
            if (randomNum <= 5)
                choice = 1;
            else
                choice = 2;
            switch (choice)
            {

                case 1:
                    games.put("initial", sg.medium1.getGame());
                    games.put("game", Integer.toString(sg.medium1.getId()));
                    solutionB = BTSudokuSolver.solve(games.get("initial"));
                    break;
                case 2:

                    games.put("initial", sg.medium2.getGame());
                    games.put("game", Integer.toString(sg.medium2.getId()));
                    solutionB = BTSudokuSolver.solve(games.get("initial"));
                    break;
            }
        }
                
            if (difficulty.equals("hard"))
            {
                if (randomNum <= 5)
                    choice = 1;
                else
                    choice = 2;
                
                switch (choice)
                {

                    case 1:
                        games.put("initial", sg.hard1.getGame());
                        games.put("game", Integer.toString(sg.hard1.getId()));
                        solutionB = BTSudokuSolver.solve(games.get("initial"));
                        break;
                    case 2:

                        games.put("initial", sg.hard2.getGame());
                        games.put("game", Integer.toString(sg.hard2.getId()));
                        solutionB = BTSudokuSolver.solve(games.get("initial"));
                        break;
                }

            }
                
            return games;



    }

    @RequestMapping(value = "{game}", params = "solution")
    @ResponseBody
    public Map<String, List<String>> solution(@PathVariable String game, @RequestParam String solution, HttpSession session)
    {
        Map<String, List<String>> map = new HashMap<>();
        List<String> errors = new ArrayList<>();
        List<String> gamePath = new ArrayList<>();
        gamePath.add(game);

        for (int i = 0; i < solutionB.length(); i++)// gets errors
        {
            if (solution.charAt(i) != solutionB.charAt(i) && solution.charAt(i) != '0')
                errors.add(Integer.toString(i));
        }

        map.put("errors", errors);
        map.put("game", gamePath);

        return map;

    }



}
