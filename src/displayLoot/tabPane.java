package displayLoot;

import java.util.ArrayList;
import javax.swing.*;
import lootGenerator.BaseGearPiece;
import lootGenerator.LootComposer;
import lootGenerator.RevisedPlayerCharacter;

public class tabPane {

	JFrame mainFrame;
	ArrayList<BaseGearPiece> gearList = new ArrayList<BaseGearPiece>();
	
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
		
	public tabPane(ArrayList<BaseGearPiece> inputGearList) {
		mainFrame = new JFrame();

		maskList.add(maskPanelList);
		chestList.add(chestPanelList);
		backpackList.add(backpackPanelList);
		glovesList.add(glovesPanelList);
		holsterList.add(holsterPanelList);
		kneepadsList.add(kneepadsPanelList);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(50, 50, 250, 250);
		tabbedPane.add("Mask", maskList);
		tabbedPane.add("Chest", chestList);
		tabbedPane.add("Backpack", backpackList);
		tabbedPane.add("Gloves", glovesList);
		tabbedPane.add("Holster", holsterList);
		tabbedPane.add("Kneepads", kneepadsList);
		mainFrame.add(tabbedPane);
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		
		updateGearList(inputGearList);
	}
	
	public void updateGearList(ArrayList<BaseGearPiece> inputGearList) {
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
	
	public static void main(String[] args) {
   	 LootComposer lootDistributor = new LootComposer();
   	 ArrayList<BaseGearPiece> testGearList = new ArrayList<BaseGearPiece>();
   	 RevisedPlayerCharacter testCharacter = new RevisedPlayerCharacter();
   	 
   	 for (int i = 0; i < 100; i++) {
   		 testGearList.add(lootDistributor.generateGearItem());
   		 }
   	 
   	 testCharacter.equipGearItem(testGearList.get(25));
   	 
   	 tabPane testTabPane = new tabPane(testGearList);
   	 
	}
}
