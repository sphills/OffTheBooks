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
	
	//Setting up these instances and objects for the constructor to arrange
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
	
	// The constructor initializes the mainFrame variable
	public tabPane2(ArrayList<BaseGearPiece> inputGearList, RevisedPlayerCharacter inputPlayerCharacter) {
		//Initialize the mainFrame with a new JFrame and set the currentPlayer variable for later reference 
		mainFrame = new JFrame();
		currentPlayer = inputPlayerCharacter;
		
		//Create the equipButton JButton to be added to the mainFrame and set the location/size
		JButton equipButton = new JButton("Equip");
        equipButton.setBounds(125, 305, 100, 50);
        
        //Add all the previously-initialized JLists<String> to their target JPanels
		maskList.add(maskPanelList);
		chestList.add(chestPanelList);
		backpackList.add(backpackPanelList);
		glovesList.add(glovesPanelList);
		holsterList.add(holsterPanelList);
		kneepadsList.add(kneepadsPanelList);
		playerList.add(playerPanelList);
		
		//Create the actual JTabbedPane that the JPanels will be displayed on
		JTabbedPane tabbedPane = new JTabbedPane();

		//Set the size of the JTabbedPane
		tabbedPane.setBounds(50, 50, 300, 250);
		tabbedPane.add("Mask", maskList);
		tabbedPane.add("Chest", chestList);
		tabbedPane.add("Backpack", backpackList);
		tabbedPane.add("Gloves", glovesList);
		tabbedPane.add("Holster", holsterList);
		tabbedPane.add("Kneepads", kneepadsList);
		tabbedPane.add("Player Inventory", playerList);
		
		//Add the two components necessary to the main JFrame
		mainFrame.add(tabbedPane);
		mainFrame.add(equipButton);
		
		//Set the size of the mainFrame, layout, and visibility
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		
		//Add an event listener for whenever a new tab is clicked on
	    tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent evt) {
	          JTabbedPane pane = (JTabbedPane) evt.getSource();

	          gearPieceSlot = pane.getSelectedIndex();
	          
	          /* this if(){} hides the equipButton if the selected tab is the playerList, 
	           * with validation so .setVisible isn't called unecessarily.
	           */
	          if (gearPieceSlot == 6) {
	        	  if (equipButton.isVisible()) {
	        		  equipButton.setVisible(false); 
	        	  }
	          } else {
	        	  if (!equipButton.isVisible()) {
	        		  equipButton.setVisible(true); 
	        	  }
	          }

	          //A private method call with the int gearPieceSlot passed as an argument
	          updateSelectedGearList(gearPieceSlot);
	          
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

	//
	public void updateFullGearList(ArrayList<BaseGearPiece> inputGearList) {
		gearList.clear();

		// This proxyListModel will be used to reference one of the previously established ListModels, without having to call .addElement
		// on that ListModel directly
		DefaultListModel<String> proxyListModel = new DefaultListModel<>();

		for (BaseGearPiece currentGearPiece : inputGearList) {
			gearList.add(currentGearPiece);
		}
	}
	
	/* This private method makes a new ArrayList<GearPiece> copy from gearList, selecting only gearPieces that have
	 * the requested enum and adding them to selectedGearList, which is how the user selects the gearPiece they want
	 * their player character to equip.
	 */
	private void updateSelectedGearList(int selectedGearPieceSlot) {
       /* Initialized desiredEnum variable for use with the for() to populate selectedGearList with gearPieces that
		* have the required GearPieceEnum
		*/
		GearPieceEnums desiredEnum = GearPieceEnums.MASK;
        DefaultListModel<String> proxyListModel = new DefaultListModel<>();
        
		//Empty the ArrayList<GearPiece> instance variable selectedGearList so no old gear is carried over/duplicated
        selectedGearList.clear();
        
        /* Switch to set desiredEnum to the target enum. Only gearPieces that have the required enum will be added to the
         * newly-emptied selectedGearList 
         */
        switch (selectedGearPieceSlot) {
        case 0:
        	proxyListModel = maskListModel;
        	desiredEnum = GearPieceEnums.MASK;
        	break;
        case 1:
        	proxyListModel = chestListModel;
      	  desiredEnum = GearPieceEnums.CHEST;
      	  break;
        case 2:
        	proxyListModel = backpackListModel;
      	  desiredEnum = GearPieceEnums.BACKPACK;
      	  break;
        case 3:
        	proxyListModel = glovesListModel;
      	  desiredEnum = GearPieceEnums.GLOVES;
      	  break;
        case 4:
        	proxyListModel = holsterListModel;
      	  desiredEnum = GearPieceEnums.HOLSTER;
      	  break;
        case 5:
        	proxyListModel = kneepadsListModel;
      	  desiredEnum = GearPieceEnums.KNEEPADS;
      	  break;
        }
        
        proxyListModel.clear();
        
        /* This for iterates through the master ArrayList<GearPiece> gearList, discriminates based on the piece having the required enum,
         * and if it does have the correct enum, adds it to the selectedGearList
         */
        
        long startTime = System.nanoTime();
        /*
        for (BaseGearPiece selectedGearPieceCopy : gearList) {
  		  if (selectedGearPieceCopy.getGearPieceEnum() == desiredEnum) {
  			  selectedGearList.add(selectedGearPieceCopy);
  		  }
  	  	}
        
        for (BaseGearPiece copyGearPiece : selectedGearList ) {
        	proxyListModel.addElement((copyGearPiece.getCharacterAttributeValue() + " " + copyGearPiece.getGearAttributeEnum().toString() + " " + copyGearPiece.getGearPieceEnum().toString()));
        }
        */
        
        for (BaseGearPiece selectedGearPieceCopy : gearList) {
    		  if (selectedGearPieceCopy.getGearPieceEnum() == desiredEnum) {
    			  selectedGearList.add(selectedGearPieceCopy);
    			  proxyListModel.addElement((selectedGearPieceCopy.getCharacterAttributeValue() + " " + selectedGearPieceCopy.getGearAttributeEnum().toString() + " " + selectedGearPieceCopy.getGearPieceEnum().toString()));
    		  }
    	  	}

        long stopTime = System.nanoTime();
        
        System.out.println("Proxy list model size: " + proxyListModel.size());
        System.out.println("Time to build list: " + (stopTime - startTime) + " nanoseconds or " + ((stopTime - startTime) / 1000000000f) + " seconds.");
        System.out.println("Time to build list per item: " + (((stopTime - startTime) / proxyListModel.size()) / 100000f) + " milliseconds.");
	}
	
	private void updatePlayerGearList() {
		BaseGearPiece equippedGearPieces[] = currentPlayer.getEquippedGearPieces();
		
		playerListModel.clear();

		HashMap<Integer, String> slotLabelMap = new HashMap<Integer, String>();
		String slotLabel = "";
		
		for (int i = 0; i < 6; i++) {
			
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
			slotLabelMap.put(i, slotLabel);
		}

		for (int i = 0; i < equippedGearPieces.length; i++) {
			if (equippedGearPieces[i] == null) {
		
				playerListModel.addElement("The player's " + slotLabelMap.get(i) + " inventory slot is empty");
				
			} else {
				playerListModel.addElement(equippedGearPieces[i].getCharacterAttributeValue() + " " + equippedGearPieces[i].getGearAttributeEnum().toString() + " " + equippedGearPieces[i].getGearPieceEnum().toString());
			}
		}
	}
}
