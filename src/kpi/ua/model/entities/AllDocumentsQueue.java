package kpi.ua.model.entities;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Микола on 18.05.2017.
 */
public class AllDocumentsQueue {

    private Queue<Document> allDocumentsQueue;

    public AllDocumentsQueue() {
        this.allDocumentsQueue = new LinkedBlockingDeque<>();
    }

    public Queue<Document> getAllDocumentsQueue() {
        return allDocumentsQueue;
    }

}
