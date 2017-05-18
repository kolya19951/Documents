package kpi.ua.controller;

import kpi.ua.model.AllDocuments;
import kpi.ua.model.entities.AllDocumentsQueue;
import kpi.ua.model.entities.institutes.BiologyInstitute;
import kpi.ua.model.entities.institutes.ClassicInstitute;
import kpi.ua.model.entities.institutes.MathInstitute;
import kpi.ua.view.View;

import javax.swing.*;

/**
 * Created by Микола on 18.05.2017.
 */
public class Controller {

    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void processUser() {

        MathInstitute mathInstitute = new MathInstitute();
        BiologyInstitute biologyInstitute = new BiologyInstitute();
        ClassicInstitute classicInstitute = new ClassicInstitute();

        AllDocuments allDocuments= new AllDocuments();
        allDocuments.init();

        AllDocumentsQueue allDocumentsQueue = new AllDocumentsQueue();

        AllDocumentsControllerThread allDocumentsControllerThread = new AllDocumentsControllerThread(allDocuments, allDocumentsQueue);

        MainThread mainThread = new MainThread(biologyInstitute, mathInstitute, classicInstitute, allDocumentsQueue, allDocuments, view);

        allDocumentsControllerThread.start();
        mainThread.start();

    }
}
