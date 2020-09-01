package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import Model.*;
import View.*;

public class Controller implements ActionListener {
	
	private static MainGame game;
	private static StartGUI startGUI;
	
	public Controller (StartGUI startGUI) {
		startGUI.setListener(this);
	}

	/**
	 * Driver method. <P> 
	 * ARGUMENT LIST:<P> 
	 * -mt (manual turn) Player number turn is user-specified per round.<P>
	 * -ac (limited action cards) User specifies number of Action Cards before start of game. Note that after running out of decks and reshuffling, number of cards is back to 50.<P>
	 * -cm (custom money) user specifies a custom starting money for each players (default $200000) <P>
	 * -cl (custom loan) user specifies a custom starting loan balance to every player (does not affect interest)<P>
	 * @param args arguments included by the user before program run.
	 */
	public static void main(String[] args) {
		
		MainGame.setArguments(args); // Check terminal arguments

		game = new MainGame(); // Create game instance.
		
		Controller.startGUI = new StartGUI();
		Controller controller = new Controller(startGUI);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start")) {
			game.gameIntro(Integer.parseInt(startGUI.getPlayerNumberFieldString())); // Set players
		}
	}
}
