package displayLoot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import lootGenerator.BaseGearPiece;
import lootGenerator.GearPieceEnums;
import lootGenerator.LootComposer;
import lootGenerator.RevisedPlayerCharacter;

public class tabPane2 {

	JFrame mainFrame;
	ArrayList<BaseGearPiece> gearList = new ArrayList<BaseGearPiece>();
	ArrayList<BaseGearPiece> selectedGearList = new ArrayList<BaseGearPiece>();
	
	private RevisedPlayerCharacter currentPlayer = null;
	
	private int gearPieceSlot = 0;
	
	JPanel maskList = new JPanel();
	DefaultListModel<String> maskListModel = new DefaultListModel<>();
	JList<String> maskPanelList = new JList<String>(maskListModel);
	JPanel chestList = new JPanel();
	DefaultListModel<String> chestListModel = new DefaultListModel<>();
	JList<String> chestPanelList = new JList<String>(chestListModel);
	JPanel backpackList = new JPanel();
	DefaultListModel<String> backpackListModel = new DefaultListModel<>();
	JList<String> backpackPanelList = new JList<String>(backpackListModel);
	JPanel glovesList = new JPanel();
	DefaultListModel<String> glovesListModel = new DefaultListModel<>();
	JList<String> glovesPanelList = new JList<String>(glovesListModel);
	JPanel holsterList = new JPanel();
	DefaultListModel<String> holsterListModel = new DefaultListModel<>();
	JList<String> holsterPanelList = new JList<String>(holsterListModel);
	JPanel kneepadsList = new JPanel();
	DefaultListModel<String> kneepadsListModel = new DefaultListModel<>();
	JList<String> kneepadsPanelList = new JList<String>(kneepadsListModel);
	JPanel playerList = new JPanel();
	DefaultListModel<String> playerListModel = new DefaultListModel<>();
	JList<String> playerPanelList = new JList<String>(playerListModel);
		
