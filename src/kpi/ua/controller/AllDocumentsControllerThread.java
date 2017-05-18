package kpi.ua.controller;

import kpi.ua.model.AllDocuments;
import kpi.ua.model.Constants;
import kpi.ua.model.entities.AllDocumentsQueue;
import kpi.ua.model.entities.Document;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Микола on 18.05.2017.
 */
public class AllDocumentsControllerThread extends Thread {

    private AllDocuments allDocuments;

    private AllDocumentsQueue allDocumentsQueue;

    public AllDocumentsControllerThread(AllDocuments allDocuments, AllDocumentsQueue allDocumentsQueue) {
        this.allDocuments = allDocuments;
        this.allDocumentsQueue = allDocumentsQueue;
    }

    @Override
    public void run() {
        while (!allDocuments.getDocuments().isEmpty()) {
            if (allDocumentsQueue.getAllDocumentsQueue().size() < Constants.MIN_DOCUMENTS_IN_QUEUE) {
                int countAddDocuments = (int) (Math.random() * Constants.MAX_ADD_IN_QUEUE_DOCUMENTS_NUMBER) + 1;
                while (countAddDocuments != 0) {
                    if (allDocuments.getDocuments().isEmpty()) {
                        return;
                    }

                    allDocumentsQueue.getAllDocumentsQueue().add(allDocuments.getDocuments().get(0));
                    allDocuments.getDocuments().remove(0);
                    countAddDocuments--;
                }
            }
        }
    }
}
