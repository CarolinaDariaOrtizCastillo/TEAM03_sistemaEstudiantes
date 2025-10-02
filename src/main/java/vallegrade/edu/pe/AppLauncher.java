package vallegrade.edu.pe;

import vallegrade.edu.pe.view.FrmEstudiante;

public class AppLauncher {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new FrmEstudiante().setVisible(true);
        });
    }
}
