package advanced.media.tree;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPane extends JPanel {

	private File file;
	private JButton treeNode;
	private JTextField treeItem;

	private ArrayList<JPane> children = new ArrayList<JPane>();
	private boolean expanded = false;

	private static Color newColor = new Color(255, 250, 245);

	private int H;
	private int i;

	private static final long serialVersionUID = 1L;

	public JPane(File args) {
		super();
		file = args;
		addNodeText();

		treeItem.setVisible(true);
		treeNode.setVisible(true);
	}

	private void addNodeText() {
		treeNode = new JButton() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				File imageFile = new File("nodeImage.png");
				Image image;
				int width = this.getWidth();
				int height = this.getHeight();
				try {
					image = ImageIO.read(imageFile);
					g.drawImage(image, 0, 0, width, height, null);
				} catch (IOException e) {
					System.out.println("IOException thrown");
				}
			}
		};

		treeItem = new JTextField(Fxns.formName(file));
		treeItem.setFont(new Font("Lucida Bright", Font.BOLD, 16));
		treeItem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		treeItem.setEditable(false);
		treeItem.setBackground(newColor);
		treeItem.setForeground(Color.BLACK);

		this.setLayout(null);
		this.add(treeNode);
		this.add(treeItem);
	}

	public int getMediaFileType() {
		if (Fxns.isVideoFile(this.getFile())) {
			return 1;
		} else if (Fxns.isAudioFile(this.getFile())) {
			return 2;
		} else if (Fxns.isVideoFile(this.getFile())) {
			return 3;
		} else {
			return 0;
		}
	}

	public boolean isRightFile() {
		boolean returnValue = false;
		if (Fxns.isMediaFile(this.getFile())) {
			returnValue = true;
		}
		return returnValue;
	}

	public boolean isExpandableFolder() {
		boolean returnValue = false;
		if (this.getFile().isDirectory() && !Fxns.dirIsEmpty(this.getFile())) {
			returnValue = true;
		}
		return returnValue;
	}

	public int getMediaType() {

		return 0;
	}

	public void setExpansionHeight(int arg0) {
		H = arg0;
	}

	public int getExpansionHeight() {
		return H;
	}

	public void setExpansionSize(int arg0) {
		i = arg0;
	}

	public int getExpansionSize() {
		return i;
	}

	public void addChildren(JPane child) {
		children.add(child);
	}

	public ArrayList<JPane> getChildren() {
		return children;
	}

	public void setBoundary(int x, int y, int width, int height) {
		this.setBounds(x, y, width, height);
		treeNode.setBounds(0, 10, 10, 10);
		treeItem.setBounds(20, 0, width - 50, height);
	}

	public boolean isBelowExpanded(JPane expanded) {
		if (this.getY() > expanded.getY()) {
			return true;
		}
		return false;
	}

	public JButton getTreeNode() {
		return treeNode;
	}

	public JTextField getTreeItem() {
		return treeItem;
	}

	public File getFile() {
		return file;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean args) {
		expanded = args;
	}

}