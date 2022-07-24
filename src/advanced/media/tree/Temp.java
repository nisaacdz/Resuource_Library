package advanced.media.tree;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileSystemView;

public class Temp {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			JFrame frame;

			@Override
			public void run() {
				frame = new JFrame("Hello World");
				frame.setVisible(true);
				frame.setSize(400, 600);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setLayout(null);

				initialize();
			}

			private void initialize() {
				File root = FileSystemView.getFileSystemView().getHomeDirectory();
				Dimension size = new Dimension(250, 600);

				MFileTree tree = new MFileTree(root, size);
				tree.getTreeTitle().setText("Media Library");
				tree.getTreeTitleView().setBackground(Fxns.getRandomColor());
				frame.getContentPane().add(tree.getContainer());
			}
		});
	}
}