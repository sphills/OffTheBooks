package displayLoot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import lootGenerator.BaseGearPiece;
import lootGenerator.RevisedPlayerCharacter;

public class TabPane3 {

	JFrame mainFrame;
	ArrayList<BaseGearPiece> gearList = new ArrayList<BaseGearPiece>();
	ArrayList<BaseGearPiece> selectedGearList = new ArrayList<BaseGearPiece>();
	
	private RevisedPlayerCharacter currentPlayer = null;
	
	private int gearPieceSlot = 0;
	
	JPanel maskList = new JPanel();
	JPanel chestList = new JPanel();
	JPanel backpackList = new JPanel();
	JPanel glovesList = new JPanel();
	JPanel holsterList = new JPanel();
	JPanel kneepadsList = new JPanel();
	JPanel playerList = new JPanel();
	
	JTabbedPane tabbedPane = new JTabbedPane();
	
	public TabPane3(ArrayList<BaseGearPiece> inputGearList, RevisedPlayerCharacter inputPlayerCharacter) {
		mainFrame = new JFrame();
		currentPlayer = inputPlayerCharacter;
		
		JButton equipButton = new JButton("Equip");
        equipButton.setBounds(125, 305, 100, 50);
		
		tabbedPane.setBounds(50, 50, 300, 250);
		tabbedPane.add("Mask", maskList);
		tabbedPane.add("Chest", chestList);
		tabbedPane.add("Backpack", backpackList);
		tabbedPane.add("Gloves", glovesList);
		tabbedPane.add("Holster", holsterList);
		tabbedPane.add("Kneepads", kneepadsList);
		tabbedPane.add("Player Inventory", playerList);
		
		mainFrame.add(equipButton);
		
		mainFrame.add(tabbedPane);
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		
		
	    tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent evt) {
	          JTabbedPane pane = (JTabbedPane) evt.getSource();

	          gearPieceSlot = pane.getSelectedIndex();
	          
	          if (gearPieceSlot == 6) {
	        	  if (equipButton.isVisible()) {
	        		  equipButton.setVisible(false); 
	        	  }
	          } else {
	        	  if (!equipButton.isVisible()) {
	        		  equipButton.setVisible(true); 
	        	  }
	          }
	          
	          
	          System.out.println("Gear Piece slot selected: " + gearPieceSlot);
	        }
	    });
	    
        equipButton.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent buttonClicked) {
          		JPanel testPanel = (JPanel) tabbedPane.getComponentAt(gearPieceSlot);
          		JList<String> selectedList = (JList<String>) testPanel.getComponent(0);
//          		equipGearToPlayer(selectedGearList.get(selectedList.getSelectedIndex()));
          		currentPlayer.tellStats();
          	}
         });
        
	}
	
	private void populateEquipmentList() {
		JPanel proxyPanel = null;
		String panelLabel = "";
		DefaultListModel<String> proxyListModel = new DefaultListModel<>();
		JList<String> proxyPanelList = new JList<String>(proxyListModel);
		
		/*
		for (int i = 0; i < 8; i++) {
			proxyListModel.addElement((copyGearPiece.getCharacterAttributeValue() + " " + copyGearPiece.getGearAttributeEnum().toString() + " " + copyGearPiece.getGearPieceEnum().toString()));
		}
		*/
		
		tabbedPane.add(panelLabel, proxyPanel);
	}
}
