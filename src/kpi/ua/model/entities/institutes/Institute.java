package kpi.ua.model.entities.institutes;

import kpi.ua.model.entities.Document;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by Микола on 18.05.2017.
 */
public abstract class Institute {

    ArrayList<Document> applied = new ArrayList<>();

    public abstract void apply(Queue<Document> queue);

    public abstract ArrayList<Document> getApplied();

}
