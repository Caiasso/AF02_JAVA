package ex1;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class TelaPrincipal extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField fdNome;
	private JButton okButton;
	private JButton cancelButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaPrincipal dialog = new TelaPrincipal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaPrincipal() {
		setTitle("Entrada de Dados");
		setBounds(100, 100, 350, 150);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 334, 111);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{			
			JLabel lblIcon = new JLabel("");
			lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
			lblIcon.setBounds(0, 0, 63, 56);
			lblIcon.setIcon(getIcon());
			contentPanel.add(lblIcon);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Informe o seu primeiro nome:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1.setBounds(73, 11, 182, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			fdNome = new JTextField();
			fdNome.setBounds(73, 36, 217, 20);
			contentPanel.add(fdNome);
			fdNome.setColumns(10);
		}
		{
			okButton = new JButton("Ok");
			okButton.setBounds(73, 67, 87, 23);
			okButton.addActionListener(this);
			contentPanel.add(okButton);
		}
		{
			cancelButton = new JButton("Cancelar");
			cancelButton.setBounds(170, 67, 87, 23);
			cancelButton.addActionListener(this);
			contentPanel.add(cancelButton);
		}
	}
	
	public ImageIcon getIcon()
	{
		ImageIcon icone = new ImageIcon(TelaPrincipal.class.getResource("/informacao.png"));
		return icone;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Ok"))
		{
			if(!fdNome.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(contentPanel, "Nome do estudante: "+fdNome.getText(), "Saída", 1, getIcon());
			}
		}
		else
		{
			dispose();
		}
		
	}

}
