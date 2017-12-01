package snake.project.com;

import snake.project.com.gui.GameWindow;
import snake.project.com.architecture.Game;
import snake.project.com.gui.KeyController;
import snake.project.com.gui.Layout;

import java.awt.*;

public class Main {

  private static final int WIDTH = 22;
  private static final int HEIGHT = 18;
  private static final int CELL = 30;

  public static void main(String[] args) {
    Game game = new Game(WIDTH, HEIGHT);
    GameWindow window = new GameWindow(game, CELL);
    Layout layout = new Layout(game, CELL);
    window.add(BorderLayout.CENTER, layout);
    window.addKeyListener(new KeyController(game));

    while (true) {
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if (game.isPause() || game.isOver()) {
        try {
          Thread.sleep(200);
        } catch (InterruptedException exception) {
          Thread.currentThread().interrupt();
          return;
        } catch (Exception exception) {
          break;
        }
      }
      layout.repaint();
      game.makeOneStep();
    }
  }
}