import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public final class WarehouseScreens {
    private static final Color BACKGROUND = new Color(245, 247, 250);
    private static final Color PANEL = Color.WHITE;
    private static final Color TEXT = new Color(33, 37, 41);
    private static final Color MUTED = new Color(102, 112, 133);
    private static final Color ACCENT = new Color(0, 122, 204);
    private static final Color BORDER = new Color(221, 226, 232);

    private WarehouseScreens() {
    }

    public static JPanel createDashboard() {
        JPanel root = createRoot("Нүүр", "Төв агуулахын өнөөдрийн товч мэдээлэл");

        JPanel main = new JPanel(new BorderLayout(0, 18));
        main.setOpaque(false);

        JPanel stats = new JPanel(new GridLayout(1, 3, 18, 0));
        stats.setOpaque(false);
        stats.add(createStatCard("Бараа", "128", "Бүртгэлтэй бараа"));
        stats.add(createStatCard("Орлого", "14", "Энэ долоо хоногийн падаан"));
        stats.add(createStatCard("Бага үлдэгдэл", "6", "Анхаарах бараа"));

        main.add(stats, BorderLayout.NORTH);

        JPanel body = new JPanel(new GridLayout(1, 2, 18, 0));
        body.setOpaque(false);

        body.add(createTablePanel("Сүүлийн хөдөлгөөн", new String[] {"Огноо", "Төрөл", "Бараа", "Тоо"}, new Object[][] {
                {"2026-05-10", "Орлого", "Дэвтэр", 40},
                {"2026-05-10", "Зарлага", "Принтерийн цаас", 12},
                {"2026-05-09", "Орлого", "USB кабель", 70},
                {"2026-05-09", "Зарлага", "Маркер", 18}
        }));

        JPanel actions = createCardPanel("Хурдан үйлдэл");
        actions.setLayout(new GridLayout(0, 1, 0, 12));
        actions.add(createActionButton("Орлогын падаан үүсгэх"));
        actions.add(createActionButton("Зарлагын падаан үүсгэх"));
        actions.add(createActionButton("Үлдэгдлийн тайлан харах"));
        actions.add(createActionButton("Тооллого эхлүүлэх"));
        body.add(actions);

        main.add(body, BorderLayout.CENTER);
        root.add(main, BorderLayout.CENTER);
        return root;
    }

    public static JPanel createProducts() {
        JPanel root = createRoot("Бараа", "Агуулахын бараа болон үлдэгдлийг харах");

        JPanel main = new JPanel(new BorderLayout(0, 18));
        main.setOpaque(false);

        JPanel filters = createCardPanel("Бараа хайх");
        filters.setLayout(new GridLayout(1, 4, 12, 0));
        filters.add(createTextField("Нэрээр хайх"));
        filters.add(createTextField("Барааны код"));
        filters.add(new JComboBox<>(new String[] {"Бүх төрөл", "Бичиг хэрэг", "Цахилгаан бараа", "Багаж"}));
        filters.add(createActionButton("Хайх"));
        main.add(filters, BorderLayout.NORTH);

        JPanel table = createTablePanel("Барааны үлдэгдэл", new String[] {"Код", "Бараа", "Нэгж", "Тоо", "Төлөв"},
                new Object[][] {
                        {"P-001", "Дэвтэр", "ширхэг", 240, "Хэвийн"},
                        {"P-002", "Принтерийн цаас", "боодол", 32, "Бага"},
                        {"P-003", "USB кабель", "ширхэг", 150, "Хэвийн"},
                        {"P-004", "Маркер", "ширхэг", 18, "Бага"},
                        {"P-005", "Гар", "ширхэг", 45, "Хэвийн"}
                });
        main.add(table, BorderLayout.CENTER);
        root.add(main, BorderLayout.CENTER);
        return root;
    }

    public static JPanel createIncomingInvoice() {
        JPanel root = createRoot("Орлогын падаан", "Агуулахад хүлээн авсан барааг бүртгэх");

        JPanel main = new JPanel(new BorderLayout(0, 18));
        main.setOpaque(false);

        JPanel form = createCardPanel("Падааны мэдээлэл");
        form.setLayout(new GridLayout(0, 2, 12, 12));
        form.add(createTextField("Падааны дугаар"));
        form.add(createTextField("Хүлээлгэн өгсөн хүн"));
        form.add(createTextField("Огноо"));
        form.add(new JComboBox<>(new String[] {"Төв агуулах", "Салбар агуулах"}));
        form.add(createTextField("Барааны код"));
        form.add(createTextField("Тоо хэмжээ"));

        JButton saveButton = createActionButton("Хадгалах");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Орлогын падаан хадгалах товч дарагдлаа");
            }
        });
        form.add(saveButton);

        JButton printButton = createActionButton("Хэвлэх");
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Орлогын падаан хэвлэх товч дарагдлаа");
            }
        });
        form.add(printButton);

        main.add(form, BorderLayout.NORTH);
        main.add(createTablePanel("Падааны мөрүүд", new String[] {"Бараа", "Нэгж", "Тоо"}, new Object[][] {
                {"Дэвтэр", "ширхэг", 40},
                {"USB кабель", "ширхэг", 70},
                {"Принтерийн цаас", "боодол", 16}
        }), BorderLayout.CENTER);

        root.add(main, BorderLayout.CENTER);
        return root;
    }

    public static JPanel createReports() {
        JPanel root = createRoot("Тайлан", "Барааны үлдэгдэл болон няравын тайлан");

        JPanel content = new JPanel(new GridLayout(1, 2, 18, 0));
        content.setOpaque(false);

        JPanel reportList = createCardPanel("Тайлангийн төрөл");
        reportList.setLayout(new BorderLayout(0, 12));
        JList<String> list = new JList<>(new String[] {
                "Одоогийн үлдэгдлийн тайлан",
                "Няравын хугацааны тайлан",
                "Сонгосон барааны тайлан",
                "Тооллогын зөрүүний тайлан"
        });
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        reportList.add(new JScrollPane(list), BorderLayout.CENTER);
        reportList.add(createActionButton("Тайлан харах"), BorderLayout.SOUTH);

        JPanel preview = createTablePanel("Тайлангийн жишээ",
                new String[] {"Бараа", "Эхний", "Орлого", "Зарлага", "Эцсийн"},
                new Object[][] {
                        {"Дэвтэр", 200, 40, 0, 240},
                        {"Принтерийн цаас", 28, 16, 12, 32},
                        {"USB кабель", 80, 70, 0, 150},
                        {"Маркер", 36, 0, 18, 18}
                });

        content.add(reportList);
        content.add(preview);
        root.add(content, BorderLayout.CENTER);
        return root;
    }

    private static JPanel createRoot(String title, String subtitle) {
        JPanel root = new JPanel(new BorderLayout(0, 18));
        root.setBackground(BACKGROUND);
        root.setBorder(BorderFactory.createEmptyBorder(28, 30, 28, 30));

        JPanel header = new JPanel(new GridLayout(0, 1, 0, 4));
        header.setOpaque(false);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(TEXT);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
        header.add(titleLabel);

        JLabel subtitleLabel = new JLabel(subtitle);
        subtitleLabel.setForeground(MUTED);
        subtitleLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        header.add(subtitleLabel);

        root.add(header, BorderLayout.PAGE_START);
        return root;
    }

    private static JPanel createStatCard(String label, String value, String hint) {
        JPanel card = createCardPanel(label);
        card.setLayout(new GridLayout(0, 1, 0, 8));

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
        valueLabel.setForeground(ACCENT);
        card.add(valueLabel);

        JLabel hintLabel = new JLabel(hint);
        hintLabel.setForeground(MUTED);
        card.add(hintLabel);

        return card;
    }

    private static JPanel createCardPanel(String title) {
        JPanel panel = new JPanel();
        panel.setBackground(PANEL);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                BorderFactory.createEmptyBorder(16, 16, 16, 16)));

        if (!title.isEmpty()) {
            panel.setLayout(new BorderLayout(0, 12));
            JLabel titleLabel = new JLabel(title);
            titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
            titleLabel.setForeground(TEXT);
            panel.add(titleLabel, BorderLayout.NORTH);
        }

        return panel;
    }

    private static JPanel createTablePanel(String title, String[] columns, Object[][] rows) {
        JPanel panel = createCardPanel(title);
        JTable table = new JTable(new DefaultTableModel(rows, columns));
        table.setRowHeight(30);
        table.getTableHeader().setReorderingAllowed(false);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private static JTextField createTextField(String placeholder) {
        JTextField field = new JTextField(placeholder);
        field.setForeground(MUTED);
        field.setPreferredSize(new Dimension(160, 38));
        return field;
    }

    private static JButton createActionButton(String label) {
        JButton button = new JButton(label);
        button.setBackground(ACCENT);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Үйлдэл: " + label);
            }
        });
        return button;
    }
}
