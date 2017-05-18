package kpi.ua.model;

import kpi.ua.model.entities.Document;
import kpi.ua.model.entities.Type;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Микола on 18.05.2017.
 */
public class AllDocuments {

    private ArrayList<Document> documents;

    public AllDocuments() {
        this.documents = new ArrayList<>();
    }

    public void init(){
        for (int i = 0; i < Constants.BIOLOGY_DOCUMENTS_NUMBER; i++) {
            documents.add(new Document(Type.BIOLOGY));
        }
        for (int i = 0; i < Constants.MATH_DOCUMENTS_NUMBER; i++) {
            documents.add(new Document(Type.MATH));
        }
        Collections.shuffle(documents);
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }
}
