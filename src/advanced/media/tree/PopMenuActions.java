package advanced.media.tree;

public class PopMenuActions {

	protected static void refreshTreeNode(MFileTree tree, JPane pane) {
		if (pane.isExpanded()) {
			tree.closeOrderly(pane, pane.getChildren());
			tree.expand(pane);
		}
	}
	
	protected static void openNode(MFileTree tree, JPane pane) {
		if (pane.isExpandableFolder()) {
			tree.expand(pane);
		}else if(pane.isRightFile()){
			
		}
	}

}
