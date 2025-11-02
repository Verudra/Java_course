import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuadraticSolver extends JFrame implements ActionListener {
    private JTextField aField, bField, cField;
    private JTextArea resultArea;
    private JButton solveButton1, solveButton2, solveButton3;

    public QuadraticSolver() {
        setTitle("一元二次方程求解器");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // 输入框
        add(new JLabel("系数 a:"));
        aField = new JTextField();
        add(aField);

        add(new JLabel("系数 b:"));
        bField = new JTextField();
        add(bField);

        add(new JLabel("系数 c:"));
        cField = new JTextField();
        add(cField);

        // 三种按钮
        solveButton1 = new JButton("求解（事件源合一）");
        solveButton1.addActionListener(this); // 事件源合一
        add(solveButton1);

        solveButton2 = new JButton("求解（匿名内部类）");
        solveButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                solveEquation();
            }
        });
        add(solveButton2);

        solveButton3 = new JButton("求解（Lambda表达式）");
        solveButton3.addActionListener(e -> solveEquation()); // Lambda表达式
        add(solveButton3);

        // 输出区域
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JLabel("结果："));
        add(resultArea);
    }

    // 事件源合一方式处理
    public void actionPerformed(ActionEvent e) {
        solveEquation();
    }

    // 求解方程
    private void solveEquation() {
        try {
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            double c = Double.parseDouble(cField.getText());

            String result = computeRoots(a, b, c);
            resultArea.setText(result);
        } catch (NumberFormatException ex) {
            resultArea.setText("请输入有效的数字！");
        }
    }

    // 计算根的方法
    private String computeRoots(double a, double b, double c) {
        if (a == 0) return "这不是一元二次方程（a不能为0）";

        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "有两个实根：x1 = " + x1 + ", x2 = " + x2;
        } else if (delta == 0) {
            double x = -b / (2 * a);
            return "有一个实根：x = " + x;
        } else {
            return "无实根，存在虚根";
        }
    }

    // 主方法：在线程中启动图形界面
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuadraticSolver solver = new QuadraticSolver();
            solver.setVisible(true);
        });
    }
}
