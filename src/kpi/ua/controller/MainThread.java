package kpi.ua.controller;

import kpi.ua.model.AllDocuments;
import kpi.ua.model.entities.AllDocumentsQueue;
import kpi.ua.model.entities.Document;
import kpi.ua.model.entities.institutes.BiologyInstitute;
import kpi.ua.model.entities.institutes.ClassicInstitute;
import kpi.ua.model.entities.institutes.MathInstitute;
import kpi.ua.view.View;
import kpi.ua.view.ViewConstants;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by Микола on 18.05.2017.
 */
public class MainThread extends Thread {

    private BiologyInstitute biologyInstitute;

    private MathInstitute mathInstitute;

    private ClassicInstitute classicInstitute;

    private Queue<Document> documentsQueue;

    private ArrayList<Document> allDocuments;

    private View view;

    public MainThread(BiologyInstitute biologyInstitute, MathInstitute mathInstitute, ClassicInstitute classicInstitute, AllDocumentsQueue allDocumentsQueue, AllDocuments allDocuments, View view) {
        this.biologyInstitute = biologyInstitute;
        this.mathInstitute = mathInstitute;
        this.classicInstitute = classicInstitute;
        this.documentsQueue = allDocumentsQueue.getAllDocumentsQueue();
        this.allDocuments = allDocuments.getDocuments();
        this.view = view;
    }

    @Override
    public void run() {
        while (documentsQueue.size() > 0 || allDocuments.size() > 0) {
            mathInstitute.apply(documentsQueue);
            classicInstitute.apply(documentsQueue);
            biologyInstitute.apply(documentsQueue);
        }
        printApplyResults();
    }

    private void printApplyResults(){
        view.printMessage(ViewConstants.MATH_APPLIED_STRING + mathInstitute.getApplied().size());
        view.printMessage(ViewConstants.BIOLOGY_APPLIED_STRING + biologyInstitute.getApplied().size());
        view.printMessage(ViewConstants.CLASSIC_APPLIED_STRING + classicInstitute.getApplied().size());
    }

}