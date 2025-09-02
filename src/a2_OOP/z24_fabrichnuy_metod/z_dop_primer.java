package a2_OOP.z24_fabrichnuy_metod;

import java.util.Scanner;

class z_dop_primer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        Dialog dialog = null;
        if ("Windows".equals(type)) {
            dialog = new WindowsDialog();
        } else if ("Html".equals(type)) {
            dialog = new HtmlDialog();
        } else {
            System.out.println("ERROR");
            return;
        }
        dialog.renderWindow();
    }
}


abstract class Dialog {
    abstract Button createButton();

    void renderWindow() {
        Button button = createButton();
        System.out.println("Рисуем окно диалога");
        button.render();
    }
}

class WindowsDialog extends Dialog {
    Button createButton() {
        return new WindowsButton();
    }
}

class HtmlDialog extends Dialog {
    Button createButton() {
        return new HtmlButton();
    }
}


abstract class Button {
    abstract void render();
}

class HtmlButton extends Button {
    void render() {
        System.out.println("Отрисовали кнопку в стиле Html с надписью OK");
    }
}

class WindowsButton extends Button {
    void render() {
        System.out.println("Отрисовали кнопку в стиле Windows с надписью OK");
    }
}