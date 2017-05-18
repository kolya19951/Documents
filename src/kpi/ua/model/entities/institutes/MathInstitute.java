package kpi.ua.model.entities.institutes;

import kpi.ua.model.entities.Document;
import kpi.ua.model.entities.Type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by Микола on 18.05.2017.
 */
public class MathInstitute extends Institute {

    @Override
    public void apply(Queue<Document> queue) {
        Iterator<Document> iterator = queue.iterator();
        while (iterator.hasNext()) {
            Document document = iterator.next();
            if (document.getType().equals(Type.BIOLOGY)){
                return;
            }else {
                applied.add(document);
                iterator.remove();
            }
        }
    }

    @Override
    public ArrayList<Document> getApplied() {
        return applied;
    }
}
