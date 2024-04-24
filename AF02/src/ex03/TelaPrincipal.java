package ex03;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class TelaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setTitle("Atividade JFileChooser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Abrir");
		mntmNewMenuItem.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/ex03/open.png")));
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem);

		mntmNewMenuItem_1 = new JMenuItem("Salvar");
		mntmNewMenuItem_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/ex03/save.png")));
		mntmNewMenuItem_1.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
	}

	public String getText() {
		String text = textArea.getText();
		return text;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("Salvar")) {
			if (!getText().isEmpty()) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Escolha o diretório onde deseja salvar o texto");
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int retorno = fileChooser.showSaveDialog(null);
				fileChooser.setVisible(true);

				if (retorno == JFileChooser.APPROVE_OPTION) {
					File diretorio = fileChooser.getSelectedFile();

					File arquivo = new File(diretorio, "ufcspa.txt");

					try {
						FileWriter writer = new FileWriter(arquivo);
						writer.write(getText());
						writer.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}

		else {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Escolha o arquivo de texto que deseja abrir");
			fileChooser.setVisible(true);

			int retorno = fileChooser.showOpenDialog(null);

			if (retorno == JFileChooser.APPROVE_OPTION) {
				File arquivo = fileChooser.getSelectedFile();
				textArea.setText(null);

				try {

					for (String linha : Files.readAllLines(arquivo.toPath())) {
						textArea.append(linha.toString() + "\n");
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

	}

}
