package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class RoomSelection {
	
	public RoomSelection(){
		initComponents();
	}
	
	private void initComponents(){
		JButton b = new JButton();
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				selectRoom(); //...
			}
		});
	}
	
	public void selectRoom(){
		//ServerUtils.getRoom(selected);
	}
	
	//Handler
	public void startGame(){
		//Game g = new Game(selectedRoom);
		//g.startGame();
	}
	
}
