import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WarehouseApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel screenPanel;

    public WarehouseApp() {
        super("Агуулахын систем");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1080, 700));
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        screenPanel = new JPanel(cardLayout);

        screenPanel.add(WarehouseScreens.createDashboard(), "Нүүр");
        screenPanel.add(WarehouseScreens.createProducts(), "Бараа");
        screenPanel.add(WarehouseScreens.createIncomingInvoice(), "Орлого");
        screenPanel.add(WarehouseScreens.createReports(), "Тайлан");

        add(createSidebar(), BorderLayout.WEST);
        add(screenPanel, BorderLayout.CENTER);
        pack();
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel(new BorderLayout());
        sidebar.setPreferredSize(new Dimension(220, 700));
        sidebar.setBackground(new Color(34, 47, 62));
        sidebar.setBorder(BorderFactory.createEmptyBorder(24, 16, 24, 16));

        JLabel title = new JLabel("<html><b>Агуулах</b><br>систем</html>");
        title.setForeground(Color.WHITE);
        title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 24, 0));
        sidebar.add(title, BorderLayout.NORTH);

        JPanel nav = new JPanel(new GridLayout(0, 1, 0, 10));
        nav.setOpaque(false);

        String[] screenNames = {"Нүүр", "Бараа", "Орлого", "Тайлан"};

        for (int i = 0; i < screenNames.length; i++) {
            final String screenName = screenNames[i];
            JButton button = new JButton(screenName);
            button.setFocusPainted(false);
            button.setHorizontalAlignment(SwingConstants.LEFT);
            button.setBackground(new Color(52, 73, 94));
            button.setForeground(Color.WHITE);
            button.setBorder(BorderFactory.createEmptyBorder(12, 14, 12, 14));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    cardLayout.show(screenPanel, screenName);
                    System.out.println("Сонгосон дэлгэц: " + screenName);
                }
            });
            nav.add(button);
        }

        sidebar.add(nav, BorderLayout.CENTER);
        return sidebar;
    }
}
