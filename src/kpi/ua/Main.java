package kpi.ua;

import kpi.ua.controller.Controller;
import kpi.ua.view.View;

/**
 * Created by Микола on 18.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        controller.processUser();
    }
}
