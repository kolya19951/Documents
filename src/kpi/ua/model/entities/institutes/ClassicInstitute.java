package kpi.ua.model.entities.institutes;

import kpi.ua.model.Constants;
import kpi.ua.model.entities.Document;
import kpi.ua.model.entities.Type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;


/**
 * Created by Микола on 18.05.2017.
 */
public class ClassicInstitute extends Institute {

    @Override
    public void apply(Queue<Document> queue) {
        int rand = (int) (Math.random() * Constants.MAX_CLASSIC_INSTITUTE_APPLIED) + 1;
        Iterator<Document> iterator = queue.iterator();
        while (rand > 0 && !queue.isEmpty() && iterator.hasNext()) {
            Document document = iterator.next();
            applied.add(document);
            iterator.remove();
            rand--;
        }
    }

    @Override
    public ArrayList<Document> getApplied() {
        return applied;
    }
}