	public tabPane2(ArrayList<BaseGearPiece> inputGearList, RevisedPlayerCharacter inputPlayerCharacter) {
		mainFrame = new JFrame();
		currentPlayer = inputPlayerCharacter;
		
		JButton equipButton = new JButton("Equip");
        equipButton.setBounds(125, 305, 100, 50);
        
		maskList.add(maskPanelList);
		chestList.add(chestPanelList);
		backpackList.add(backpackPanelList);
		glovesList.add(glovesPanelList);
		holsterList.add(holsterPanelList);
		kneepadsList.add(kneepadsPanelList);
		playerList.add(playerPanelList);
		
		JTabbedPane tabbedPane = new JTabbedPane();
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
	          
	          updateSelectedGearList(gearPieceSlot);
	          
	          System.out.println("Gear Piece slot selected: " + gearPieceSlot);
	        }
	    });
	    
        equipButton.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent buttonClicked) {
          		JPanel testPanel = (JPanel) tabbedPane.getComponentAt(gearPieceSlot);
          		JList<String> selectedList = (JList<String>) testPanel.getComponent(0);
          		equipGearToPlayer(selectedGearList.get(selectedList.getSelectedIndex()));
          		currentPlayer.tellStats();
          		updatePlayerGearList();
          	}
          });
        
		updateFullGearList(inputGearList);
		updateSelectedGearList(0);
		updatePlayerGearList();
	}
	
	private void equipGearToPlayer(BaseGearPiece gearPieceToEquip) {
		currentPlayer.equipGearItem(gearPieceToEquip);
	}
 
	public void updateFullGearList(ArrayList<BaseGearPiece> inputGearList) {
		gearList.clear();
		
		for (BaseGearPiece currentGearPiece : inputGearList) {
			gearList.add(currentGearPiece);
		}
		
		for (BaseGearPiece copyGearPiece : gearList) {
			
			switch (copyGearPiece.getGearPieceEnum()) {
			case MASK:
				maskListModel.addElement((copyGearPiece.getCharacterAttributeValue() + " " + copyGearPiece.getGearAttributeEnum().toString() + " " + copyGearPiece.getGearPieceEnum().toString()));
				break;
			case CHEST:
				chestListModel.addElement((copyGearPiece.getCharacterAttributeValue() + " " + copyGearPiece.getGearAttributeEnum().toString() + " " + copyGearPiece.getGearPieceEnum().toString()));
				break;
			case BACKPACK:
				backpackListModel.addElement((copyGearPiece.getCharacterAttributeValue() + " " + copyGearPiece.getGearAttributeEnum().toString() + " " + copyGearPiece.getGearPieceEnum().toString()));
				break;
			case GLOVES:
				glovesListModel.addElement((copyGearPiece.getCharacterAttributeValue() + " " + copyGearPiece.getGearAttributeEnum().toString() + " " + copyGearPiece.getGearPieceEnum().toString()));
				break;
			case HOLSTER:
				holsterListModel.addElement((copyGearPiece.getCharacterAttributeValue() + " " + copyGearPiece.getGearAttributeEnum().toString() + " " + copyGearPiece.getGearPieceEnum().toString()));
				break;
			case KNEEPADS:
				kneepadsListModel.addElement((copyGearPiece.getCharacterAttributeValue() + " " + copyGearPiece.getGearAttributeEnum().toString() + " " + copyGearPiece.getGearPieceEnum().toString()));
				break;
			}
		}
	}
	
	private void updateSelectedGearList(int selectedGearPieceSlot) {
        GearPieceEnums desiredEnum = GearPieceEnums.MASK;
        
        gearPieceSlot = selectedGearPieceSlot;
        
        selectedGearList.clear();
        
        switch (gearPieceSlot) {
        case 0:
      	  desiredEnum = GearPieceEnums.MASK;
      	  break;
        case 1:
      	  desiredEnum = GearPieceEnums.CHEST;
      	  break;
        case 2:
      	  desiredEnum = GearPieceEnums.BACKPACK;
      	  break;
        case 3:
      	  desiredEnum = GearPieceEnums.GLOVES;
      	  break;
        case 4:
      	  desiredEnum = GearPieceEnums.HOLSTER;
      	  break;
        case 5:
      	  desiredEnum = GearPieceEnums.KNEEPADS;
      	  break;
        }
        
        for (BaseGearPiece selectedGearPieceCopy : gearList) {
  		  if (selectedGearPieceCopy.getGearPieceEnum() == desiredEnum) {
  			  selectedGearList.add(selectedGearPieceCopy);
  		  }
  	  }
	}
	
	private void updatePlayerGearList() {
		BaseGearPiece equippedGearPieces[] = currentPlayer.getEquippedGearPieces();
		
		playerListModel.clear();

		HashMap<Integer, String> slotLabelMap = new HashMap<Integer, String>();
		slotLabelMap.put(0, "mask");
		slotLabelMap.put(1, "chest");
		slotLabelMap.put(2, "backpack");
		slotLabelMap.put(3, "gloves");
		slotLabelMap.put(4, "holster");
		slotLabelMap.put(5, "kneepads");

		for (int i = 0; i < equippedGearPieces.length; i++) {
			if (equippedGearPieces[i] == null) {
				
				/*
				String slotLabel = "";
				
				switch (i) {
				case 0:
					slotLabel = "mask";
					break;
				case 1:
					slotLabel = "chest";
					break;
				case 2:
					slotLabel = "backpack";
					break;
				case 3:
					slotLabel = "gloves";
					break;
				case 4:
					slotLabel = "holster";
					break;
				case 5:
					slotLabel = "kneepads";
					break;
				}
				 */
								
				playerListModel.addElement("The player's " + slotLabelMap.get(i) + " inventory slot is empty");
				
			} else {
				playerListModel.addElement(equippedGearPieces[i].getCharacterAttributeValue() + " " + equippedGearPieces[i].getGearAttributeEnum().toString() + " " + equippedGearPieces[i].getGearPieceEnum().toString());
			}
		}
	}
	
	public static void main(String[] args) {
		LootComposer lootDistributor = new LootComposer();
		ArrayList<BaseGearPiece> testGearList = new ArrayList<BaseGearPiece>();
		RevisedPlayerCharacter testCharacter = new RevisedPlayerCharacter();
   	 
		for (int i = 0; i < 100; i++) {
			testGearList.add(lootDistributor.generateGearItem());
		}
   	 
		tabPane2 testTabPane = new tabPane2(testGearList, testCharacter);

		for (int i = 0; i < 100; i++) {
			testGearList.add(lootDistributor.generateGearItem());
		}

	}
}
