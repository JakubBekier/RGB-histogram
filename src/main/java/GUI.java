import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI {
    public GUI(){
        JButton open = new JButton();
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("images","jpg","png");
        fc.setFileFilter(filter);
        fc.setCurrentDirectory(new java.io.File(System.getProperty("user.dir") + "/src/main"));
        fc.setDialogTitle("Choose a file to analyze");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setApproveButtonText("Analyze");
        if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION){
            Plot ex = new Plot(fc.getSelectedFile().getAbsolutePath());
            ex.setVisible(true);
        }
    }
}
