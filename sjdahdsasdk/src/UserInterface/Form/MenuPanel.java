package UserInterface.Form;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import UserInterface.CustomerControl.PatButton;

public class MenuPanel extends JPanel {
    private BufferedImage backgroundImage;
    public PatButton btnHome = new PatButton("🏠 Home");
    public PatButton btnCita = new PatButton("📅 Agendar Cita");

    public MenuPanel() {
        // Cargar la imagen de fondo
        try {
            backgroundImage = ImageIO.read(new File("/UserInterface/Resource/EPNPG.png")); // Usa la imagen que subiste
        } catch (IOException e) {
            System.out.println("No se pudo cargar la imagen de fondo.");
        }

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1020, 720));
        setBorder(new LineBorder(Color.BLACK, 2));

        // Panel para agrupar botones y evitar que se pierdan en el fondo
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(2, 1, 10, 10));
        panelButtons.setOpaque(true); // Fondo sólido
        panelButtons.setBackground(new Color(255, 255, 255, 180)); // Blanco semi-transparente para visibilidad
        panelButtons.add(btnHome);
        panelButtons.add(btnCita);

        add(panelButtons, BorderLayout.SOUTH); // Botones al fondo del menú
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
