import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

class GetData
{
    public static double getDouble(String s)
    {

        return Double.parseDouble(getString(s));
    }

    public static int getInt(String s)
    {

        return Integer.parseInt(getString(s));
    }

    public static String getString(String s)

    {
        return JOptionPane.showInputDialog(s);
    }

    public static void display(String title, String text, int row, int col)
    {
        JTextArea s = new JTextArea(text, row, col);
        JScrollPane pane = new JScrollPane(s);
        JOptionPane.showMessageDialog(null, pane, title, JOptionPane.INFORMATION_MESSAGE);
    }
}