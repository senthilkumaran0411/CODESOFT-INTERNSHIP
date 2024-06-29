import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystemGUI gui = new StudentManagementSystemGUI();
        JFrame frame = gui.getFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}